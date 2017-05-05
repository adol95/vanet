package software.uok.vanet.view.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import software.uok.vanet.R;
import software.uok.vanet.VanetApplication;
import software.uok.vanet.model.Customer;

/**
 * Created by Mr648 on 5/5/2017.
 */
public class AdapterCustomer extends ArrayAdapter<Customer> {

    public AdapterCustomer(ArrayList<Customer> array) {
        super(VanetApplication.context, R.layout.adapter_customer, array);
    }


    private static class ViewHolder {

        public ViewGroup layoutRoot;
        public TextView  txtTitle;
        public TextView  txtDescription;
        public CheckBox  chkDone;
        public ImageView imgDelete;


        public ViewHolder(View view) {
//            txtTitle = (TextView) view.findViewById(R.id.txtTitle);
//            txtDescription = (TextView) view.findViewById(R.id.txtDescription);
//            chkDone = (CheckBox) view.findViewById(R.id.chkDone);
//            layoutRoot = (ViewGroup) view.findViewById(R.id.layoutRoot);
//            imgDelete = (ImageView) view.findViewById(R.id.imgDelete);
        }


        public void fill(final ArrayAdapter<Customer> adapter, final Customer item, final int position) {
//            txtTitle.setText(item.title);
//            txtDescription.setText(item.description);
//            chkDone.setChecked(item.done);

//            imgDelete.setOnClickListener(new OnClickListener() {
//
//                @Override
//                public void onClick(View arg0) {
//                    adapter.remove(item);
//                }
//            });
//            layoutRoot.setOnClickListener(new OnClickListener() {
//
//                @Override
//                public void onClick(View arg0) {
//                    Intent intent = new Intent(G.currentActivity, ActivityEdit.class);
//                    intent.putExtra("POSITION", position);
//                    G.currentActivity.startActivity(intent);
//                }
//            });
//            chkDone.setOnClickListener(new OnClickListener() {
//
//                @Override
//                public void onClick(View view) {
//                    CheckBox checkBox = (CheckBox) view;
//                    item.done = checkBox.isChecked();
//
//                    if (item.done) {
//                        txtTitle.setTextColor(Color.RED);
//                    } else {
//                        txtTitle.setTextColor(Color.WHITE);
//                    }
//                }
//            });
//
//            if (item.done) {
//                txtTitle.setTextColor(Color.RED);
//            } else {
//                txtTitle.setTextColor(Color.WHITE);
//            }
        }
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        Customer item = getItem(position);
        if (convertView == null) {
            convertView = VanetApplication.inflater.inflate(R.layout.adapter_customer, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.fill(this, item, position);
        return convertView;
    }
}
