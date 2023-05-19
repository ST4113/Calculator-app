package com.example.kaalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import org.mozilla.javascript.ast.TryStatement;

public class Splashkalkulator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashkalkulator);
        getSupportActionBar().hide();

        Thread thread = new Thread() {


            public void run() {
                try {
                    sleep(3000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(Splashkalkulator.this , MainActivity.class);
                    startActivity(intent);
                }
            }
        };thread.start();


    }
}