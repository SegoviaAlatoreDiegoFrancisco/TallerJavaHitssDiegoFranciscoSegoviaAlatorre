
import java.time.LocalDate;
import java.util.*;

public class SistemaUniversitario {
    private Map<String, Curso> cursos = new HashMap<>();
    private Map<String, Estudiante> estudiantes = new HashMap<>();
    private Map<String, Profesor> profesores = new HashMap<>();
    private Map<String, Set<Curso>> cursosPorEstudiante = new HashMap<>();

    public SistemaUniversitario() {
    }
     
    public void registrarCurso(String nombre, String profesorNombre, LocalDate inicio, LocalDate fin){
        Profesor profesor = profesores.computeIfAbsent(profesorNombre, Profesor::new);
        Curso curso = new Curso(fin, inicio, profesorNombre, profesor);
        cursos.put(nombre, curso);
    }
    public void registrarEstudiante(String id,String nombre){
        estudiantes.putIfAbsent(id, new Estudiante(id,nombre));
    }
    public boolean inscribirEstudiante(String idEstudiante,String nombreCurso){
        Estudiante estudiante = estudiantes.get(idEstudiante);
        Curso curso = cursos.get(nombreCurso);
        if(estudiante == null || curso == null){
            return false;
        }
        Set<Curso> actuales = cursosPorEstudiante.getOrDefault(idEstudiante, new HashSet<>());
        if(curso.inscribirEstudiante(estudiante, actuales)){
            actuales.add(curso);
            cursosPorEstudiante.put(idEstudiante, actuales);
            return true;
        }
        return false;
    }
    public void retirarEstudiante(String idEstudiante, String nombreCurso){
        Estudiante estudiante = estudiantes.get(idEstudiante);
        Curso curso = cursos.get(nombreCurso);
        if(estudiante !=null && curso !=null){
            curso.retirarEstudiante(estudiante);
            cursosPorEstudiante.getOrDefault(idEstudiante,new HashSet<>()).remove(curso);
        }
    }
    
    public void listarCursosDeProfesor(String nombreProfesor){
        Profesor profesor = profesores.get(nombreProfesor);
        if(profesor!=null){
            System.out.println("Cursos de: "+nombreProfesor+":");
            profesor.getCursos().forEach(System.out::println);
        }
    }
    public void listarCursosActivosEn(LocalDate fecha){
        System.out.println("Cursos activos en "+fecha+":");
        cursos.values().stream()
            .filter(curso->curso.estaActivoEn(fecha))
            .forEach(System.out::println);
    }
    public void listarCursosDeEstudiante(String idEstudiante){
        System.out.println("Cursos de "+ idEstudiante+":");
        cursosPorEstudiante.getOrDefault(idEstudiante, Set.of());

    }
}
