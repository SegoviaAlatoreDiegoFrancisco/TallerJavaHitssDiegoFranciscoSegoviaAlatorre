package catalogo.modelos;
import java.time.LocalDate;

import catalogo.abstractos.Producto;
import catalogo.interfaces.ILibro;

public class Libro extends Producto implements ILibro{
    private LocalDate fechaPublicacion;
    private String autor;
    private String titulo;
    private String editorial;
    public Libro(int precio, LocalDate fechaPublicacion, String autor, String titulo, String editorial) {
        super(precio);
        this.fechaPublicacion = fechaPublicacion;
        this.autor = autor;
        this.titulo = titulo;
        this.editorial = editorial;
    }
   
    @Override
    public String getAutor() {
        // TODO Auto-generated method stub
        return autor;
    }
    @Override
    public String getEditorial() {
        // TODO Auto-generated method stub
        return editorial;
    }
    @Override
    public LocalDate getFechaPublicacion() {
        // TODO Auto-generated method stub
        return fechaPublicacion;
    }
    @Override
    public String getTitulo() {
        // TODO Auto-generated method stub
        return titulo;
    }
    @Override
    public double getPrecioVenta() {
        // TODO Auto-generated method stub
        return precio *1.1;
    }

    
}
