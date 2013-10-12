Descripcion del proyecto del lado XPDL
com.fing.pis.bizativiti.core.CLI:

    Es la clase encargada de procesar la linea de comandos, abrir los archivos de lectura y plugins, crear los de escritura y delegar el trabajo al converter de Main

 com.fing.pis.bizativiti.core.Main:

    Es la clase principal, encargada de crear el plugin manager, cargarle los plugins, obtener el plugin a usar para la conversión, realizar la conversión de la entrada a una lista de MetamodelElement y luego pasar esa lista de MetamodelElement al converter de bpmn. Por último guarda la conversión hecha por el BPMNConverter en el archivo de salida (escribe al flujo de salida).

com.fing.pis.bizativiti.plugin.xpdl
.Facade:

    Es la clase que implementa la interfaz IPlugin, utilizada para realizar la conversión del flujo de entrada en XPDL a una lista de MetamodelElement.

    La conversión se realiza en dos pasos:

    1) se deserializa la entrada en XML a una instancia de
    org.wfmc._2009.xpdl2.PackageType
     .

    2) se utiliza el converter que fué creado al momento de instanciar la clase para iniciar la conversión de la instancia de 
     
    org.wfmc._2009.xpdl2.PackageType
     
     deserializada anteriormente.

    Sobre el converter:

    Es una instancia de com.fing.pis.bizativiti.plugin.xpdl.Converter, creada mediante la clase com.fing.pis.bizativiti.plugin.xpdl.Converter.Builder, en la que se debe registrar (al momento de creación) un translator para cada tipo de clase que se puede encontrar en un nodo de XPDL.

    Ejemplo: para convertir el nodo de tipo 
     
    org.wfmc._2009.xpdl2.PackageType
     
    debe agregarse un translator
      que pueda manejar el nodo. Para convertir cada nodo de los que contiene un 
    org.wfmc._2009.xpdl2.PackageType deben agregarse sus translators, y así se continua.

com.fing.pis.bizativiti.plugin.xpdl
 .
Converter
:

    Es la clase que mantiene la lista de translators registrados, como una asociación (clase del nodo de XPDL, instancia de translator a usar).

    Tambien es la clase utilizada para iniciar la conversión del nodo de tipo 
    org.wfmc._2009.xpdl2.PackageType
     .

    A tener en cuenta:

    En esta clase no se mantiene ningun tipo de estado de la conversión, solo estan registrados los translators.

 
com.fing.pis.bizativiti.plugin.xpdl
.
Converter
.Builder:

    Es una clase de ayuda, utilizada solo para poder implementar el patrón Builder en la creación de una instancia de Converter.

com.fing.pis.bizativiti.plugin.xpdl
 .
Converter
.ParserConverter:

    Esta clase es la encargada de realizar la evaluación de cada nodo.

    Surge debido a la necesidad de mantener un estado entre los distintos translators, y el querer mantener la instancia de Converter en Facade independiente de estado.

    Evalua cada nodo segun el translator adecuado (segun su tipo). Tambien permite acceder a los elementos previamente convertidos según su ID si es usado en una llamada recursiva (la forma en que efectivamente se utiliza el converter).

com.fing.pis.bizativiti.plugin.xpdl
 .
ATranslato
r:

    Clase base (abstracta) de los translator. Indica el método que debe sobreescribir cada translator.

    NOTA: de la forma en que fué pensada la arquitectura los translators no deben mantener estado, solo convertir elementos.

com.fing.pis.bizativiti.plugin.xpdl
 .
DummyTranslator
 :

    Translator de conveniencia, utilizado para registrar una clase de XPDL e indicarle al Converter que no se desea procesar (esta clase termina el procesamiento recursivo del nodo, ya que siempre retorna una lista vacia de elementos).

 
com.fing.pis.bizativiti.plugin.xpdl
 .
ErrorTranslator
 :

    Translator de conveniencia, utilizado para registrar una clase de XPDL e indicarle al Converter que debe lanzar una Excepción.

com.fing.pis.bizativiti.plugin.xpdl.
Util:

    Clase de utileria. Utilizada para obtener distintos atributos necesarios para el MetamodelElement a partir de un nodo.

 
com.fing.pis.bizativiti.plugin.xpdl
 .Translator*,
com.fing.pis.bizativiti.plugin.xpdl
 .even
ts.Translator*,
com.fing.pis.bizativiti.plugin.xpdl
 .tasks
.Translator*
 :

    Clases derivadas de ATranslator, que realizan la conversión de un nodo de XPDL a un elemento (o elementos) del metamodelo.

    La forma de funcionamiento es la siguiente:
    * si es un nodo "hoja" crea el elemento correspondiente al metamodelo.

    * si no es un nodo "hoja" llama recursivamente por cada nodo al método eval de la clase ParserConverter (recordemos que es esta quien tiene el estado, no la clase Converter) para convertir sus nodos hijo. Luego devuelve todos los elementos que fueron convertidos.

    Si el tipo de nodo no debe hacer ninguna conversión, debe registrarse con el translator DummyTranslator.