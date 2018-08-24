package ht.queeny.nbpharma.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ht.queeny.nbpharma.Models.Register;
import ht.queeny.nbpharma.R;

public class RegisterAdapter extends ArrayAdapter<RegisterAdapter> {

        private String UserName; //in database
        private String Phone; //in database
        private String Email; //in database
        Register register = new Register();

        ArrayList<RegisterAdapter> RegisterAdapter;
        Context context;
        int resource;
        public String getUserName() {
            return UserName;
        }
        public String getPhone() {
            return Phone;
        }
        public String getEmail() {
            return Email;
        }

        private static class ViewHolder {
            TextView UserName;
            TextView Phone;
            TextView Email;
            private List<RegisterAdapter> list;
            ArrayList<RegisterAdapter> listUser;
        }

        public RegisterAdapter(Context context, ArrayList<RegisterAdapter> Register) {
            super(context, R.layout.list_item, Register);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            RegisterAdapter.ViewHolder viewHolder;
            final RegisterAdapter registerAdapter = getItem(position);
            if (convertView == null) {
                viewHolder = new RegisterAdapter.ViewHolder();
                LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
                convertView = layoutInflater.inflate(R.layout.list_item, null, true);

                viewHolder.UserName = (TextView) convertView.findViewById(R.id.balance);

               // Velly Verifye code sa stp
                viewHolder.Email = (TextView) convertView.findViewById(R.id.Email);

                //Cache the viewHolder object inside the fresh view
                convertView.setTag(viewHolder);
            } else {
                // View is being recycled, retrieve the viewHolder object from tag
                viewHolder = (RegisterAdapter.ViewHolder) convertView.getTag();
            }

            viewHolder.UserName.setText(register.getUserName());
            viewHolder.Email.setText(register.getEmail());

            //Picasso.with(getContext())
                  //  .load(medicamentAdapter.getImageMedicament())
                  //  .resize(220, 130).into(viewHolder.imageMedicament);

            return convertView;

        }
}

