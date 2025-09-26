import java.util.*;

public class Profesor {
    private String nombre;
    private Set<Curso> cursos = new HashSet<>();

    
    public Profesor(String nombre) {
        this.nombre = nombre;
    }

    public Profesor() {
    }
    
    public void agregarCurso(Curso curso){
        cursos.add(curso);
    }
    public Set<Curso> getCursos(){
        return cursos;
    }
    @Override
    public String toString() {
        return "Profesor [nombre=" + nombre + ", cursos=" + cursos + "]";
    }

    public String getNombre() {
        return nombre;
    }
    
}
