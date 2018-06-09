package com.playmarket.gloolgle.site_v1_android;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

import util.PostsGetSet;

public class ImageAdapter extends PagerAdapter {
    private Context context;
    private List<PostsGetSet> postsGetSets;
    private String[] imageUrls;

    ImageAdapter(Context context, String[] imageUrls){
        this.context = context;
        this.imageUrls = imageUrls;
    }

    @Override
    public int getCount() {
        return imageUrls.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        final ImageView imageView = new ImageView(context);
        Picasso.get()
                .load(imageUrls[position])
                .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
//                .networkPolicy(NetworkPolicy.NO_CACHE)
                .placeholder(R.drawable.ic_launcher_background)
                .fetch(new Callback() {
                    @Override
                    public void onSuccess() {
                        Picasso
                                .get()
                                .load(imageUrls[position])
                                .into(imageView);
                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });
//                .into(imageView);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
