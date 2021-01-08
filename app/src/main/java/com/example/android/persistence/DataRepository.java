package com.example.android.persistence;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import com.example.android.persistence.db.AppDatabase;
import com.example.android.persistence.db.entity.MitarbeiterEntity;
import com.example.android.persistence.db.entity.PersonEntity;
import com.example.android.persistence.viewmodel.loginViewModel;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Repository handling the work with products and comments.
 */
public class DataRepository {

    private static DataRepository sInstance;

    private final AppDatabase mDatabase;
   // private MediatorLiveData<List<ProductEntity>> mObservableProducts;

    static final ExecutorService Executor =
            Executors.newFixedThreadPool(4);


    private DataRepository(final AppDatabase database) {
        mDatabase = database;
       /* mObservableProducts = new MediatorLiveData<>();

        mObservableProducts.addSource(mDatabase.productDao().loadAllProducts(),
                productEntities -> {
                    if (mDatabase.getDatabaseCreated().getValue() != null) {
                        mObservableProducts.postValue(productEntities);
                    }
                });*/
    }

    public static DataRepository getInstance(final AppDatabase database) {
        if (sInstance == null) {
            synchronized (DataRepository.class) {
                if (sInstance == null) {
                    sInstance = new DataRepository(database);
                }
            }
        }
        return sInstance;
    }
    public void getMitarbeiterByName(String name, loginViewModel av) {
        Executor.execute(()->{
            LiveData<MitarbeiterEntity> e = mDatabase.personDao().getMitarbeiterbyName(name);
           av.re(e);

        });

    }

    public AppDatabase getmDatabase() {
        return mDatabase;
    }
    /**
     * Get the list of products from the database and get notified when the data changes.
     */
   /* public LiveData<List<ProductEntity>> getProducts() {
        return mObservableProducts;
    }

    public LiveData<ProductEntity> loadProduct(final int productId) {
        return mDatabase.productDao().loadProduct(productId);
    }

    public LiveData<List<CommentEntity>> loadComments(final int productId) {
        return mDatabase.commentDao().loadComments(productId);
    }

    public LiveData<List<ProductEntity>> searchProducts(String query) {
        return mDatabase.productDao().searchAllProducts(query);
    }*/
}
