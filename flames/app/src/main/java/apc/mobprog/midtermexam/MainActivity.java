package apc.mobprog.midtermexam;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private EditText mName1, mName2;
    private TextView mResult;

    public void displayToast(View v) {
        Toast.makeText(MainActivity.this,"Zarex Alvin Daria, BSIT-MI", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mResult = findViewById(R.id.text);
        mName1 = findViewById(R.id.yourName);
        mName2 = findViewById(R.id.partnerName);
        Button ok = findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                String name1 = mName1.getText().toString().toLowerCase();
                String name2 = mName2.getText().toString().toLowerCase();

                if (name1.equals("") && name2.equals("") ||
                        name1.equals("") && name2.equals("")) {
                    mResult.setText("");
                    return;
                }

                String res = "FLAMES";
                switch (flames(name1, name2)) {
                    case "f":
                        res = "FRIENDSHIP";
                        break;
                    case "l":
                        res = "LOVE";
                        break;
                    case "a":
                        res = "AFFECTION";
                        break;
                    case "m":
                        res = "MARRIAGE";
                        break;
                    case "e":
                        res = "ENEMY";
                        break;
                    case "s":
                        res = "SIBLING";
                        break;
                }
                mResult.setText(res);
            }
        });
        Button mClear = findViewById(R.id.clear);
        mClear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View p1) {
                mName1.setText("");
                mName2.setText("");
                mResult.setText("");
            }
        });

    }

    private String flames(String name1, String name2) {
        int i, j, n = 0, len1, len2, tot;

        char[] array = name1.toCharArray();
        Arrays.sort(array);
        name1 = new String(array);
        name1 = name1.trim();
        Log.d("Flames ", name1);

        array = name2.toCharArray();
        Arrays.sort(array);
        name2 = new String(array);
        name2 = name2.trim();
        Log.d("Flames ", name2);

        if (name1.length() < name2.length()) {
            String t = name2;
            name2 = name1;
            name1 = t;
        }

        len1 = name1.length();
        len2 = name2.length();
        tot = name1.length() + name2.length();
        for (i = 0; i < len1; i++) {
            for (j = n; j < len2; j++) {
                if (name1.charAt(i) == name2.charAt(j)) {
                    tot -= 2;
                    n = ++j;
                    break;
                }
            }
        }
        Log.d("Flames ", "" + tot);
        if (tot <= 0) return "";
        return rem(tot);
    }

    private String rem(int n) {
        String result = "flames";
        String t;
        int n2;
        while (result.length() > 1) {
            n2 = n % result.length();
            n2 = (n2 == 0) ? result.length() : n2;
            t = result.substring(n2);
            result = result.substring(0, n2 - 1);
            result = t + result;
        }
        return result;
    }
}