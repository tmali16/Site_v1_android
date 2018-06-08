package com.playmarket.gloolgle.site_v1_android;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.playmarket.gloolgle.site_v1_android.home.HomeActivity;

import me.relex.circleindicator.CircleIndicator;
import util.PostsGetSet;

import java.util.ArrayList;
import java.util.List;

import static com.playmarket.gloolgle.site_v1_android.R.color.colorPrimary;

public class PostAdapter extends ArrayAdapter<PostsGetSet>{
    private Context context;
    private List<PostsGetSet> postsGetSets;

    public PostAdapter(Context context, List<PostsGetSet> postsGetSets) {
        super(context, R.layout.layout_list_item, postsGetSets);
        this.context = context;
        this.postsGetSets = postsGetSets;
    }
    @SuppressLint("ResourceAsColor")
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.layout_list_item, parent, false);
        }
//        ImageView img = (ImageView)row.findViewById(R.id.image1);

        ViewPager viewPagerIm = (ViewPager)row.findViewById(R.id.v_flipper);
        final PostsGetSet item = postsGetSets.get(position);

        ArrayList<String> images = new ArrayList<String>(5);
        try {
            if (item.getImage_1().length() != 0) {
//                image = new String[1];
                images.add(item.getImage_1());
            }
            if (item.getImage_2().length() != 0) {
//                image = new String[2];
                images.add(item.getImage_2());
            }
            if (item.getImage_3().length() != 0) {
//                image = new String[3];
                images.add(item.getImage_3());
            }
            if (item.getImage_4().length() != 0) {
//                image = new String[4];
                images.add(item.getImage_4());
            }
            if (item.getImage_5().length() != 0) {
//                image = new String[5];
                images.add(item.getImage_5());
            }
        }catch (Exception e){
            System.out.print("error: "+e.getMessage());
        }

        String[] image = new String[images.size()];
        image = images.toArray(image);
        ImageAdapter viewPager = new ImageAdapter(context, image);
        final CircleIndicator indicator = (CircleIndicator) row.findViewById(R.id.indicator);
        viewPagerIm.setAdapter(viewPager);
        indicator.setViewPager(viewPagerIm);
        viewPager.registerDataSetObserver(indicator.getDataSetObserver());
//-----------------------------------------------------------------------------------

        TextView PostName = (TextView)row.findViewById(R.id.PostName) ;
        TextView PostAge = (TextView)row.findViewById(R.id.PostAge) ;
        TextView TitleCoast = (TextView)row.findViewById(R.id.TitleCoast);
        TextView date = (TextView)row.findViewById(R.id.date_update);

        Button call = (Button)row.findViewById(R.id.Call);
        String coast = "1-Час: " + item.getAppart_1() + " Сом";

//------------------------------------------------------------------------------------
        call.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+item.getPhone()));
                context.startActivity(intent);
            }
        });
        call.setText(item.getPhone());
        PostName.setText(item.getName());
        PostAge.setText(String.format("%s лет", item.getAge()));
        TitleCoast.setText(coast);
        date.setText(item.getUpdate().toString());


        return row;
    }
}
