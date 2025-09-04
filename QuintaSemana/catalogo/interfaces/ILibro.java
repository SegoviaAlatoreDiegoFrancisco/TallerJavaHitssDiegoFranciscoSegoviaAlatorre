package catalogo.interfaces;
import java.time.LocalDate;

public interface ILibro {
    LocalDate getFechaPublicacion();
    String getAutor();
    String getTitulo();
    String getEditorial();

}
