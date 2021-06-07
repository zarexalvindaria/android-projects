package apc.mobprog.mobilenetworkidentifier.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.List;
import java.util.Locale;
import apc.mobprog.mobilenetworkidentifier.MainActivity;
import apc.mobprog.mobilenetworkidentifier.MobNumber;
import apc.mobprog.mobilenetworkidentifier.R;

public class ModifyFragment extends Fragment {

    private MainViewModel mViewModel;
    private MobNumberListAdapter adapter;
    // private MobNumberDao mobNumberDao;


    private TextView mobileNumberId;
    private EditText mobNumPrefix;
    private EditText mobileNetwork;

    public static ModifyFragment newInstance() {
        return new ModifyFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.modify_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mobileNumberId = getView().findViewById(R.id.mobNumID);
        mobNumPrefix = getView().findViewById(R.id.mobNumPrefix);
        mobileNetwork = getView().findViewById(R.id.mobNetwork);

        listenerSetup();
        observerSetup();
        recyclerSetup();
    }

    private void clearFields() {
        mobileNumberId.setText("");
        mobNumPrefix.setText("");
        mobileNetwork.setText("");
    }


    private void listenerSetup() {
        /* Add all the number prefixes and network */
        Button addAllPrefixesBtn = getView().findViewById(R.id.addAllPrefixesBtn);
        Button addBtn = getView().findViewById(R.id.addBtn);
        Button findBtn = getView().findViewById(R.id.findBtn);
        Button deleteBtn = getView().findViewById(R.id.deleteBtn);
        ImageButton backBtn = getView().findViewById(R.id.backBtn);
        Button clearBtn = getView().findViewById(R.id.clearFieldsBtn);
        Button ClearDatabase = getView().findViewById(R.id.clearDatabaseBtn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = mobNumPrefix.getText().toString();
                String network = mobileNetwork.getText().toString();
                if (!number.equals("") && !network.equals("")) {
                    MobNumber mobNumber = new MobNumber(number,
                            network);
                    mViewModel.insertMobileNumber(mobNumber);
                    clearFields();
                } else {
                    mobileNumberId.setText("Incomplete information");
                }
            }
        });

        findBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.findMobileNumber(mobNumPrefix.getText().toString());
            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.deleteMobileNumber(mobNumPrefix.getText().toString());
                clearFields();
            }
        });
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearFields();
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        addAllPrefixesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAllPrefixes();
            }
        });
        ClearDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewModel.deleteDatabase();
            }
        });

    }

    private void observerSetup() {
        mViewModel.getAllMobileNumbers().observe(getViewLifecycleOwner(),
                new Observer<List<MobNumber>>() {
                    @Override
                    public void onChanged(@Nullable final List<MobNumber> mobNumbers) {
                        adapter.setNumbersList(mobNumbers);
                    }
                });
        mViewModel.getSearchResults().observe(getViewLifecycleOwner(),
                new Observer<List<MobNumber>>() {
                    @Override
                    public void onChanged(@Nullable final List<MobNumber> numbers) {
                        if (numbers.size() > 0) {
                            mobileNumberId.setText(String.format(Locale.US, "%d",
                                    numbers.get(0).getId()));
                            mobNumPrefix.setText(numbers.get(0).getMobNumPrefix());
                            mobileNetwork.setText(numbers.get(0).getMobileNetwork());
                        } else {
                            mobileNumberId.setText("No Match");
                        }
                    }
                });
    }

    private void recyclerSetup() {
        RecyclerView recyclerView;
        adapter = new MobNumberListAdapter(R.layout.mobilenumber_list_item);
        recyclerView = getView().findViewById(R.id.number_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }


    private MutableLiveData<List<MobNumber>> searchResults =
            new MutableLiveData<>();
    private LiveData<List<MobNumber>> allMobileNumbers;


    private void addAllPrefixes() { // adds all default prefixes
        MobNumber prefix1 = new MobNumber("0905", "GLOBE/TM");
        MobNumber prefix2 = new MobNumber("0906", "GLOBE/TM");
        MobNumber prefix3 = new MobNumber("0915", "GLOBE/TM");
        MobNumber prefix4 = new MobNumber("0916", "GLOBE/TM");
        MobNumber prefix5 = new MobNumber("0917", "GLOBE/TM");
        MobNumber prefix6 = new MobNumber("0926", "GLOBE/TM");
        MobNumber prefix7 = new MobNumber("0927", "GLOBE/TM");
        MobNumber prefix8 = new MobNumber("0935", "GLOBE/TM");
        MobNumber prefix9 = new MobNumber("0936", "GLOBE/TM");
        MobNumber prefix10 = new MobNumber("0937", "GLOBE/TM");
        MobNumber prefix11 = new MobNumber("0945", "GLOBE/TM");
        MobNumber prefix12 = new MobNumber("0953", "GLOBE/TM");
        MobNumber prefix13 = new MobNumber("0954", "GLOBE/TM");
        MobNumber prefix14 = new MobNumber("0955", "GLOBE/TM");
        MobNumber prefix15 = new MobNumber("0956", "GLOBE/TM");
        MobNumber prefix16 = new MobNumber("0965", "GLOBE/TM");
        MobNumber prefix17 = new MobNumber("0966", "GLOBE/TM");
        MobNumber prefix18 = new MobNumber("0967", "GLOBE/TM");
        MobNumber prefix19 = new MobNumber("0975", "GLOBE/TM");
        MobNumber prefix20 = new MobNumber("0977", "GLOBE/TM");
        MobNumber prefix21 = new MobNumber("0978", "GLOBE/TM");
        MobNumber prefix22 = new MobNumber("0979", "GLOBE/TM");
        MobNumber prefix23 = new MobNumber("0995", "GLOBE/TM");
        MobNumber prefix24 = new MobNumber("0996", "GLOBE/TM");
        MobNumber prefix25 = new MobNumber("0997", "GLOBE/TM");
        MobNumber prefix26 = new MobNumber("+63905", "GLOBE/TM");
        MobNumber prefix27 = new MobNumber("+63906", "GLOBE/TM");
        MobNumber prefix28 = new MobNumber("+63915", "GLOBE/TM");
        MobNumber prefix29 = new MobNumber("+63916", "GLOBE/TM");
        MobNumber prefix30 = new MobNumber("+63917", "GLOBE/TM");
        MobNumber prefix31 = new MobNumber("+63926", "GLOBE/TM");
        MobNumber prefix32 = new MobNumber("+63927", "GLOBE/TM");
        MobNumber prefix33 = new MobNumber("+63935", "GLOBE/TM");
        MobNumber prefix34 = new MobNumber("+63936", "GLOBE/TM");
        MobNumber prefix35 = new MobNumber("+63937", "GLOBE/TM");
        MobNumber prefix36 = new MobNumber("+63945", "GLOBE/TM");
        MobNumber prefix37 = new MobNumber("+63953", "GLOBE/TM");
        MobNumber prefix38 = new MobNumber("+63954", "GLOBE/TM");
        MobNumber prefix39 = new MobNumber("+63955", "GLOBE/TM");
        MobNumber prefix40 = new MobNumber("+63956", "GLOBE/TM");
        MobNumber prefix41 = new MobNumber("+63965", "GLOBE/TM");
        MobNumber prefix42 = new MobNumber("+63966", "GLOBE/TM");
        MobNumber prefix43 = new MobNumber("+63967", "GLOBE/TM");
        MobNumber prefix44 = new MobNumber("+63975", "GLOBE/TM");
        MobNumber prefix45 = new MobNumber("+63977", "GLOBE/TM");
        MobNumber prefix46 = new MobNumber("+63978", "GLOBE/TM");
        MobNumber prefix47 = new MobNumber("+63979", "GLOBE/TM");
        MobNumber prefix48 = new MobNumber("+63995", "GLOBE/TM");
        MobNumber prefix49 = new MobNumber("+63996", "GLOBE/TM");
        MobNumber prefix50 = new MobNumber("+63996", "GLOBE/TM");

        MobNumber prefix51 = new MobNumber("0918", "SMART");
        MobNumber prefix52 = new MobNumber("0919", "SMART");
        MobNumber prefix53 = new MobNumber("0920", "SMART");
        MobNumber prefix54 = new MobNumber("0921", "SMART");
        MobNumber prefix55 = new MobNumber("0928", "SMART");
        MobNumber prefix56 = new MobNumber("0929", "SMART");
        MobNumber prefix57 = new MobNumber("0939", "SMART");
        MobNumber prefix58 = new MobNumber("0947", "SMART");
        MobNumber prefix59 = new MobNumber("0949", "SMART");
        MobNumber prefix60 = new MobNumber("0951", "SMART");
        MobNumber prefix61 = new MobNumber("0961", "SMART");
        MobNumber prefix62 = new MobNumber("0998", "SMART");
        MobNumber prefix63 = new MobNumber("0999", "SMART");
        MobNumber prefix64 = new MobNumber("+63908", "SMART");
        MobNumber prefix65 = new MobNumber("+63918", "SMART");
        MobNumber prefix66 = new MobNumber("+63919", "SMART");
        MobNumber prefix67 = new MobNumber("+63920", "SMART");
        MobNumber prefix68 = new MobNumber("+63921", "SMART");
        MobNumber prefix69 = new MobNumber("+63928", "SMART");
        MobNumber prefix70 = new MobNumber("+63929", "SMART");
        MobNumber prefix71 = new MobNumber("+63939", "SMART");
        MobNumber prefix72 = new MobNumber("+63947", "SMART");
        MobNumber prefix73 = new MobNumber("+63949", "SMART");
        MobNumber prefix74 = new MobNumber("+63951", "SMART");
        MobNumber prefix75 = new MobNumber("+63961", "SMART");
        MobNumber prefix76 = new MobNumber("+63998", "SMART");
        MobNumber prefix77 = new MobNumber("+63999", "SMART");

        MobNumber prefix78 = new MobNumber("0922", "SUN");
        MobNumber prefix79 = new MobNumber("0923", "SUN");
        MobNumber prefix80 = new MobNumber("0924", "SUN");
        MobNumber prefix81 = new MobNumber("0925", "SUN");
        MobNumber prefix82 = new MobNumber("0931", "SUN");
        MobNumber prefix83 = new MobNumber("0932", "SUN");
        MobNumber prefix84 = new MobNumber("0933", "SUN");
        MobNumber prefix85 = new MobNumber("0934", "SUN");
        MobNumber prefix86 = new MobNumber("0940", "SUN");
        MobNumber prefix87 = new MobNumber("0941", "SUN");
        MobNumber prefix88 = new MobNumber("0942", "SUN");
        MobNumber prefix89 = new MobNumber("0943", "SUN");
        MobNumber prefix90 = new MobNumber("0973", "SUN");
        MobNumber prefix91 = new MobNumber("0974", "SUN");
        MobNumber prefix92 = new MobNumber("+63922", "SUN");
        MobNumber prefix93 = new MobNumber("+63923", "SUN");
        MobNumber prefix94 = new MobNumber("+63924", "SUN");
        MobNumber prefix95 = new MobNumber("+63925", "SUN");
        MobNumber prefix96 = new MobNumber("+63931", "SUN");
        MobNumber prefix97 = new MobNumber("+63932", "SUN");
        MobNumber prefix98 = new MobNumber("+63933", "SUN");
        MobNumber prefix99 = new MobNumber("+63934", "SUN");
        MobNumber prefix100 = new MobNumber("+63940", "SUN");
        MobNumber prefix101 = new MobNumber("+63941", "SUN");
        MobNumber prefix102 = new MobNumber("+63942", "SUN");
        MobNumber prefix103 = new MobNumber("+63943", "SUN");
        MobNumber prefix104 = new MobNumber("+63973", "SUN");
        MobNumber prefix105 = new MobNumber("+63974", "SUN");

        MobNumber prefix106 = new MobNumber("09173", "GLOBE POSTPAID");
        MobNumber prefix107 = new MobNumber("09175", "GLOBE POSTPAID");
        MobNumber prefix108 = new MobNumber("09176", "GLOBE POSTPAID");
        MobNumber prefix109 = new MobNumber("09178", "GLOBE POSTPAID");
        MobNumber prefix110 = new MobNumber("09253", "GLOBE POSTPAID");
        MobNumber prefix111 = new MobNumber("09255", "GLOBE POSTPAID");
        MobNumber prefix112 = new MobNumber("09256", "GLOBE POSTPAID");
        MobNumber prefix113 = new MobNumber("09257", "GLOBE POSTPAID");
        MobNumber prefix114 = new MobNumber("09258", "GLOBE POSTPAID");
        MobNumber prefix115 = new MobNumber("+639173", "GLOBE POSTPAID");
        MobNumber prefix116 = new MobNumber("+639175", "GLOBE POSTPAID");
        MobNumber prefix117 = new MobNumber("+639176", "GLOBE POSTPAID");
        MobNumber prefix118 = new MobNumber("+639178", "GLOBE POSTPAID");
        MobNumber prefix119 = new MobNumber("+639253", "GLOBE POSTPAID");
        MobNumber prefix120 = new MobNumber("+639255", "GLOBE POSTPAID");
        MobNumber prefix121 = new MobNumber("+639256", "GLOBE POSTPAID");
        MobNumber prefix122 = new MobNumber("+639257", "GLOBE POSTPAID");
        MobNumber prefix123 = new MobNumber("+639258", "GLOBE POSTPAID");

        mViewModel.insertMobileNumber(prefix1);
        mViewModel.insertMobileNumber(prefix2);
        mViewModel.insertMobileNumber(prefix3);
        mViewModel.insertMobileNumber(prefix4);
        mViewModel.insertMobileNumber(prefix5);
        mViewModel.insertMobileNumber(prefix6);
        mViewModel.insertMobileNumber(prefix7);
        mViewModel.insertMobileNumber(prefix8);
        mViewModel.insertMobileNumber(prefix9);
        mViewModel.insertMobileNumber(prefix10);
        mViewModel.insertMobileNumber(prefix11);
        mViewModel.insertMobileNumber(prefix12);
        mViewModel.insertMobileNumber(prefix13);
        mViewModel.insertMobileNumber(prefix14);
        mViewModel.insertMobileNumber(prefix15);
        mViewModel.insertMobileNumber(prefix16);
        mViewModel.insertMobileNumber(prefix17);
        mViewModel.insertMobileNumber(prefix18);
        mViewModel.insertMobileNumber(prefix19);
        mViewModel.insertMobileNumber(prefix20);
        mViewModel.insertMobileNumber(prefix21);
        mViewModel.insertMobileNumber(prefix22);
        mViewModel.insertMobileNumber(prefix23);
        mViewModel.insertMobileNumber(prefix24);
        mViewModel.insertMobileNumber(prefix25);
        mViewModel.insertMobileNumber(prefix26);
        mViewModel.insertMobileNumber(prefix27);
        mViewModel.insertMobileNumber(prefix28);
        mViewModel.insertMobileNumber(prefix29);
        mViewModel.insertMobileNumber(prefix30);
        mViewModel.insertMobileNumber(prefix31);
        mViewModel.insertMobileNumber(prefix32);
        mViewModel.insertMobileNumber(prefix33);
        mViewModel.insertMobileNumber(prefix34);
        mViewModel.insertMobileNumber(prefix35);
        mViewModel.insertMobileNumber(prefix36);
        mViewModel.insertMobileNumber(prefix37);
        mViewModel.insertMobileNumber(prefix38);
        mViewModel.insertMobileNumber(prefix39);
        mViewModel.insertMobileNumber(prefix40);
        mViewModel.insertMobileNumber(prefix41);
        mViewModel.insertMobileNumber(prefix42);
        mViewModel.insertMobileNumber(prefix43);
        mViewModel.insertMobileNumber(prefix44);
        mViewModel.insertMobileNumber(prefix45);
        mViewModel.insertMobileNumber(prefix46);
        mViewModel.insertMobileNumber(prefix47);
        mViewModel.insertMobileNumber(prefix48);
        mViewModel.insertMobileNumber(prefix49);
        mViewModel.insertMobileNumber(prefix50);
        mViewModel.insertMobileNumber(prefix51);
        mViewModel.insertMobileNumber(prefix52);
        mViewModel.insertMobileNumber(prefix53);
        mViewModel.insertMobileNumber(prefix54);
        mViewModel.insertMobileNumber(prefix55);
        mViewModel.insertMobileNumber(prefix56);
        mViewModel.insertMobileNumber(prefix57);
        mViewModel.insertMobileNumber(prefix58);
        mViewModel.insertMobileNumber(prefix59);
        mViewModel.insertMobileNumber(prefix60);
        mViewModel.insertMobileNumber(prefix61);
        mViewModel.insertMobileNumber(prefix62);
        mViewModel.insertMobileNumber(prefix63);
        mViewModel.insertMobileNumber(prefix64);
        mViewModel.insertMobileNumber(prefix65);
        mViewModel.insertMobileNumber(prefix66);
        mViewModel.insertMobileNumber(prefix67);
        mViewModel.insertMobileNumber(prefix68);
        mViewModel.insertMobileNumber(prefix69);
        mViewModel.insertMobileNumber(prefix70);
        mViewModel.insertMobileNumber(prefix71);
        mViewModel.insertMobileNumber(prefix72);
        mViewModel.insertMobileNumber(prefix73);
        mViewModel.insertMobileNumber(prefix74);
        mViewModel.insertMobileNumber(prefix75);
        mViewModel.insertMobileNumber(prefix76);
        mViewModel.insertMobileNumber(prefix77);
        mViewModel.insertMobileNumber(prefix78);
        mViewModel.insertMobileNumber(prefix79);
        mViewModel.insertMobileNumber(prefix80);
        mViewModel.insertMobileNumber(prefix81);
        mViewModel.insertMobileNumber(prefix82);
        mViewModel.insertMobileNumber(prefix83);
        mViewModel.insertMobileNumber(prefix84);
        mViewModel.insertMobileNumber(prefix85);
        mViewModel.insertMobileNumber(prefix86);
        mViewModel.insertMobileNumber(prefix87);
        mViewModel.insertMobileNumber(prefix88);
        mViewModel.insertMobileNumber(prefix89);
        mViewModel.insertMobileNumber(prefix90);
        mViewModel.insertMobileNumber(prefix91);
        mViewModel.insertMobileNumber(prefix92);
        mViewModel.insertMobileNumber(prefix93);
        mViewModel.insertMobileNumber(prefix94);
        mViewModel.insertMobileNumber(prefix95);
        mViewModel.insertMobileNumber(prefix96);
        mViewModel.insertMobileNumber(prefix97);
        mViewModel.insertMobileNumber(prefix98);
        mViewModel.insertMobileNumber(prefix99);
        mViewModel.insertMobileNumber(prefix100);
        mViewModel.insertMobileNumber(prefix101);
        mViewModel.insertMobileNumber(prefix102);
        mViewModel.insertMobileNumber(prefix103);
        mViewModel.insertMobileNumber(prefix104);
        mViewModel.insertMobileNumber(prefix105);
        mViewModel.insertMobileNumber(prefix106);
        mViewModel.insertMobileNumber(prefix107);
        mViewModel.insertMobileNumber(prefix108);
        mViewModel.insertMobileNumber(prefix109);
        mViewModel.insertMobileNumber(prefix110);
        mViewModel.insertMobileNumber(prefix111);
        mViewModel.insertMobileNumber(prefix112);
        mViewModel.insertMobileNumber(prefix113);
        mViewModel.insertMobileNumber(prefix114);
        mViewModel.insertMobileNumber(prefix115);
        mViewModel.insertMobileNumber(prefix116);
        mViewModel.insertMobileNumber(prefix117);
        mViewModel.insertMobileNumber(prefix118);
        mViewModel.insertMobileNumber(prefix119);
        mViewModel.insertMobileNumber(prefix120);
        mViewModel.insertMobileNumber(prefix121);
        mViewModel.insertMobileNumber(prefix122);
        mViewModel.insertMobileNumber(prefix123);
    }
}