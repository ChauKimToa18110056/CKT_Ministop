// Generated code from Butter Knife. Do not modify!
package CKT.Ministop.Apk.activities;

import CKT.Ministop.Apk.R;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class OrderDetailsActivity_ViewBinding implements Unbinder {
  private OrderDetailsActivity target;

  @UiThread
  public OrderDetailsActivity_ViewBinding(OrderDetailsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public OrderDetailsActivity_ViewBinding(OrderDetailsActivity target, View source) {
    this.target = target;

    target.mOrderProductsRecyclerView = Utils.findRequiredViewAsType(source, R.id.orderProductsRecyclerView, "field 'mOrderProductsRecyclerView'", RecyclerView.class);
    target.mOrderProductName = Utils.findRequiredViewAsType(source, R.id.orderProductNameTextSwitcher, "field 'mOrderProductName'", TextSwitcher.class);
    target.mOrderProductPrice = Utils.findRequiredViewAsType(source, R.id.orderProductPriceTextSwitcher, "field 'mOrderProductPrice'", TextSwitcher.class);
    target.mUserName = Utils.findRequiredViewAsType(source, R.id.userNameTextView, "field 'mUserName'", TextView.class);
    target.mUserAddress = Utils.findRequiredViewAsType(source, R.id.userEnteredAddressTextView, "field 'mUserAddress'", TextView.class);
    target.mUserPhoneNumber = Utils.findRequiredViewAsType(source, R.id.userPhoneNumberTextView, "field 'mUserPhoneNumber'", TextView.class);
    target.mOrderPayment = Utils.findRequiredViewAsType(source, R.id.userPaymentPriceTextView, "field 'mOrderPayment'", TextView.class);
    target.mOrderDiscount = Utils.findRequiredViewAsType(source, R.id.userPaymentDiscountPriceTextView, "field 'mOrderDiscount'", TextView.class);
    target.mOrderStatusRecyclerView = Utils.findRequiredViewAsType(source, R.id.orderStatusRecyclerView, "field 'mOrderStatusRecyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    OrderDetailsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mOrderProductsRecyclerView = null;
    target.mOrderProductName = null;
    target.mOrderProductPrice = null;
    target.mUserName = null;
    target.mUserAddress = null;
    target.mUserPhoneNumber = null;
    target.mOrderPayment = null;
    target.mOrderDiscount = null;
    target.mOrderStatusRecyclerView = null;
  }
}
