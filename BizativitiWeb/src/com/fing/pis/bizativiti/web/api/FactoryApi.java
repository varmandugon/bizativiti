package com.fing.pis.bizativiti.web.api;

import javax.servlet.ServletContext;

public class FactoryApi {

    private static Api instance;

    public static Api getApi(ServletContext servletContext) {
        if (instance == null) {
            instance = new ApiImpl(servletContext);
        }
        return instance;
    }

}