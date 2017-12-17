package com.mlab.mlabandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Anish Antony on 17-12-2017.
 */

public class ReviewNoteActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.review_note);

        Button button = (Button) findViewById(R.id.doneButton);

        // Capture button clicks
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent authenticationResponse = new Intent(ReviewNoteActivity.this,
                        FacebookLoginActivity.class);
                startActivity(authenticationResponse);
            }
        });

    }
}