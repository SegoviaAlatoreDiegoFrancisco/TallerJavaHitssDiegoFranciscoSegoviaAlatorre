public class Persona {
    private String nombre;
    private String dni;
    private String numeroFiscal;
    private String direccion;

    public Persona(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public Persona(String direccion, String dni, String nombre, String numeroFiscal) {
        this.direccion = direccion;
        this.dni = dni;
        this.nombre = nombre;
        this.numeroFiscal = numeroFiscal;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getNumeroFiscal() {
        return numeroFiscal;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", DNI: " + dni;
    }
}

