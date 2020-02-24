package com.example.dpmptsp_app.api;


import static com.example.dpmptsp_app.util.Utility.BASE_URL_API;


public class Server {
    public static ApiService getAPIService() {

        return Client.getClient(BASE_URL_API).create(ApiService.class);
    }

}
