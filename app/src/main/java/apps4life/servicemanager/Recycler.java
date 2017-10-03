package apps4life.servicemanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Recycler extends AppCompatActivity {

    private static final String TAGLOG = "firebase-db";

    private RecyclerView listaUsuarios;

    FirebaseRecyclerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        DatabaseReference dbUser =
                FirebaseDatabase.getInstance().getReference()
                    .child("tblUser");

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.listaUsuarios);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        mAdapter =
                new FirebaseRecyclerAdapter<Usuarios, UsuariosHolder> (
                    Usuarios.class, R.layout.usuarios_lista, UsuariosHolder.class, dbUser
                ){

                    @Override
                    protected void populateViewHolder(UsuariosHolder viewUsuarioHolder, Usuarios viewUsuarios, int position) {
                    viewUsuarioHolder.setCargo(viewUsuarios.getCargo());
                    viewUsuarioHolder.setNombres(viewUsuarios.getNombres());
                    viewUsuarioHolder.setApellidos(viewUsuarios.getApellidos());
                    viewUsuarioHolder.setCedula(viewUsuarios.getCedula());
                    viewUsuarioHolder.setCiudad(viewUsuarios.getCiudad());
                    viewUsuarioHolder.setCorreo(viewUsuarios.getCorreo());
                    viewUsuarioHolder.setCorreo(viewUsuarios.getTelefono());
                    }
                };
                recyclerView.setAdapter(mAdapter);

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        mAdapter.cleanup();
    }
}
