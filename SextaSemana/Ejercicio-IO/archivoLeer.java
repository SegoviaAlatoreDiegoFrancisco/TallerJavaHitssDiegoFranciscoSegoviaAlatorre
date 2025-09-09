import java.io.*;

public class archivoLeer {

    public static void main(String[] args) {
        String rutaArchivo = "Usuario.txt"; // Cambia el nombre si tu archivo es diferente

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                try {
                    validarNombre(linea);
                    System.out.println("Nombre válido: " + linea);
                } catch (NombreInvalidoException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe: " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void validarNombre(String nombre) throws NombreInvalidoException {
        if (nombre == null || nombre.trim().length() < 3) {
            throw new NombreInvalidoException("El nombre '" + nombre + "' es inválido (menos de 3 caracteres).");
        }
    }
}

// Excepción personalizada
class NombreInvalidoException extends Exception {
    public NombreInvalidoException(String mensaje) {
        super(mensaje);
    }
}