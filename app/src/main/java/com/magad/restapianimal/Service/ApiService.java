package com.magad.restapianimal.Service;

import com.magad.restapianimal.model.ResponseDer;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public interface ApiService {

    @GET("top-headlines?sources=cnn&apiKey=b962bf8dadda4339992f2229d4ce0276")
    Call<ResponseDer> getDataItems();


    @GET("top-headlines?sources=al-jazeera-english&apiKey=b962bf8dadda4339992f2229d4ce0276")
    Call<ResponseDer> getDataNews();
}
