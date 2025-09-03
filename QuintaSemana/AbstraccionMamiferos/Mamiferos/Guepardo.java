public class Guepardo extends Felino{

    public Guepardo(String habitat, double altura, double largo, double peso, String nombreCientifico, double tamanioGarras, int velocidad) {
        super(habitat, altura, largo, peso, nombreCientifico, tamanioGarras, velocidad);
    }


    @Override
    public String comer() {
        return "El Guepardo caza solo en las planicies de " + habitat;
    }

    @Override
    public String comunicarse() {
        return "El Guepardo emite sonidos agudos para comunicarse.";
    }

    @Override
    public String correr() {
        return "El Guepardo alcanza hasta " + velocidad + " km/h en persecuciones cortas.";
    }

    @Override
    public String dormir() {
        return "El Guepardo descansa en zonas elevadas de " + habitat;
    }
}
