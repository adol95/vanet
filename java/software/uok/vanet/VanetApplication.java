package software.uok.vanet;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import java.text.SimpleDateFormat;
import java.util.Locale;

import software.uok.vanet.database.DatabaseOpenHelper;

/**
 * Created by Mr648 on 5/1/2017.
 */
public class VanetApplication extends Application {

    public static Context context;

    public static DatabaseOpenHelper databaseOpenHelper;

    public static Activity currentActivity;

    private static final SimpleDateFormat formatter = new SimpleDateFormat(
            "yyyy-MM-dd", Locale.ENGLISH);

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        databaseOpenHelper = DatabaseOpenHelper.getInstance(context);
        databaseOpenHelper.getWritableDatabase();

    }
}
