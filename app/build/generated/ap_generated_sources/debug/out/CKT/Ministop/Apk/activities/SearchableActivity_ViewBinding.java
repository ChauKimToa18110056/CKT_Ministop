// Generated code from Butter Knife. Do not modify!
package CKT.Ministop.Apk.activities;

import CKT.Ministop.Apk.R;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SearchableActivity_ViewBinding implements Unbinder {
  private SearchableActivity target;

  @UiThread
  public SearchableActivity_ViewBinding(SearchableActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SearchableActivity_ViewBinding(SearchableActivity target, View source) {
    this.target = target;

    target.mProductsRecyclerView = Utils.findRequiredViewAsType(source, R.id.productsSearchResultsRecyclerView, "field 'mProductsRecyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SearchableActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mProductsRecyclerView = null;
  }
}
