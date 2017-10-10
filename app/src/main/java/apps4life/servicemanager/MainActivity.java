package apps4life.servicemanager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import static apps4life.servicemanager.R.layout.content_main;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FirebaseRecyclerAdapter mAdapter;
    private RecyclerView lettersView;
    FirebaseDatabase database;
    DatabaseReference imagesLettersdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DatabaseReference dbAnuncios =
                FirebaseDatabase.getInstance().getReference().child("tblAnunciosCongregaciones");

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvAnuncios);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter =
                new FirebaseRecyclerAdapter<AnunciosItems, AnunciosItemsHolder> (
                        AnunciosItems.class, R.layout.items_anuncios_congregaciones, AnunciosItemsHolder.class, dbAnuncios)
                {
                    @Override
                    protected void populateViewHolder(AnunciosItemsHolder anunciosItemsHolder, AnunciosItems anunciosItems, int position) {

                        anunciosItemsHolder.setFecha("Fecha: "+anunciosItems.getFecha());
                        anunciosItemsHolder.setCongregacion("Congregacion: "+anunciosItems.getCongregacion());
                        anunciosItemsHolder.setAsunto("Asunto: "+anunciosItems.getAsunto());
                        anunciosItemsHolder.setMensaje("Mensaje: "+anunciosItems.getMensaje());
                    }
                };
        recyclerView.setAdapter(mAdapter);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Carga las imagenes de Cartas de la organización
        lettersView = (RecyclerView)findViewById(R.id.rvCartas);
        lettersView.setHasFixedSize(true);
        lettersView.setLayoutManager(new LinearLayoutManager(this));

        database = FirebaseDatabase.getInstance();
        imagesLettersdb = database.getReference("tblPathUploads");
    }

    @Override
    protected void onStart() {
        super.onStart();
 
        FirebaseRecyclerAdapter<Letters_Model, Letter_Holder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Letters_Model, Letter_Holder>(Letters_Model.class,
                        R.layout.design_rowl_letters,
                        Letter_Holder.class,
                        imagesLettersdb) {

                    @Override
                    protected void populateViewHolder(Letter_Holder viewHolder, Letters_Model model, int position) {
                    viewHolder.setPathName(model.getPathname());
                    viewHolder.setPathRoute(getApplicationContext(), model.getPathroute());
                    }
                };
                lettersView.setAdapter(firebaseRecyclerAdapter);
    }

    //ViewHolder para las imagenes de Cartas de la Organización
    public static class Letter_Holder extends RecyclerView.ViewHolder{
        View mView;

        public Letter_Holder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("www.google.com"));
                    Intent browserChooserIntent = Intent.createChooser(browserIntent,"Escoge el navegador");
                    v.getContext().startActivity(browserChooserIntent);
                }
            });
        }
            public void setPathName(String title){
                TextView post_title = (TextView)mView.findViewById(R.id.text_view_rowl_letters);
                post_title.setText(title);
            }
            public void setPathRoute(Context ctx, String image){
                ImageView post_image = (ImageView)mView.findViewById(R.id.image_view_rowl_letters);
                Picasso.with(ctx).load(image).into(post_image);
            }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAdapter.cleanup();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_register_service) {

        } else if (id == R.id.nav_maps) {

        } else if (id == R.id.nav_assignments) {

        } else if (id == R.id.nav_history_notice) {

        } else if (id == R.id.nav_login) {

            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
