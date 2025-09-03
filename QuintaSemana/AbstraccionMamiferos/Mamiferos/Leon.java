public class Leon extends Felino{
    private Integer numManada =0;
    private double potenciaDeRugido;

    public Leon(double potenciaDeRugido, String habitat, double altura, double largo, double peso, String nombreCientifico, double tamanioGarras, int velocidad, int numManada) {
        super(habitat, altura, largo, peso, nombreCientifico, tamanioGarras, velocidad);
        this.numManada= numManada;
        this.potenciaDeRugido = potenciaDeRugido;
    }

    @Override
    public String comer() {
     return "El León caza junto a su manada de " + numManada + "  en " + habitat;
    }

    @Override
    public String comunicarse() {
        return "El león se cominica con un rugido de "+potenciaDeRugido+" dB";
    }

    @Override
    public String correr() {
     return "El león, al correr alcanza velocidades de "+ velocidad+ "Km/h";
    }

    @Override
    public String dormir() {
        return "el león duerme donde lo agarre el sueño en "+habitat;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + "\n velocidad: "+ velocidad+"\n Potencia de rugido(dB): " + potenciaDeRugido;
    }

    



}
