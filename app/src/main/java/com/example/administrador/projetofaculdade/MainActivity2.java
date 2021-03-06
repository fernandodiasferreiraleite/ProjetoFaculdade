package com.example.administrador.projetofaculdade;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class MainActivity2 extends AppCompatActivity {

    public TextView txtStatus;
    public LoginButton loginbutton;
    public CallbackManager callbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        FacebookSdk.sdkInitialize(getApplicationContext());
        initializeControlControls();
        loginWithFE();


    }

    private void initializeControlControls() {

        callbackManager = CallbackManager.Factory.create();

        loginbutton = (LoginButton) findViewById(R.id.loginbutton);


    }

    private void loginWithFE() {
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                Toast.makeText(MainActivity2.this, "Login sucesso\n" + loginResult.getAccessToken(), Toast.LENGTH_SHORT).show();



                Intent intent = new Intent(MainActivity2.this, ListDespesaActivity.class);
                startActivity(intent);






            }

            @Override
            public void onCancel() {
                txtStatus.setText("Login cancelado");

            }

            @Override
            public void onError(FacebookException error) {
                txtStatus.setText("Login Error:" + error.getMessage());

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);

    }





}
