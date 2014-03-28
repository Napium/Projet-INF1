package com.example.projet;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuEnfant extends ActionBarActivity {

    private ListView liste;
    String nom;
    private Button btnAddLoustic;

    EnfantsBDD enfantsBdd = new EnfantsBDD(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        setContentView(R.layout.activity_menu_enfant);

        btnAddLoustic = (Button) findViewById(R.id.addLoustic);
        btnAddLoustic.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent newEnfant = new Intent(MenuEnfant.this, CreationEnfant.class);
                startActivityForResult(newEnfant, 1);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        liste = (ListView) findViewById(R.id.listEnfant);

        EnfantsBDD enfantsBdd = new EnfantsBDD(this);

        // Données
        // Liste d'item
        List<HashMap<String, String>> listDonnees = new ArrayList<HashMap<String, String>>();

        enfantsBdd.open();
        listDonnees = enfantsBdd.selectAll();
        enfantsBdd.close();

        ListAdapter adapter = new SimpleAdapter(this, listDonnees, R.layout.item_listenfants, new String[] {"prenom", "age", "img"},
                new int[] {R.id.item_prenom, R.id.item_age, R.id.item_image });
        liste.setAdapter(adapter);


        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                HashMap<String, String> map = (HashMap<String, String>) liste.getItemAtPosition(position);

                Intent selectEnfant = new Intent(MenuEnfant.this, MenuActivity.class);
                selectEnfant.putExtra("prenom",map.get("prenom"));
                startActivityForResult(selectEnfant, 1);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
