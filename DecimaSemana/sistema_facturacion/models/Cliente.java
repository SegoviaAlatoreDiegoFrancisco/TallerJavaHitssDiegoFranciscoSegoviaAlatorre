public class Cliente {
    private int id;
    private String nombre;
    private String email;

    public Cliente(String email, int id, String nombre) {
        this.email = email;
        this.id = id;
        this.nombre = nombre;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" nombre=").append(nombre);
        sb.append(", email=").append(email);
        return sb.toString();
    }


}
