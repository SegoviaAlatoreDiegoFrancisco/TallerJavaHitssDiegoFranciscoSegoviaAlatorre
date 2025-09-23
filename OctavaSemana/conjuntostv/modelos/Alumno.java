public class Alumno implements Comparable<Alumno>{
    private Integer id;
    private String nombre;
    private double calificacion;

    public Alumno() {
    }                                                                               

    public Alumno(int id, String nombre, double calificacion) {
        this.calificacion = calificacion;
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCalificacion() {
        return calificacion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Alumno{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", calificacion=").append(calificacion);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Alumno other = (Alumno) obj;
        if (id != other.id)
            return false;
        return id==other.id && nombre.equals(other.nombre);
    }

    @Override
    public int compareTo(Alumno o) {
        //return this.nombre.compareTo(o.nombre);
        return this.id.compareTo(o.id);
    }
    

}   
