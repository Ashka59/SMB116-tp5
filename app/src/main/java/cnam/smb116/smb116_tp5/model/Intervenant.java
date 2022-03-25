package cnam.smb116.smb116_tp5.model;

import android.provider.BaseColumns;

public class Intervenant {
    private long id;
    private String nom;
    private String prenom;
    private String courriel;

    public Intervenant(String nom, String prenom, String courriel) {
        this.nom = nom;
        this.prenom = prenom;
        this.courriel = courriel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public static class TableDefinition implements BaseColumns {
        public static final String TABLE_NAME = "intervenant";
        public static final String COLUMN_NAME_NOM = "Nom";
        public static final String COLUMN_NAME_PRENOM = "Prénom";
        public static final String COLUMN_NAME_COURRIEL = "Courriel";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME_NOM + " TEXT," +
                        COLUMN_NAME_PRENOM + " TEXT," +
                        COLUMN_NAME_COURRIEL + " TEXT )";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;

    }
}
