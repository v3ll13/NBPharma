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
import android.widget.RatingBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import ht.queeny.nbpharma.R;

/**
 * Created by root on 8/21/18.
 */

public class MedicamentAdapter extends ArrayAdapter<MedicamentAdapter> {

    ArrayList<MedicamentAdapter> medicamentAdapters;
    Context context;
    int resource;

    private static class ViewHolder {
        TextView nomMedicament;
        TextView dateExpi;
        ImageView imageMedicament;
        private List<MedicamentAdapter> list;
        ArrayList<MedicamentAdapter> listMedicament;
    }

    public MedicamentAdapter(Context context, ArrayList<MedicamentAdapter> medoc) {
        super(context, R.layout.list_item, medoc);
    }


//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        ViewHolder viewHolder;
//        final MedicamentAdapter medicamentAdapter= getItem(position);
//        if (convertView == null){
//            viewHolder = new ViewHolder();
//            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
//            convertView = layoutInflater.inflate(R.layout.list_item, null, true);
//
//            viewHolder.nomMedicament = (TextView) convertView.findViewById(R.id.nomMedicament);
//            viewHolder.dateExpi = (TextView) convertView.findViewById(R.id.dateExpi);
//            viewHolder.imageMedicament = (ImageView) convertView.findViewById(R.id.imgMedoc);
//
//            //Cache the viewHolder object inside the fresh view
//            convertView.setTag(viewHolder);
//        }else {
//            // View is being recycled, retrieve the viewHolder object from tag
//            viewHolder = (ViewHolder) convertView.getTag();
//        }
//
//        //viewHolder.nomMedicament.setText(medicamentAdapter.get());
//
//    }
}