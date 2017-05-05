package software.uok.vanet.view;

import android.os.Bundle;
import android.view.View;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import software.uok.vanet.R;
import software.uok.vanet.VanetApplication;

/**
 * Created by Mr648 on 5/1/2017.
 */
public class MainActivity  extends VanetActivity{

    @Override
    public void onCreate(Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }
}
