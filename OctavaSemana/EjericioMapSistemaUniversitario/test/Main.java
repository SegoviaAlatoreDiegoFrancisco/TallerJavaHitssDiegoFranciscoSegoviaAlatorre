
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        SistemaUniversitario sistema = new SistemaUniversitario();

        sistema.registrarEstudiante("E001", "Pedro Paramo");
        sistema.registrarEstudiante("E002", "Luis Garcia");

        sistema.registrarCurso("Estadística", "Frumencio Martinez", LocalDate.of(2025, 06, 7), LocalDate.of(2027, 2, 12));
        sistema.registrarCurso("Bases de Datos", "Pedro Rueda", LocalDate.of(2025, 9, 1), LocalDate.of(2025, 11, 30));
        sistema.registrarCurso("Redes", "Xochitl Cohén", LocalDate.of(2025, 10, 1), LocalDate.of(2025, 12, 15));
        
        sistema.inscribirEstudiante("E001", "POO");
        sistema.inscribirEstudiante("E001", "Bases de Datos"); // OK
        sistema.inscribirEstudiante("E001", "Redes"); // Conflicto

        sistema.listarCursosDeEstudiante("E001");
        sistema.listarCursosDeProfesor("Dra. Martínez");
        sistema.listarCursosActivosEn(LocalDate.of(2025, 10, 15));
    
    }
}
