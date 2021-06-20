// Generated code from Butter Knife. Do not modify!
package CKT.Ministop.Apk.adapters;

import CKT.Ministop.Apk.R;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProductsAdapter$ProductsViewHolder_ViewBinding implements Unbinder {
  private ProductsAdapter.ProductsViewHolder target;

  private View view7f0a0084;

  private View view7f0a01db;

  @UiThread
  public ProductsAdapter$ProductsViewHolder_ViewBinding(
      final ProductsAdapter.ProductsViewHolder target, View source) {
    this.target = target;

    View view;
    target.mProductImageView = Utils.findRequiredViewAsType(source, R.id.productImage, "field 'mProductImageView'", ImageView.class);
    target.mProductNameTextView = Utils.findRequiredViewAsType(source, R.id.productNameTextView, "field 'mProductNameTextView'", TextView.class);
    target.mProductPrice = Utils.findRequiredViewAsType(source, R.id.productPriceTextView, "field 'mProductPrice'", TextView.class);
    target.mProductDescription = Utils.findRequiredViewAsType(source, R.id.productDescriptionTextView, "field 'mProductDescription'", TextView.class);
    view = Utils.findRequiredView(source, R.id.addToWishlistImageButton, "field 'mAddProductToWishlistImageButton' and method 'onFavoriteButtonClick'");
    target.mAddProductToWishlistImageButton = Utils.castView(view, R.id.addToWishlistImageButton, "field 'mAddProductToWishlistImageButton'", ImageButton.class);
    view7f0a0084 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onFavoriteButtonClick();
      }
    });
    target.mSaleInPercentageTextView = Utils.findRequiredViewAsType(source, R.id.saleInPercentageTextView, "field 'mSaleInPercentageTextView'", TextView.class);
    view = Utils.findRequiredView(source, R.id.productListParentCardView, "method 'onProductClick'");
    view7f0a01db = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onProductClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    ProductsAdapter.ProductsViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mProductImageView = null;
    target.mProductNameTextView = null;
    target.mProductPrice = null;
    target.mProductDescription = null;
    target.mAddProductToWishlistImageButton = null;
    target.mSaleInPercentageTextView = null;

    view7f0a0084.setOnClickListener(null);
    view7f0a0084 = null;
    view7f0a01db.setOnClickListener(null);
    view7f0a01db = null;
  }
}
