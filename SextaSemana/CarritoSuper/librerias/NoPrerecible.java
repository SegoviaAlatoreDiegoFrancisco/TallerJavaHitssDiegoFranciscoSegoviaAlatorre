package librerias;
public class NoPrerecible extends Producto{
    private int calorias;
    private int contenido;

    public NoPrerecible(int calorias, int contenido, String nombre, double precio) {
        super(nombre, precio);
        this.calorias = calorias;
        this.contenido = contenido;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public int getContenido() {
        return contenido;
    }

    public void setContenido(int contenido) {
        this.contenido = contenido;
    }


}
