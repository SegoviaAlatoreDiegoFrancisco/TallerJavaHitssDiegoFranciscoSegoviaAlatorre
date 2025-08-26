package poo;
public class Automovil {
    //Atributos public, provate, protected, (default)}
    /* 
    //Los atributos "públicos" son para un ejemplo en el que se accede a ellos desde otro paquete
    //pero sin la encapsulación de los atributos 
    public String marca;
    public String color;
    public int anio;
    public Integer numeroPuertas = 4;
    */
    //Atributos para la encapsulación
    private String  marca;
    private String  color;
    private int     anio;
    private Integer numeroPuertas = 4;
    //Constructor (publico por defecto)
    public Automovil(){}

    //Metodos de acceso: getter/setter
    //get marca
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public Integer getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(Integer numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    

}
