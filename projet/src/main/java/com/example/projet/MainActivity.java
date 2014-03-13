package com.example.projet;

import android.app.AlertDialog;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends ActionBarActivity {

    private ListView liste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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


        ListAdapter adapter = new SimpleAdapter(this, listDonnees, R.layout.item_listview, new String[] {"prenom", "age", "img"},
                new int[] {R.id.item_prenom, R.id.item_age, R.id.item_image });
        liste.setAdapter(adapter);

        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                //on récupère la HashMap contenant les infos de notre item
                HashMap<String, String> map = (HashMap<String, String>) liste.getItemAtPosition(position);
                //on créer une boite de dialogue
                AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                adb.setTitle("Sélection Item");
                adb.setMessage("Votre choix : " + map.get("prenom"));
                adb.setPositiveButton("Ok", null);
                adb.show();
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
