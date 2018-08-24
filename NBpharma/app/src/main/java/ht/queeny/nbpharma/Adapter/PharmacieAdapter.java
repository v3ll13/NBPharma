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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ht.queeny.nbpharma.Models.Pharmacie;
import ht.queeny.nbpharma.R;

public class PharmacieAdapter extends ArrayAdapter<PharmacieAdapter> {

    private String adresse;
    private String email;
    private String horaire;
    private String Images;
    private String Intineraire;
    private Double map_lati;
    private Double map_long;
    private String nom;
    private String Pharmacien_responsable;
    private int status;
    private String  telephone;
    private Date created;
    Pharmacie pharma = new Pharmacie();
    ArrayList<PharmacieAdapter> PharmacieAdapter;
    Context context;
    int resource;


    private static class ViewHolder {
        TextView adresse;
        TextView email;
        TextView horaire;
        TextView Intineraire;
        TextView map_lati;
        TextView map_long;
        TextView nom;
        TextView Pharmacien_responsable;
        TextView status;
        TextView telephone;
        TextView created;
        ImageView Images;


        private List<PharmacieAdapter> list;
        ArrayList<PharmacieAdapter> listPharmacie;
    }

    public PharmacieAdapter(Context context, ArrayList<PharmacieAdapter> pharmacie) {
        super(context, R.layout.list_item, pharmacie);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        PharmacieAdapter.ViewHolder viewHolder;
        final PharmacieAdapter pharmacieAdapter = getItem(position);
        if (convertView == null) {
            viewHolder = new PharmacieAdapter.ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item, null, true);

//            viewHolder.adresse = (TextView) convertView.findViewById(R.id.NomPharmacie);
//            viewHolder.email = (TextView) convertView.findViewById(R.id.NomPharmacie);
//            viewHolder.horaire = (TextView) convertView.findViewById(R.id.NomPharmacie);
//            viewHolder.Intineraire = (TextView) convertView.findViewById(R.id.NomPharmacie);
//            viewHolder.map_lati = (TextView) convertView.findViewById(R.id.NomPharmacie);
//            viewHolder.map_long = (TextView) convertView.findViewById(R.id.NomPharmacie);
//            viewHolder.nom = (TextView) convertView.findViewById(R.id.NomPharmacie);
//            viewHolder.Pharmacien_responsable = (TextView) convertView.findViewById(R.id.NomPharmacie);
//            viewHolder.status = (TextView) convertView.findViewById(R.id.NomPharmacie);
//            viewHolder.telephone = (TextView) convertView.findViewById(R.id.NomPharmacie);
//            viewHolder.created = (TextView) convertView.findViewById(R.id.NomPharmacie);
//            viewHolder.Images = (ImageView) convertView.findViewById(R.id.ImagesPharmacie);

            //Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);
        } else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (PharmacieAdapter.ViewHolder) convertView.getTag();
        }

        viewHolder.nom.setText(pharma.getNom());
        viewHolder.Images.setVisibility(View.GONE);

        Picasso.with(getContext())
                .load(pharma.getImages())
                .resize(220, 130).into(viewHolder.Images);

        return convertView;

    }
}