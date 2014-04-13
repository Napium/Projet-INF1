package com.example.projet;

import android.content.Context;
import android.media.Image;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.Random;

public class MathEx1Activity extends ActionBarActivity {

    private TextView counter;
    private TextView reponse;
    private TextView temp;
    private TextView resultat;
    private TextView score;
    private LinearLayout vuejeu;
    private LinearLayout btnRes;
    private FrameLayout counterLayout;
    private GridLayout gridLayout;
    private Integer j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_ex1);

        counter = (TextView) findViewById(R.id.counter);
        temp = (TextView) findViewById(R.id.temp);
        resultat = (TextView) findViewById(R.id.resultat);
        score = (TextView) findViewById(R.id.score);
        score.setText("0");

        reponse = (TextView) findViewById(R.id.reponse);
        reponse.setCursorVisible(false);

        vuejeu = (LinearLayout) findViewById(R.id.vuejeu);
        btnRes = (LinearLayout) findViewById(R.id.btnRes);

        counterLayout = (FrameLayout) findViewById(R.id.layoutCounter);
        gridLayout = (GridLayout) findViewById(R.id.gridLayout);

        btnRes.setVisibility(View.INVISIBLE);
        counterLayout.setVisibility(View.VISIBLE);
        vuejeu.setVisibility(View.INVISIBLE);
        decompte();

        reponse.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }
            @Override
            public void afterTextChanged(Editable editable) {
                CharSequence str = reponse.getText();
                Character lastChar = reponse.getText().charAt(str.length() - 1);
                if (j.toString().equals(lastChar.toString())) {
                    Integer mavar = Integer.parseInt(score.getText().toString())+1 ;
                    score.setText(mavar.toString());
                    jeux();
                }
            }
        });
    }

    public void decompte (){

        new CountDownTimer(3000, 2) {

            public void onTick(long millisUntilFinished) {
                counter.setText(""+(millisUntilFinished + 1000) / 1000);
            }

            public void onFinish() {
                counterLayout.setVisibility(View.INVISIBLE);
                vuejeu.setVisibility(View.VISIBLE);
                jeux();
                showKeyboard();
                chrono();
            }
        }.start();
    }


    public void chrono (){
        new CountDownTimer(10000, 1) {

            public void onTick(long millisUntilFinished) {
                temp.setText(""+ millisUntilFinished / 1000);
            }

            public void onFinish() {
                hideKeyboard();
                reponse.setEnabled(false);
                vuejeu.setVisibility(View.INVISIBLE);
                counterLayout.setVisibility(View.VISIBLE);
                counter.setText(score.getText());
                if(Integer.parseInt(score.getText().toString()) > 5){
                    resultat.setText("Bravo !");
                }
                else {
                    resultat.setText("Pas assez Rapide!");
                }
                btnRes.setVisibility(View.VISIBLE);

            }
        }.start();
    }

    public void showKeyboard() {
        InputMethodManager imm = (InputMethodManager) this
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(this.getCurrentFocus(),
                InputMethodManager.SHOW_FORCED);
    }

    public void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) this
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(),
                0);
    }

    public void jeux (){

        gridLayout.removeAllViews();

        Random r = new Random();
        j = r.nextInt(10 - 1) + 1;
        for(int i=0;i<j;i++){
            ImageView image = new ImageView(this);
            image.setImageResource(R.drawable.lapin);
            gridLayout.addView(image,i);
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
