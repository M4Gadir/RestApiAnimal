package com.magad.restapianimal.Service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConfigRetrofit {
    public static String url = "https://newsapi.org/v2/";
    public  static Retrofit setInit(){
        return new Retrofit.Builder().baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static ApiService setInstance(){ return setInit().create(ApiService.class);}
}
