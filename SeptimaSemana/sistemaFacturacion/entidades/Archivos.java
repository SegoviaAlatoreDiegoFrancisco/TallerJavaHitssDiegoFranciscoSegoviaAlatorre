import java.io.*;
import java.nio.file.*;
import java.util.*;
public class Archivos {
    private static final String FACTURAS_DIR="facturas";
    //método qque guarda factura en un archivo
    public static void guardarFactura(Factura factura){
        try {
            Files.createDirectories(Paths.get(FACTURAS_DIR));
            String nombreArchivo = FACTURAS_DIR +"/Factura_"+factura.getId()+".txt";
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))){
            writer.write("idFactura: "+factura.getId());
            writer.newLine();
            writer.write("Cliente: "+factura.getCliente());
            writer.newLine();
            writer.write("Productos: ");
            for (Producto p: factura.getProductos()){
                writer.newLine();
                writer.write("   "+p.getDescripcion()+", $"+p.getPrecio());
            }  
            writer.write("\n\t Total: "+ factura.calcularTotal());
            }
        }catch( IOException e){
             System.out.println("Error al guardar la factura: "+e.getMessage());
            }
    }
    //método para leer factura
    public static void leerFactura(Long idFactura){
        String nombreArchivo = FACTURAS_DIR + "/Factura_" + idFactura + ".txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer la factura: " + e.getMessage());
        }
    }
    //Metodo para listar las facturas
    public static List<String> listarFacturas(){
        List<String> nombres = new ArrayList<>();
        try {
            Files.createDirectories(Paths.get(FACTURAS_DIR));
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(FACTURAS_DIR), "Factura_*.txt")) {
                for (Path entry : stream) {
                    nombres.add(entry.getFileName().toString());
                }
            }
        } catch (IOException e) {
            System.out.println("Error, no se listarón las facturas"+e.getMessage());
        }
        return nombres;
    }
}