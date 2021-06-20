// Generated code from Butter Knife. Do not modify!
package CKT.Ministop.Apk.fragments;

import CKT.Ministop.Apk.R;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WishlistFragment_ViewBinding implements Unbinder {
  private WishlistFragment target;

  @UiThread
  public WishlistFragment_ViewBinding(WishlistFragment target, View source) {
    this.target = target;

    target.mFavoriteRecyclerView = Utils.findRequiredViewAsType(source, R.id.favoriteItemsRecyclerView, "field 'mFavoriteRecyclerView'", RecyclerView.class);
    target.mEmptyState = Utils.findRequiredView(source, R.id.emptyWishlistState, "field 'mEmptyState'");
  }

  @Override
  @CallSuper
  public void unbind() {
    WishlistFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mFavoriteRecyclerView = null;
    target.mEmptyState = null;
  }
}
