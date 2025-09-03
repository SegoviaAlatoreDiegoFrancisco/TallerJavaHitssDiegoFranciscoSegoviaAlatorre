public class Perro extends Canino{
    private Integer fuerzaMordida;

    public Perro(String habitat, double altura, double largo, double peso, String nombreCientifico, String color, double tamanioColmillos, int fuerzaMordida) {
        super(habitat, altura, largo, peso, nombreCientifico, color, tamanioColmillos);
        this.fuerzaMordida = fuerzaMordida;
    }

    @Override
    public String comer() {
        return "El Perro muerde con " + fuerzaMordida + " psi.";
    }

    @Override
    public String comunicarse() {
        return "El perro puede cominicarse de muchas maneras, sobre todo con gestos o ladrando";
    }

    @Override
    public String correr() {
        return "El perro puede correr en espacios libres en "+habitat;
    }

    @Override
    public String dormir() {
        return "El perro duerme donde lo agarre el sueño en "+ habitat;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + "Fuerza de mordida: "+ fuerzaMordida;
    }
}
