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
import java.lang.IllegalStateException;
import java.lang.Override;

public class OrdersAdapter$OrdersViewHolder_ViewBinding implements Unbinder {
  private OrdersAdapter.OrdersViewHolder target;

  private View view7f0a02a4;

  @UiThread
  public OrdersAdapter$OrdersViewHolder_ViewBinding(final OrdersAdapter.OrdersViewHolder target,
      View source) {
    this.target = target;

    View view;
    target.mOrderKeyTextView = Utils.findRequiredViewAsType(source, R.id.userOrderKeyTextView, "field 'mOrderKeyTextView'", TextView.class);
    target.mOrderPaymentPriceTextView = Utils.findRequiredViewAsType(source, R.id.userOrderPriceTextView, "field 'mOrderPaymentPriceTextView'", TextView.class);
    target.mOrderStatusTextView = Utils.findRequiredViewAsType(source, R.id.userOrderStatusTextView, "field 'mOrderStatusTextView'", TextView.class);
    view = Utils.findRequiredView(source, R.id.userOrderCardView, "method 'onOrderClick'");
    view7f0a02a4 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onOrderClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    OrdersAdapter.OrdersViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mOrderKeyTextView = null;
    target.mOrderPaymentPriceTextView = null;
    target.mOrderStatusTextView = null;

    view7f0a02a4.setOnClickListener(null);
    view7f0a02a4 = null;
  }
}
