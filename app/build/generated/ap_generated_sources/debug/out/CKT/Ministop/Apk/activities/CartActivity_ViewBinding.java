// Generated code from Butter Knife. Do not modify!
package CKT.Ministop.Apk.activities;

import CKT.Ministop.Apk.R;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CartActivity_ViewBinding implements Unbinder {
  private CartActivity target;

  private View view7f0a01b0;

  private View view7f0a01f5;

  @UiThread
  public CartActivity_ViewBinding(CartActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CartActivity_ViewBinding(final CartActivity target, View source) {
    this.target = target;

    View view;
    target.mCartProductsRecyclerView = Utils.findRequiredViewAsType(source, R.id.categoryCartProductsRecyclerView, "field 'mCartProductsRecyclerView'", RecyclerView.class);
    target.mCartEmptyState = Utils.findRequiredView(source, R.id.cartProductEmptyState, "field 'mCartEmptyState'");
    target.mTotalPriceTextView = Utils.findRequiredViewAsType(source, R.id.totalPriceTextView, "field 'mTotalPriceTextView'", TextView.class);
    target.mCartActivityParent = Utils.findRequiredViewAsType(source, R.id.cartActivityParent, "field 'mCartActivityParent'", ViewGroup.class);
    view = Utils.findRequiredView(source, R.id.orderButton, "field 'mOrderButton' and method 'onOrderButtonClick'");
    target.mOrderButton = Utils.castView(view, R.id.orderButton, "field 'mOrderButton'", Button.class);
    view7f0a01b0 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onOrderButtonClick();
      }
    });
    target.mToolbar = Utils.findRequiredViewAsType(source, R.id.cartToolbar, "field 'mToolbar'", Toolbar.class);
    target.mHeaderImage = Utils.findRequiredViewAsType(source, R.id.headerImage, "field 'mHeaderImage'", KenBurnsView.class);
    target.mCollapsingToolbar = Utils.findRequiredViewAsType(source, R.id.cartCollapsingToolbar, "field 'mCollapsingToolbar'", CollapsingToolbarLayout.class);
    view = Utils.findRequiredView(source, R.id.retryConnectionButton, "field 'mRetryConnectionButton' and method 'onRetryButtonClick'");
    target.mRetryConnectionButton = Utils.castView(view, R.id.retryConnectionButton, "field 'mRetryConnectionButton'", Button.class);
    view7f0a01f5 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onRetryButtonClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    CartActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mCartProductsRecyclerView = null;
    target.mCartEmptyState = null;
    target.mTotalPriceTextView = null;
    target.mCartActivityParent = null;
    target.mOrderButton = null;
    target.mToolbar = null;
    target.mHeaderImage = null;
    target.mCollapsingToolbar = null;
    target.mRetryConnectionButton = null;

    view7f0a01b0.setOnClickListener(null);
    view7f0a01b0 = null;
    view7f0a01f5.setOnClickListener(null);
    view7f0a01f5 = null;
  }
}
