package software.uok.vanet.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import software.uok.vanet.R;
import software.uok.vanet.VanetApplication;
import software.uok.vanet.model.Clerk;

/**
 * Created by micropardaz on 5/4/2017.
 */
public class EditClerkActivity extends  VanetActivity {

    private Button btnEdit;
    private Button btnCancel;

    private TextView txtCode;

    private EditText txtEditName;
    private EditText txtEditFamily;
    private EditText txtEditUser;
    private EditText txtEditPass;
    private EditText txtEditNationalCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_clerk);

        Bundle extras = this.getIntent().getExtras();
        final Clerk current = (Clerk) extras.get("CURRENT_CLERK");

        btnEdit = (Button) findViewById(R.id.btnAddAdmin);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        txtCode = (TextView) findViewById(R.id.txtCode);
        txtEditName = (EditText) findViewById(R.id.txtEditName);
        txtEditFamily = (EditText) findViewById(R.id.txtEditFamily);
        txtEditUser = (EditText) findViewById(R.id.txtEditUser);
        txtEditPass = (EditText) findViewById(R.id.txtEditPass);
        txtEditNationalCode = (EditText) findViewById(R.id.txtEditNationalCode);

        txtCode.setText(current.getId());
        txtEditName.setText(current.getName());
        txtEditFamily.setText(current.getFamily());
        txtEditUser.setText(current.getUsername());
        txtEditPass.setText(current.getPassword());
        txtEditNationalCode.setText(current.getNationalCode()+"");

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String _name = txtEditName.getText().toString();
                String _family = txtEditFamily.getText().toString();
                String _user = txtEditUser.getText().toString();
                String _pass = txtEditPass.getText().toString();
                String _national = txtEditNationalCode.getText().toString();

                if (_name.isEmpty() || _family.isEmpty() ||
                        _user.isEmpty() || _pass.isEmpty() || _national.isEmpty()) {
                    Toast.makeText(VanetApplication.context, "اطلاعات کامل وارد نشده است", Toast.LENGTH_SHORT);
                } else {
                    Clerk updated = new Clerk();
                    Toast.makeText(VanetApplication.context, _family, Toast.LENGTH_SHORT).show();

                    updated.setName(_name);
                    updated.setFamily(_family);
                    updated.setPhone(_user);
                    updated.setAddress(_pass);
                    updated.setAddress(_national);

                    VanetApplication.databaseOpenHelper.updateClerk(current,updated);

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
