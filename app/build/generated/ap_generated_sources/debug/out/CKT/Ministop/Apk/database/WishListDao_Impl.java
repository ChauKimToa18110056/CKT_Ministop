package CKT.Ministop.Apk.database;

import CKT.Ministop.Apk.model.Product;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.lifecycle.ComputableLiveData;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.InvalidationTracker.Observer;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unchecked")
public final class WishListDao_Impl implements WishListDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfProduct;

  private final DateConverters __dateConverters = new DateConverters();

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfProduct;

  public WishListDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfProduct = new EntityInsertionAdapter<Product>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `WishList`(`name`,`description`,`category`,`code`,`price`,`image`,`sale`,`createdAt`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Product value) {
        if (value.getName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getName());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDescription());
        }
        if (value.getCategory() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getCategory());
        }
        stmt.bindLong(4, value.getCode());
        stmt.bindDouble(5, value.getPrice());
        if (value.getImage() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getImage());
        }
        stmt.bindDouble(7, value.getSale());
        final Long _tmp;
        _tmp = __dateConverters.getTimeStamp(value.getTimeStamp());
        if (_tmp == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, _tmp);
        }
      }
    };
    this.__deletionAdapterOfProduct = new EntityDeletionOrUpdateAdapter<Product>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `WishList` WHERE `code` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Product value) {
        stmt.bindLong(1, value.getCode());
      }
    };
  }

  @Override
  public void addProductToWishlist(Product product) {
    __db.beginTransaction();
    try {
      __insertionAdapterOfProduct.insert(product);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteProduct(Product product) {
    __db.beginTransaction();
    try {
      __deletionAdapterOfProduct.handle(product);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Product>> getAllProducts() {
    final String _sql = "SELECT * FROM WishList ORDER BY createdAt";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new ComputableLiveData<List<Product>>(__db.getQueryExecutor()) {
      private Observer _observer;

      @Override
      protected List<Product> compute() {
        if (_observer == null) {
          _observer = new Observer("WishList") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
          final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("description");
          final int _cursorIndexOfCategory = _cursor.getColumnIndexOrThrow("category");
          final int _cursorIndexOfCode = _cursor.getColumnIndexOrThrow("code");
          final int _cursorIndexOfPrice = _cursor.getColumnIndexOrThrow("price");
          final int _cursorIndexOfImage = _cursor.getColumnIndexOrThrow("image");
          final int _cursorIndexOfSale = _cursor.getColumnIndexOrThrow("sale");
          final int _cursorIndexOfTimeStamp = _cursor.getColumnIndexOrThrow("createdAt");
          final List<Product> _result = new ArrayList<Product>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Product _item;
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final String _tmpCategory;
            _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            final int _tmpCode;
            _tmpCode = _cursor.getInt(_cursorIndexOfCode);
            final float _tmpPrice;
            _tmpPrice = _cursor.getFloat(_cursorIndexOfPrice);
            final String _tmpImage;
            _tmpImage = _cursor.getString(_cursorIndexOfImage);
            final float _tmpSale;
            _tmpSale = _cursor.getFloat(_cursorIndexOfSale);
            final Date _tmpTimeStamp;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfTimeStamp)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfTimeStamp);
            }
            _tmpTimeStamp = __dateConverters.getDate(_tmp);
            _item = new Product(_tmpName,_tmpDescription,_tmpCategory,_tmpCode,_tmpPrice,_tmpImage,_tmpSale,_tmpTimeStamp);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }

  @Override
  public LiveData<Product> getProduct(int productCode) {
    final String _sql = "SELECT * FROM WishList WHERE code =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, productCode);
    return new ComputableLiveData<Product>(__db.getQueryExecutor()) {
      private Observer _observer;

      @Override
      protected Product compute() {
        if (_observer == null) {
          _observer = new Observer("WishList") {
            @Override
            public void onInvalidated(@NonNull Set<String> tables) {
              invalidate();
            }
          };
          __db.getInvalidationTracker().addWeakObserver(_observer);
        }
        final Cursor _cursor = __db.query(_statement);
        try {
          final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
          final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("description");
          final int _cursorIndexOfCategory = _cursor.getColumnIndexOrThrow("category");
          final int _cursorIndexOfCode = _cursor.getColumnIndexOrThrow("code");
          final int _cursorIndexOfPrice = _cursor.getColumnIndexOrThrow("price");
          final int _cursorIndexOfImage = _cursor.getColumnIndexOrThrow("image");
          final int _cursorIndexOfSale = _cursor.getColumnIndexOrThrow("sale");
          final int _cursorIndexOfTimeStamp = _cursor.getColumnIndexOrThrow("createdAt");
          final Product _result;
          if(_cursor.moveToFirst()) {
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            final String _tmpCategory;
            _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
            final int _tmpCode;
            _tmpCode = _cursor.getInt(_cursorIndexOfCode);
            final float _tmpPrice;
            _tmpPrice = _cursor.getFloat(_cursorIndexOfPrice);
            final String _tmpImage;
            _tmpImage = _cursor.getString(_cursorIndexOfImage);
            final float _tmpSale;
            _tmpSale = _cursor.getFloat(_cursorIndexOfSale);
            final Date _tmpTimeStamp;
            final Long _tmp;
            if (_cursor.isNull(_cursorIndexOfTimeStamp)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getLong(_cursorIndexOfTimeStamp);
            }
            _tmpTimeStamp = __dateConverters.getDate(_tmp);
            _result = new Product(_tmpName,_tmpDescription,_tmpCategory,_tmpCode,_tmpPrice,_tmpImage,_tmpSale,_tmpTimeStamp);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    }.getLiveData();
  }

  @Override
  public Product getProductForExistence(int code) {
    final String _sql = "SELECT * FROM WishList WHERE code =?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, code);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("description");
      final int _cursorIndexOfCategory = _cursor.getColumnIndexOrThrow("category");
      final int _cursorIndexOfCode = _cursor.getColumnIndexOrThrow("code");
      final int _cursorIndexOfPrice = _cursor.getColumnIndexOrThrow("price");
      final int _cursorIndexOfImage = _cursor.getColumnIndexOrThrow("image");
      final int _cursorIndexOfSale = _cursor.getColumnIndexOrThrow("sale");
      final int _cursorIndexOfTimeStamp = _cursor.getColumnIndexOrThrow("createdAt");
      final Product _result;
      if(_cursor.moveToFirst()) {
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpDescription;
        _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        final String _tmpCategory;
        _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
        final int _tmpCode;
        _tmpCode = _cursor.getInt(_cursorIndexOfCode);
        final float _tmpPrice;
        _tmpPrice = _cursor.getFloat(_cursorIndexOfPrice);
        final String _tmpImage;
        _tmpImage = _cursor.getString(_cursorIndexOfImage);
        final float _tmpSale;
        _tmpSale = _cursor.getFloat(_cursorIndexOfSale);
        final Date _tmpTimeStamp;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfTimeStamp)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfTimeStamp);
        }
        _tmpTimeStamp = __dateConverters.getDate(_tmp);
        _result = new Product(_tmpName,_tmpDescription,_tmpCategory,_tmpCode,_tmpPrice,_tmpImage,_tmpSale,_tmpTimeStamp);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Product> getAllProductsWidget() {
    final String _sql = "SELECT * FROM WishList ORDER BY createdAt";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final Cursor _cursor = __db.query(_statement);
    try {
      final int _cursorIndexOfName = _cursor.getColumnIndexOrThrow("name");
      final int _cursorIndexOfDescription = _cursor.getColumnIndexOrThrow("description");
      final int _cursorIndexOfCategory = _cursor.getColumnIndexOrThrow("category");
      final int _cursorIndexOfCode = _cursor.getColumnIndexOrThrow("code");
      final int _cursorIndexOfPrice = _cursor.getColumnIndexOrThrow("price");
      final int _cursorIndexOfImage = _cursor.getColumnIndexOrThrow("image");
      final int _cursorIndexOfSale = _cursor.getColumnIndexOrThrow("sale");
      final int _cursorIndexOfTimeStamp = _cursor.getColumnIndexOrThrow("createdAt");
      final List<Product> _result = new ArrayList<Product>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Product _item;
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final String _tmpDescription;
        _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        final String _tmpCategory;
        _tmpCategory = _cursor.getString(_cursorIndexOfCategory);
        final int _tmpCode;
        _tmpCode = _cursor.getInt(_cursorIndexOfCode);
        final float _tmpPrice;
        _tmpPrice = _cursor.getFloat(_cursorIndexOfPrice);
        final String _tmpImage;
        _tmpImage = _cursor.getString(_cursorIndexOfImage);
        final float _tmpSale;
        _tmpSale = _cursor.getFloat(_cursorIndexOfSale);
        final Date _tmpTimeStamp;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfTimeStamp)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfTimeStamp);
        }
        _tmpTimeStamp = __dateConverters.getDate(_tmp);
        _item = new Product(_tmpName,_tmpDescription,_tmpCategory,_tmpCode,_tmpPrice,_tmpImage,_tmpSale,_tmpTimeStamp);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
