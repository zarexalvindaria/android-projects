package apc.mobprog.roomdemo.ui.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import apc.mobprog.roomdemo.Product;
import apc.mobprog.roomdemo.ProductRepository;
import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private ProductRepository repository;
    private LiveData<List<Product>> allProducts;
    private MutableLiveData<List<Product>> searchResults;

    public MainViewModel(@NonNull Application application) {
        super(application);
        repository = new ProductRepository(application);
        allProducts = repository.getAllProducts();
        searchResults = repository.getSearchResults();
    }

    MutableLiveData<List<Product>> getSearchResults() {
        return searchResults;
    }
    LiveData<List<Product>> getAllProducts() {
        return allProducts;
    }
    public void insertProduct(Product product) {
        repository.insertProduct(product);
    }
    public void findProduct(String name) {
        repository.findProduct(name);
    }
    public void deleteProduct(String name) {
        repository.deleteProduct(name);
    }
}