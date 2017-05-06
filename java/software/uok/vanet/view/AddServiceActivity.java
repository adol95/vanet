package software.uok.vanet.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

import software.uok.vanet.R;
import software.uok.vanet.VanetApplication;
import software.uok.vanet.database.DatabaseOpenHelper;

/**
 * Created by micropardaz on 5/5/2017.
 */
public class AddServiceActivity extends VanetActivity {
    private Spinner spnDriverId;
    private Spinner spnCusomerId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_service);

//        spnCusomerId=(Spinner) findViewById(R.id.spnDriverId);
//        spnCusomerId=(Spinner) findViewById(R.id.spnDriverId);
//
//
//        DatabaseOpenHelper db= DatabaseOpenHelper.getInstance(VanetApplication.context);
//
//        List list = db.getAllDriver();
//        //creating adapter for spinner
//        String[] nameList=new String[list.size()];
//
//        for(int i=0;i<list.size();i++){
//            nameList[i]=list.get(i).toString(); //create array of name
//        }
//
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, nameList);
//
//        spnDriverId.setAdapter(dataAdapter);

    }
}
