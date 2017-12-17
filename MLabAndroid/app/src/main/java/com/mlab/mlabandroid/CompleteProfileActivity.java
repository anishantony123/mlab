package com.mlab.mlabandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Anish Antony on 16-12-2017.
 */

public class CompleteProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complete_profile);

        Button button = (Button) findViewById(R.id.verifyButton);

        // Capture button clicks
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent authenticationResponse = new Intent(CompleteProfileActivity.this,
                        ReviewNoteActivity.class);
                startActivity(authenticationResponse);
            }
        });

    }
}
