package com.example.projet;

/**
 * Created by lombardr on 27/03/14.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EnfantsBDD {

    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "enfants.db";

    private static final String TABLE_ENFANTS = "TABLE_ENFANTS";
    private static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;
    private static final String COL_PRENOM = "Prenom";
    private static final int NUM_COL_PRENOM = 1;
    private static final String COL_AGE = "Age";
    private static final int NUM_COL_AGE = 2;
    private static final String COL_IMG = "Image";
    private static final int NUM_COL_IMG = 3;

    private SQLiteDatabase bdd;

    private BaseSQL maBaseSQLite;

    public EnfantsBDD(Context context){
        maBaseSQLite = new BaseSQL(context, NOM_BDD, null, VERSION_BDD);
    }

    public void open(){
        bdd = maBaseSQLite.getWritableDatabase();
    }

    public void close(){
        bdd.close();
    }

    public SQLiteDatabase getBDD(){
        return bdd;
    }

    public long insertEnfant(Enfant enfant){
        ContentValues values = new ContentValues();
        values.put(COL_PRENOM, enfant.getPrenom());
        values.put(COL_AGE, enfant.getAge());
        if(enfant.getImage() != null){
            values.put(COL_IMG, enfant.getImage());
        }
        return bdd.insert(TABLE_ENFANTS, null, values);
    }

    public int updateEnfant(int id, Enfant enfant){
        ContentValues values = new ContentValues();
        values.put(COL_PRENOM, enfant.getPrenom());
        values.put(COL_AGE, enfant.getAge());
        values.put(COL_IMG, enfant.getImage());
        return bdd.update(TABLE_ENFANTS, values, COL_ID + " = " +id, null);
    }

    public int removeEnfantWithID(int id){
       return bdd.delete(TABLE_ENFANTS, COL_ID + " = " +id, null);
    }

    public Enfant getEnfantWithNom(String Age){
        Cursor c = bdd.query(TABLE_ENFANTS, new String[] {COL_ID, COL_PRENOM, COL_AGE}, COL_AGE + " LIKE \"" + Age +"\"", null, null, null, null);
        return cursorToEnfant(c);
    }

    private Enfant cursorToEnfant(Cursor c){
        if (c.getCount() == 0)
            return null;
        c.moveToFirst();
        Enfant enfant = new Enfant();
        enfant.setId(c.getInt(NUM_COL_ID));
        enfant.setPrenom(c.getString(NUM_COL_PRENOM));
        enfant.setAge(c.getInt(NUM_COL_AGE));
        enfant.setImage(c.getString(NUM_COL_IMG));
        c.close();

        return enfant;
    }

    public List selectAll(){

        Cursor c = bdd.query(TABLE_ENFANTS, new String[] {COL_ID, COL_PRENOM, COL_AGE, COL_IMG}, null, null, null, null, null);

        List<HashMap<String, String>> listDonnees = new ArrayList<HashMap<String, String>>();

        HashMap<String, String> map;
        map = new HashMap<String, String>();

        if (c.getCount() == 0) {
            listDonnees.add(map);
            return listDonnees;
        }

        if (c.moveToFirst()) {
            map = new HashMap<String, String>();
            map.put("prenom", c.getString(NUM_COL_PRENOM));
            map.put("age", c.getInt(NUM_COL_AGE) + " ans");
            map.put("img", c.getString(NUM_COL_IMG));
            listDonnees.add(map);

            while(c.moveToNext()){
                map = new HashMap<String, String>();
                map.put("prenom", c.getString(NUM_COL_PRENOM));
                map.put("age", c.getInt(NUM_COL_AGE) + " ans");
                map.put("img", c.getString(NUM_COL_IMG));
                listDonnees.add(map);
            }
        }
        c.close();

        return listDonnees;
    }
}