package apc.mobprog.viewmodeldemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import apc.mobprog.viewmodeldemo.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
            Toast.makeText(MainActivity.this, "Daria, Zarex Alvin BSIT-MI",
                    Toast.LENGTH_SHORT).show();
        }
    }
}