package apps4life.servicemanager;

import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.View;
import android.widget.TextView;

/**
 * Created by sserje06 on 02/10/2017.
 */

public class UsuariosHolder extends RecyclerView.ViewHolder {

    private View mView;

    public UsuariosHolder(View itemView) {
        super(itemView);
        mView = itemView;
    }

    public void setCargo(String cargo){

        TextView field = (TextView) mView.findViewById(R.id.lblCargo);
        field.setText(cargo);
    }

    public void setNombres(String nombres){
        TextView field = (TextView) mView.findViewById(R.id.lbl_nombres);
        field.setText(nombres);
    }

    public void setApellidos(String apellidos){
        TextView field = (TextView) mView.findViewById(R.id.lbl_apellidos);
        field.setText(apellidos);
    }

    public  void setCedula(String cedula){
        TextView field = (TextView) mView.findViewById(R.id.lblCedula);
        field.setText(cedula);
    }

    public  void setCiudad(String ciudad){
        TextView field = (TextView) mView.findViewById(R.id.lblCiudad);
        field.setText(ciudad);
    }

    public  void setCorreo(String correo){
        TextView field = (TextView) mView.findViewById(R.id.lblCorreo);
        field.setText(correo);
    }

    public  void setTelefono(String telefono){
        TextView field = (TextView) mView.findViewById(R.id.lblTelefono);
        field.setText(telefono);
    }


}
