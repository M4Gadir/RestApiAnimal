package com.magad.restapianimal.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.magad.restapianimal.R;
import com.magad.restapianimal.model.ArticlesItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterNews extends RecyclerView.Adapter<AdapterNews.VIewHolder> {
    Context context;
    List<ArticlesItem> data;
    public AdapterNews(Context context, List<ArticlesItem> dataArticles) {
    this.context = context;
    this.data = dataArticles;
    }

    @NonNull
    @Override
    public VIewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_home, null);

        return new VIewHolder(v,context);
    }

    @Override
    public void onBindViewHolder(@NonNull VIewHolder vIewHolder, int i) {
        Picasso.get().load(data.get(i).getUrlToImage()).into(vIewHolder.imdata);
        vIewHolder.author.setText(data.get(i).getAuthor());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class VIewHolder extends RecyclerView.ViewHolder {
        ImageView imdata;
        TextView date,author,title,from;
        public VIewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            author = itemView.findViewById(R.id.tv_author);
            imdata = itemView.findViewById(R.id.imhome);
        }
    }
}
