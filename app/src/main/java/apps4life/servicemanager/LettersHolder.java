package apps4life.servicemanager;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by sserje06 on 10/10/2017.
 */

public class LettersHolder extends RecyclerView.ViewHolder {

    View mView;

    public LettersHolder(View itemView, View mView) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("www.google.com"));
                Intent browserChooserIntent = Intent.createChooser(browserIntent, "Escoge el navegador");
                v.getContext().startActivity(browserChooserIntent);
            }
        });
    }

    public void setPathName(String pathname) {
        TextView post_title = (TextView) mView.findViewById(R.id.text_view_rowl_letters);
        post_title.setText(pathname);
    }

    public void setPathRoute(Context ctx, String pathrouth) {
        ImageView post_image = (ImageView) mView.findViewById(R.id.image_view_rowl_letters);
        Picasso.with(ctx).load(pathrouth).into(post_image);
    }

}
