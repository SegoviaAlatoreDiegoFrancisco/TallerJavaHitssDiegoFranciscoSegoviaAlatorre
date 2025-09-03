
public class Lobo extends Canino{
    private int numCamada;
    private String especieLobo;

    public Lobo(String especieLobo, int numCamada, String habitat, double altura, double largo, double peso, String nombreCientifico, String color, double tamanioColmillos) {
        super(habitat, altura, largo, peso, nombreCientifico, color, tamanioColmillos);
        this.especieLobo = especieLobo;
        this.numCamada = numCamada;
    }
    
    @Override
    public String comer() {
        return "El Lobo " + especieLobo + " caza en manada en " + habitat;
    }

    @Override
    public String comunicarse() {
        return "El Lobo aúlla para comunicarse con su camada de " + numCamada + " miembros.";
    }

    @Override
    public String correr() {
        return "El Lobo corre en grupo para rodear a su presa.";
    }

    @Override
    public String dormir() {
        return "El Lobo " + color + " duerme en las cavernas de " + habitat;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() +" Numero de camada: "+ numCamada+"\nespecie de lobo: "+especieLobo;
    }

    
}
