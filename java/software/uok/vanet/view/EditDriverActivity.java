package software.uok.vanet.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import software.uok.vanet.R;

/**
 * Created by farooq on 5/4/2017.
 */
public class EditDriverActivity extends VanetActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_driver);

        Button btnEditDriver = (Button) findViewById(R.id.btnEditDriver);
        Button btnCancelDriver = (Button) findViewById(R.id.btnCancelDriver);

        EditText txtEditName = (EditText) findViewById(R.id.txtEditName);
        EditText txtEditFamily = (EditText) findViewById(R.id.txtEditFamily);
        EditText txtEditPhone = (EditText) findViewById(R.id.txtEditPhone);
        EditText txtEditAddress = (EditText) findViewById(R.id.txtEditAddress);
        EditText txtEditNationalCode = (EditText) findViewById(R.id.txtEditNationalCode);
        EditText txtEditTypeCar = (EditText) findViewById(R.id.txtEditTypeCar);
    }
}
