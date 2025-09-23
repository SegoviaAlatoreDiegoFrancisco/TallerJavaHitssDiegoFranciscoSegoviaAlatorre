
import java.util.Set;
import java.util.TreeSet;

public class ConjuntoTreeSet {
    public static void main(String[] args) {
        Set<String> nombres = new TreeSet<>();
        nombres.add("Diego");
        nombres.add("Susana");
        nombres.add("Pedro");
        nombres.add("Manuel");
        nombres.add("Diego");//Duplicados se ignoran
        System.out.println("Nombres: "+nombres);
        
    }
}
