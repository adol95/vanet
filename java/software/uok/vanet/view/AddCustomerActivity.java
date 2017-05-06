package software.uok.vanet.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import software.uok.vanet.R;
import software.uok.vanet.VanetApplication;
import software.uok.vanet.database.dao.CustomerDAO;
import software.uok.vanet.model.Customer;

/**
 * Created by micropardaz on 5/4/2017.
 */

public class AddCustomerActivity extends VanetActivity {

    private Button btnAddAdmin;
    private Button btnCancel;
    private TextView txtCode;
    private EditText txtAddName;
    private EditText txtAddFamily;
    private EditText txtAddPhone;
    private EditText txtAddAddress;

    @Override
    protected void onResume() {
        super.onResume();
        VanetApplication.currentActivity = this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);

        btnAddAdmin = (Button) findViewById(R.id.btnAddAdmin);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        txtCode = (TextView) findViewById(R.id.txtCode);
        txtAddName = (EditText) findViewById(R.id.txtAddName);
        txtAddFamily = (EditText) findViewById(R.id.txtAddFamily);
        txtAddPhone = (EditText) findViewById(R.id.txtAddPhone);
        txtAddAddress = (EditText) findViewById(R.id.txtAddAddress);

        txtCode.setText("مشتری شماره :" + VanetApplication.databaseOpenHelper.getLastRowId(CustomerDAO.KEY_ID, CustomerDAO.TABLE_CUSTOMER));
        btnAddAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String _name = txtAddName.getText().toString();
                String _family = txtAddFamily.getText().toString();
                String _phone = txtAddPhone.getText().toString();
                String _address = txtAddAddress.getText().toString();

                if (_name.isEmpty() || _family.isEmpty() ||
                        _phone.isEmpty() || _address.isEmpty()) {
                    Toast.makeText(VanetApplication.context, "اطلاعات کامل وارد نشده است", Toast.LENGTH_SHORT);
                } else {
                    Customer customer = new Customer();
                    Toast.makeText(VanetApplication.context, _family, Toast.LENGTH_SHORT).show();

                    customer.setName(_name);
                    customer.setFamily(_family);
                    customer.setPhone(_phone);
                    customer.setAddress(_address);

                    VanetApplication.databaseOpenHelper.addCustomer(customer);
                    txtCode.setText("مشتری شماره :" + VanetApplication.databaseOpenHelper.getLastRowId(CustomerDAO.KEY_ID, CustomerDAO.TABLE_CUSTOMER));

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
