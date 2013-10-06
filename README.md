biztiviti
=========

Proyecto de Ingenieria de Software - CPA Innovation- Bizagi - Activiti middleware 

Objetivo
========

El objetivo es crear un conversor del estandar XPDL al estándar BPMN 2.0.

Descripción
===========


Generación jar BizativitiProject
================================

Con ant

    $ # cd "directorio BizativitiProject"
    $ ant    # esto genera el archivo bin/bizativiti.jar
    $ java -jar bin/bizativiti.jar
    Option                                   Description
    ------                                   -----------
    --input <input_file>                     Input file
    --output <output_file>                   Output file
    --plugin-list <plugins_definition_file>  Plugins definition file
    --type <plugins_to_use>                  Plugin for use

    $ java -jar bin/bizativiti.jar --plugin-list resources/plugins.xml XPDL --input archivo_entrada --output archivo_salida

Con eclipse:
* Primero hay que generar la configuración por defecto:
1) Click-derecho en el directorio del proyecto BizativitiProject
2) Run As > Java Application
3) Elegir CLI - com.fing.pis.bizativiti.core
* Generación del jar:
1) Click-derecho en el directorio del proyecto BizativitiProject
2) Export...
3) Elgir Java > Runnable Jar file
4) a) Launch configuration: eligen CLI - com.fing.pis.bizativiti.core
   b) Export destination: BizativitiProject/bin/bizativiti.jar
   c) Library handling: Package required libraries into generated JAR
