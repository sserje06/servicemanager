package apps4life.servicemanager;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class prueba extends AppCompatActivity {

    private RecyclerView lettersView;
    FirebaseDatabase database;
    DatabaseReference imagesLettersdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba);

        //Carga las imagenes de Cartas de la organización
        lettersView = (RecyclerView)findViewById(R.id.rvCartas);
        lettersView.setHasFixedSize(true);
        lettersView.setLayoutManager(new LinearLayoutManager(this));

        database = FirebaseDatabase.getInstance();
        imagesLettersdb = database.getReference().child("tblPathUploads");


    }
    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Letters_Model, prueba.Letter_Holder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Letters_Model, prueba.Letter_Holder>(
                        Letters_Model.class,
                        R.layout.design_rowl_letters,
                        prueba.Letter_Holder.class,
                        imagesLettersdb) {

                    @Override
                    protected void populateViewHolder(prueba.Letter_Holder viewHolder, Letters_Model model, int position) {
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
        public void setPathName(String pathname){
            TextView post_title = (TextView)mView.findViewById(R.id.text_view_rowl_letters);
            post_title.setText(pathname);
        }
        public void setPathRoute(Context ctx, String pathrouth){
            ImageView post_image = (ImageView)mView.findViewById(R.id.image_view_rowl_letters);
            Picasso.with(ctx).load(pathrouth).into(post_image);
        }
    }

}
