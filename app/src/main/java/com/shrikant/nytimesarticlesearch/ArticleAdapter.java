package com.shrikant.nytimesarticlesearch;

import com.shrikant.nytimesarticleview.ArticleActivity;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by spandhare on 2/10/16.
 */
public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @Bind(R.id.ivArticle) ImageView ivArticle;
        @Bind(R.id.tvArticle) TextView tvArticle;

        public ViewHolder(View view) {
            super(view);
            // Attach a click listener to the entire row view
            view.setOnClickListener(this);
            ButterKnife.bind(this, view);
        }

        // Handles the row being being clicked
        @Override
        public void onClick(View view) {
            int position = getLayoutPosition(); // gets item position
            Article article = articles.get(position);
            // We can access the data within the views
            Toast.makeText(mContext, "Loading article...", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(mContext, ArticleActivity.class);
            i.putExtra("webUrl", article.webUrl);
            mContext.startActivity(i);
        }
    }

    private static List<Article> articles;
    private static Context mContext;
    public ArticleAdapter(Context context, ArrayList<Article> articles) {
        this.articles = articles;
        mContext = context;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View articleView = inflater.inflate(R.layout.grid_view_item_template, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(articleView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Article article = articles.get(position);

        viewHolder.ivArticle.setImageResource(0); //clearoff
        if (!TextUtils.isEmpty(article.thumbnailUrl)) {
            Picasso.with(mContext).load(article.thumbnailUrl).into(viewHolder.ivArticle);
        }
        viewHolder.tvArticle.setText(article.headline);
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public void addAll(List<Article> list) {
        Log.i("ArticleAdapter", "" + list.size());
        articles.addAll(list);
    }
}