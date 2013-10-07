package com.fing.pis.bizativiti.web;

public class Util {

    private Util() {}

    public enum Extension {
        HTML, JSON
    }

    /**
     * Clase utilizada para mantener el resultado de parsear el PathInfo de un
     * servlet.
     */
    public static class ParsedUrl {

        private final boolean isValid;
        private final String ticketId;
        private final Extension extension;

        public ParsedUrl() {
            this.isValid = false;
            this.ticketId = null;
            this.extension = null;
        }

        public ParsedUrl(String ticketId, Extension extension) {
            this.isValid = true;
            this.ticketId = ticketId;
            this.extension = extension;
        }

        /** Indica si el PathInfo parseado es válido */
        public boolean isValid() {
            return isValid;
        }

        /**
         * Devuelve el ticketId si el PathInfo parseado es válido, sino lanza
         * una excepción
         */
        public String getTicketId() {
            if (!isValid) {
                throw new IllegalStateException("ParseUrl isn't valid");
            }
            return ticketId;
        }

        /**
         * Devuelve la extensión si el PathInfo parseado es válido, sino lanza
         * una excepción
         */
        public Extension getExtension() {
            if (!isValid) {
                throw new IllegalStateException("ParseUrl isn't valid");
            }
            return extension;
        }

    }

    private static final String EXTENSION_HTML = "html";
    private static final String EXTENSION_JSON = "json";

    /**
     * Parsea urls de la forma "/ticketId.extension". Si no puede devuelve un
     * ParsedUrl invalido.
     * 
     * @param url
     * @return ParsedUrl conteniendo el ticketId y la extensión o un ParsedUrl
     *         invalido
     */
    public static ParsedUrl parseUrl(String url) {
        if (url == null || !url.startsWith("/")) {
            return new ParsedUrl();
        }
        // quitamos el primer caracter "/"
        url = url.substring(1);
        // vemos que no contenga separadores de paths, y que solo tenga un '.'
        String[] parts = url.split("\\.");
        if (url.contains("/") || parts.length != 2) {
            return new ParsedUrl();
        }
        // el ticketId debe ser de 40 carácteres exactos
        String ticketId = parts[0];
        if (ticketId.length() != 40) {
            return new ParsedUrl();
        }
        // la extensión debe ser html o json
        String extensionString = parts[1];
        Extension extension = null;
        if (extensionString.equals(EXTENSION_HTML)) {
            extension = Extension.HTML;
        } else if (extensionString.equals(EXTENSION_JSON)) {
            extension = Extension.JSON;
        } else {
            return new ParsedUrl();
        }
        return new ParsedUrl(ticketId, extension);
    }
}