public abstract class Felino extends Mamiferos{
    protected Double tamanioGarras;
    protected Integer velocidad=0;

    
    public Felino(String habitat, double altura, double largo, double peso, String nombreCientifico, double tamanioGarras, int velocidad){
        super(habitat,altura,peso,largo,nombreCientifico);
        this.tamanioGarras = tamanioGarras;
        this.velocidad = velocidad;
    }
    
}
