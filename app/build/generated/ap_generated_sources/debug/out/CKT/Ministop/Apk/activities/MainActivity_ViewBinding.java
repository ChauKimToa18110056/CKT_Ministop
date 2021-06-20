// Generated code from Butter Knife. Do not modify!
package CKT.Ministop.Apk.activities;

import CKT.Ministop.Apk.R;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.google.android.material.navigation.NavigationView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view7f0a01f5;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    target.mCategoriesRecyclerView = Utils.findRequiredViewAsType(source, R.id.categoriesRecyclerView, "field 'mCategoriesRecyclerView'", RecyclerView.class);
    target.mDrawerLayout = Utils.findRequiredViewAsType(source, R.id.drawerLayout, "field 'mDrawerLayout'", DrawerLayout.class);
    target.mToolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'mToolbar'", Toolbar.class);
    target.mNavigationView = Utils.findRequiredViewAsType(source, R.id.navigationView, "field 'mNavigationView'", NavigationView.class);
    target.mFTProductsRecyclerView = Utils.findRequiredViewAsType(source, R.id.featuredProductsRecyclerView, "field 'mFTProductsRecyclerView'", RecyclerView.class);
    target.mFTProductNameTextSwitcher = Utils.findRequiredViewAsType(source, R.id.featuredProductNameTextSwitcher, "field 'mFTProductNameTextSwitcher'", TextSwitcher.class);
    target.mFTProductPrice = Utils.findRequiredViewAsType(source, R.id.featuredProductPrice, "field 'mFTProductPrice'", TextSwitcher.class);
    target.mFTProductsLabel = Utils.findRequiredViewAsType(source, R.id.featuredProductsLabel, "field 'mFTProductsLabel'", TextView.class);
    target.mLoadingIndicator = Utils.findRequiredViewAsType(source, R.id.loadingIndicator, "field 'mLoadingIndicator'", ProgressBar.class);
    view = Utils.findRequiredView(source, R.id.retryConnectionButton, "field 'mRetryButton' and method 'onRetryButtonClick'");
    target.mRetryButton = Utils.castView(view, R.id.retryConnectionButton, "field 'mRetryButton'", Button.class);
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
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mCategoriesRecyclerView = null;
    target.mDrawerLayout = null;
    target.mToolbar = null;
    target.mNavigationView = null;
    target.mFTProductsRecyclerView = null;
    target.mFTProductNameTextSwitcher = null;
    target.mFTProductPrice = null;
    target.mFTProductsLabel = null;
    target.mLoadingIndicator = null;
    target.mRetryButton = null;

    view7f0a01f5.setOnClickListener(null);
    view7f0a01f5 = null;
  }
}
