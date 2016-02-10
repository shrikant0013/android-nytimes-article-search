package com.shrikant.nytimesarticlesearch;

import com.squareup.picasso.Picasso;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by spandhare on 2/10/16.
 */
public class ArticleAdapter extends ArrayAdapter {
    public ArticleAdapter(Context context, ArrayList<Article> articles) {
        super(context, 0, articles);
    }

    static class ViewHolder {
        @Bind(R.id.ivArticle) ImageView ivArticle;
        @Bind(R.id.tvArticle) TextView tvArticle;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Article article = (Article)getItem(position);

        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).
                    inflate(R.layout.grid_view_item_template, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.ivArticle.setImageResource(0); //clearoff
        if (!TextUtils.isEmpty(article.thumbnailUrl)) {
            Picasso.with(getContext()).load(article.thumbnailUrl).into(viewHolder.ivArticle);
        }
        viewHolder.tvArticle.setText(article.headline);
        return convertView;
    }
}
