package CKT.Ministop.Apk.activities;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextSwitcher;
import android.widget.TextView;

import com.bumptech.glide.request.RequestOptions;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ramotion.cardslider.CardSliderLayoutManager;
import com.tapadoo.alerter.Alerter;
import com.transitionseverywhere.ChangeText;
import com.transitionseverywhere.TransitionManager;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import CKT.Ministop.Apk.R;
import CKT.Ministop.Apk.adapters.CategoriesAdapter;
import CKT.Ministop.Apk.adapters.ProductImagesAdapter;
import CKT.Ministop.Apk.firebaseviewmodel.CartViewModel;
import CKT.Ministop.Apk.firebaseviewmodel.CategoriesViewModel;
import CKT.Ministop.Apk.model.Categories;
import CKT.Ministop.Apk.model.Product;
import CKT.Ministop.Apk.model.User;
import CKT.Ministop.Apk.wishlistviewmodel.WishlistProductsViewModel;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private static final String CATEGORIES_STATE_KEY = "CKT.Ministop.Apk.activities";
    final List<Product> mFTProducts = new ArrayList<>();
    @BindView(R.id.categoriesRecyclerView)
    RecyclerView mCategoriesRecyclerView;
    @BindView(R.id.drawerLayout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.navigationView)
    NavigationView mNavigationView;
    @BindView(R.id.featuredProductsRecyclerView)
    RecyclerView mFTProductsRecyclerView;
    @BindView(R.id.featuredProductNameTextSwitcher)
    TextSwitcher mFTProductNameTextSwitcher;
    @BindView(R.id.featuredProductPrice)
    TextSwitcher mFTProductPrice;
    @BindView(R.id.featuredProductsLabel)
    TextView mFTProductsLabel;
    @BindView(R.id.loadingIndicator)
    ProgressBar mLoadingIndicator;
    @BindView(R.id.retryConnectionButton)
    Button mRetryButton;
    private ImageView mProfileImage;
    private ImageView mProfileHeader;
    private TextView mUserNameTextView;
    private TextView mUserEmailTextView;
    private TextView mCartBadgeTextView;
    private TextView mWishlistProductsBadgeTextView;
    private CategoriesAdapter mCategoriesAdapter;
    private CardSliderLayoutManager mFTLayoutManager;
    private int mFTRecyclerViewPosition;
    private Parcelable mLayoutState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupHeader();
        if (savedInstanceState != null) {
            mLayoutState = savedInstanceState.getParcelable(CATEGORIES_STATE_KEY);
        }
        setupViews();
        setupNavigationDrawer();
        setupCartMenu();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mLayoutState = mCategoriesRecyclerView.getLayoutManager().onSaveInstanceState();
        outState.putParcelable(CATEGORIES_STATE_KEY, mLayoutState);
    }


    private void loadCategories() {
        showLoadingIndicator();
        CategoriesViewModel categoriesViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(CategoriesViewModel.class);
        /*CategoriesViewModel categoriesViewModel = ViewModelProviders.of(this).get(CategoriesViewModel.class);*/
        categoriesViewModel.getCategories().observe(this, new Observer<List<Categories>>() {
            @Override
            public void onChanged(@Nullable List<Categories> categories) {
                mCategoriesAdapter = new CategoriesAdapter(MainActivity.this, categories);
                mCategoriesRecyclerView.setAdapter(mCategoriesAdapter);

                mFTProducts.clear();
                for (int i = 0; i < categories.size(); i++) {
                    mFTProducts.addAll(categories.get(i).getCategoryProducts());
                }
                if (mLayoutState != null) {
                    mCategoriesRecyclerView.getLayoutManager().onRestoreInstanceState(mLayoutState);
                }
                loadFeatureProducts();
            }
        });

    }

    private void setupViews() {
        if (isNetworkAvailable()) {
            hideRetryButton();
            setupTextSwitcher();
            setupRecyclerViews();
            loadCategories();
        } else {
            showRetryButton();
            hideFeaturedProductsLabel();
            showConnectionErrorMessage();
        }
    }

    @OnClick(R.id.retryConnectionButton)
    public void onRetryButtonClick() {
        setupViews();
    }

    private void hideRetryButton() {
        mRetryButton.setVisibility(View.GONE);
    }

    private void showRetryButton() {
        mRetryButton.setVisibility(View.VISIBLE);
    }

    private void hideFeaturedProductsLabel() {
        mFTProductsLabel.setVisibility(View.GONE);
    }

    private void showFeaturedProductsLabel() {
        mFTProductsLabel.setVisibility(View.VISIBLE);
    }

    private void showConnectionErrorMessage() {
        Alerter.create(this)
                .setTitle(R.string.connection_alerter_title)
                .setText(R.string.connection_alerter_text)
                .setIcon(R.drawable.ic_network)
                .setDuration(getResources().getInteger(R.integer.alerter_default_duration))
                .setDismissable(true)
                .show();
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void showLoadingIndicator() {
        hideFeaturedProductsLabel();
        mFTProductsRecyclerView.setVisibility(View.GONE);
        mCategoriesRecyclerView.setVisibility(View.GONE);
        mFTProductPrice.setVisibility(View.GONE);
        mFTProductNameTextSwitcher.setVisibility(View.GONE);
        mLoadingIndicator.setVisibility(View.VISIBLE);
    }

    private void hideLoadingIndicator() {
        mLoadingIndicator.setVisibility(View.GONE);
        mFTProductsRecyclerView.setVisibility(View.VISIBLE);
        mCategoriesRecyclerView.setVisibility(View.VISIBLE);
        mFTProductPrice.setVisibility(View.VISIBLE);
        mFTProductNameTextSwitcher.setVisibility(View.VISIBLE);
        showFeaturedProductsLabel();
    }

    private void setupTextSwitcher() {
        mFTProductNameTextSwitcher.setFactory(() -> {
            TextView textView = new TextView(MainActivity.this);
            textView.setGravity(View.TEXT_ALIGNMENT_CENTER);
            textView.setTextColor(getResources().getColor(R.color.primaryTextColor));
            textView.setTextSize(16f);
            Typeface typeface = ResourcesCompat.getFont(MainActivity.this, R.font.poppins);
            textView.setTypeface(typeface);
            return textView;
        });
        mFTProductPrice.setFactory(() -> {
            TextView textView = new TextView(MainActivity.this);
            textView.setGravity(View.TEXT_ALIGNMENT_CENTER);
            textView.setTextColor(getResources().getColor(R.color.primaryTextColor));
            textView.setTextSize(16f);
            Typeface typeface = ResourcesCompat.getFont(MainActivity.this, R.font.poppins);
            textView.setTypeface(typeface);
            return textView;
        });
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        mFTProductNameTextSwitcher.setInAnimation(in);
        mFTProductNameTextSwitcher.setOutAnimation(out);
        mFTProductPrice.setInAnimation(in);
        mFTProductPrice.setOutAnimation(out);
    }

    private void onActiveCardChange() {
        final int position = mFTLayoutManager.getActiveCardPosition();
        if (position == RecyclerView.NO_POSITION || position == mFTRecyclerViewPosition) {
            return;
        }
        onActiveCardChange(position);
    }

    private void onActiveCardChange(int position) {
        mFTProductNameTextSwitcher.setText(String.valueOf(mFTProducts.get(position).getName()));
        mFTProductPrice.setText("VND" + new DecimalFormat().format(mFTProducts.get(position).getPrice()));
        mFTRecyclerViewPosition = position;
    }

    private void setupNavigationDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,
                mToolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        mNavigationView.setNavigationItemSelectedListener(this);
        mToolbar.setNavigationIcon(R.drawable.ic_menu);
        mToolbar.setTitle(R.string.app_name);
    }

    private void setupHeader() {
        View navigationViewHeader = mNavigationView.getHeaderView(0);
        mProfileHeader = navigationViewHeader.findViewById(R.id.profileHeaderBackground);
        mProfileImage = navigationViewHeader.findViewById(R.id.profileImageView);
        mUserNameTextView = navigationViewHeader.findViewById(R.id.profileNameTextView);
        mUserEmailTextView = navigationViewHeader.findViewById(R.id.profileEmailTextView);
        setupHeaderViews();
    }

    private void setupHeaderViews() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.place_holder)
                .error(R.drawable.error_holder);

        Glide.with(this)
                .load(getString(R.string.main_activity_header_image))
                .apply(options)
                .into(mProfileHeader);

        Glide.with(this).load(user.getPhotoUrl())
                .apply(options)
                .apply(RequestOptions.circleCropTransform())
                .into(mProfileImage);
/*
        Glide.with(this)
                .load(getString(R.string.main_activity_header_image))
                .placeholder(R.drawable.place_holder)
                .error(R.drawable.error_holder)
                .into(mProfileHeader);

        GlideApp.with(this).load(user.getPhotoUrl())
                .apply(new RequestOptions().override(400, 600))
                .placeholder(R.drawable.place_holder)
                .error(R.drawable.error_holder)
                .apply(RequestOptions.circleCropTransform())
                .into(mProfileImage);
*/
        mUserNameTextView.setText(String.valueOf(user.getDisplayName()));
        mUserEmailTextView.setText(String.valueOf(user.getEmail()));
    }

    private void setupCartMenu() {
        mCartBadgeTextView = mNavigationView.getMenu().findItem(R.id.cartMenuItemAction).getActionView().findViewById(R.id.menuItemCartBadgeNavDrawerTextView);
        /*CartViewModel model = ViewModelProviders.of(this).get(CartViewModel.class);*/
        CartViewModel model = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(CartViewModel.class);
        model.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                mCartBadgeTextView.setText(String.valueOf(user.getProductsCount()));
            }
        });

        setupWishlistMenu();
    }

    private void setupWishlistMenu() {
        mWishlistProductsBadgeTextView = mNavigationView.getMenu().findItem(R.id.wishlistMenuItemAction).getActionView().findViewById(R.id.menuItemWishlistedBadgeNavDrawerTextView);
        /*WishlistProductsViewModel wishlistProductsViewModel = ViewModelProviders.of(this).get(WishlistProductsViewModel.class);*/
        WishlistProductsViewModel wishlistProductsViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(WishlistProductsViewModel.class);
        wishlistProductsViewModel.getWishlistedProducts().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(@Nullable List<Product> products) {
                if (products != null)
                    mWishlistProductsBadgeTextView.setText(String.valueOf(products.size()));
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    private void loadFeatureProducts() {
        ProductImagesAdapter mFeaturedProductsAdapter = new ProductImagesAdapter(mFTProducts, this);
        mFTProductsRecyclerView.setAdapter(mFeaturedProductsAdapter);
        hideLoadingIndicator();
        TransitionManager.beginDelayedTransition(mDrawerLayout,
                new ChangeText().setChangeBehavior(ChangeText.CHANGE_BEHAVIOR_OUT_IN));
        mFTProductNameTextSwitcher.setText(String.valueOf(mFTProducts.get(mFTRecyclerViewPosition).getName()));
        mFTProductPrice.setText("VND" + new DecimalFormat().format(mFTProducts.get(mFTRecyclerViewPosition).getPrice()));

    }

    private void setupRecyclerViews() {
        mCategoriesRecyclerView.setNestedScrollingEnabled(false);
        mFTProductsRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    onActiveCardChange();
                }
            }
        });
        mFTLayoutManager = new CardSliderLayoutManager(this);
        mFTProductsRecyclerView.setLayoutManager(mFTLayoutManager);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.profileMenuItemAction:
                launchUserOrdersActivity();
                break;
            case R.id.cartMenuItemAction:
                launchCartActivity();
                break;
            case R.id.wishlistMenuItemAction:
                launchWishlistActivity();
                break;
            case R.id.signOutMenuItemAction:
                signOutUser();
                break;

        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void launchUserOrdersActivity() {
        Intent intent = new Intent(this, UserOrdersActivity.class);
        startActivity(intent);
    }

    private void launchWishlistActivity() {
        Intent intent = new Intent(this, WishlistProductsActivity.class);
        startActivity(intent);
    }

    private void signOutUser() {
        AuthUI.getInstance().signOut(this).addOnCompleteListener(task -> startActivity(new Intent(MainActivity.this, LoginActivity.class)));
    }

    private void launchCartActivity() {
        Intent intent = new Intent(this, CartActivity.class);
        startActivity(intent);
    }

}