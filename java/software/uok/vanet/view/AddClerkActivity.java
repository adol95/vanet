package software.uok.vanet.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import software.uok.vanet.R;
import software.uok.vanet.VanetApplication;
import software.uok.vanet.database.dao.ClerkDAO;
import software.uok.vanet.model.Clerk;
/**
 * Created by micropardaz on 5/4/2017.
 */
public class AddClerkActivity extends VanetActivity{
    private Button btnAddAdmin;
    private Button btnCancel;
    private TextView txtCode;
    private EditText txtAddName;
    private EditText txtAddFamily;
    private EditText txtAddUser;
    private EditText txtAddPass;
    private EditText txtAddNationalCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_clerk);

        btnAddAdmin = (Button) findViewById(R.id.btnAddAdmin);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        txtCode = (TextView) findViewById(R.id.txtCode);
        txtAddName = (EditText) findViewById(R.id.txtAddName);
        txtAddFamily = (EditText) findViewById(R.id.txtAddFamily);
        txtAddUser = (EditText) findViewById(R.id.txtAddUser);
        txtAddPass = (EditText) findViewById(R.id.txtAddPass);
        txtAddNationalCode = (EditText) findViewById(R.id.txtAddNationalCode);

        txtCode.setText("منشی شماره :"+VanetApplication.databaseOpenHelper.getLastRowId(ClerkDAO.KEY_ID, ClerkDAO.TABLE_CLERK));
        btnAddAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String _name = txtAddName.getText().toString();
                String _family = txtAddFamily.getText().toString();
                String _user = txtAddUser.getText().toString();
                String _pass = txtAddPass.getText().toString();
                String _nationalCode = txtAddNationalCode.getText().toString();

                if (_name.isEmpty() || _family.isEmpty() ||
                        _user.isEmpty() || _pass.isEmpty() || _nationalCode.isEmpty()) {
                    Toast.makeText(VanetApplication.context, "اطلاعات کامل وارد نشده است", Toast.LENGTH_SHORT);
                } else {
                    Clerk ad = new Clerk();
                    Toast.makeText(VanetApplication.context, _family, Toast.LENGTH_SHORT).show();

                    ad.setName(_name);
                    ad.setFamily(_family);
                    ad.setUsername(_user);
                    ad.setPassword(_pass);
                    ad.setNationalCode(Long.parseLong(_nationalCode));

                    VanetApplication.databaseOpenHelper.addClerk(ad);
                    txtCode.setText("منشی شماره :"+VanetApplication.databaseOpenHelper.getLastRowId(ClerkDAO.KEY_ID , ClerkDAO.TABLE_CLERK));

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
