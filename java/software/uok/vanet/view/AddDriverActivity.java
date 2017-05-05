package software.uok.vanet.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import software.uok.vanet.R;

/**
 * Created by farooq on 5/4/2017.
 */
public class AddDriverActivity extends VanetActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_driver);

        Button btnAddDriver = (Button) findViewById(R.id.btnAddDriver);
        Button btnCancelDriver = (Button) findViewById(R.id.btnCancelDriver);

        EditText txtEditName = (EditText) findViewById(R.id.txtEditName);
        EditText txtEditFamily = (EditText) findViewById(R.id.txtEditFamily);
        EditText txtEditPhone = (EditText) findViewById(R.id.txtEditPhone);
        EditText txtEditAddress = (EditText) findViewById(R.id.txtEditAddress);
        EditText txtEditNationalCode = (EditText) findViewById(R.id.txtEditNationalCode);
        EditText txtEditTypeCar = (EditText) findViewById(R.id.txtEditTypeCar);

        btnAddDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
