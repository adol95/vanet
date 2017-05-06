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
public class EditAdminActivity extends Activity{

    private Button btnEdit;
    private Button btnCancel;

    private TextView txtCode;

    private EditText txtEditName;
    private EditText txtEditFamily;
    private EditText txtEditUser;
    private EditText txtEditPass;
    private EditText txtEditNationalCode;
    private EditText txtEditPhone;
    private EditText txtEditAddress;

    @Override
    protected void onResume() {
        super.onResume();
        VanetApplication.currentActivity=this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_admin);

        Bundle extras = this.getIntent().getExtras();
        final Admin current = (Admin) extras.get("CURRENT_ADMIN");

        btnEdit = (Button) findViewById(R.id.btnAddAdmin);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        txtEditName = (EditText) findViewById(R.id.txtEditName);
        txtEditFamily = (EditText) findViewById(R.id.txtEditFamily);
        txtEditUser = (EditText) findViewById(R.id.txtEditUser);
        txtEditPass = (EditText) findViewById(R.id.txtEditPass);
        txtEditNationalCode = (EditText) findViewById(R.id.txtEditNationalCode);
        txtEditPhone = (EditText) findViewById(R.id.txtEditPhone);
        txtEditAddress = (EditText) findViewById(R.id.txtEditAddress);

        txtEditName.setText(current.getName());
        txtEditFamily.setText(current.getFamily());
        txtEditUser.setText(current.getUsername());
        txtEditPass.setText(current.getPassword());
        txtEditNationalCode.setText(current.getNationalCode()+"");
        txtEditPhone.setText(current.getPhone());
        txtEditAddress.setText(current.getAddress());

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String _name = txtEditName.getText().toString();
                String _family = txtEditFamily.getText().toString();
                String _user = txtEditUser.getText().toString();
                String _pass = txtEditPass.getText().toString();
                String _nationalCode = txtEditNationalCode.getText().toString();
                String _phone = txtEditPhone.getText().toString();
                String _address = txtEditAddress.getText().toString();

                if (_name.isEmpty() || _family.isEmpty() ||
                        _user.isEmpty() || _pass.isEmpty() ||
                        _nationalCode.isEmpty() || _phone.isEmpty() || _address.isEmpty()) {
                    Toast.makeText(VanetApplication.context, "اطلاعات کامل وارد نشده است", Toast.LENGTH_SHORT);
                } else {
                    Admin updated = new Admin();

                    updated.setName(_name);
                    updated.setFamily(_family);
                    updated.setUsername(_user);
                    updated.setPassword(_pass);
                    updated.setNationalCode(Long.parseLong(_nationalCode));
                    updated.setPhone(_phone);
                    updated.setAddress(_address);

                    VanetApplication.databaseOpenHelper.updateAdmin(current,updated);

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
