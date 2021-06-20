// Generated code from Butter Knife. Do not modify!
package CKT.Ministop.Apk.activities;

import CKT.Ministop.Apk.LabelKenBurnsView;
import CKT.Ministop.Apk.R;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import java.lang.IllegalStateException;
import java.lang.Override;

public class WishlistProductDetailsActivity_ViewBinding implements Unbinder {
  private WishlistProductDetailsActivity target;

  private View view7f0a02bc;

  private View view7f0a02c4;

  private View view7f0a02c5;

  @UiThread
  public WishlistProductDetailsActivity_ViewBinding(WishlistProductDetailsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public WishlistProductDetailsActivity_ViewBinding(final WishlistProductDetailsActivity target,
      View source) {
    this.target = target;

    View view;
    target.mProductImage = Utils.findRequiredViewAsType(source, R.id.wishListProductDetailsImage, "field 'mProductImage'", LabelKenBurnsView.class);
    target.mProductDescriptionTextView = Utils.findRequiredViewAsType(source, R.id.wishListProductDetailsDescriptionTextView, "field 'mProductDescriptionTextView'", TextView.class);
    target.mProductNameTextView = Utils.findRequiredViewAsType(source, R.id.wishListProductDetailsNameTextView, "field 'mProductNameTextView'", TextView.class);
    target.mPriceTextView = Utils.findRequiredViewAsType(source, R.id.wishListProductDetailsTotalPrice, "field 'mPriceTextView'", TextView.class);
    target.mDiscountPriceTextView = Utils.findRequiredViewAsType(source, R.id.wishListProductDetailsDiscountPrice, "field 'mDiscountPriceTextView'", TextView.class);
    target.mCategoryHashTag = Utils.findRequiredViewAsType(source, R.id.wishListProductDetailsHashTag, "field 'mCategoryHashTag'", TextView.class);
    target.mFABsMenu = Utils.findRequiredViewAsType(source, R.id.wishListProductFABMenu, "field 'mFABsMenu'", FloatingActionMenu.class);
    view = Utils.findRequiredView(source, R.id.wishListAddToCartFAB, "field 'mAddToCartFab' and method 'onAddToCartFABClick'");
    target.mAddToCartFab = Utils.castView(view, R.id.wishListAddToCartFAB, "field 'mAddToCartFab'", FloatingActionButton.class);
    view7f0a02bc = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onAddToCartFABClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.wishListRemoveFromWishListFAB, "field 'mRemoveFromWishListFAB' and method 'onRemoveFromWishListFABClick'");
    target.mRemoveFromWishListFAB = Utils.castView(view, R.id.wishListRemoveFromWishListFAB, "field 'mRemoveFromWishListFAB'", FloatingActionButton.class);
    view7f0a02c4 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onRemoveFromWishListFABClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.wishListShareProductFAB, "field 'mShareFAB' and method 'onShareFABClick'");
    target.mShareFAB = Utils.castView(view, R.id.wishListShareProductFAB, "field 'mShareFAB'", FloatingActionButton.class);
    view7f0a02c5 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onShareFABClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    WishlistProductDetailsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mProductImage = null;
    target.mProductDescriptionTextView = null;
    target.mProductNameTextView = null;
    target.mPriceTextView = null;
    target.mDiscountPriceTextView = null;
    target.mCategoryHashTag = null;
    target.mFABsMenu = null;
    target.mAddToCartFab = null;
    target.mRemoveFromWishListFAB = null;
    target.mShareFAB = null;

    view7f0a02bc.setOnClickListener(null);
    view7f0a02bc = null;
    view7f0a02c4.setOnClickListener(null);
    view7f0a02c4 = null;
    view7f0a02c5.setOnClickListener(null);
    view7f0a02c5 = null;
  }
}
