package com.shrikant.nytimesarticlesearch;

import com.squareup.picasso.Picasso;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by spandhare on 2/10/16.
 */
//public class ArticleAdapter extends ArrayAdapter {
//    public ArticleAdapter(Context context, ArrayList<Article> articles) {
//        super(context, 0, articles);
//    }
//
//    static class ViewHolder {
//        @Bind(R.id.ivArticle) ImageView ivArticle;
//        @Bind(R.id.tvArticle) TextView tvArticle;
//
//        public ViewHolder(View view) {
//            ButterKnife.bind(this, view);
//        }
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        Article article = (Article)getItem(position);
//
//        ViewHolder viewHolder;
//        if (convertView == null) {
//            convertView = LayoutInflater.from(getContext()).
//                    inflate(R.layout.grid_view_item_template, parent, false);
//            viewHolder = new ViewHolder(convertView);
//            convertView.setTag(viewHolder);
//        } else {
//            viewHolder = (ViewHolder)convertView.getTag();
//        }
//        viewHolder.ivArticle.setImageResource(0); //clearoff
//        if (!TextUtils.isEmpty(article.thumbnailUrl)) {
//            Picasso.with(getContext()).load(article.thumbnailUrl).into(viewHolder.ivArticle);
//        }
//        viewHolder.tvArticle.setText(article.headline);
//        return convertView;
//    }
//}

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.ivArticle) ImageView ivArticle;
        @Bind(R.id.tvArticle) TextView tvArticle;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    private List<Article> articles;
    private Context mContext;
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

//    public void clear() {
//        articles.clear();
//    }

    public void addAll(List<Article> list) {
        Log.i("ArticleAdapter", "" + list.size());
        articles.addAll(list);
    }
}