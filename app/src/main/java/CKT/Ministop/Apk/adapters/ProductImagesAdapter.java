package CKT.Ministop.Apk.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import CKT.Ministop.Apk.R;
import CKT.Ministop.Apk.activities.ProductDetailsActivity;
import CKT.Ministop.Apk.model.Product;

public class ProductImagesAdapter extends RecyclerView.Adapter<ProductImagesAdapter.FeaturedProductsViewHolder> {

    private List<Product> mProducts;
    private Context mContext;

    public ProductImagesAdapter(List<Product> mProducts, Context mContext) {
        this.mProducts = mProducts;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public FeaturedProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View featuredProductsView = LayoutInflater.from(mContext).inflate(R.layout.list_item_product_images, parent, false);
        return new FeaturedProductsViewHolder(featuredProductsView);
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedProductsViewHolder holder, int position) {
        Product product = mProducts.get(position);
        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.place_holder)
                .error(R.drawable.error_holder);

        Glide.with(mContext)
                .load(product.getImage())
                .apply(options)
                .into(holder.mProductImage);
/*
        GlideApp.with(mContext)
                .load(product.getImage())
                .placeholder(R.drawable.place_holder)
                .error(R.drawable.error_holder)
                .into(holder.mProductImage);

 */

    }

    @Override
    public int getItemCount() {
        return mProducts == null ? 0 : mProducts.size();
    }

    public void setProducts(List<Product> products) {
        mProducts = products;
        notifyDataSetChanged();
    }

    public class FeaturedProductsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.featuredProductImage)
        ImageView mProductImage;

        public FeaturedProductsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.featuredProductImage)
        public void onFeaturedProductClick() {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                createSceneTransition();
            } else {
                viewProductDetails();
            }
        }

        private void viewProductDetails() {
            Intent intent = new Intent(mContext, ProductDetailsActivity.class);
            intent.putExtra(Intent.EXTRA_TEXT, mProducts.get(getBindingAdapterPosition()).getCode());
            intent.putExtra(Intent.EXTRA_TITLE, mProducts.get(getBindingAdapterPosition()).getCategory());
            mContext.startActivity(intent);
        }

        @SuppressLint("NewApi")
        private void createSceneTransition() {
            Bundle bundle = ActivityOptions.makeSceneTransitionAnimation((Activity) mContext).toBundle();
            Intent intent = new Intent(mContext, ProductDetailsActivity.class);
            intent.putExtra(Intent.EXTRA_TEXT, mProducts.get(getBindingAdapterPosition()).getCode());
            intent.putExtra(Intent.EXTRA_TITLE, mProducts.get(getBindingAdapterPosition()).getCategory());
            mContext.startActivity(intent, bundle);
        }
    }
}
