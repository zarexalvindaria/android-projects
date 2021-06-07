package apc.mobprog.viewmodeldemo.ui.main;

import static apc.mobprog.viewmodeldemo.BR.myViewModel;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import apc.mobprog.viewmodeldemo.R;
import apc.mobprog.viewmodeldemo.databinding.MainFragmentBinding;


public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    public MainFragmentBinding binding;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.main_fragment, container, false);
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        SavedStateViewModelFactory factory =
                new SavedStateViewModelFactory(getActivity().getApplication(),this);
        mViewModel = new ViewModelProvider(this, factory).get(MainViewModel.class);

        binding.setVariable(myViewModel, mViewModel);
    }

}