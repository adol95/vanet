package software.uok.vanet.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import software.uok.vanet.R;
import software.uok.vanet.VanetApplication;
import software.uok.vanet.model.Customer;

/**
 * Created by micropardaz on 5/4/2017.
 */

public class AddCustomerActivity extends VanetActivity {

    private Button btnAdd;
    private Button btnCancel;
    private EditText txtAddCode;
    private EditText txtAddName;
    private EditText txtAddFamily;
    private EditText txtAddPhone;
    private EditText txtAddAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        txtAddCode = (EditText) findViewById(R.id.txtAddCode);
        txtAddName = (EditText) findViewById(R.id.txtAddName);
        txtAddFamily = (EditText) findViewById(R.id.txtAddFamily);
        txtAddPhone = (EditText) findViewById(R.id.txtAddPhone);
        txtAddAddress = (EditText) findViewById(R.id.txtAddAddress);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _code = txtAddCode.getText().toString();
                String _name = txtAddName.getText().toString();
                String _family = txtAddFamily.getText().toString();
                String _phone = txtAddPhone.getText().toString();
                String _address = txtAddAddress.getText().toString();

                if (_code.isEmpty() || _name.isEmpty() || _family.isEmpty() ||
                        _phone.isEmpty() || _address.isEmpty()) {
                    Toast.makeText(VanetApplication.context, "اطلاعات کامل وارد نشده است", Toast.LENGTH_SHORT);
                } else {
                    Customer cu = new Customer();

                    cu.setId(Integer.parseInt(_code));
                    cu.setName(_name);
                    cu.setName(_family);
                    cu.setName(_phone);
                    cu.setName(_address);

//                    VanetApplication.databaseOpenHelper.addCustomer(cu);

                }

            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VanetApplication.currentActivity.finish();
            }
        });
    }
}
