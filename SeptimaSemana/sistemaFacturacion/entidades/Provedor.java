package entidades;

public class Provedor {
    private String nombre;
    private String rfc;
    private String razonSocial;

    public Provedor(String nombre, String razonSocial, String rfc) {
        this.nombre = nombre;
        this.razonSocial = razonSocial;
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    @Override
    public String toString() {
        return "Provedor {rfc: "+rfc+", nombre: "+nombre+
        ", razonSocial: "+razonSocial+"}";
    }

    
}
