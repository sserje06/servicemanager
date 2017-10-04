package apps4life.servicemanager;

/**
 * Created by sserje06 on 03/10/2017.
 */

public class AnunciosItems {

    private String fecha;
    private String congregacion;
    private String asunto;
    private String mensaje;

    public AnunciosItems() {

    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCongregacion() {
        return congregacion;
    }

    public void setCongregacion(String congregacion) {
        this.congregacion = congregacion;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "AnunciosItems{" +
                "fecha='" + fecha + '\'' +
                ", congregacion='" + congregacion + '\'' +
                ", asunto='" + asunto + '\'' +
                ", mensaje='" + mensaje + '\'' +
                '}';
    }
}
