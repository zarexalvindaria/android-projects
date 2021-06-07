package apc.mobprog.mobilenetworkidentifier.ui.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import apc.mobprog.mobilenetworkidentifier.MobNumber;
import apc.mobprog.mobilenetworkidentifier.MobNumberRepository;

public class MainViewModel extends AndroidViewModel {

    private MobNumberRepository repository;
    private LiveData<List<MobNumber>> allMobileNumbers;
    private MutableLiveData<List<MobNumber>> searchResults;

    public MainViewModel(@NonNull Application application) {
        super(application);
        this.repository = new MobNumberRepository(application);
        this.allMobileNumbers = repository.getAllMobileNumbers();
        this.searchResults = repository.getSearchResults();
    }

    MutableLiveData<List<MobNumber>> getSearchResults() {
        return searchResults;
    }

    LiveData<List<MobNumber>> getAllMobileNumbers() {
        return allMobileNumbers;
    }

    public void insertMobileNumber(MobNumber mobNumber) {
        repository.insertMobileNumber(mobNumber);
    }

    public void findMobileNumber(String name) {
        repository.findMobileNumber(name);
    }

    public void deleteMobileNumber(String name) {
        repository.deleteMobileNumber(name);
    }

    public void deleteDatabase() {
        repository.deleteDatabase();
    }
}