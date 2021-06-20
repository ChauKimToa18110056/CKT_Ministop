package CKT.Ministop.Apk.activities;

import android.annotation.SuppressLint;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.app.NavUtils;
import androidx.core.app.ShareCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatDrawableManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.tapadoo.alerter.Alerter;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import CKT.Ministop.Apk.LabelKenBurnsView;
import CKT.Ministop.Apk.R;
import CKT.Ministop.Apk.database.WishlistDatabase;
import CKT.Ministop.Apk.firebaseviewmodel.CartViewModel;
import CKT.Ministop.Apk.model.Cart;
import CKT.Ministop.Apk.model.Product;
import CKT.Ministop.Apk.model.User;
import CKT.Ministop.Apk.utils.Constants;
import CKT.Ministop.Apk.wishlistviewmodel.WishlistProductDetailsViewModel;
import CKT.Ministop.Apk.wishlistviewmodel.WishlistProductDetailsViewModelFactory;

public class WishlistProductDetailsActivity extends AppCompatActivity {

    @BindView(R.id.wishListProductDetailsImage)
    LabelKenBurnsView mProductImage;
    @BindView(R.id.wishListProductDetailsDescriptionTextView)
    TextView mProductDescriptionTextView;
    @BindView(R.id.wishListProductDetailsNameTextView)
    TextView mProductNameTextView;
    @BindView(R.id.wishListProductDetailsTotalPrice)
    TextView mPriceTextView;
    @BindView(R.id.wishListProductDetailsDiscountPrice)
    TextView mDiscountPriceTextView;
    @BindView(R.id.wishListProductDetailsHashTag)
    TextView mCategoryHashTag;
    @BindView(R.id.wishListProductFABMenu)
    FloatingActionMenu mFABsMenu;
    @BindView(R.id.wishListAddToCartFAB)
    FloatingActionButton mAddToCartFab;
    @BindView(R.id.wishListRemoveFromWishListFAB)
    FloatingActionButton mRemoveFromWishListFAB;
    @BindView(R.id.wishListShareProductFAB)
    FloatingActionButton mShareFAB;

    private Product mWishlistedProduct;
    private TextView mCartBadgeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
            int code = intent.getIntExtra(Intent.EXTRA_TEXT, -1);
            queryForProduct(code);
        } else if (getIntent().getExtras() != null) {
            int code = getIntent().getExtras().getInt(Intent.EXTRA_TEXT);
            queryForProduct(code);
        } else {
            errorUponLaunch();
        }

        setupFABs();
    }

    @SuppressLint("RestrictedApi")
    private void setupFABs() {
        mAddToCartFab.setImageDrawable(AppCompatDrawableManager.get().getDrawable(this, R.drawable.ic_shopping_cart));
        mRemoveFromWishListFAB.setImageDrawable(AppCompatDrawableManager.get().getDrawable(this, R.drawable.ic_wishlist_remove));
        mShareFAB.setImageDrawable(AppCompatDrawableManager.get().getDrawable(this, R.drawable.ic_share));
    }

    @OnClick(R.id.wishListShareProductFAB)
    public void onShareFABClick() {
        String text;
        if (mWishlistedProduct.getSale() > 0) {
            text = shareTextWithSale();
        } else {
            text = shareTextWithoutSale();
        }
        shareProduct(text);
    }

    @NonNull
    private String shareTextWithoutSale() {
        return mWishlistedProduct.getName() + " " + getString(R.string.share_product_sale_for_part) + "VND" + new DecimalFormat().format(mWishlistedProduct.getPrice()) + "\n\n\n" +
                mWishlistedProduct.getDescription();
    }

    @NonNull
    private String shareTextWithSale() {
        return getString(R.string.share_product_sale_first_part) + mWishlistedProduct.getName() + getString(R.string.share_product_sale_for_part) +
                "VND" + new DecimalFormat().format(mWishlistedProduct.getPrice() - mWishlistedProduct.getSale()) +
                getString(R.string.share_product_sale_second_part) + "VND" + new DecimalFormat().format(mWishlistedProduct.getPrice()) + getString(R.string.share_product_sale_on_part) + getString(R.string.app_name) +
                " " + mWishlistedProduct.getName() + "\n\n\n" + mWishlistedProduct.getDescription();
    }

    private void shareProduct(String text) {
        mFABsMenu.close(true);
        ShareCompat.IntentBuilder.from(this)
                .setType("text/plain")
                .setChooserTitle(getString(R.string.share_product_chooser_title))
                .setText(text)
                .startChooser();
    }

    @OnClick(R.id.wishListRemoveFromWishListFAB)
    public void onRemoveFromWishListFABClick() {
        WishlistDatabase database = WishlistDatabase.getDatabase(this);
        database.mWishListProductsDao().deleteProduct(mWishlistedProduct);
        mFABsMenu.close(true);
        finish();
    }

    @OnClick(R.id.wishListAddToCartFAB)
    public void onAddToCartFABClick() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference reference = database.getReference().child(Constants.USER_CHILD);
        final FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        final Product product = mWishlistedProduct;
        final int productCode = product.getCode();

        reference.orderByChild(Constants.USER_ID_CHILD).equalTo(firebaseUser.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                if (user == null) {

                    List<Product> products = new ArrayList<>();
                    product.setShoppingCartQuantity(1);
                    products.add(product);
                    Cart cart = new Cart(products, firebaseUser.getUid());
                    User user1 = new User(firebaseUser.getDisplayName(), firebaseUser.getUid(), cart, products.size());
                    reference.push().setValue(user1);
                    showCartAddedAlerterMsg();
                } else {
                    reference.orderByChild(Constants.USER_ID_CHILD).equalTo(firebaseUser.getUid()).addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                            String key = dataSnapshot.getKey();
                            User user = dataSnapshot.getValue(User.class);
                            Cart cart = user.getCart();
                            List<Product> productList = cart.getCartProducts();
                            List<Integer> codes = new ArrayList<>();

                            for (int i = 0; i < productList.size(); i++) {
                                codes.add(productList.get(i).getCode());
                            }


                            for (int i = 0; i < productList.size(); i++) {
                                Product product1 = productList.get(i);
                                if (product1.getCode() == productCode) {

                                    product1.setShoppingCartQuantity(product1.getShoppingCartQuantity() + 1);
                                    productList.set(i, product1);

                                    cart.setCartProducts(productList);
                                    user.setCart(cart);
                                    user.setProductsCount(productList.size());
                                    reference.child(key).updateChildren(user.toMap());
                                    showProductCartQuantityAlerterMsg();
                                    break;
                                }

                            }


                            if (!codes.contains(productCode)) {
                                product.setShoppingCartQuantity(1);
                                productList.add(product);
                                cart.setCartProducts(productList);
                                user.setCart(cart);
                                user.setProductsCount(productList.size());
                                reference.child(key).setValue(user);
                                showCartAddedAlerterMsg();
                            }
                        }

                        @Override
                        public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                        }

                        @Override
                        public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                        }

                        @Override
                        public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void showCartAddedAlerterMsg() {
        mFABsMenu.close(true);
        Alerter.create(this)
                .setText(R.string.cart_add_product_alerter_msg)
                .setIcon(R.drawable.ic_shopping_cart)
                .setDismissable(true)
                .setDuration(getResources().getInteger(R.integer.alerter_default_duration))
                .show();
    }

    private void showProductCartQuantityAlerterMsg() {
        mFABsMenu.close(true);
        Alerter.create(this)
                .setTitle(R.string.cart_add_product_exists_alerter_msg)
                .setText(R.string.cart_add_product_increase_quantity_alerter_text)
                .setDuration(getResources().getInteger(R.integer.alerter_default_duration))
                .setIcon(R.drawable.ic_plus_one)
                .setDismissable(true)
                .show();
    }

    private void queryForProduct(int code) {
        WishlistDatabase database = WishlistDatabase.getDatabase(getApplicationContext());
        WishlistProductDetailsViewModelFactory factory = new WishlistProductDetailsViewModelFactory(code, database);
        WishlistProductDetailsViewModel model = ViewModelProviders.of(this, factory).get(WishlistProductDetailsViewModel.class);
        model.getProduct().observe(this, new Observer<Product>() {
            @Override
            public void onChanged(@Nullable Product product) {
                mWishlistedProduct = product;
                initViews(product);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.wishlistCartMenuItemAction:
                launchCartActivity();
                return true;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void launchCartActivity() {
        Intent intent = new Intent(this, CartActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.wishlist_menu, menu);
        final MenuItem cartMenuItem = menu.findItem(R.id.wishlistCartMenuItemAction);
        View actionView = cartMenuItem.getActionView();
        mCartBadgeTextView = actionView.findViewById(R.id.cartMenuItemBadge);
        setupCartViewModel();
        actionView.setOnClickListener(view -> onOptionsItemSelected(cartMenuItem));
        return super.onCreateOptionsMenu(menu);
    }

    private void setupCartViewModel() {
        /*CartViewModel model = ViewModelProviders.of(this).get(CartViewModel.class);*/
        CartViewModel model  = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(CartViewModel.class);
        model.getUser().observe(this, user -> mCartBadgeTextView.setText(String.valueOf(user.getProductsCount())));
    }

    private void initViews(final Product product) {
        if (product == null) return;
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.place_holder)
                .error(R.drawable.error_holder);

        Glide.with(this)
                .load(product.getImage())
                .apply(options)
                .into(mProductImage);

        /*
        GlideApp.with(this)
                .load(product.getImage())
                .placeholder(R.drawable.place_holder)
                .error(R.drawable.error_holder)
                .into(mProductImage);

         */
        mProductNameTextView.setText(product.getName());
        mProductDescriptionTextView.setText(product.getDescription());

        float productSale = product.getSale();
        float productPrice = product.getPrice();

        if (productSale > 0) {
            setPriceWithSale(productSale, productPrice);
        } else {
            setPriceWithoutSale(productPrice);
        }

        mCategoryHashTag.setText(String.valueOf("#" + product.getCategory()));
        mCategoryHashTag.setOnClickListener(view -> showCategoryProducts(product.getCategory()));
    }

    @SuppressLint("SetTextI18n")
    private void setPriceWithoutSale(float productPrice) {
        mProductImage.setLabelVisual(false);
        mDiscountPriceTextView.setVisibility(View.GONE);
        mPriceTextView.setText("VND" + new DecimalFormat().format(productPrice));
    }

    @SuppressLint("SetTextI18n")
    private void setPriceWithSale(float productSale, float productPrice) {
        float saleInPercentage = (productSale / productPrice) * 100;
        mProductImage.setLabelText(new DecimalFormat("#.#").format(saleInPercentage) + getString(R.string.percent_sale_off_label));
        mDiscountPriceTextView.setText(new DecimalFormat().format(productPrice - productSale));
        mPriceTextView.setText("VND" + new DecimalFormat().format(productPrice));
        mPriceTextView.setPaintFlags(mPriceTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }

    private void showCategoryProducts(String category) {
        Intent intent = new Intent(this, CategoryProductsActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, category);
        startActivity(intent);
    }

    private void errorUponLaunch() {
        Toast.makeText(this, R.string.error_message, Toast.LENGTH_SHORT).show();
        finish();
    }
}
