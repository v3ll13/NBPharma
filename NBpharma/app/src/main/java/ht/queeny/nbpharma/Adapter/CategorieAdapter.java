package ht.queeny.nbpharma.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ht.queeny.nbpharma.R;

/**
 * Created by root on 8/21/18.
 */

public class CategorieAdapter extends ArrayAdapter<CategorieAdapter> {

    private String description; //in database
    private String objectId; //in database

    ArrayList<CategorieAdapter> CategorieAdapter;
    Context context;
    int resource;

    public String getDescription() {
        return description;
    }

    public String getObjectId() {
        return objectId;
    }

    private static class ViewHolder {
        TextView description;
        TextView objectId;
        private List<CategorieAdapter> list;
        ArrayList<CategorieAdapter> listCategories;
    }

    public CategorieAdapter(Context context, ArrayList<CategorieAdapter> categorie) {
        super(context, R.layout.list_item, categorie);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        final CategorieAdapter CategorieAdapter = getItem(position);
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item, null, true);

           // viewHolder.description = (TextView) convertView.findViewById(R.id.description);
           // viewHolder.objectId = (TextView) convertView.findViewById(R.id.objectId);


            //Cache the viewHolder object inside the fresh view
            convertView.setTag(viewHolder);
        } else {
            // View is being recycled, retrieve the viewHolder object from tag
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.description.setText(CategorieAdapter.getDescription());
        viewHolder.objectId.setText(CategorieAdapter.getObjectId());

        // Picasso.with(getContext())
        //   .load(CategorieAdapter.getImageMedicament())
        //  .resize(220, 130).into(viewHolder.imageMedicament);

        return convertView;

    }
}
