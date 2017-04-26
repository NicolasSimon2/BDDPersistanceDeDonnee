package com.example.simon.basededonnee;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by simon on 15/03/2017.
 */

public class ChapitreBDD {
    //VERSION = 1
    //NOM_BDD = « Chapitres.db »
    //Chaque colonne a une valeur string
    //Chaque colonne a un identifiant numérique (1ère colonne a un indice 0).
    public static final String NOM_BDD = "Chapitre.db";
    public static final String COL_ID = "ID";
    public static final String COL_NAME = "Nom";
    public static final String COL_DESC = "Description";
    public static final String TABLE_CHAPITRE = "Chapitre";

    public static final int NUM_COL_ID = 0;
    public static final int NUM_COL_NAME = 0;
    public static final int NUM_COL_DESC = 0;

    public static final int VERSION = 1;

    private SQLiteDatabase bdd;
    private ChapiteBaseSQLite Chapitres;
    public ChapitreBDD(Context context){
        Chapitres = new ChapiteBaseSQLite(context, NOM_BDD, null, VERSION);
    }

    public void openForWritte() { bdd = Chapitres.getWritableDatabase();}

    public void openForRead() {
        bdd = Chapitres.getReadableDatabase();
    }

    public void close() {
        bdd.close() ;
    }

    public SQLiteDatabase getBdd() {
        return bdd;
    }

    public void insertChapter (String Nom, String Desc, TextView textView) {
        openForWritte();
        ContentValues content = new ContentValues();
        content.put(COL_NAME, Nom);
        content.put(COL_DESC, Desc);
        textView.setText(content.toString());
        bdd.insert("Chapitre", null, content);

    }

    public int updateChapter(int id, Chapitre chapitre){
        ContentValues content = new ContentValues();
        content.put(COL_NAME, chapitre.getNom());
        content.put(COL_DESC, chapitre.getDescription());
        return bdd.update(TABLE_CHAPITRE, content, COL_ID + " = " + id, null);
    }

    public int removeChapter(String name) {
        return bdd.delete(TABLE_CHAPITRE, COL_NAME + " = " + name, null);
    }

    public Chapitre getChapter(String name){
        openForRead();
        Cursor c = bdd.query(TABLE_CHAPITRE, new String[]{
                COL_ID, COL_NAME, COL_DESC}, COL_NAME + " LIKE \"" + name + "\"" + name + "\"", null, null, null, COL_NAME);
        return cursorToChapter(c);
    }

    public Chapitre cursorToChapter(Cursor c) {
        if (c.getCount() == 0) {
            c.close();
            return null;
        }
        Chapitre chapter = new Chapitre();
        chapter.setID(c.getInt(NUM_COL_ID));
        chapter.setNom(c.getString(NUM_COL_NAME));
        chapter.setDescription(c.getString(NUM_COL_DESC));
        c.close();
        return chapter;
    }

    public ArrayList<Chapitre> getAllChapters() {
        Cursor c = bdd.query(TABLE_CHAPITRE, new String[] {
                COL_ID, COL_NAME, COL_DESC }, null, null, null, null, COL_NAME);
        if (c.getCount() == 0) {
            c.close();
            return null;
        }
        ArrayList<Chapitre> chapterList = new
                ArrayList<Chapitre> ();
        while (c.moveToNext()) {
            Chapitre chapter = new Chapitre();
            chapter.setID(c.getInt(NUM_COL_ID));
            chapter.setNom(c.getString(NUM_COL_NAME));
            chapter.setDescription(c.getString(NUM_COL_DESC));
            chapterList.add(chapter);
        }
        c.close();
        return chapterList;
    }
}
