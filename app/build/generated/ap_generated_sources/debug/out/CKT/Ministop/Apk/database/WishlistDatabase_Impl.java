package CKT.Ministop.Apk.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public final class WishlistDatabase_Impl extends WishlistDatabase {
  private volatile WishListDao _wishListDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(3) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `WishList` (`name` TEXT, `description` TEXT, `category` TEXT, `code` INTEGER NOT NULL, `price` REAL NOT NULL, `image` TEXT, `sale` REAL NOT NULL, `createdAt` INTEGER, PRIMARY KEY(`code`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"0d30d75e29f60ed1c3d4d7c8a400950b\")");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `WishList`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsWishList = new HashMap<String, TableInfo.Column>(8);
        _columnsWishList.put("name", new TableInfo.Column("name", "TEXT", false, 0));
        _columnsWishList.put("description", new TableInfo.Column("description", "TEXT", false, 0));
        _columnsWishList.put("category", new TableInfo.Column("category", "TEXT", false, 0));
        _columnsWishList.put("code", new TableInfo.Column("code", "INTEGER", true, 1));
        _columnsWishList.put("price", new TableInfo.Column("price", "REAL", true, 0));
        _columnsWishList.put("image", new TableInfo.Column("image", "TEXT", false, 0));
        _columnsWishList.put("sale", new TableInfo.Column("sale", "REAL", true, 0));
        _columnsWishList.put("createdAt", new TableInfo.Column("createdAt", "INTEGER", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWishList = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWishList = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWishList = new TableInfo("WishList", _columnsWishList, _foreignKeysWishList, _indicesWishList);
        final TableInfo _existingWishList = TableInfo.read(_db, "WishList");
        if (! _infoWishList.equals(_existingWishList)) {
          throw new IllegalStateException("Migration didn't properly handle WishList(CKT.Ministop.Apk.model.Product).\n"
                  + " Expected:\n" + _infoWishList + "\n"
                  + " Found:\n" + _existingWishList);
        }
      }
    }, "0d30d75e29f60ed1c3d4d7c8a400950b", "a4d74212ab45db1dc24fa8f572cbbf41");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    return new InvalidationTracker(this, "WishList");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `WishList`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public WishListDao mWishListProductsDao() {
    if (_wishListDao != null) {
      return _wishListDao;
    } else {
      synchronized(this) {
        if(_wishListDao == null) {
          _wishListDao = new WishListDao_Impl(this);
        }
        return _wishListDao;
      }
    }
  }
}
