package com.shrikant.nytimesarticlesearch;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONObject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cz.msebera.android.httpclient.Header;

public class SearchActivity extends AppCompatActivity {

    public final static String NYTIMES_URL =
            "http://api.nytimes.com/svc/search/v2/articlesearch.json";
    public final static String API_KEY = "api-key";
    public final static String PAGE = "page";
    public final static String QUERY = "q";
    public final static String RESPONSE = "response";
    public final static String DOCS = "docs";
    public final static String WEB_URL = "web_url";
    private final static String KEY = "24c318449f40e9695d3ff025f7cf7ba1:11:54196591";

    ArrayList<Article> articles;
    ArticleAdapter articleAdapter;

    @Bind(R.id.btSearch) Button searchButton;
    @Bind(R.id.etSearch) EditText searchEditText;
    @Bind(R.id.gvArticles) GridView articlesGridView;
    @Bind(R.id.toolbar) Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        articles = new ArrayList<>();
        articleAdapter = new ArticleAdapter(this, articles);
        articlesGridView.setAdapter(articleAdapter);
    }

    @OnClick(R.id.btSearch)
    public void searchArticle(View view) {
        //articles = new ArrayList<>();
        articleAdapter.clear();
        String searchText = searchEditText.getText().toString();

        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        RequestParams requestParams = new RequestParams();
        requestParams.put(API_KEY, KEY);
        requestParams.put(PAGE, 0);
        requestParams.put(QUERY, searchText);

        asyncHttpClient.get(NYTIMES_URL, requestParams, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                if (response != null) {
                    JSONObject jsonResponseObject = response.optJSONObject(RESPONSE);
                    if (jsonResponseObject != null) {
                        JSONArray jsonDocsArray = jsonResponseObject.optJSONArray(DOCS);
                        articleAdapter.addAll(Article.fromJSONArray(jsonDocsArray));
                    }
                }
                //articleAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString,
                                  Throwable throwable) {
                Log.w("ASYNC FAILURE", "HTTP Request failure: " + statusCode + " " +
                        throwable.getMessage());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
