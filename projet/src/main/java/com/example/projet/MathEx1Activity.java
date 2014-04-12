package com.example.projet;

import android.media.Image;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.Random;

public class MathEx1Activity extends ActionBarActivity {

    private TextView counter;
    private FrameLayout counterLayout;
    private GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_ex1);

        counter = (TextView) findViewById(R.id.counter);
        counterLayout = (FrameLayout) findViewById(R.id.layoutCounter);
        gridLayout = (GridLayout) findViewById(R.id.gridLayout);


        counterLayout.setVisibility(View.VISIBLE);
        decompte();
    }

    public void decompte (){

        counter.setText("Pret ?");

        new CountDownTimer(3000, 2) {

            public void onTick(long millisUntilFinished) {
                counter.setText(""+(millisUntilFinished + 1000) / 1000);
            }

            public void onFinish() {
                counterLayout.setVisibility(View.INVISIBLE);
                jeux();
            }
        }.start();
    }

    public void jeux (){

        Random r = new Random();
        int j = r.nextInt(10 - 1) + 1;
        for(int i=0;i<j;i++){
            ImageView image = new ImageView(this);
            image.setImageResource(R.drawable.lapin);
            gridLayout.addView(image);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.math_ex1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}
