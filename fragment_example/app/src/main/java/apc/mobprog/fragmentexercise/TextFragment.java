package apc.mobprog.fragmentexercise;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TextFragment extends Fragment {

    private static TextView textview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text, container, false);
        textview = view.findViewById(R.id.textView1);

        return view;
    }

    public void changeTextProperties(int fontsize, String text) {
        textview.setTextSize(fontsize);
        textview.setText(text);
    }

    public void setAboutText() {
        String aboutText = "Daria, Zarex Alvin N. BSIT-MI";
        textview.setText(aboutText);
    }
}