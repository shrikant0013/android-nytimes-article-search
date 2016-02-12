package com.shrikant.nytimesarticlesearch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by @author Shrikant Pandhare on 2/11/16.
 */
public class SearchFilterFragment extends DialogFragment {

    @Bind(R.id.spSortOrder) Spinner spinnerSortOrder;
    @Bind(R.id.btnSave) Button saveButton;
    @Bind(R.id.btnCancel) Button cancelButton;
    @Bind(R.id.etBeginDate) EditText beginDateEditText;
    @Bind(R.id.cbArts) CheckBox artsCheckbox;
    @Bind(R.id.cbFashion_and_Stlye) CheckBox fashionAndStyleCheckbox;
    @Bind(R.id.cbSports) CheckBox sportsCheckbox;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_search_filter, container, false);
        ButterKnife.bind(this, rootView);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.sortorder_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerSortOrder.setAdapter(adapter);
        spinnerSortOrder.setSelection(1, true);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SearchActivity.FilterAttributes.beginDate = beginDateEditText.getText().toString();
                updateNewsDesk();
                Toast.makeText(getActivity(), "Save clicked", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Cancel clicked", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });

        beginDateEditText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v4.app.DialogFragment newFragment = new DatePickerFragment();
                newFragment.setTargetFragment(SearchFilterFragment.this, 300);
                newFragment.show(getFragmentManager(), "datePicker");
                //dismiss();
            }
        });
    }

    public void fromDate(String inputText) {
        beginDateEditText.setText(inputText);
    }

    private void updateNewsDesk() {
        Log.i("Filter_Frag", "Updating NewsDesk");
        List<SearchActivity.NewsDesk> newsDesks = new ArrayList<SearchActivity.NewsDesk>();

        if (artsCheckbox.isChecked()) {
            newsDesks.add(SearchActivity.NewsDesk.ARTS);
        }
        if (fashionAndStyleCheckbox.isChecked()) {
            newsDesks.add(SearchActivity.NewsDesk.FASHION_AND_STYLE);
        }
        if (sportsCheckbox.isChecked()) {
            newsDesks.add(SearchActivity.NewsDesk.SPORTS);
        }

        SearchActivity.FilterAttributes.newsDesks = newsDesks;
    }
}
