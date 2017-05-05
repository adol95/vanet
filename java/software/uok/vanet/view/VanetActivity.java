package software.uok.vanet.view;

import android.app.Activity;

import software.uok.vanet.VanetApplication;

/**
 * Created by Mr648 on 5/5/2017.
 */
public class VanetActivity extends Activity {
    @Override
    protected void onResume() {
        super.onResume();
        VanetApplication.currentActivity = this;
    }

}
