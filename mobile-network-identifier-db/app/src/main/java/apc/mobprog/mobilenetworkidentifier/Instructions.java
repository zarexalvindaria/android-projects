package apc.mobprog.mobilenetworkidentifier;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Instructions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        addInstructions();
        goBacktoMainPage();
    }

    @SuppressLint("SetTextI18n")
    private void addInstructions() {
        TextView instruction1 = findViewById(R.id.instruction1);
        instruction1.setText("1. If it's your first time opening the application, you need to " +
                "add the prefixes manually. To do that, you need to click the " +
                "ADD DEFAULT PREFIXES button. This will add all the default prefixes " +
                "to the database. You can verify that the prefixes were added when they are " +
                "already populated on the Saved Prefixes List.");

        TextView instruction2 = findViewById(R.id.instruction2);
        instruction2.setText("2. After doing Step 1, you can now go back to the " +
                "Home page and search the equivalent Mobile Network of the prefix you're looking " +
                "for. Your input should have at least 4 characters so make sure that your input " +
                "is at least 4-digit. You will get a warning \"Prefix is too short!\"" +
                " if your input is less than 4 characters. The version of the number with the area " +
                "code is also saved in the database so either of your search should return an " +
                "equivalent network.");

        TextView instruction3 = findViewById(R.id.instruction3);
        instruction3.setText("3.If in any case you did not get any result from your search, " +
                "try to narrow it down (e.g. instead of +639xx, try 09xx). If after " +
                "several tries you did not get the network, go back to the database page and " +
                "add manually add the prefix and its Network value .");

        TextView instruction4 = findViewById(R.id.instruction4);
        instruction4.setText("Note: The ADD DEFAULT PREFIXES button should only be clicked once." +
                "Adding it twice will cause duplicate mobile number prefixes to be saved in the " +
                "database. If that happens, you can easily clear the database by clicking the " +
                "!CLEAR DATABASE button.");


        instruction1.setMovementMethod(new ScrollingMovementMethod());
        instruction2.setMovementMethod(new ScrollingMovementMethod());
        instruction3.setMovementMethod(new ScrollingMovementMethod());
        instruction4.setMovementMethod(new ScrollingMovementMethod());
    }

    private void goBacktoMainPage() {
        Button backBtn = findViewById(R.id.BtnBacktoMain);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}