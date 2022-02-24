package cnam.smb116.smb116_tp5.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;

import cnam.smb116.smb116_tp5.database.IntervenantDAO;
import cnam.smb116.smb116_tp5.database.IntervenantDbHelper;
import cnam.smb116.smb116_tp5.model.Intervenant;

import static cnam.smb116.smb116_tp5.ShowDatabase.TABLE_NAME;

public class MyContentProvider extends ContentProvider {

    public static final String AUTHORITY = "cnam.smb116.smb116_tp5.provider.MyContentProvider";
    public static final String TABLE_NAME = "intervenant";
    public static final Uri URI_INTERVENANT = Uri.parse("content://" + AUTHORITY + "/" + TABLE_NAME);

    public MyContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return -1;
    }

    @Override
    public String getType(Uri uri) {
        return "vnd.android.cursor.dir/" + AUTHORITY + "." + TABLE_NAME;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        return null;
    }

    @Override
    public boolean onCreate() {
        // TODO: Implement this to initialize your content provider on startup.
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        Cursor cursor = new IntervenantDAO(getContext()).queryWithCursor();
        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        return -1;
    }
}