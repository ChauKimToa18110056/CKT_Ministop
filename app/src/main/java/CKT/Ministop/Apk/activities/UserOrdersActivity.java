package CKT.Ministop.Apk.activities;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.os.Parcelable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import androidx.core.app.NavUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.flaviofaria.kenburnsview.KenBurnsView;

import butterknife.BindView;
import butterknife.ButterKnife;
import CKT.Ministop.Apk.R;
import CKT.Ministop.Apk.adapters.OrdersAdapter;
import CKT.Ministop.Apk.firebaseviewmodel.UserOrdersViewModel;

public class UserOrdersActivity extends AppCompatActivity {

    private static final String LAYOUT_KEY = "CKT.Ministop.Apk.activities";
    @BindView(R.id.userOrdersRecyclerView)
    RecyclerView mOrdersRecyclerView;
    @BindView(R.id.userOrdersToolbar)
    Toolbar mToolbar;
    @BindView(R.id.userOrdersHeaderImage)
    KenBurnsView mHeaderImage;
    @BindView(R.id.userOrdersCollapsingToolbar)
    CollapsingToolbarLayout mCollapsingToolbar;
    @BindView(R.id.userOrdersEmptyState)
    View mEmptyState;
    private Parcelable mLayoutState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFullScreenWindow();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        setContentView(R.layout.activity_user_orders);
        ButterKnife.bind(this);
        setupToolbar();
        loadOrders();

        if (savedInstanceState != null) {
            mLayoutState = savedInstanceState.getParcelable(LAYOUT_KEY);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mLayoutState = mOrdersRecyclerView.getLayoutManager().onSaveInstanceState();
        outState.putParcelable(LAYOUT_KEY, mLayoutState);
    }

    private void setFullScreenWindow() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void setupToolbar() {
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        mCollapsingToolbar.setTitle(getString(R.string.order_activity_label));
        mCollapsingToolbar.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.place_holder)
                .error(R.drawable.error_holder);

        Glide.with(this)
                .load(getString(R.string.user_orders_header_image))
                .apply(options)
                .into(mHeaderImage);
        /*
        GlideApp.with(this)
                .load(getString(R.string.user_orders_header_image))
                .placeholder(R.drawable.place_holder)
                .error(R.drawable.error_holder)
                .into(mHeaderImage);

         */

    }

    private void loadOrders() {
        UserOrdersViewModel model  = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(UserOrdersViewModel.class);
        /*UserOrdersViewModel model = ViewModelProviders.of(this).get(UserOrdersViewModel.class);*/
        model.getUserOrders().observe(this, orders -> {
            if (orders.size() == 0) {
                showEmptyState();
            } else {
                hideEmptyState();
                OrdersAdapter adapter = new OrdersAdapter(orders, UserOrdersActivity.this);
                mOrdersRecyclerView.setAdapter(adapter);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mLayoutState != null) {
            mOrdersRecyclerView.getLayoutManager().onRestoreInstanceState(mLayoutState);
        }
    }

    private void showEmptyState() {
        mEmptyState.setVisibility(View.VISIBLE);
    }

    private void hideEmptyState() {
        mEmptyState.setVisibility(View.GONE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);

        }
        return true;
    }

}
