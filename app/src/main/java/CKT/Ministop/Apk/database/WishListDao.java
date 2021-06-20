package CKT.Ministop.Apk.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import CKT.Ministop.Apk.model.Product;


@Dao
public interface WishListDao {
    @Query("SELECT * FROM WishList ORDER BY createdAt")
    LiveData<List<Product>> getAllProducts();

    @Insert
    void addProductToWishlist(Product product);

    @Query("SELECT * FROM WishList WHERE code =:productCode")
    LiveData<Product> getProduct(int productCode);

    @Query("SELECT * FROM WishList WHERE code =:code")
    Product getProductForExistence(int code);

    @Delete
    void deleteProduct(Product product);

    @Query("SELECT * FROM WishList ORDER BY createdAt")
    List<Product> getAllProductsWidget();
}

