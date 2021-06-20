// Generated code from Butter Knife. Do not modify!
package CKT.Ministop.Apk.adapters;

import CKT.Ministop.Apk.R;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ProductImagesAdapter$FeaturedProductsViewHolder_ViewBinding implements Unbinder {
  private ProductImagesAdapter.FeaturedProductsViewHolder target;

  private View view7f0a0138;

  @UiThread
  public ProductImagesAdapter$FeaturedProductsViewHolder_ViewBinding(
      final ProductImagesAdapter.FeaturedProductsViewHolder target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.featuredProductImage, "field 'mProductImage' and method 'onFeaturedProductClick'");
    target.mProductImage = Utils.castView(view, R.id.featuredProductImage, "field 'mProductImage'", ImageView.class);
    view7f0a0138 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onFeaturedProductClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    ProductImagesAdapter.FeaturedProductsViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mProductImage = null;

    view7f0a0138.setOnClickListener(null);
    view7f0a0138 = null;
  }
}
