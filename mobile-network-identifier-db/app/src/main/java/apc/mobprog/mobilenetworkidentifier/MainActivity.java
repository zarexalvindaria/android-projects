 /*
 * Mobile Network Identifier - a simple app which identifies the network of mobile number
 * prefixes.
 * @author  Zarex Alvin Daria
 * @version 1.0
 */

package apc.mobprog.mobilenetworkidentifier;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import apc.mobprog.mobilenetworkidentifier.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }
}