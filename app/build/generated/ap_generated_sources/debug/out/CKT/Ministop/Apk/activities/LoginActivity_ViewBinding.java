// Generated code from Butter Knife. Do not modify!
package CKT.Ministop.Apk.activities;

import CKT.Ministop.Apk.R;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.flaviofaria.kenburnsview.KenBurnsView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding implements Unbinder {
  private LoginActivity target;

  private View view7f0a0189;

  private View view7f0a0187;

  @UiThread
  public LoginActivity_ViewBinding(LoginActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LoginActivity_ViewBinding(final LoginActivity target, View source) {
    this.target = target;

    View view;
    target.donthaveMembershipLabel = Utils.findRequiredViewAsType(source, R.id.switchtoregister2, "field 'donthaveMembershipLabel'", TextView.class);
    target.loginImage = Utils.findRequiredViewAsType(source, R.id.loginImage, "field 'loginImage'", KenBurnsView.class);
    target.loginEmailEditText = Utils.findRequiredViewAsType(source, R.id.loginEmailEditText, "field 'loginEmailEditText'", EditText.class);
    target.loginPasswordEditText = Utils.findRequiredViewAsType(source, R.id.loginPasswordEditText, "field 'loginPasswordEditText'", EditText.class);
    view = Utils.findRequiredView(source, R.id.loginGoogleAuthImageButton, "method 'onGoogleButtonClick'");
    view7f0a0189 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onGoogleButtonClick();
      }
    });
    view = Utils.findRequiredView(source, R.id.loginButton, "method 'onLoginButtonClick'");
    view7f0a0187 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onLoginButtonClick(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    LoginActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.donthaveMembershipLabel = null;
    target.loginImage = null;
    target.loginEmailEditText = null;
    target.loginPasswordEditText = null;

    view7f0a0189.setOnClickListener(null);
    view7f0a0189 = null;
    view7f0a0187.setOnClickListener(null);
    view7f0a0187 = null;
  }
}
