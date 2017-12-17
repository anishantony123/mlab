package com.mlab.mlabandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.mlab.mlabandroid.list.JobModel;

/**
 * Created by Anish Antony on 16-12-2017.
 */

public class ChooseLanguageActivity  extends AppCompatActivity {
    String[] languageArray = {"English","Malayalam","Tamil","Telungu",
            "Hindi","Bangali","Kannada","Gujarathi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_language);
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.choose_language_list, languageArray);

        ListView listView = (ListView) findViewById(R.id.language_list);
        listView.setAdapter(adapter);

        Button button = (Button) findViewById(R.id.confirm);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Start NewActivity.class
                Intent authenticationResponse = new Intent(ChooseLanguageActivity.this,
                        CompleteProfileActivity.class);
                startActivity(authenticationResponse);
            }
        });


    }
 }
