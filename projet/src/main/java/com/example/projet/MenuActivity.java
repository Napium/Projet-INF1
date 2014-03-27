package com.example.projet;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuActivity extends ActionBarActivity {

    private TextView tvBienvenu;
    private ImageView ivMath;
    private ImageView ivFrancais;
    private ImageView ivHistoire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_matiere);

        Intent i = getIntent();

        // Puis on récupère le nom donné dans l'autre activité, or null if no String value was found.
        String nom = i.getStringExtra("prenom");

        tvBienvenu = new TextView(this);
        tvBienvenu = (TextView) findViewById(R.id.hello);
        tvBienvenu.setText("Bienvenu " + nom + "!");

        ivMath = new ImageView(this);
        ivMath = (ImageView) findViewById(R.id.math);
        ivMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent selectMatiere = new Intent(MenuActivity.this, MenuMathEx.class);
                startActivityForResult(selectMatiere, 1);
            }
        });



        ivFrancais = new ImageView(this);
        ivFrancais = (ImageView) findViewById(R.id.francais);

        ivHistoire = new ImageView(this);
        ivHistoire = (ImageView) findViewById(R.id.histoire);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
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
