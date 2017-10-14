package apps4life.servicemanager;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
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

    public void setPathRoute(final Context ctx, final String pathrouth) {
        ImageView post_image = (ImageView) mView.findViewById(R.id.image_view_rowl_letters);
        Glide.with(ctx).load(pathrouth).into(post_image);
        post_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setupDialog(ctx, pathrouth);
            }
        });
    }

    private void setupDialog(Context context, String path) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.dialog_image_full, null);
        builder.setView(view);
        final AlertDialog alertDialog = builder.create();
        alertDialog.setCancelable(true);
        ImageView img_photo = (ImageView)view.findViewById(R.id.img_photo);
        TextView lbl_close = (TextView)view.findViewById(R.id.lbl_close);
        //Glide.with(context).load(R.drawable.ic_alert).into(img_photo);
        Picasso.with(context).load(path).placeholder(R.drawable.ic_alert).into(img_photo);
        lbl_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        alertDialog.show();
    }

}
