package com.example.simon.basededonnee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView Text1;
    String Nom;
    String Desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView List = (ListView)findViewById(R.id.BDDList);
        TextView Text1 = (TextView) findViewById(R.id.Text1);
        ChapitreBDD db = new ChapitreBDD(this);



        Log.d("Insert: ", "Inserting ..");
        db.insertChapter(Nom = "rfbervibh", Desc = "hebrb", Text1);
        db.insertChapter(Nom = "hfuezhfiojreou", Desc = "nidonusre", Text1);


        Log.d("Reading: ", "Reading all Chapitres..");
        List<Chapitre> chapitreList = db.getAllChapters();

        for (Chapitre chapitre : chapitreList) {
            String log = "Id: " + chapitre.getID() + " ,Name: " + chapitre.getNom() + " ,Address: " + chapitre.getDescription();
            Log.d("Chapitre: : ", log);
            Text1.setText(log);
        }


    }
}
