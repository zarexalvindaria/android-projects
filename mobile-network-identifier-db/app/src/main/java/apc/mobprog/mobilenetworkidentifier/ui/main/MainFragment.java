 /*
 * Mobile Network Identifier - a simple app which identifies the network of mobile number
 * prefixes.
 * @author  Zarex Alvin Daria
 * @version 1.0
 */

package apc.mobprog.mobilenetworkidentifier.ui.main;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import apc.mobprog.mobilenetworkidentifier.Instructions;
import apc.mobprog.mobilenetworkidentifier.MobNumber;
import apc.mobprog.mobilenetworkidentifier.ModifyActivity;
import apc.mobprog.mobilenetworkidentifier.R;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private EditText mobNumPrefix;
    private TextView mobileNetwork;
    final int MAXPREFIXLENGTH = 7; // maximum length of prefix
    final int MINPREFIXLENGTH = 4; // maximum length of prefix
    /* boolean isItInDatabase; */
    int mobNumPrefixLength;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mobNumPrefix = getView().findViewById(R.id.mobNumPrefix);
        mobileNetwork = getView().findViewById(R.id.mobNetwork);

        listenerSetup();
        observerSetup();
    }

    private void clearFields() { // clears fields
        mobNumPrefix.setText("");
        mobileNetwork.setText("");
    }

    @SuppressLint("SetTextI18n")
    private void setNetworkValuetoMissing() {
        mobileNetwork.setText("PREFIX NOT FOUND");
    }

    private void listenerSetup() {
        Button findBtn = getView().findViewById(R.id.findBtn);
        Button clearBtn = getView().findViewById(R.id.clearFieldsBtn);
        Button nextPageBtn = getView().findViewById(R.id.nextPageBtn);
        Button instructionsBtn = getView().findViewById(R.id.gotoInstructionsBtn);

        // Number Buttons
        final Button Btn1 = getView().findViewById(R.id.Btn1);
        final Button Btn2 = getView().findViewById(R.id.Btn2);
        final Button Btn3 = getView().findViewById(R.id.Btn3);
        final Button Btn4 = getView().findViewById(R.id.Btn4);
        final Button Btn5 = getView().findViewById(R.id.Btn5);
        final Button Btn6 = getView().findViewById(R.id.Btn6);
        final Button Btn7 = getView().findViewById(R.id.Btn7);
        final Button Btn8 = getView().findViewById(R.id.Btn8);
        final Button Btn9 = getView().findViewById(R.id.Btn9);
        final Button Btn0 = getView().findViewById(R.id.Btn0);
        final Button BtnPlus = getView().findViewById(R.id.BtnPlus);
        final ImageButton BtnbackSpace = getView().findViewById(R.id.BtnbackSpace);
        // Ends Number Buttons

        findBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // searches the prefix in the Database
                // isItInDatabase = false;
                mobNumPrefixLength = mobNumPrefix.getText().length();
                if (mobNumPrefixLength < MINPREFIXLENGTH) {
                    Toast.makeText(getActivity(), "Prefix too short!", Toast.LENGTH_LONG).show();
                } else {
                    mViewModel.findMobileNumber(mobNumPrefix.getText().toString());
                    /* supposedly for substring of input - to be added later
                    while ((!isItInDatabase) && (mobNumPrefixLength >= MINPREFIXLENGTH)) {
                        mViewModel.findMobileNumber(mobNumPrefix.getText().toString().substring(0,
                                mobNumPrefixLength));
                        mobNumPrefixLength--;
                        }
                     */
                }
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearFields();
            }
        });  // clears the fields

        nextPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // redirects to the Database Activity
                Intent intent = new Intent(getActivity(), ModifyActivity.class);
                startActivity(intent);
            }
        });

        // redirects to the Instructions Activity
        instructionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Instructions.class);
                startActivity(intent);
            }
        });

        Btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPrefixValue("0");
            }
        });

        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPrefixValue("1");
            }
        });

        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPrefixValue("2");
            }
        });

        Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPrefixValue("3");
            }
        });

        Btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPrefixValue("4");
            }
        });

        Btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPrefixValue("5");
            }
        });

        Btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPrefixValue("6");
            }
        });

        Btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPrefixValue("7");
            }
        });

        Btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPrefixValue("8");
            }
        });

        Btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPrefixValue("9");
            }
        });

        BtnPlus.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                mobileNetwork.setText("{{NETWORK}}");
                setPrefixValue("+63");
            }
        });

        BtnbackSpace.setOnClickListener(new View.OnClickListener() { // executes the backspace button
            @Override
            public void onClick(View view) {
                String prefixText = mobNumPrefix.getText().toString();
                int prefixLength = mobNumPrefix.length();
                if (prefixLength != 0) {
                    mobNumPrefix.setText(prefixText.substring(0, prefixLength - 1));
                }
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void setPrefixValue(String input) { // inputs the number value to prefix field
        String prefText = mobNumPrefix.getText().toString();
        int prefixLength = mobNumPrefix.length();
        if (prefixLength < MAXPREFIXLENGTH) {
            mobNumPrefix.setText(prefText + input);
        } else {
            Toast.makeText(getActivity(), "Maximum of 7-digit prefix only",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private void observerSetup() {
        mViewModel.getSearchResults().observe(getViewLifecycleOwner(),
                new Observer<List<MobNumber>>() {
                    @Override
                    public void onChanged(@Nullable final List<MobNumber> mobNumbers) {
                        if (mobNumbers.size() > 0) { // executes if prefix is found
                            /* isItInDatabase = true; */
                            mobileNetwork.setText(mobNumbers.get(0).getMobileNetwork());
                        } else { // executes if prefix is not found
                            /* isItInDatabase = false; */
                            setNetworkValuetoMissing();
                            Toast notFoundToast = Toast.makeText(getActivity(),
                                    "Narrow down your search!", Toast.LENGTH_SHORT);
                            notFoundToast.show();
                        }
                    }
                });
    }
}