package software.uok.vanet.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import software.uok.vanet.R;
import software.uok.vanet.VanetApplication;
import software.uok.vanet.model.Admin;
import software.uok.vanet.model.Clerk;

/**
 * Created by micropardaz on 5/4/2017.
 */
public class AddAdminActivity extends VanetActivity{
    private Button btnAddAdmin;
    private Button btnCancel;


    private EditText txtAddName;
    private EditText txtAddFamily;
    private EditText txtAddUser;
    private EditText txtAddPass;
    private EditText txtAddNationalCode;
    private EditText txtAddPhone;
    private EditText txtAddAddress;

    @Override
    protected void onResume() {
        super.onResume();
        VanetApplication.currentActivity=this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_admin);

        btnAddAdmin = (Button) findViewById(R.id.btnAddAdmin);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        txtAddName = (EditText) findViewById(R.id.txtAddName);
        txtAddFamily = (EditText) findViewById(R.id.txtAddFamily);
        txtAddUser = (EditText) findViewById(R.id.txtAddUser);
        txtAddPass = (EditText) findViewById(R.id.txtAddPass);
        txtAddNationalCode = (EditText) findViewById(R.id.txtAddNationalCode);
        txtAddPhone = (EditText) findViewById(R.id.txtAddPhone);
        txtAddAddress = (EditText) findViewById(R.id.txtAddAddress);

        btnAddAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String _name = txtAddName.getText().toString();
                String _family = txtAddFamily.getText().toString();
                String _user = txtAddUser.getText().toString();
                String _pass = txtAddPass.getText().toString();
                String _nationalCode = txtAddNationalCode.getText().toString();
                String _phone = txtAddPhone.getText().toString();
                String _address = txtAddAddress.getText().toString();

                if (_name.isEmpty() || _family.isEmpty() ||
                        _user.isEmpty() || _pass.isEmpty() ||
                        _nationalCode.isEmpty() || _phone.isEmpty() || _address.isEmpty()) {
                    Toast.makeText(VanetApplication.context, "اطلاعات کامل وارد نشده است", Toast.LENGTH_SHORT);
                } else {
                    Admin ad = new Admin();

                    ad.setName(_name);
                    ad.setFamily(_family);
                    ad.setUsername(_user);
                    ad.setPassword(_pass);
                    ad.setNationalCode(Long.parseLong(_nationalCode));
                    ad.setPhone(_phone);
                    ad.setAddress(_address);

                    VanetApplication.databaseOpenHelper.addAdmin(ad);

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
