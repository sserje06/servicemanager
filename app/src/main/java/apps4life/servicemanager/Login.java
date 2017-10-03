package apps4life.servicemanager;

import android.annotation.TargetApi;
import android.support.v4.text.TextDirectionHeuristicCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {

    private static final String TAGLOG = "firebase-db";

    private TextView lbl_nombres;
    private TextView lbl_apellidos;

    private DatabaseReference dbUser;
    private ValueEventListener eventListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        lbl_nombres = (TextView)findViewById(R.id.lbl_nombres);
        lbl_apellidos = (TextView)findViewById(R.id.lbl_apellidos);

        dbUser = FirebaseDatabase.getInstance().getReference()
                .child("user");

        eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
              lbl_nombres.setText(dataSnapshot.child("Name").getValue().toString());
              lbl_apellidos.setText(dataSnapshot.child("Lastname").getValue().toString());

                Log.e(TAGLOG, "onDataChange:" + dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(TAGLOG, "Error!", databaseError.toException());
            }
        };
        dbUser.addValueEventListener(eventListener);
    }
}
