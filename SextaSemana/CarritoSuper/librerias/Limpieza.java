package librerias;
public class Limpieza extends Producto{
    private String componenetes;
    private double litros;

    public Limpieza(String componenetes, double litros, String nombre, double precio) {
        super(nombre, precio);
        this.componenetes = componenetes;
        this.litros = litros;
    }

    public String getComponenetes() {
        return componenetes;
    }

    public void setComponenetes(String componenetes) {
        this.componenetes = componenetes;
    }

    public double getLitros() {
        return litros;
    }

    public void setLitros(double litros) {
        this.litros = litros;
    }


}
