package com.shrikant.view;

import com.shrikant.search.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ArticleActivity extends AppCompatActivity {

    public static final String PACKAGE_NAME = "com.shrikant.search.";
    public static final String PARENT_NAME_EXTRA = "SearchActivity";

    @Bind(R.id.wvArticle) WebView articleWebView;
    private String currentUrl ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        // Enable up icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        articleWebView.getSettings().setLoadsImagesAutomatically(true);
        articleWebView.getSettings().setJavaScriptEnabled(true);
        articleWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        // Configure the client to use when opening URLs
        articleWebView.setWebViewClient(new MyBrowser());

        // Load the initial URL
        Intent i = getIntent();
        currentUrl = i.getStringExtra("webUrl");
        articleWebView.loadUrl(currentUrl);
    }

    // Manages the behavior when URLs are loaded
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_article, menu);

        MenuItem item = menu.findItem(R.id.menu_article_share);
        ShareActionProvider miShare = (ShareActionProvider) MenuItemCompat.getActionProvider(item);
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");

        shareIntent.putExtra(Intent.EXTRA_TEXT, currentUrl);

        miShare.setShareIntent(shareIntent);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // This is the up button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public Intent getSupportParentActivityIntent() {
//        // Extract the class name of our parent
//        Intent parentIntent = getIntent();
//        String className = parentIntent.getStringExtra(PARENT_NAME_EXTRA);
//        // Create intent based on the parent class name
//        Intent newIntent = null;
//        try {
//            //you need to define the class with package name
//            newIntent = new Intent(this, Class.forName(PACKAGE_NAME + className));
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        // Return the created intent as the "up" activity
//        return newIntent;
//    }
}
