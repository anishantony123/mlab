package com.mlab.mlabandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Anish Antony on 16-12-2017.
 */

public class AuthenticationRequestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authentication_request);
        final TextInputLayout usernameWrapper = (TextInputLayout) findViewById(R.id.usernameWrapper);
        final TextInputLayout passwordWrapper = (TextInputLayout) findViewById(R.id.passwordWrapper);
        usernameWrapper.setHint("Mobile Number");
        passwordWrapper.setHint("Email Address");

        // Locate the button in activity_main.xml
        Button button = (Button) findViewById(R.id.verifyButton);

        // Capture button clicks
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start NewActivity.class
                Intent authenticationResponse = new Intent(AuthenticationRequestActivity.this,
                        AuthenticationResponseActivity.class);
                startActivity(authenticationResponse);
            }
        });


    }

 /*   @Override
    public void setContentView(View view) {
        super.setContentView(view);

    }*/
}
