package com.mlab.mlabandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Anish Antony on 16-12-2017.
 */

public class ChooseLanguageActivity  extends AppCompatActivity {
    String[] languageArray = {"English","Malayalam","Tamil","Telungu",
            "WebOS","Ubuntu","Windows7","Max OS X"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.choose_language_list, languageArray);

        ListView listView = (ListView) findViewById(R.id.language_list);
        listView.setAdapter(adapter);

    }
 }
