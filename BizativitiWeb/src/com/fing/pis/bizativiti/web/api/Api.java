package com.fing.pis.bizativiti.web.api;

import java.io.InputStream;
import java.io.OutputStream;

public interface Api {

    /**
     * Estado del procesamiento de un archivo
     */
    public enum Status {
        /** El ticket no existe en el sistema */
        Unknown,
        /** El ticket está esperando a ser agregado a la cola de espera */
        Pending,
        /** El ticket está en la cola de espera, esperando a ser procesado */
        Starting,
        /** El ticket está siendo procesado */
        Processing,
        /** El procesamiento del ticket termino exitosamente */
        Completed,
        /** Hubo errores en el procesamiento del ticket */
        Error;
    }

    /**
     * Importamos archivo a procesar por el sistema
     * 
     * @param name
     *            nombre del archivo
     * @param is
     *            contenido del archivo
     * @return ticket dado en el sistema
     */
    String upload(String name, InputStream is);

    /**
     * Devuelve el estado de un ticket dado.
     * 
     * @param ticketId
     * @return
     */
    Status getStatus(String ticketId);

    /**
     * Devuelve el archivo procesado
     * 
     * @param ticketId
     * @return
     * @throws ApiException
     *             si el ticket no está en estado {@link Status#Completed}
     */
    OutputStream getProcessedFile(String ticketId) throws ApiException;

    /**
     * Devuelve el archivo de log para el ticket dado
     * 
     * @param ticketId
     * @return
     * @throws ApiException
     *             si el ticket no está en estado {@link Status#Completed}
     */
    OutputStream getLogFile(String ticketId) throws ApiException;

}