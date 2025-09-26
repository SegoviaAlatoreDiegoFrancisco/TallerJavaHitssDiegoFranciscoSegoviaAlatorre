

public class Estudiante {
    private String id;
    private String nombre;

    public Estudiante(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if(!(obj instanceof Estudiante)){
            return false;
        }
        Estudiante obj_estudiante = (Estudiante) obj;
        return id.equals(obj_estudiante.id);
    }

    @Override
    public String toString() {
        return "Estudiante [id=" + id + ", nombre=" + nombre + "]";
    }
    


}
