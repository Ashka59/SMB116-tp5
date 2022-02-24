package cnam.smb116.smb116_tp5;

import android.app.ListActivity;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends ListActivity {

    private static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, ShowDatabase.class);
        startActivity(intent);
    }
}