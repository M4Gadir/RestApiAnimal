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
import com.magad.restapianimal.model.ArticlesItem;
import com.magad.restapianimal.model.ResponseDer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {
    RecyclerView rvHome;
    AdapterHome adapter;
    List<ArticlesItem> dataArticles;

    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_home, container, false);
        rvHome = v.findViewById(R.id.rv_home);
        rvHome.setLayoutManager(new LinearLayoutManager(getActivity()));
        getDataItems();
        return v;
    }

    private void getDataItems() {
        ConfigRetrofit.setInstance().getDataItems().enqueue(new Callback<ResponseDer>() {
            @Override
            public void onResponse(Call<ResponseDer> call, Response<ResponseDer> response) {
                if (response.isSuccessful()){
                    dataArticles = response.body().getArticles();
                    adapter = new AdapterHome(getActivity(),dataArticles );
                    rvHome.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<ResponseDer> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
