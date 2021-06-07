package apc.mobprog.fragmentexercise;

import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity implements ToolbarFragment.ToolbarListener,
        View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonAbout = findViewById(R.id.buttonAbout);

        buttonAbout.setOnClickListener(this);
    }

    @Override
    public void onButtonClick(int fontsize, String text) {

        TextFragment textFragment =
                (TextFragment)
                    getSupportFragmentManager().findFragmentById(R.id.text_fragment);

        textFragment.changeTextProperties(fontsize, text);
    }

    @Override
    public void onClick(View view) {
        TextFragment textFragment =
                (TextFragment)
                        getSupportFragmentManager().findFragmentById(R.id.text_fragment);
        textFragment.setAboutText();
    }
}