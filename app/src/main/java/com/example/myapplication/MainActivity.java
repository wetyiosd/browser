package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

   private WebView web;
   private EditText inputUrl;
   private Button forwardButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        web = (WebView) findViewById(R.id.WebView);
        inputUrl = (EditText) findViewById(R.id.url);
        forwardButton = (Button) findViewById(R.id.button3);
        backButton = (Button) findViewById(R.id.button2);

        WebSettings ws = web.getSettings();
        ws.setJavaScriptEnabled(true);
        web.loadUrl("https://ya.ru/");
        web.setWebViewClient(new WebViewClient());
    }



    public void web(View view) {
        String url = inputUrl.getText().toString();

        if (!url.startsWith("https://")) {
            url = "https://" + url ;
        }
        web.loadUrl(url);
        inputUrl.setText("");


        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), inputMethodManager.HIDE_NOT_ALWAYS);

    }


    public void next(View v) {
        if (web.canGoForward())
            web.goForward();
    }
    public void back(View v) {
        if (web.canGoBack())
            web.goBack();
    }





}