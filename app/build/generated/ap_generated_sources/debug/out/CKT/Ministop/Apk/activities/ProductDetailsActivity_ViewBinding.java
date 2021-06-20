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

public class ProductDetailsActivity_ViewBinding implements Unbinder {
  private ProductDetailsActivity target;

  private View view7f0a0082;

  private View view7f0a0083;

  private View view7f0a0226;

  @UiThread
  public ProductDetailsActivity_ViewBinding(ProductDetailsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ProductDetailsActivity_ViewBinding(final ProductDetailsActivity target, View source) {
    this.target = target;

    View view;
    target.mProductImage = Utils.findRequiredViewAsType(source, R.id.detailProductImage, "field 'mProductImage'", LabelKenBurnsView.class);
    target.mProductDescriptionTextView = Utils.findRequiredViewAsType(source, R.id.detailProductDescriptionTextView, "field 'mProductDescriptionTextView'", TextView.class);
    target.mProductNameTextView = Utils.findRequiredViewAsType(source, R.id.detailProductNameTextView, "field 'mProductNameTextView'", TextView.class);
    target.mPriceTextView = Utils.findRequiredViewAsType(source, R.id.detailProductTotalPrice, "field 'mPriceTextView'", TextView.class);
    target.mDiscountPriceTextView = Utils.findRequiredViewAsType(source, R.id.detailProductDiscountPrice, "field 'mDiscountPriceTextView'", TextView.class);
    target.mCategoryHashTag = Utils.findRequiredViewAsType(source, R.id.productCategoryHashtagTextView, "field 'mCategoryHashTag'", TextView.class);
    target.mFABsMenu = Utils.findRequiredViewAsType(source, R.id.productFABMenu, "field 'mFABsMenu'", FloatingActionMenu.class);
    view = Utils.findRequiredView(source, R.id.addToCartFAB, "field 'mAddToCartFab' and method 'addProductToUserCart'");
    target.mAddToCartFab = Utils.castView(view, R.id.addToCartFAB, "field 'mAddToCartFab'", FloatingActionButton.class);
    view7f0a0082 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.addProductToUserCart();
      }
    });
    view = Utils.findRequiredView(source, R.id.addToWishListFAB, "field 'mAddToWishListFab' and method 'onAddToWishListClick'");
    target.mAddToWishListFab = Utils.castView(view, R.id.addToWishListFAB, "field 'mAddToWishListFab'", FloatingActionButton.class);
    view7f0a0083 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onAddToWishListClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.shareProductFAB, "field 'mShareFAB' and method 'onShareFABClick'");
    target.mShareFAB = Utils.castView(view, R.id.shareProductFAB, "field 'mShareFAB'", FloatingActionButton.class);
    view7f0a0226 = view;
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
    ProductDetailsActivity target = this.target;
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
    target.mAddToWishListFab = null;
    target.mShareFAB = null;

    view7f0a0082.setOnClickListener(null);
    view7f0a0082 = null;
    view7f0a0083.setOnClickListener(null);
    view7f0a0083 = null;
    view7f0a0226.setOnClickListener(null);
    view7f0a0226 = null;
  }
}
