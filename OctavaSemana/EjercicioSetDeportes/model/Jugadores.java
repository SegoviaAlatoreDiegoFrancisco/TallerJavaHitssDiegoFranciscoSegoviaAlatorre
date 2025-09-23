package model;

import java.util.Objects;

public class Jugadores implements Comparable<Jugadores>{
    private Integer id;
    private String nombre;

    public Jugadores( int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.nombre);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jugadores other = (Jugadores) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Jugadores{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(Jugadores o) {
        if(o==null){
            return 1;
        }
        int byName= this.nombre == null ?(o.nombre==null? 0:1):(o.nombre==null?1:this.nombre.compareToIgnoreCase(o.nombre));
        if (byName!=0){
            return byName;
        }
        return this.id.compareTo(o.id);
    }
    

}
