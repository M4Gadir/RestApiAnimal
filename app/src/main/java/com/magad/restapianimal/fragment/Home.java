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

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {
    RecyclerView rvHome;
    Response data;
    List<ArticlesItem> dataArticle;
    AdapterHome adapter;


    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        rvHome = v.findViewById(R.id.rv_home);
        getDataItems();
        return v;
    }

    private void getDataItems() {
        ConfigRetrofit.setInstance().getDataItems().enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, Response<Response> response) {
                if(response.isSuccessful()){

                    adapter = new AdapterHome(getActivity(),dataArticle);
                    rvHome.setLayoutManager(new LinearLayoutManager(getActivity()));
                    rvHome.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
