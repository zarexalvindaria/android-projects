package apc.mobprog.networkidentifier;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    final int MAXDIGIT = 7;
    final static int MINDIGIT = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button buttonPlus = findViewById(R.id.buttonPlus);
        Button buttonBackSpace = findViewById(R.id.buttonBackSpace);
        Button buttonClear = findViewById(R.id.buttonClear);
        Button buttonFindNetwork = findViewById(R.id.buttonFindNetwork);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonBackSpace.setOnClickListener(this);
        buttonClear.setOnClickListener(this);
        buttonFindNetwork.setOnClickListener(this);
    }

    //@SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {
        TextView prefix = findViewById(R.id.prefix);
        TextView network = findViewById(R.id.network);
        String prefixText = prefix.getText().toString();
        int prefixLength = prefixText.length();


        if ((v.getId() == R.id.button0) && (prefixLength < MAXDIGIT)) {
            NetworkFinder.setPrefixValue(prefixText, 0);
            prefix.setText(NetworkFinder.setPrefixValue);
        }
        if ((v.getId() == R.id.button1) && (prefixLength < MAXDIGIT)) {
            NetworkFinder.setPrefixValue(prefixText, 1);
            prefix.setText(NetworkFinder.setPrefixValue);
        }
        if ((v.getId() == R.id.button2) && (prefixLength < MAXDIGIT)) {
            NetworkFinder.setPrefixValue(prefixText, 2);
            prefix.setText(NetworkFinder.setPrefixValue);
        }
        if ((v.getId() == R.id.button3) && (prefixLength < MAXDIGIT)) {
            NetworkFinder.setPrefixValue(prefixText, 3);
            prefix.setText(NetworkFinder.setPrefixValue);
        }
        if ((v.getId() == R.id.button4) && (prefixLength < MAXDIGIT)) {
            NetworkFinder.setPrefixValue(prefixText, 4);
            prefix.setText(NetworkFinder.setPrefixValue);
        }
        if ((v.getId() == R.id.button5) && (prefixLength < MAXDIGIT)) {
            NetworkFinder.setPrefixValue(prefixText, 5);
            prefix.setText(NetworkFinder.setPrefixValue);
        }
        if ((v.getId() == R.id.button6) && (prefixLength < MAXDIGIT)) {
            NetworkFinder.setPrefixValue(prefixText, 6);
            prefix.setText(NetworkFinder.setPrefixValue);
        }
        if ((v.getId() == R.id.button7) && (prefixLength < MAXDIGIT)) {
            NetworkFinder.setPrefixValue(prefixText, 7);
            prefix.setText(NetworkFinder.setPrefixValue);
        }
        if ((v.getId() == R.id.button8) && (prefixLength < MAXDIGIT)) {
            NetworkFinder.setPrefixValue(prefixText, 8);
            prefix.setText(NetworkFinder.setPrefixValue);
        }
        if ((v.getId() == R.id.button9) && (prefixLength < MAXDIGIT)) {
            NetworkFinder.setPrefixValue(prefixText, 9);
            prefix.setText(NetworkFinder.setPrefixValue);
        }
        if ((v.getId() == R.id.buttonPlus) && (prefixLength < MAXDIGIT)) {
            if (prefixText.equals(""))
                prefix.setText("+");
        }
        if (v.getId() == R.id.buttonBackSpace) {
            if (prefixLength != 0)
                prefix.setText(prefixText.substring(0, prefixLength - 1));
        }
        if (v.getId() == R.id.buttonClear) {
            prefix.setText("");
            network.setText("");
        }
        if (v.getId() == R.id.buttonFindNetwork) {
            NetworkFinder.findNetwork(prefixText);
            network.setText(NetworkFinder.findNetwork);
        }
    }
}