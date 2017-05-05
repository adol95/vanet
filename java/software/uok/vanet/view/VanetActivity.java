package software.uok.vanet.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import software.uok.vanet.R;
import software.uok.vanet.VanetApplication;

/**
 * Created by Mr648 on 5/5/2017.
 */
public class VanetActivity extends Activity {
    private SlidingMenu menu;

    private DialogInterface.OnClickListener onBackPressedDialogPositiveButtonClickListener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            VanetApplication.currentActivity.finish();
        }
    };

    private DialogInterface.OnClickListener onBackPressedDialogNegativeButtonClickListener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            dialog.cancel();
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        VanetApplication.currentActivity = this;
    }

    @Override
    protected void onStart() {
        super.onStart();
        menu = VanetApplication.setupSlidingMenu(this);
    }

    @Override
    public void onBackPressed() {
        final Activity m = this;
        if (menu != null && menu.isMenuShowing()) {
            menu.toggle(true);
        } else {
            showDialog(getResources().getString(R.string.dialog_exit_message)
                    , getResources().getString(R.string.dialog_yes)
                    , getResources().getString(R.string.dialog_no)
                    , onBackPressedDialogPositiveButtonClickListener
                    , onBackPressedDialogNegativeButtonClickListener
            );
        }
    }

    private void showDialog(String message, String positiveButtonText, String negativeButtonText,
                            DialogInterface.OnClickListener positiveButtonClickListener,
                            DialogInterface.OnClickListener negativeButtonClickListener) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton(positiveButtonText, positiveButtonClickListener)
                .setNegativeButton(negativeButtonText, negativeButtonClickListener);
        final AlertDialog alert = builder.create();
        alert.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                alert.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(Color.WHITE);
                alert.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.WHITE);
                alert.getButton(AlertDialog.BUTTON_NEGATIVE).setBackgroundColor(Color.parseColor("#3949AB"));
                alert.getButton(AlertDialog.BUTTON_POSITIVE).setBackgroundColor(Color.parseColor("#3949AB"));
            }
        });
        alert.show();
    }


}
