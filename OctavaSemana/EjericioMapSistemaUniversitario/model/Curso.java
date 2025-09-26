
import java.time.LocalDate;
import java.util.*;

public class Curso {
    private String nombre;
    private Profesor profesor;
    private LocalDate inicio;
    private LocalDate fin;
    private Set<Estudiante> estudiantes = new HashSet<>();

    public Curso(LocalDate fin, LocalDate inicio, String nombre, Profesor profesor) {
        this.fin = fin;
        this.inicio = inicio;
        this.nombre = nombre;
        this.profesor = profesor;
    }

    public Curso() {
    }

    public String getNombre() {
        return nombre;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public LocalDate getFin() {
        return fin;
    }

    public Set<Estudiante> getEstudiantes() {
        return estudiantes;
    }
    public boolean conflictoHorario(Curso curso){
        return !(fin.isBefore(curso.inicio) || inicio.isAfter(curso.fin));
    }
    public boolean inscribirEstudiante(Estudiante estudiante, Set<Curso> cursosActuales) {
        for (Curso c : cursosActuales) {
            if (conflictoHorario(c)) return false;
        }
        return estudiantes.add(estudiante);
    }
    public void retirarEstudiante(Estudiante estudiante){
        estudiantes.remove(estudiante);
    }
    public boolean estaActivoEn(LocalDate fecha){
        return !fecha.isBefore(inicio) && !fecha.isAfter(fin);
    }

    @Override
    public String toString() {
        return nombre + " (" + inicio + " -> " + fin + ") - Profesor: " + profesor.getNombre();   
    }

}
