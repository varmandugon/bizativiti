package com.fing.pis.bizativiti.web.api;

public class FactoryApi {

    private static Api instance;

    public static Api getApi() {
        if (instance == null) {
            instance = new ApiImpl();
        }
        return instance;
    }

}