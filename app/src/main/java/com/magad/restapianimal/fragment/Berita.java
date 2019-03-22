package com.magad.restapianimal.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.magad.restapianimal.R;
import com.magad.restapianimal.Service.ConfigRetrofit;
import com.magad.restapianimal.adapter.AdapterHome;
import com.magad.restapianimal.adapter.AdapterNews;
import com.magad.restapianimal.model.ArticlesItem;
import com.magad.restapianimal.model.ResponseDer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class Berita extends Fragment {
    RecyclerView rvBerita;
    List<ArticlesItem> dataArticles;
    AdapterNews adapter;


    public Berita() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_berita, container, false);
        rvBerita = v.findViewById(R.id.rv_berita);

        getDataNews();
        return v;
    }

    private void getDataNews() {
        ConfigRetrofit.setInstance().getDataNews().enqueue(new Callback<ResponseDer>() {
            @Override
            public void onResponse(Call<ResponseDer> call, Response<ResponseDer> response) {
                if (response.isSuccessful()){
                    dataArticles = response.body().getArticles();
                    adapter = new AdapterNews(getActivity(),dataArticles );
                    rvBerita.setLayoutManager(new LinearLayoutManager(getActivity()));
                    rvBerita.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseDer> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
