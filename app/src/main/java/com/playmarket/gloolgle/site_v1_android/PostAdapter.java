package com.playmarket.gloolgle.site_v1_android;


import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.playmarket.gloolgle.site_v1_android.PostsGetSet;
import com.playmarket.gloolgle.site_v1_android.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PostAdapter extends ArrayAdapter<PostsGetSet>{
    private Context context;
    private List<PostsGetSet> postsGetSets;

    public PostAdapter(Context context, List<PostsGetSet> postsGetSets) {
        super(context, R.layout.layout_list_item, postsGetSets);
        this.context = context;
        this.postsGetSets = postsGetSets;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.layout_list_item, parent, false);
        }
        ImageView img = (ImageView)row.findViewById(R.id.image1);
        TextView text = (TextView)row.findViewById(R.id.firstText) ;
        TextView text2 = (TextView)row.findViewById(R.id.secondText) ;

        PostsGetSet item = postsGetSets.get(position);

        String name = item.getName();
        String img1 = item.getImage_1();
        String imgs = item.getImage2() + ' '+ item.getImage3();

        Picasso.get().load(img1).into(img);
        text.setText(name);
        text2.setText(imgs);

        return row;
    }
}
