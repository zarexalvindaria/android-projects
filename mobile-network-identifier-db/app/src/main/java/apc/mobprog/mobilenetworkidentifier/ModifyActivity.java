package apc.mobprog.mobilenetworkidentifier;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import apc.mobprog.mobilenetworkidentifier.ui.main.ModifyFragment;

public class ModifyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modify_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ModifyFragment.newInstance())
                    .commitNow();
        }
    }
}