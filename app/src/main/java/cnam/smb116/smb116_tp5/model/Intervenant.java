package cnam.smb116.smb116_tp5.model;

import android.provider.BaseColumns;

import static android.os.Build.ID;

public class Intervenant {
    private long id;
    private String lastName;
    private String firstName;
    private String email;

    public Intervenant() {
    }

    public Intervenant(String lastName, String firstName, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static class TableDefinition implements BaseColumns {
        public static final String TABLE_NAME = "intervenant";
        public static final String COLUMN_NAME_LASTNAME = "last_name";
        public static final String COLUMN_NAME_FIRSTNAME = "first_name";
        public static final String COLUMN_NAME_EMAIL = "email";

        public static final String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID + " INTEGER PRIMARY KEY," +
                        COLUMN_NAME_LASTNAME + " TEXT," +
                        COLUMN_NAME_FIRSTNAME + " TEXT," +
                        COLUMN_NAME_EMAIL + " TEXT )";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;

    }
}
