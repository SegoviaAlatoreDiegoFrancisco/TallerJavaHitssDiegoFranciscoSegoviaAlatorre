package model;

public class Cliente {
    private int id;
    private String nombre;
    private String apellido;

    public Cliente(String apellido, int id, String nombre) {
        this.apellido = apellido;
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + "]";
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

}
