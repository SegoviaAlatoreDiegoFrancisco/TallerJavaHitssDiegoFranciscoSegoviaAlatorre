
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestVentas {
    public static void main(String[] args) {
        TreeMap<LocalDate,Ventas> ventas = new TreeMap<>();
        ventas.put(LocalDate.of(2025, 9, 10), new Ventas(1, 1265.0, "Agusto"));
        ventas.put(LocalDate.of(2025, 9, 11), new Ventas(8, 1234.0, "Agusto2"));
        ventas.put(LocalDate.of(2025, 9, 12), new Ventas(5, 2212.0, "Agustoii"));
        ventas.put(LocalDate.of(2025, 9, 13), new Ventas(2, 1288.0, "Agusto H"));
        ventas.put(LocalDate.of(2025, 9, 14), new Ventas(4, 1255.0, "Agusto Pietro"));
        imprimir(ventas);        

        //Buscar ventas anteriores a una fecha
        System.out.println("Ventas antes del 2025-09-13");
        for (Map.Entry<LocalDate, Ventas> ventasAnterior : 
            ventas.headMap(LocalDate.of(2025, 9, 13)).entrySet()) {
            System.err.println(ventasAnterior.getKey()+" -> "+ventasAnterior.getValue());
        }
        
        //Buscar ventas posteriores a una fecha
        System.out.println("Ventas despues del 2025-09-13");
        for (Map.Entry<LocalDate, Ventas> ventasDespues : 
            ventas.tailMap(LocalDate.of(2025, 9, 13)).entrySet()) {
            System.err.println(ventasDespues.getKey()+" -> "+ventasDespues.getValue());
        }

    }
    public static void imprimir(Map<LocalDate,Ventas> mapa){
        for (var elemento : mapa.entrySet()) {
            System.out.println(elemento.getKey()+" -> "+ elemento.getValue());
            
        }
    }
}
