
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import model.Empleado;

public class testEmpleadoComparator {
   public static void main(String[] args) {
    //comparador para ordenar por nombre
    Comparator<Empleado> ordenarPorNombre = 
    Comparator.comparing(Empleado::getNombre);
   
    //comparador para ordenar al empleado por id
    Comparator<Empleado> ordenarPorId = Comparator.comparingInt(Empleado::getId);

    //TreeMap con las claves = Empelado
    Map<Empleado,Double> empleadosPorNombre = new TreeMap<>(ordenarPorNombre);
    empleadosPorNombre.put( new Empleado(4,"Susana","Analista"), 12340);
    empleadosPorNombre.put( new Empleado(3,"Aramando","Programador"),15152);
    empleadosPorNombre.put( new Empleado(4,"Carla","Gerencia"),23233);
    imprimirEmpleados(empleadosPorNombre);
   }
    public static void imprimirEmpleados(Map<Empleado, Double> empleados){
        for(var empleado: empleados.entrySet()){
            System.out.println(empleado.getKey()+" -> "+empleado.getValue());
        }
    }


}