package apps4life.servicemanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AnunciosCongregaciones extends AppCompatActivity {

    FirebaseRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anuncios_congregaciones);

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
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAdapter.cleanup();
    }
}
