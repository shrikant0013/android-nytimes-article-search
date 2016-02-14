package com.shrikant.search;

import com.shrikant.modal.Article;
import com.shrikant.view.ArticleActivity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by spandhare on 2/12/16.
 */
public class TextArticleViewHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener{

    @Bind(R.id.tvArticleText) TextView tvArticleText;
    List<Article> articles;
    Context mContext;

    public TextArticleViewHolder(Context context, View view, List<Article> mArticles) {
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
//        SearchActivity searchActivity = (SearchActivity)mContext;
////        Log.i("TextArticleViewHolder", SearchActivity.cachedQueryString);
////        //i.putExtra("searchText", mContext.)
////        i.putExtra(ArticleActivity.PARENT_NAME_EXTRA, "SearchActivity");

        mContext.startActivity(i);
    }

    public TextView getTvArticleText() {
        return tvArticleText;
    }

    public void setTvArticleText(TextView tvArticleText) {
        this.tvArticleText = tvArticleText;
    }
}
