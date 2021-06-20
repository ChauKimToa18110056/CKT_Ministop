package CKT.Ministop.Apk.wishlistviewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import CKT.Ministop.Apk.database.WishlistDatabase;
import CKT.Ministop.Apk.model.Product;

public class WishlistProductDetailsViewModel extends ViewModel {
    private LiveData<Product> mProduct;
    private int mProductCode;
    private WishlistDatabase mDatabase;

    public WishlistProductDetailsViewModel(int code, WishlistDatabase database) {
        this.mProductCode = code;
        this.mDatabase = database;
    }

    public LiveData<Product> getProduct() {
        if (mProduct == null) {
            mProduct = new MutableLiveData<>();
            getItemFromDatabase();
        }
        return mProduct;
    }

    private void getItemFromDatabase() {
        mProduct = mDatabase.mWishListProductsDao().getProduct(mProductCode);
    }
}