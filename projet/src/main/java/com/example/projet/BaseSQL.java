package com.example.projet;

/**
 * Created by lombardr on 27/03/14.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class BaseSQL extends SQLiteOpenHelper {

    private static final String TABLE_ENFANTS = "table_enfants";
    private static final String COL_ID = "ID";
    private static final String COL_PRENOM = "Prenom";
    private static final String COL_AGE = "Age";
    private static final String COL_IMG = "Image";

    private static final String CREATE_BDD = "CREATE TABLE " + TABLE_ENFANTS + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_PRENOM + " TEXT NOT NULL, "
            + COL_AGE + " TEXT NOT NULL, " + COL_IMG + " TEXT NOT NULL);";

    public BaseSQL(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //on créé la table à partir de la requête écrite dans la variable CREATE_BDD
        db.execSQL(CREATE_BDD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + TABLE_ENFANTS + ";");
        onCreate(db);
    }

}
