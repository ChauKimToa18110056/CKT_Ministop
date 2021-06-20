package CKT.Ministop.Apk.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import android.content.Context;

import CKT.Ministop.Apk.model.Product;


@Database(entities = {Product.class}, version = 3, exportSchema = false)
@TypeConverters(DateConverters.class)
public abstract class WishlistDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "WishlistProducts";
    private static final Object LOCK = new Object();

    private static WishlistDatabase sDatabase;

    public static WishlistDatabase getDatabase(Context context) {
        if (sDatabase == null) {
            synchronized (LOCK) {
                sDatabase = Room.databaseBuilder(context.getApplicationContext(),
                        WishlistDatabase.class,
                        DATABASE_NAME)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return sDatabase;
    }

    public abstract WishListDao mWishListProductsDao();
}
