package software.uok.vanet.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import software.uok.vanet.R;
import software.uok.vanet.VanetApplication;
import software.uok.vanet.model.Customer;

/**
 * Created by micropardaz on 5/4/2017.
 */
public class EditCustomerActivity extends VanetActivity{
    private Button btnEdit;
    private Button btnCancel;
    private TextView txtCode;
    private EditText txtEditName;
    private EditText txtEditFamily;
    private EditText txtEditPhone;
    private EditText txtEditAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_customer);

        Bundle extras = this.getIntent().getExtras();
        final Customer current = (Customer) extras.get("CURRENT_CUSTOMER");

        btnEdit = (Button) findViewById(R.id.btnAddAdmin);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        txtCode = (TextView) findViewById(R.id.txtCode);
        txtEditName = (EditText) findViewById(R.id.txtEditName);
        txtEditFamily = (EditText) findViewById(R.id.txtEditFamily);
        txtEditPhone = (EditText) findViewById(R.id.txtEditPhone);
        txtEditAddress = (EditText) findViewById(R.id.txtEditAddress);

        txtCode.setText(current.getId());
        txtEditName.setText(current.getName());
        txtEditFamily.setText(current.getFamily());
        txtEditPhone.setText(current.getId());
        txtEditAddress.setText(current.getId());

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String _name = txtEditName.getText().toString();
                String _family = txtEditFamily.getText().toString();
                String _phone = txtEditPhone.getText().toString();
                String _address = txtEditAddress.getText().toString();

                if (_name.isEmpty() || _family.isEmpty() ||
                        _phone.isEmpty() || _address.isEmpty()) {
                    Toast.makeText(VanetApplication.context, "اطلاعات کامل وارد نشده است", Toast.LENGTH_SHORT);
                } else {
                    Customer updated = new Customer();
                    Toast.makeText(VanetApplication.context, _family, Toast.LENGTH_SHORT).show();

                    updated.setName(_name);
                    updated.setFamily(_family);
                    updated.setPhone(_phone);
                    updated.setAddress(_address);

                    VanetApplication.databaseOpenHelper.updateCustomer(current,updated);

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
