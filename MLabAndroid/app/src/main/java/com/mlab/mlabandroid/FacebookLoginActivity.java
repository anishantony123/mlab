package com.mlab.mlabandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class FacebookLoginActivity extends AppCompatActivity {
    /*CalendarView calendarView;
    TextView dateDisplay;*/
    LoginButton loginButton;
    TextView loginStatusText;
    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       FacebookSdk.sdkInitialize(getApplicationContext());
        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

//Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //getSupportActionBar().setDisplayShowTitleEnabled(false);
       // getSupportActionBar().hide();
        setContentView(R.layout.facebook_login);
        loginButton = (LoginButton)findViewById(R.id.fb_login_bn);
        loginStatusText = (TextView)findViewById(R.id.loginStatusTextView);
        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                if(loginResult.getAccessToken().getUserId().equals("1657274484293686")) {
                    Intent authenticationRequestPage = new Intent(FacebookLoginActivity.this, HomePageActivity.class);
                    startActivity(authenticationRequestPage);
                } else {
                    Intent authenticationRequestPage = new Intent(FacebookLoginActivity.this, AuthenticationRequestActivity.class);
                    startActivity(authenticationRequestPage);
                }

                loginStatusText.setText("Login Success"+
                loginResult.getAccessToken().getUserId());
            }

            @Override
            public void onCancel() {
                loginStatusText.setText("Login Cancelled");
            }

            @Override
            public void onError(FacebookException error) {

            }
        });

       /* calendarView = (CalendarView) findViewById(R.id.calendarView);
        dateDisplay = (TextView) findViewById(R.id.date_display);
        dateDisplay.setText("Date: ");

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                dateDisplay.setText("Date: " + i2 + " / " + i1 + " / " + i);

                Toast.makeText(getApplicationContext(), "Selected Date:\n" + "Day = " + i2 + "\n" + "Month = " + i1 + "\n" + "Year = " + i, Toast.LENGTH_LONG).show();
            }
        });*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }
}
