package com.fing.pis.bizativiti.utils.xpdlparser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.wfmc._2009.xpdl2.PackageType;

/**
 * Clase que encapsula la lectura de los archivos XPDL
 * @author pis2013
 *
 */
public class FileHandler {
	
	/**
	 * Lee le archivo y retorna el nodo padre con la estructura cargada en memoria
	 * @param filePath Ruta del archivo a leer
	 * @return Nodo padre con la estructura en memoria.
	 */
	public static PackageType readFile(String filePath){
		
		org.wfmc._2009.xpdl2.PackageType packageType = null;
		XMLInputFactory factory = XMLInputFactory.newInstance(); // Factory para obtener xmlreaders
		try {
			JAXBContext xpdlContext = JAXBContext.newInstance(org.wfmc._2009.xpdl2.PackageType.class); // Contexto JAXB con la clase que corresponde al root del xml 
			Unmarshaller unmarshallerXpdl = xpdlContext.createUnmarshaller();
			File file = new File(filePath);
			if(file.exists()){
				XMLStreamReader reader = factory.createXMLStreamReader(new FileReader(filePath)); // XML reader que usara JAXB el cual apunta al archivo a leer
				JAXBElement<org.wfmc._2009.xpdl2.PackageType> jaxbPackage = unmarshallerXpdl.unmarshal(reader,org.wfmc._2009.xpdl2.PackageType.class); //Aca es cuando efectivamente des-serializa
				
				packageType = jaxbPackage.getValue(); // Aca obtengo el elemento root del xml 
				reader.close();
			}else{
				throw new FileNotFoundException("No se ha encontrado del archivo:" + filePath);					
			}
		} catch (JAXBException | FileNotFoundException | XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return packageType;
		
	}
}
