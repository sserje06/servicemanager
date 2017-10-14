package apps4life.servicemanager;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Letters extends AppCompatActivity {

    private Context context;
    private DatabaseReference dbImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letters);
        initActivity();
    }

    private void initActivity() {
        context = this;
        dbImages = FirebaseDatabase.getInstance().getReference().child("tblPathUploads");
        setupRecycler();
    }

    private void setupRecycler() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvCartas);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        FirebaseRecyclerAdapter mAdapter = new FirebaseRecyclerAdapter<Letters_Model, LettersHolder>(
                Letters_Model.class,R.layout.design_rowl_letters,LettersHolder.class, dbImages
        ){
            @Override
            protected void populateViewHolder (LettersHolder letterholder, Letters_Model lettermodels, int position){
                letterholder.setPathName(lettermodels.getPathname());
                letterholder.setPathRoute(context, lettermodels.getPathroute());
            }
        };
        recyclerView.setAdapter(mAdapter);
    }

}
