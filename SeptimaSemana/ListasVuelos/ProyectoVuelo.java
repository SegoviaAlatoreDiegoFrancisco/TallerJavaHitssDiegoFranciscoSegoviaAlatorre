import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class ProyectoVuelo {
    public static void main(String[] args) {
        List<Vuelo> vuelos = new ArrayList<>();

        //DateTimeFormatter formatterFecha = DateTimeFormatter.ofPattern("EEE dd MMM yyyy", Locale.ENGLISH);
        DateTimeFormatter formatterFecha = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);
        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm");

        try (BufferedReader br = new BufferedReader(new FileReader("docs\\vuelos.csv"))) {
            String linea;
            br.readLine(); // Saltar encabezado

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                String nombre = datos[0].trim();
                String origen = datos[1].trim();
                String destino = datos[2].trim();

                String fechaRaw = datos[3].replaceAll("Lun|Mar|Mié|Jue|Vie|Sáb|Dom", "").trim()
                          .replace("Ago", "Aug");
                LocalDate fecha = LocalDate.parse(fechaRaw, DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH));

                String horaRaw = datos[4].replace("hrs", "").trim();
                LocalTime hora = LocalTime.parse(horaRaw, DateTimeFormatter.ofPattern("HH:mm"));
                //LocalDate fecha = LocalDate.parse(fechaRaw, formatterFecha);
                //LocalTime hora = LocalTime.parse(horaRaw, formatterHora);
                int pasajeros = Integer.parseInt(datos[5].trim());
                vuelos.add(new Vuelo(nombre, origen, destino, fecha, hora, pasajeros));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Ordenar por llegada
        vuelos.sort(Comparator.comparing(Vuelo::getFecha).thenComparing(Vuelo::getHora));

        System.out.println("Vuelos ordenados por llegada:");
        vuelos.forEach(System.out::println);

        if (!vuelos.isEmpty()) {
            Vuelo ultimo = vuelos.get(vuelos.size() - 1);
            Vuelo menorPasajeros = Collections.min(vuelos, Comparator.comparingInt(Vuelo::getPasajeros));

            System.out.println("\nÚltimo vuelo en llegar: " + ultimo);
            System.out.println("Vuelo con menos pasajeros: " + menorPasajeros);
        } else {
            System.out.println("No se cargaron vuelos. Revisa el formato del archivo.");
        }

    }
}
