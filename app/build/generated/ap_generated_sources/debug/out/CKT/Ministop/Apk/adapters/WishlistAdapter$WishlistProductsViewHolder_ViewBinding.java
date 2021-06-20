// Generated code from Butter Knife. Do not modify!
package CKT.Ministop.Apk.adapters;

import CKT.Ministop.Apk.R;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.lid.lib.LabelImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WishlistAdapter$WishlistProductsViewHolder_ViewBinding implements Unbinder {
  private WishlistAdapter.WishlistProductsViewHolder target;

  private View view7f0a02ce;

  @UiThread
  public WishlistAdapter$WishlistProductsViewHolder_ViewBinding(
      final WishlistAdapter.WishlistProductsViewHolder target, View source) {
    this.target = target;

    View view;
    target.mProductImage = Utils.findRequiredViewAsType(source, R.id.wishlistedProductImage, "field 'mProductImage'", LabelImageView.class);
    target.mWishlistProductDescription = Utils.findRequiredViewAsType(source, R.id.wishlistedProductDescriptionTextView, "field 'mWishlistProductDescription'", TextView.class);
    target.mWishlistProductName = Utils.findRequiredViewAsType(source, R.id.wishlistedProductNameTextView, "field 'mWishlistProductName'", TextView.class);
    target.mProductPriceTextView = Utils.findRequiredViewAsType(source, R.id.wishlistedProductPriceTextView, "field 'mProductPriceTextView'", TextView.class);
    view = Utils.findRequiredView(source, R.id.wishlistedProductListParent, "method 'onWishlistedProductClick'");
    view7f0a02ce = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onWishlistedProductClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    WishlistAdapter.WishlistProductsViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mProductImage = null;
    target.mWishlistProductDescription = null;
    target.mWishlistProductName = null;
    target.mProductPriceTextView = null;

    view7f0a02ce.setOnClickListener(null);
    view7f0a02ce = null;
  }
}
