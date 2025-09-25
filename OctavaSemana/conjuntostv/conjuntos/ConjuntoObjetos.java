
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import modelos.Alumno;
public class ConjuntoObjetos {
    public static void main(String[] args) {
        Set<Alumno> alumnos = new HashSet<>();
        Set<Alumno> alumnosLinked = new LinkedHashSet<>();
        Set<Alumno> alumnosTree = new TreeSet<>();
        alumnos.add( new Alumno(1,"Elor1",90));
        alumnos.add( new Alumno(2,"Elor2",90));
        alumnos.add( new Alumno(3,"Elor3",90));
        alumnos.add( new Alumno(4,"Elor4",90));
        alumnos.add( new Alumno(5,"Elor5",90));
        alumnos.add( new Alumno(6,"Elor6",90));

        for (Alumno alumno : alumnos){
            System.out.println(alumno);
        }
        
        alumnosLinked.add( new Alumno(1,"Elor1",90));
        alumnosLinked.add( new Alumno(2,"Elor2",90));
        alumnosLinked.add( new Alumno(3,"Elor3",90));
        alumnosLinked.add( new Alumno(4,"Elor4",90));
        alumnosLinked.add( new Alumno(5,"Elor5",90));
        alumnosLinked.add( new Alumno(6,"Elor6",90));

        for (Alumno alumno : alumnosLinked){
            System.out.println(alumno);
        }
        alumnosTree.add( new Alumno(1,"Elor1",90));
        alumnosTree.add( new Alumno(2,"Elor2",90));
        alumnosTree.add( new Alumno(3,"Elor3",90));
        alumnosTree.add( new Alumno(4,"Elor4",90));
        alumnosTree.add( new Alumno(5,"Elor5",90));
        alumnosTree.add( new Alumno(6,"Elor6",90));
        
        for (Alumno alumno : alumnosTree){
            System.out.println(alumno);
        }
    }
}
