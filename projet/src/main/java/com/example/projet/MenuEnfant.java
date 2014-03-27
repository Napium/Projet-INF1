package com.example.projet;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuEnfant extends ActionBarActivity {

    private ListView liste;
    String nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        setContentView(R.layout.activity_menu_enfant);

        liste = (ListView) findViewById(R.id.listEnfant);

        List<String> exemple = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            exemple.add("Item " + i);
        }

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, exemple);
        //liste.setAdapter(adapter);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, exemple);

        // Données
        // Liste d'item
        List<HashMap<String, String>> listDonnees = new ArrayList<HashMap<String, String>>();
        // un item
        HashMap<String, String> map;
        map = new HashMap<String, String>();
        map.put("prenom", "Thomas");
        map.put("age", "8 ans");
        map.put("img", String.valueOf(R.drawable.enfant1));
        listDonnees.add(map);

        // un item
        map = new HashMap<String, String>();
        map.put("prenom", "Alexandre");
        map.put("age", "5 ans");
        map.put("img", String.valueOf(R.drawable.enfant1));
        listDonnees.add(map);

        // un item
        map = new HashMap<String, String>();
        map.put("prenom", "Maxime");
        map.put("age", "2 ans");
        map.put("img", String.valueOf(R.drawable.enfant1));
        listDonnees.add(map);

        // un item
        map = new HashMap<String, String>();
        map.put("prenom", "Raphaël");
        map.put("age", "2 ans");
        map.put("img", String.valueOf(R.drawable.enfant1));
        listDonnees.add(map);


        ListAdapter adapter = new SimpleAdapter(this, listDonnees, R.layout.item_listenfants, new String[] {"prenom", "age", "img"},
                new int[] {R.id.item_prenom, R.id.item_age, R.id.item_image });
        liste.setAdapter(adapter);

        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                //on récupère la HashMap contenant les infos de notre item
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
