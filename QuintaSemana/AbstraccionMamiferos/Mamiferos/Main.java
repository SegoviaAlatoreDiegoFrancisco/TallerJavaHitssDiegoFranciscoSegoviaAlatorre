public class Main {
    public static void main(String[] args) {
        Mamiferos[] mamiferos = new Mamiferos[6];

        mamiferos[0] = new Leon(130, "Sur Africa", 2.1, 1.2, 190, "Panthera leo", 5.5, 120, 10);
        mamiferos[1] = new Tigre("Bengala", "India", 1.1, 2.5, 220, "Panthera tigris", 6.0, 65);
        mamiferos[2] = new Guepardo("Africa", 0.9, 1.5, 72, "Acynonix jubantus", 4.9, 6);
        mamiferos[3] = new Lobo("Gris", 12, "Canadá", .8, 1.5,50, "Canis Lupus", "Gris", 6);
        mamiferos[4] = new Perro("Sabana", 0.7, 1.4, 40, "Lycaon pictus", "moteado", 2.8, 320);
        mamiferos[5] = new Leon(130,"Serengeti", 1.3, 2.2, 200, "Panthera leo", 5.8, 85, 12);

        for (Mamiferos animal : mamiferos) {
            System.out.println("Mamifero" + animal.getClass().getSimpleName());
            System.out.println("Come: " + animal.comer());
            System.out.println("Duerme:  " + animal.dormir());
            System.out.println("Corre: " + animal.correr());
            System.out.println("Se comunica: " + animal.comunicarse());
            System.out.println("--------------------------------------------------");
        }
    }
}