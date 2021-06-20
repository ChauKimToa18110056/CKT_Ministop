// Generated code from Butter Knife. Do not modify!
package CKT.Ministop.Apk.adapters;

import CKT.Ministop.Apk.R;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.github.vipulasri.timelineview.TimelineView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class OrderStatusAdapter$OrderStatusViewHolder_ViewBinding implements Unbinder {
  private OrderStatusAdapter.OrderStatusViewHolder target;

  @UiThread
  public OrderStatusAdapter$OrderStatusViewHolder_ViewBinding(
      OrderStatusAdapter.OrderStatusViewHolder target, View source) {
    this.target = target;

    target.mOrderTracker = Utils.findRequiredViewAsType(source, R.id.orderStatusTimeLineView, "field 'mOrderTracker'", TimelineView.class);
    target.mOrderStatus = Utils.findRequiredViewAsType(source, R.id.orderStatusTextView, "field 'mOrderStatus'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    OrderStatusAdapter.OrderStatusViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mOrderTracker = null;
    target.mOrderStatus = null;
  }
}
