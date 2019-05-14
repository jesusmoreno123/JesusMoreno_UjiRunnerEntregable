package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import testFramework.TestFramework;
import testParallax.TestParallax;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void testFramework(View view) {
        Intent intent = new Intent(this, TestFramework.class);
        startActivity(intent);
    }
    public void testParallax(View view) {
        Intent intent = new Intent(this, TestParallax.class);
        startActivity(intent);
    }
}
