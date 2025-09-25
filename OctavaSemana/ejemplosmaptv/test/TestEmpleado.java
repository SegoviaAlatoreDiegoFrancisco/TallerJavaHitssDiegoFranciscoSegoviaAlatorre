import java.util.HashMap;
import java.util.Map;

public class TestEmpleado {
    public static void main(String[] args){
        //crea un hashMap donde la clave es el ID y el valor es un empleado
        Map<Integer,Empleado> empleados = new HashMap<>();
        
        //agregar empleado
        empleados.put (2, new Empleado(2,"Pedro Paramo","TI"));
        empleados.put(5, new Empleado(5, "Ana Velazco", "RRHH"));
        empleados.put(102, new Empleado(102, "Juan", "Ventas"));

        //System.out.println(empleados);
        imprimirMapa(empleados);

        //acceder a un elemento en especifico por su ID
        System.out.println("Buscar empleado con ID 5");
        System.out.println(empleados.get(5));
        
        //verificar si existe un empleado
        int buscarId = 5;
        if (empleados.containsKey(buscarId)){
            System.out.println("El empleado " +buscarId+ " si existe.");
        }else{
            System.out.println("El empleado " +buscarId+ " no existe.");
        }
        //Eliminar un empleado 
        System.out.println("Eempleado eliminado " + empleados.remove(buscarId));
        empleados.put(201, new Empleado(201, "Noemi Garcia", "Gerencia"));
        imprimirMapa(empleados);

    }


    public static void imprimirMapa(Map<Integer,Empleado> empleados){
        for (Map.Entry<Integer,Empleado> empleado : empleados.entrySet()) {
            System.out.println(empleado.getKey() + " -> "+empleado.getValue());
        }
    }
}
