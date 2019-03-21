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

public class AdapterHome extends RecyclerView.Adapter<AdapterHome.ViewHolder> {
    Context context;
    List<ArticlesItem> data;
    public AdapterHome(Context context, List<ArticlesItem> data) {
    this.context = context;
    this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_home, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Picasso.get().load(data.get(i).getUrlToImage()).into(viewHolder.imdata);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imdata;
        TextView date,author,title,from;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imdata = itemView.findViewById(R.id.imhome);
        }
    }
}
