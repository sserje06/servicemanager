package apps4life.servicemanager;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by sserje06 on 03/10/2017.
 */

public class AnunciosItemsHolder extends RecyclerView.ViewHolder {

    private View mView;

    public AnunciosItemsHolder(View itemView) {
        super(itemView);
        mView = itemView;
    }

    public void setFecha (String fecha){
        TextView field = (TextView) mView.findViewById(R.id.lblfecha_anuncios);
        field.setText(fecha);
    }

    public void  setCongregacion (String congregacion){
        TextView field = (TextView) mView.findViewById(R.id.lblcongregacion_anuncios);
        field.setText(congregacion);
    }

    public void  setAsunto (String asunto){
        TextView field = (TextView) mView.findViewById(R.id.lblasunto_anuncios);
        field.setText(asunto);
    }

    public void  setMensaje (String mensaje){
        TextView field = (TextView) mView.findViewById(R.id.lblmensaje_anuncios);
        field.setText(mensaje);
    }

}
