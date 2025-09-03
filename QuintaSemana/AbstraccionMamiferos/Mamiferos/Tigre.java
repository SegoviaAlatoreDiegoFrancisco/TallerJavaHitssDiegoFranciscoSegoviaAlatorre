public class Tigre  extends Felino{
    private String especieTigre;

    public Tigre(String especieTigre, String habitat, double altura, double largo, double peso, String nombreCientifico, double tamanioGarras, int velocidad) {
        super(habitat, altura, largo, peso, nombreCientifico, tamanioGarras, velocidad);
        this.especieTigre = especieTigre;
    }

    @Override
    public String comer() {
        return "El tigre "+especieTigre+ " busca se alimenta en "+ habitat;
    }

    @Override
    public String comunicarse() {
        return "El Tigre ruge para marcar territorio.";
    }

    @Override
    public String correr() {
      return "El Tigre corre a " + velocidad + " km/h para emboscar a su presa.";
    }

    @Override
    public String dormir() {
        return "El Tigre duerme entre la vegetación de " + habitat;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + "Especie de tigre: "+ especieTigre;
    }

    
}
