package com.shrikant.nytimesarticlesearch;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
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

    enum SortOrder {
        NEWEST("Newest"), OLDEST("Oldest");

        SortOrder(String input) {
        }
    }

    enum NewsDesk {
        ARTS, FASHION_AND_STYLE, SPORTS;
    }

    public static class FilterAttributes {
        static String beginDate =  "" + System.currentTimeMillis();
        static SortOrder sortOder = SortOrder.NEWEST;
        static List<NewsDesk> newsDesks = Arrays.asList(NewsDesk.SPORTS);
    }

//    @Bind(R.id.btSearch) Button searchButton;
//    @Bind(R.id.etSearch) EditText searchEditText;
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

    //@OnClick(R.id.btSearch)
    //public void searchArticle(View view) {
    public void searchArticle(String query) {

        Log.i("SEARCHACTIVITY", "beginDate: " + FilterAttributes.beginDate + "sortoder" +
                FilterAttributes.sortOder.toString());

        for (NewsDesk n :  FilterAttributes.newsDesks) {
            Log.i("SEARCHACTIVITY", "News desk: " + n.toString());
        }

        //articles = new ArrayList<>();
        articleAdapter.clear();
        //String searchText = searchEditText.getText().toString();
        String searchText = query;

        Log.i("SEARCHACTIVITY", "Search text: " + searchText);

        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        RequestParams requestParams = new RequestParams();
        requestParams.put(API_KEY, KEY);
        requestParams.put(PAGE, 0);
        requestParams.put(QUERY, searchText);

        asyncHttpClient.get(NYTIMES_URL, requestParams, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Log.i("SEARCHACTIVITY", "Inside success callback");
                if (response != null) {
                    Log.i("SEARCHACTIVITY", "Got response");
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
        MenuItem searchMenuItem = menu.findItem(R.id.action_search);

        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchMenuItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // perform query here
                // workaround to avoid issues with some emulators and keyboard devices firing twice if a keyboard enter is used
                // see https://code.google.com/p/android/issues/detail?id=24599

//                Toast.makeText(getApplicationContext(), "Search entered: " + query,
//                        Toast.LENGTH_LONG).show();
                //showProgress();
                searchArticle(query);
                //hideProgress();
                searchView.clearFocus();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//
//            Toast.makeText(getApplicationContext(), "Settings clicked", Toast.LENGTH_SHORT).show();
//            return true;
//        }
        if (id == R.id.action_search_filter) {

            Toast.makeText(getApplicationContext(), "Filter clicked", Toast.LENGTH_SHORT).show();
            launchFilterDialog();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void launchFilterDialog() {
        SearchFilterFragment searchFilterDialog = new SearchFilterFragment();
        FragmentManager fm = getSupportFragmentManager();
        searchFilterDialog.show(fm, "filter");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("SEARCHACTIVITY", "Starting back");
        Toast.makeText(this, "Back to activity", Toast.LENGTH_SHORT).show();
    }
}
