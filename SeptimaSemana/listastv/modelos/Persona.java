package modelos;

public class Persona /*implements Comparable<Persona>*/{
    private int id;
    private String nombre;
    private Integer edad;
    public Persona(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
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
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    @Override
    public String toString() {
        return "Persona [id=" + id + ", nombre=" + nombre + ", edad=" + edad + "]";
    }
    /* 
    @Override
    public int compareTo(Persona o) {
        //ordenamiento de manera natral (ascendente)
        //   return this.nombre.compareTo(o.nombre);
        
        //ORDENAMIENTO POR ENTERO (EDAD)
        //return Integer.compare(this.edad, o.edad);
        int resultado = Integer.compare(this.edad, o.edad);
        if(resultado ==0){
            resultado = this.edad.compareTo(o.edad);
        }
        return resultado;
    }
    */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((edad == null) ? 0 : edad.hashCode());
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
        Persona other = (Persona) obj;
        if (id != other.id)
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (edad == null) {
            if (other.edad != null)
                return false;
        } else if (!edad.equals(other.edad))
            return false;
        return true;
    }
    
    

    
}
