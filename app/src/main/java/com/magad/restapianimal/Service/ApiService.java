package com.magad.restapianimal.Service;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public interface ApiService {

    @GET("op-headlines?sources=cnn&apiKey=b962bf8dadda4339992f2229d4ce0276")
    Call<Response> getDataItems();


    @GET("top-headlines?sources=al-jazeera-english&apiKey=b962bf8dadda4339992f2229d4ce0276")
    Call<Response> getDataNews();
}
