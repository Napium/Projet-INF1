package com.example.projet;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MenuMathEx extends ActionBarActivity {

    private LinearLayout ex1;
    private LinearLayout ex2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_math);

        ex1 = (LinearLayout) findViewById(R.id.MathEx1);
        ex1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mathEx1 = new Intent(MenuMathEx.this, MathEx1Activity.class);
                startActivityForResult(mathEx1, 1);
            }
        });

        ex2 = (LinearLayout) findViewById(R.id.MathEx2);
        ex2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent mathEx2 = new Intent(MenuMathEx.this, MathEx2Activity.class);
                startActivityForResult(mathEx2, 1);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.math_menu, menu);
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
