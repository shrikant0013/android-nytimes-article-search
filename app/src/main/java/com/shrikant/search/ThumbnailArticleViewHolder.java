package com.shrikant.search;

import com.shrikant.modal.Article;
import com.shrikant.view.ArticleActivity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by spandhare on 2/12/16.
 */
public class ThumbnailArticleViewHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener {
    @Bind(R.id.ivArticle) ImageView ivArticle;
    @Bind(R.id.tvArticle) TextView tvArticle;
    List<Article> articles;
    Context mContext;

    public ThumbnailArticleViewHolder(Context context, View view, List<Article> mArticles) {
        super(view);

        this.articles = mArticles;
        this.mContext = context;
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

    public ImageView getIvArticle() {
        return ivArticle;
    }

    public void setIvArticle(ImageView ivArticle) {
        this.ivArticle = ivArticle;
    }

    public TextView getTvArticle() {
        return tvArticle;
    }

    public void setTvArticle(TextView tvArticle) {
        this.tvArticle = tvArticle;
    }
}
