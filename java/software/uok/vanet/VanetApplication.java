package software.uok.vanet;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import java.text.SimpleDateFormat;
import java.util.Locale;

import software.uok.vanet.database.DatabaseOpenHelper;
import software.uok.vanet.view.VanetActivity;

/**
 * Created by Mr648 on 5/1/2017.
 */
public class VanetApplication extends Application {

    public static Context context;

    public static DatabaseOpenHelper databaseOpenHelper;

    public static Activity currentActivity;
    public static LayoutInflater inflater;

    private static final SimpleDateFormat formatter = new SimpleDateFormat(
            "yyyy-MM-dd", Locale.ENGLISH);

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        databaseOpenHelper = DatabaseOpenHelper.getInstance(context);
        databaseOpenHelper.getWritableDatabase();
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);


    }

    public static SlidingMenu setupSlidingMenu(VanetActivity activity){
        SlidingMenu menu = new SlidingMenu(activity);
        menu.setMode(SlidingMenu.LEFT);
        menu.setMode(SlidingMenu.SLIDING_WINDOW);
        menu.setShadowWidth(5);
        menu.setFadeDegree(0.0f);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setBehindOffset(100);

        menu.attachToActivity(activity, SlidingMenu.SLIDING_CONTENT);

        View view = VanetApplication.inflater.inflate(R.layout.sliding_menu, null);
//        view.findViewById(R.id.layout_crop).setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(G.context, "Crop Clicked", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        view.findViewById(R.id.img_logo).setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Intent browserIntent = new Intent("android.intent.action.VIEW", Uri.parse("http://uncocoder.com"));
//                startActivity(browserIntent);
//            }
//        });

        menu.setMenu(view);
        return menu;
    }
}
