package test;

import genericas.Bolsa;
import librerias.Fruta;
import librerias.Lacteo;
import librerias.Limpieza;
import librerias.NoPrerecible;
import librerias.Producto;
public class Main {
    public static void main(String[] args) {
        Bolsa<Fruta> frutas = new Bolsa<>();
        frutas.addProducto(new Fruta("Rojo", 1.0,"Manzana",37));
        frutas.addProducto(new Fruta("Amarillo", 10.0,"Plátano", 0.25 ));

        Bolsa<Limpieza> limpieza = new Bolsa<>();
        limpieza.addProducto(new Limpieza("Cloro", 25.0, "Hipoclorito", 1.0));
        limpieza.addProducto(new Limpieza("Detergente", 30.0, "Tensoactivos", 1.5));
         
        Bolsa<Lacteo> lacteos = new Bolsa<>();
        lacteos.addProducto(new Lacteo(1, 8, "Leche", 29));
        
        Bolsa<NoPrerecible> noPrerecibles = new Bolsa<>();
        noPrerecibles.addProducto( new NoPrerecible(500, 4, "Oreos", 19));

        

        mostrarBolsa("Frutas", frutas);
        mostrarBolsa("Limpieza", limpieza);
        mostrarBolsa("Lácteos", lacteos);
        mostrarBolsa("No Perecibles", noPrerecibles);
    }

    public static <T extends Producto> void mostrarBolsa(String tipo, Bolsa<T> bolsa) {
        System.out.println("\n Bolsa de " + tipo);
        for (T producto : bolsa.getProductos()) {
            System.out.println(" * " + producto.getNombre() + " - $" + producto.getPrecio());
            if (producto instanceof Fruta f)
                System.out.println("   Peso: " + f.getPeso() + "kg, Color: " + f.getColor());
            else if (producto instanceof Limpieza l)
                System.out.println("   Componentes: " + l.getComponenetes() + ", Litros: " + l.getLitros());
            else if (producto instanceof Lacteo la)
                System.out.println("   Cantidad: " + la.getCantidad() + "L, Proteínas: " + la.getProteinas() + "g");
            else if (producto instanceof NoPrerecible np)
                System.out.println("   Calorías: " + np.getCalorias() + ", Contenido: " + np.getContenido() + "g");
        }
    }
}
