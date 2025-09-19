package arraylist;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import modelos.Persona;
public class Listas{
    public static void main(String[] args) {
        List<String> empleados = new ArrayList<>();
        List<String> nuevosEmpleados = Arrays.asList("Arturo","Antonio");
        empleados.add("Pedro");
        empleados.add("Saul");
        empleados.add("Ezrra");
        empleados.add("Mijail");
        empleados.add("Salazar");
        System.out.println("Lista de empleados: " + empleados);
        //coloca un nuevo elemento en la 4ta posición y recorre el resto
        empleados.add(4,"Gustavo");
        System.out.println("Lista de empleados: " + empleados);
        empleados.addFirst("Juan");
        System.out.println("Lista de empleados: " + empleados);
        empleados.addLast("Zayuri");
        System.out.println("Lista de empleados: " + empleados);
        empleados.addAll(nuevosEmpleados);
        System.out.println("Lista de empleados: " + empleados);
        //modifica un elemento de la lista
        System.out.println("Total: "+ empleados.size());
        System.out.println("Ingrese un indice para reemplazar(9): ");

        System.out.println("Empleado modificado en el indice("+9+")"+empleados.set(9,"Toño"));
        System.out.println("Lista de empleados: " + empleados);
        //obtener un elemento
        System.out.println("Elemento: "+ empleados.get(4));
        empleados.add(3,"Diego");
        System.out.println("Lista de empleados: "+empleados);
        
        //iteradores
        System.out.println("=".repeat(5)+"Usando Iteradores"+"=".repeat(5));
        Iterator<String> iterador = empleados.iterator();
        while(iterador.hasNext()){
            //System.out.println("Elemento: "+iterador.next());
            if (iterador.next().equals("Diego")){
                iterador.remove();
            }
        }
        
        System.out.println("Lista de empleados: "+empleados);
        System.out.println("Despues del primer iterador( se quedo en la ultima posision del los elementos)");
        //la siguente interfaz solo sirve para list,set y map en sus implementaciones
        System.out.println("=".repeat(5)+"List Iterator"+"=".repeat(5));
        ListIterator<String> listIterator = empleados.listIterator();
        while(listIterator.hasNext()){
            System.out.println("Indice: "+ listIterator.nextIndex());
            System.out.println("Elemento:"+listIterator.next());
        }
        System.out.println("Recorrer de fin a inicio");
        while(listIterator.hasPrevious()){
            System.out.println("Indice: "+ listIterator.previousIndex());
            System.out.println("Elemento "+listIterator.previous());
        }        
        listIterator.add("Diego");
        System.out.println("empleados");
        
        //ordenamiento
        //List<Integer> enteros = new ArrayList<Integer>();
//        Collection.sort(empleados);
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Diego", 26));
        personas.add(new Persona(2, "Victor", 24));
        personas.add(new Persona(3, "Emi", 25));
        personas.add(new Persona(4, "Mati", 19));
        personas.add(new Persona(5, "Pedro", 30));
        personas.add(new Persona(6, "Juan", 40));
        personas.add(new Persona(7, "Jaun", 26));
        System.out.println("====Lista de personas====");
        for (Persona persona : personas) {
            System.err.println(persona);
        }
        //se necesita la implementacion de la interfaz comparable para haser uso de collections.sort()
        //Collections.sort(personas);       
        //personas.sort(Comparator.comparingInt(Persona::getEdad));
        //Persona::getEdad ==> Referencia a metodo
        //p-> p.getEdad() --> expresion lambda ToIntFunction
        //utilizando valor entero
        //personas.sort(Comparator.compareinInt(Persona::getEdad));
        //utilizando String
        personas.sort(Comparator.comparing(Persona::getNombre)
            .thenComparing(p->p.getNombre().length())
            .thenComparing(Persona::getEdad).reversed());
        System.err.println("Despues de implementar conparable y rodenar la lista: ");
        for (Persona persona : personas) {
            System.err.println(persona);
        }
        List<Integer> numeros = new ArrayList<>(Arrays.asList(4,5,3,7,5,4,1,8,6));
        System.out.println("Total: "+Collections.frequency(personas, "Diego"));
        
        System.out.println("Numeros: "+ numeros);
        System.out.println("Total de 5: "+Collections.frequency(numeros, 5));
        System.out.println("Minimo: "+Collections.min(numeros));
        System.out.println("Minimo: "+Collections.max(numeros));
        Collections.shuffle(numeros);
        System.out.println("Numeros: "+ numeros);
        System.out.println("Total: "+ Collections.frequency(personas, new Persona(8,"Ramón",23)));

        
    }
}