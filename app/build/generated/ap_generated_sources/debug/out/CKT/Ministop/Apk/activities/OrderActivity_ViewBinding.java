// Generated code from Butter Knife. Do not modify!
package CKT.Ministop.Apk.activities;

import CKT.Ministop.Apk.R;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.braintreepayments.cardform.view.CardForm;
import com.hbb20.CountryCodePicker;
import java.lang.IllegalStateException;
import java.lang.Override;

public class OrderActivity_ViewBinding implements Unbinder {
  private OrderActivity target;

  private View view7f0a01d6;

  @UiThread
  public OrderActivity_ViewBinding(OrderActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public OrderActivity_ViewBinding(final OrderActivity target, View source) {
    this.target = target;

    View view;
    target.mNameEditText = Utils.findRequiredViewAsType(source, R.id.nameInputEditText, "field 'mNameEditText'", EditText.class);
    target.mAddressEditText = Utils.findRequiredViewAsType(source, R.id.addressInputEditText, "field 'mAddressEditText'", EditText.class);
    target.mZipEdiText = Utils.findRequiredViewAsType(source, R.id.zipInputEditText, "field 'mZipEdiText'", EditText.class);
    target.mPhoneEditText = Utils.findRequiredViewAsType(source, R.id.phoneNumberInputEditText, "field 'mPhoneEditText'", EditText.class);
    target.mEmailEditText = Utils.findRequiredViewAsType(source, R.id.emailInputEdiText, "field 'mEmailEditText'", EditText.class);
    target.mExpMonthEditText = Utils.findRequiredViewAsType(source, R.id.creditCardExpirationMonthInputEditText, "field 'mExpMonthEditText'", EditText.class);
    target.mCardForm = Utils.findRequiredViewAsType(source, R.id.creditCardForm, "field 'mCardForm'", CardForm.class);
    view = Utils.findRequiredView(source, R.id.proceedToOrderButton, "field 'mOrderButton' and method 'onProceedOrderClick'");
    target.mOrderButton = Utils.castView(view, R.id.proceedToOrderButton, "field 'mOrderButton'", Button.class);
    view7f0a01d6 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onProceedOrderClick();
      }
    });
    target.mExpYearEditText = Utils.findRequiredViewAsType(source, R.id.creditCardExpirationYearInputEditText, "field 'mExpYearEditText'", EditText.class);
    target.mCountryCodePicker = Utils.findRequiredViewAsType(source, R.id.countryCodePicker, "field 'mCountryCodePicker'", CountryCodePicker.class);
    target.mTotalPriceTextView = Utils.findRequiredViewAsType(source, R.id.totalPriceOrderTextView, "field 'mTotalPriceTextView'", TextView.class);
    target.mParentLayout = Utils.findRequiredViewAsType(source, R.id.creditCardFormParent, "field 'mParentLayout'", LinearLayout.class);
    target.mLoadingIndicator = Utils.findRequiredViewAsType(source, R.id.loadingIndicator, "field 'mLoadingIndicator'", ProgressBar.class);
    target.mImagesRecyclerView = Utils.findRequiredViewAsType(source, R.id.cartImagesRecyclerView, "field 'mImagesRecyclerView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    OrderActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mNameEditText = null;
    target.mAddressEditText = null;
    target.mZipEdiText = null;
    target.mPhoneEditText = null;
    target.mEmailEditText = null;
    target.mExpMonthEditText = null;
    target.mCardForm = null;
    target.mOrderButton = null;
    target.mExpYearEditText = null;
    target.mCountryCodePicker = null;
    target.mTotalPriceTextView = null;
    target.mParentLayout = null;
    target.mLoadingIndicator = null;
    target.mImagesRecyclerView = null;

    view7f0a01d6.setOnClickListener(null);
    view7f0a01d6 = null;
  }
}
