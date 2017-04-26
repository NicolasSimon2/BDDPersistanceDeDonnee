package com.example.simon.basededonnee;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by simon on 15/03/2017.
 */

public class ChapiteBaseSQLite extends SQLiteOpenHelper {
    public static final String NomTable = "Chapitre";
    public static final String ID = "ID";
    public static final String Nom = "Nom";
    public static final String Description = "Description";


    public static final String CREATE_BDD =

            "CREATE TABLE " + NomTable + " (" +

                    ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +

                    Nom + " TEXT, " +

                    Description + " TEXT);";



    public ChapiteBaseSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static final String CHAPITRE_TABLE_DROP = "DROP TABLE IF EXISTS " + NomTable + ";";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BDD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int OldVersion, int NewVersion) {
        db.execSQL(CHAPITRE_TABLE_DROP);
        onCreate(db);
    }

}
