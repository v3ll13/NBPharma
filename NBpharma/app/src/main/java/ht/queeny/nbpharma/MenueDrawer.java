package ht.queeny.nbpharma;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.Place;

import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


import com.backendless.Backendless;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import ht.queeny.nbpharma.Adapter.CustomExpendableListAdapter;
import ht.queeny.nbpharma.Fragments.FragmentContent;
import ht.queeny.nbpharma.Fragments.MedicamentContent;
import ht.queeny.nbpharma.Fragments.PharmacieContent;
import ht.queeny.nbpharma.Helper.FragmentNavigationManage;
import ht.queeny.nbpharma.Interface.NavigationManage;
import ht.queeny.nbpharma.Settings.BackendlessSettings;

public class MenueDrawer extends AppCompatActivity  {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private String mActivityTitle;
    private String[] items;

    //googlemap
    private GoogleMap mMap;

    private ExpandableListView expandableListView;
    private ExpandableListAdapter adapter;
    private List<String> listTitle;
    private Map<String ,List<String>> listChild;
    private NavigationManage navigationManage;

    /*private SearchView searchView = null;
    private SearchView.OnQueryTextListener queryTextListener;*/


    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menue_drawer);





        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();
        expandableListView =(ExpandableListView)findViewById(R.id.nav_list);
        navigationManage = FragmentNavigationManage.getmInstance(this);
        String email = getIntent().getStringExtra("email");
        String namee = getIntent().getStringExtra("name");

        initItems();
        View listHeaderView = getLayoutInflater().inflate(R.layout.nav_header, null, false);
        TextView name = listHeaderView.findViewById(R.id.balance);
        TextView emaill = listHeaderView.findViewById(R.id.Email);
        name.setText(namee);
        emaill.setText(email);



        expandableListView.addHeaderView(listHeaderView);
        
        genData();
        addDrawer();
        SetUpDrawer();

        if(savedInstanceState == null)
            selectFirstItemAsDefault();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("NBPharma");


        
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    private void selectFirstItemAsDefault() {
        if (navigationManage != null){

            String firstitem = listTitle.get(0);
            navigationManage.showFragment(firstitem);
            getSupportActionBar().setTitle(firstitem);
        }
    }

    private void SetUpDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close ){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("NBPharma");
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu();
            }
        };

            mDrawerToggle.setDrawerIndicatorEnabled(true);
            mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    private void addDrawer() {
        adapter = new CustomExpendableListAdapter(this, listTitle, listChild);
        expandableListView.setAdapter(adapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                getSupportActionBar().setTitle(listTitle.get(groupPosition).toString());// Set title for toolbar when open menu
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                getSupportActionBar().setTitle("NBPharma");

            }

        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long l) {
                // change fragment when click on item

                String selectedItem = ((List)(listChild.get(listTitle.get(groupPosition)))).get(childPosition).toString();
                getSupportActionBar().setTitle(selectedItem);



                if(selectedItem  == "Liste Medicament"){
                    //navigationManage.showFragment(selectedItem);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("medicamentContent", 1);

                    MedicamentContent medicamentContent = new MedicamentContent();
                    medicamentContent.setArguments(bundle);
                    //
                    onFragmentTransaction(medicamentContent);

                }else if (selectedItem  == "Liste Pharmacie"){
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("pharmacieContent", 2);

                    PharmacieContent pharmacieContent = new PharmacieContent();
                    pharmacieContent.setArguments(bundle);

                    onFragmentTransaction(pharmacieContent);
                }
                else{
                    //throw new IllegalArgumentException("Not a supported Fragment");
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                }

                mDrawerLayout.closeDrawer(GravityCompat.START);


                    return false;
            }
        });
    }

    private void genData() {
        List<String> title = Arrays.asList("Medicament", "Pharmacie", "Conseil", "A propos");
        List<String> childitem = Arrays.asList("Liste Medicament","Liste Pharmacie","Location Pharmacie", "Prix Medicament");

        listChild  = new TreeMap<>();
        listChild  = new TreeMap<>();
        listChild.put(title.get(0), Arrays.asList("Liste Medicament"));
        listChild.put(title.get(1), Arrays.asList("Liste Pharmacie"));
        listChild.put(title.get(2), Arrays.asList("Location Pharmacie"));
        listChild.put(title.get(3), Arrays.asList("Prix Medicament"));

        listTitle = new ArrayList<>(listChild.keySet());
    }

    public void onFragmentTransaction(Fragment fragment){
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

    private void initItems() {
        items = new String[]{"Medicament","Pharmacie", "Conseil", "A Propos"};
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenue, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id  = item.getItemId();

        if(mDrawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }


}
