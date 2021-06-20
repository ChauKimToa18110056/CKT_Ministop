// Generated code from Butter Knife. Do not modify!
package CKT.Ministop.Apk.activities;

import CKT.Ministop.Apk.R;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CategoryProductsActivity_ViewBinding implements Unbinder {
  private CategoryProductsActivity target;

  @UiThread
  public CategoryProductsActivity_ViewBinding(CategoryProductsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CategoryProductsActivity_ViewBinding(CategoryProductsActivity target, View source) {
    this.target = target;

    target.mProductsRecyclerView = Utils.findRequiredViewAsType(source, R.id.productsRecyclerView, "field 'mProductsRecyclerView'", RecyclerView.class);
    target.mToolbar = Utils.findRequiredViewAsType(source, R.id.categoryProductsToolbar, "field 'mToolbar'", Toolbar.class);
    target.mSearchView = Utils.findRequiredViewAsType(source, R.id.productsSearchView, "field 'mSearchView'", MaterialSearchView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CategoryProductsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mProductsRecyclerView = null;
    target.mToolbar = null;
    target.mSearchView = null;
  }
}
