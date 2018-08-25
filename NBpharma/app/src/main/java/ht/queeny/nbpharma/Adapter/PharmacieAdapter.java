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

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ht.queeny.nbpharma.Models.Pharmacie;
import ht.queeny.nbpharma.Models.pharmacies;
import ht.queeny.nbpharma.R;

public class PharmacieAdapter extends ArrayAdapter<pharmacies> {

    private Context context;
    private List<pharmacies> pharmacieList;

    public PharmacieAdapter(Context context, List<pharmacies> list)
    {
        super(context, R.layout.pharmacie_row_layout, list);

        this.context = context;
        this.pharmacieList = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(R.layout.pharmacie_row_layout, parent,false);

        TextView address = convertView.findViewById(R.id.address);
        address.setText(pharmacieList.get(position).getAdresse());

        return convertView;
    }
}