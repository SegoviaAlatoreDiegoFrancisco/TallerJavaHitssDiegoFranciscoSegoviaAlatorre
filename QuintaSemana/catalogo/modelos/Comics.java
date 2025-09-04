package catalogo.modelos;

import java.time.LocalDate;

public class Comics extends Libro{
    private String persinaje;

    public Comics(int precio, LocalDate fechaPublicacion, String autor, String titulo, String editorial,
            String persinaje) {
        super(precio, fechaPublicacion, autor, titulo, editorial);
        this.persinaje = persinaje;
    }

    @Override
    public double getPrecioVenta() {
        // TODO Auto-generated method stub
        return getPrecio() * 1.05;
    }

    public String getPersinaje() {
        return persinaje;
    }
    
    
}
