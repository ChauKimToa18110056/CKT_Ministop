// Generated code from Butter Knife. Do not modify!
package CKT.Ministop.Apk.adapters;

import CKT.Ministop.Apk.LabelKenBurnsView;
import CKT.Ministop.Apk.R;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProductsAdapter$FirstProductViewHolder_ViewBinding implements Unbinder {
  private ProductsAdapter.FirstProductViewHolder target;

  private View view7f0a0141;

  private View view7f0a0144;

  @UiThread
  public ProductsAdapter$FirstProductViewHolder_ViewBinding(
      final ProductsAdapter.FirstProductViewHolder target, View source) {
    this.target = target;

    View view;
    target.mFirstProductImage = Utils.findRequiredViewAsType(source, R.id.firstProductLabelKenBurnsView, "field 'mFirstProductImage'", LabelKenBurnsView.class);
    target.mFirstProductDescription = Utils.findRequiredViewAsType(source, R.id.firstProductDescriptionTextView, "field 'mFirstProductDescription'", TextView.class);
    target.mFirstProductName = Utils.findRequiredViewAsType(source, R.id.firstProductNameTextView, "field 'mFirstProductName'", TextView.class);
    target.mFirstProductPrice = Utils.findRequiredViewAsType(source, R.id.firstProductPriceTextView, "field 'mFirstProductPrice'", TextView.class);
    view = Utils.findRequiredView(source, R.id.firstAddProductWishlistImageButton, "field 'mFirstProductWishlistButton' and method 'onFirstProductAddToWishlistButtonClick'");
    target.mFirstProductWishlistButton = Utils.castView(view, R.id.firstAddProductWishlistImageButton, "field 'mFirstProductWishlistButton'", ImageButton.class);
    view7f0a0141 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onFirstProductAddToWishlistButtonClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.firstProductListParent, "method 'onParentClick'");
    view7f0a0144 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onParentClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    ProductsAdapter.FirstProductViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mFirstProductImage = null;
    target.mFirstProductDescription = null;
    target.mFirstProductName = null;
    target.mFirstProductPrice = null;
    target.mFirstProductWishlistButton = null;

    view7f0a0141.setOnClickListener(null);
    view7f0a0141 = null;
    view7f0a0144.setOnClickListener(null);
    view7f0a0144 = null;
  }
}
