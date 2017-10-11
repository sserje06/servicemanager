package apps4life.servicemanager;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

/**
 * Created by sserje06 on 10/10/2017.
 */

public class LettersHolder extends RecyclerView.ViewHolder {

    View mView;

    public LettersHolder(View itemView) {
        super(itemView);
        mView = itemView;
    }

    public void setPathName(String pathname) {
        TextView post_title = (TextView) mView.findViewById(R.id.text_view_rowl_letters);
        post_title.setText(pathname);
    }

    public void setPathRoute(Context ctx, String pathrouth) {
        ImageView post_image = (ImageView) mView.findViewById(R.id.image_view_rowl_letters);
        Glide.with(ctx).load(pathrouth).into(post_image);
    }

}
