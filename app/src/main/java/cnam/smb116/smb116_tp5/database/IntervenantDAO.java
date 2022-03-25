package cnam.smb116.smb116_tp5.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import cnam.smb116.smb116_tp5.model.Intervenant;

import java.util.ArrayList;
import java.util.List;

public class IntervenantDAO {

    private static final String TAG = IntervenantDAO.class.getName();
    private Context context;
    private IntervenantDbHelper dbHelper;
    private SQLiteDatabase db;

    public IntervenantDAO(Context context) {
        this.context = context;
        this.dbHelper = new IntervenantDbHelper(context);
        this.initializeDb();
    }

    public long create(Intervenant intervenant){
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Intervenant.TableDefinition.COLUMN_NAME_NOM, intervenant.getNom());
        values.put(Intervenant.TableDefinition.COLUMN_NAME_PRENOM, intervenant.getPrenom());
        values.put(Intervenant.TableDefinition.COLUMN_NAME_COURRIEL, intervenant.getCourriel());

        long newRowId = db.insert(Intervenant.TableDefinition.TABLE_NAME, null, values);
        db.close();
        return newRowId;
    }

    public List<Intervenant> query(){
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(Intervenant.TableDefinition.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null);

        List<Intervenant> intervenantList = new ArrayList<>();

        while (cursor.moveToNext()){
            Intervenant intervenant = new Intervenant(
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3)
            );
            intervenantList.add(intervenant);
        }
        cursor.close();
        return intervenantList;
    }

    public Cursor queryWithCursor(){
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(Intervenant.TableDefinition.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null);
        return cursor;
    }

    public void initializeDb(){
            db = dbHelper.getReadableDatabase();
            Cursor cursor = db.query(Intervenant.TableDefinition.TABLE_NAME,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null);
            if (!cursor.moveToNext()){
                Log.i(TAG, "initialize");
                Intervenant i1 = new Intervenant("Douin", "Jean-Michel", "jean-michel.douin@cnam.fr");
                Intervenant i2 = new Intervenant("Lemoine", "Frédéric", "frederic.lemoine@cnam.fr");

                this.create(i1);
                this.create(i2);
            }
    }
}
