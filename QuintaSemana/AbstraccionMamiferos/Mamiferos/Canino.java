public abstract class Canino extends Mamiferos{
    protected String color;
    protected double tamanioColmillos;

    public Canino(String habitat, double altura, double largo, double peso, String nombreCientifico, String color, double tamanioColmillos) {
        super(habitat, altura, largo, peso, nombreCientifico);
        this.color = color;
        this.tamanioColmillos = tamanioColmillos;
    }
    
    
}
