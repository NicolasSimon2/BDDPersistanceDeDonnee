package com.example.simon.basededonnee;

/**
 * Created by simon on 15/03/2017.
 */

public class Chapitre {
    private int ID;
    private String Nom;
    private String Description;

    public Chapitre()
    {

    }
    public Chapitre(int id,String name,String desc)
    {
        this.ID=id;
        this.Nom=name;
        this.Description=desc;
    }

    public Chapitre(String name,String desc)
    {
        this.Nom=name;
        this.Description=desc;
    }

    public  int getID() { return ID; }

    public void setID(int id){ this.ID = id; }

    public  String getNom() { return Nom; }

    public void setNom(String nom){ this.Nom = nom; }

    public String getDescription(){  return Description; }

    public void setDescription(String descri){
        this.Description = descri;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nom du chapitre = " + Nom + "\n" + "Description du chapitre = " + Description);
        return sb.toString();
    }
}
