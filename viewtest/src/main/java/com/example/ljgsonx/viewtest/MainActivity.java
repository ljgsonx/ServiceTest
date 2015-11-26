package com.example.ljgsonx.viewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DrawableView dv = new DrawableView(this);
        setContentView(R.layout.activity_main);
        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setText(Html.fromHtml("<h1 style='color:#fef'>text3:</h1>  Text <font color='#fef'>with</font> a <a href=\"http://www.google.com\">link</a>created in the Java source code using HTML."));

    }
}
