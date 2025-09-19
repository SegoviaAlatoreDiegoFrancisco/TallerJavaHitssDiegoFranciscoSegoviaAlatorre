package linkedlist;
import java.util.LinkedList;
import java.util.List;
public class ListasEnlazadas {
    public static void main(String[] args) {
        List<String> personas = new LinkedList<>();
        personas.add("Diego");
        personas.add("Susana");
        personas.add("Abby");
        personas.add("Juan");
        personas.add("Federico");
        personas.add("Criss");
        System.out.println("Lista de personas: "+personas);
        System.out.println("Contiene a Juan: "+personas.contains("Juan"));
        personas.add(3,"Django");
        System.out.println("Lista de personas: "+personas);
        System.out.println("Elemento eliminado: "+personas.remove(3));
        System.out.println("Lista de personas: "+personas);
        System.out.println("Se agregará un nuevo elemento a partir de punteros, ya qeu se está usando LinkedList."+
        "Busca el elemento a partir del puntero que lo antecede y precede.");
        personas.set(3,"Rango");
        System.out.println("Lista de personas: "+personas);
        System.out.println("Contiene a Juan: "+personas.contains("Juan"));

    }
}
