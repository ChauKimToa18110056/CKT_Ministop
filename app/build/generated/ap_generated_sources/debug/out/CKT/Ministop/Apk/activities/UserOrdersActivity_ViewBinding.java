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
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class UserOrdersActivity_ViewBinding implements Unbinder {
  private UserOrdersActivity target;

  @UiThread
  public UserOrdersActivity_ViewBinding(UserOrdersActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public UserOrdersActivity_ViewBinding(UserOrdersActivity target, View source) {
    this.target = target;

    target.mOrdersRecyclerView = Utils.findRequiredViewAsType(source, R.id.userOrdersRecyclerView, "field 'mOrdersRecyclerView'", RecyclerView.class);
    target.mToolbar = Utils.findRequiredViewAsType(source, R.id.userOrdersToolbar, "field 'mToolbar'", Toolbar.class);
    target.mHeaderImage = Utils.findRequiredViewAsType(source, R.id.userOrdersHeaderImage, "field 'mHeaderImage'", KenBurnsView.class);
    target.mCollapsingToolbar = Utils.findRequiredViewAsType(source, R.id.userOrdersCollapsingToolbar, "field 'mCollapsingToolbar'", CollapsingToolbarLayout.class);
    target.mEmptyState = Utils.findRequiredView(source, R.id.userOrdersEmptyState, "field 'mEmptyState'");
  }

  @Override
  @CallSuper
  public void unbind() {
    UserOrdersActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mOrdersRecyclerView = null;
    target.mToolbar = null;
    target.mHeaderImage = null;
    target.mCollapsingToolbar = null;
    target.mEmptyState = null;
  }
}
