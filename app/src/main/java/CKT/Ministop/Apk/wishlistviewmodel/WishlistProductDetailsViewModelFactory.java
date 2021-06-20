package CKT.Ministop.Apk.wishlistviewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;

import CKT.Ministop.Apk.database.WishlistDatabase;


public class WishlistProductDetailsViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private int mItemCode;
    private WishlistDatabase mDatabase;


    public WishlistProductDetailsViewModelFactory(int code, WishlistDatabase database) {
        this.mItemCode = code;
        this.mDatabase = database;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(WishlistProductDetailsViewModel.class)) {
            return (T) new WishlistProductDetailsViewModel(mItemCode, mDatabase);
        } else {
            throw new IllegalArgumentException("This is unknown ViewModel class :/ ");
        }
    }
}