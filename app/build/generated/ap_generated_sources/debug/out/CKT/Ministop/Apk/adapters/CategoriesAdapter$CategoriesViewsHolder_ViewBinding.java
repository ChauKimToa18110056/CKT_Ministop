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
import com.fmsirvent.ParallaxEverywhere.PEWImageView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CategoriesAdapter$CategoriesViewsHolder_ViewBinding implements Unbinder {
  private CategoriesAdapter.CategoriesViewsHolder target;

  private View view7f0a00c8;

  @UiThread
  public CategoriesAdapter$CategoriesViewsHolder_ViewBinding(
      final CategoriesAdapter.CategoriesViewsHolder target, View source) {
    this.target = target;

    View view;
    target.mCategoryImageView = Utils.findRequiredViewAsType(source, R.id.categoryImageView, "field 'mCategoryImageView'", PEWImageView.class);
    target.mCategoryTextView = Utils.findRequiredViewAsType(source, R.id.categoryNameTextView, "field 'mCategoryTextView'", TextView.class);
    view = Utils.findRequiredView(source, R.id.categoriesCardView, "method 'onCategoryClick'");
    view7f0a00c8 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onCategoryClick();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    CategoriesAdapter.CategoriesViewsHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mCategoryImageView = null;
    target.mCategoryTextView = null;

    view7f0a00c8.setOnClickListener(null);
    view7f0a00c8 = null;
  }
}
