public class Empleado {
    private int id;
    private String nombre;
    private String pusto;

    public Empleado(int id, String nombre, String pusto) {
        this.id = id;
        this.nombre = nombre;
        this.pusto = pusto;
    }

    public Empleado() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPusto() {
        return pusto;
    }

    public void setPusto(String pusto) {
        this.pusto = pusto;
    }


}
