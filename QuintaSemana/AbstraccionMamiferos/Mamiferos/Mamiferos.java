public abstract class Mamiferos {
    protected String habitat;
    protected double altura;
    protected double largo;
    protected double peso;
    protected String nombreCientifico;

    public Mamiferos(String habitat, double altura, double largo, double peso, String nombreCientifico) {
        this.habitat = habitat;
        this.altura = altura;
        this.largo = largo;
        this.peso = peso;
        this.nombreCientifico = nombreCientifico;
    }

    public abstract String comer();
    public abstract String dormir();
    public abstract String correr();
    public abstract String comunicarse();
    


    @Override
    public String toString() {
        return "mamifero:\n"+ "nombreCientifico: \n" +nombreCientifico+",\n habitat: "+
        habitat+ ",\naltura: "+ altura +",\n peso: "+peso+",\nlargo:"+largo+"\n";
    }
    
}
