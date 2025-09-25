
import java.time.LocalDate;

public class CambioPuesto {
    private LocalDate fecha;
    private String puestoNuevo;
    public CambioPuesto(LocalDate fecha, String puestoNuevo) {
        this.fecha = fecha;
        this.puestoNuevo = puestoNuevo;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public String getPuestoNuevo() {
        return puestoNuevo;
    }
    public void setPuestoNuevo(String puestoNuevo) {
        this.puestoNuevo = puestoNuevo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append("").append(fecha);
        sb.append("-> puestoNuevo=").append(puestoNuevo);
        sb.append("");
        return sb.toString();
    }
    
}
