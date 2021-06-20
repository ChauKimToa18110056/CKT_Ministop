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

public class CartAdapter$CartProductsViewHolder_ViewBinding implements Unbinder {
  private CartAdapter.CartProductsViewHolder target;

  private View view7f0a00f0;

  private View view7f0a016c;

  private View view7f0a00bc;

  @UiThread
  public CartAdapter$CartProductsViewHolder_ViewBinding(
      final CartAdapter.CartProductsViewHolder target, View source) {
    this.target = target;

    View view;
    target.mCartProductImageView = Utils.findRequiredViewAsType(source, R.id.cartProductImageView, "field 'mCartProductImageView'", ImageView.class);
    target.mCartProductNameTextView = Utils.findRequiredViewAsType(source, R.id.cartProductNameTextView, "field 'mCartProductNameTextView'", TextView.class);
    target.mCartProductDescriptionTextView = Utils.findRequiredViewAsType(source, R.id.cartProductDescriptionTextView, "field 'mCartProductDescriptionTextView'", TextView.class);
    target.mCartProductPriceTextView = Utils.findRequiredViewAsType(source, R.id.cartProductPriceTextView, "field 'mCartProductPriceTextView'", TextView.class);
    target.mCartProductQuantityCounter = Utils.findRequiredViewAsType(source, R.id.cartProductQuantityTextView, "field 'mCartProductQuantityCounter'", TextView.class);
    view = Utils.findRequiredView(source, R.id.decreaseQuantityCartProductImageButton, "field 'mMinusQuantityButton' and method 'onMinusQuantityButtonClick'");
    target.mMinusQuantityButton = Utils.castView(view, R.id.decreaseQuantityCartProductImageButton, "field 'mMinusQuantityButton'", ImageButton.class);
    view7f0a00f0 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onMinusQuantityButtonClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.increaseQuantityCartProductImageButton, "field 'mPlusQuantityButton' and method 'onIncreaseQuantityButtonClick'");
    target.mPlusQuantityButton = Utils.castView(view, R.id.increaseQuantityCartProductImageButton, "field 'mPlusQuantityButton'", ImageButton.class);
    view7f0a016c = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onIncreaseQuantityButtonClick();
      }
    });
    target.mCartProductSaleTextView = Utils.findRequiredViewAsType(source, R.id.cartProductSalePercentageTextView, "field 'mCartProductSaleTextView'", TextView.class);
    view = Utils.findRequiredView(source, R.id.cartItemDeleteFab, "method 'onDeleteFabClick'");
    view7f0a00bc = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onDeleteFabClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    CartAdapter.CartProductsViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mCartProductImageView = null;
    target.mCartProductNameTextView = null;
    target.mCartProductDescriptionTextView = null;
    target.mCartProductPriceTextView = null;
    target.mCartProductQuantityCounter = null;
    target.mMinusQuantityButton = null;
    target.mPlusQuantityButton = null;
    target.mCartProductSaleTextView = null;

    view7f0a00f0.setOnClickListener(null);
    view7f0a00f0 = null;
    view7f0a016c.setOnClickListener(null);
    view7f0a016c = null;
    view7f0a00bc.setOnClickListener(null);
    view7f0a00bc = null;
  }
}
