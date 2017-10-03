package apps4life.servicemanager;

/**
 * Created by sserje06 on 02/10/2017.
 */

public class Usuarios {

    private String cargo;
    private String nombres;
    private String apellidos;
    private String cedula;
    private String ciudad;
    private String correo;
    private String telefono;

    public Usuarios(){

    }

    public Usuarios (String cargo, String nombres, String apellidos,
                     String cedula, String ciudad, String correo, String telefono)
    {
        this.cargo = cargo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.ciudad = ciudad;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getCargo(){
        return cargo;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getCedula() {
        return cedula;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString(){
        return "DatosUsuarioController{" +
                "cargo='" + nombres +'\'' +
                ", nombres='" + apellidos +'\'' +
                ", apellidos=" + apellidos +'\'' +
                ", cedula=" + cedula +'\'' +
                ", ciudad=" + ciudad +'\'' +
                ", correo=" + correo +'\'' +
                ", telefono=" + telefono +
                '}';
    }

}
