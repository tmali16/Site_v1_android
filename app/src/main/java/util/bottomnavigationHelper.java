package util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.playmarket.gloolgle.site_v1_android.home.HomeActivity;
import com.playmarket.gloolgle.site_v1_android.profile.ProfileActivity;
import com.playmarket.gloolgle.site_v1_android.R;


public class bottomnavigationHelper {
    private static final String Tag = "BottomNavigationViewHelper";

    @SuppressLint("LongLogTag")
    public static void setupBottomNavView(BottomNavigationViewEx bottomNavigationViewEx) {
        Log.d(Tag, "setupBottomNavView: setting up NavigationView");
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
    }

    public static void enableNavigation(final Context context, BottomNavigationViewEx view) {
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.house:
                        Intent intent1 = new Intent(context, HomeActivity.class); //ACTIVITY_NUM = 0
                         context.startActivity(intent1);
                        break;

                    case R.id.profile:
                        Intent intent2 = new Intent(context, ProfileActivity.class); //ACTIVITY_NUM = 1
                        context.startActivity(intent2);
                        break;
                }
                return false;
            }
        });
    }
}
