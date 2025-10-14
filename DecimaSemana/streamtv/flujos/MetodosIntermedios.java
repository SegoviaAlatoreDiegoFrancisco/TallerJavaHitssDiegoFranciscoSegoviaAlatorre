package flujos;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MetodosIntermedios {
    public static void main (String[] args){
        //Metodos intermedios
        //filter(Predicate<T> predicate)
        //que hace: selecciona solo los elementos que cumplen una condicion 
        //Devuelve un nuevo string con los elementos filtrados
        List<Integer> enteros = List.of(1,5,3,6,7,8,4,2,3,4,19);
//        Stream<Integer> flujo = enteros.stream();
//        Predicate<Integer> impar = n->n%2 !=0;
//        enteros.stream().filter(impar);
//        enteros.stream().filter(n->n%2 !=0);
        enteros.stream()
            .filter(n -> n%2 !=0)//metodo intermedio
//            .forEach(n -> System.out.println(n));//metodo terminal
            .forEach(System.out::print);


        //map(Function<T,R> mapper)
        //Que hace:Transforma cada elemento en otro tipo o valor
        //Devuelve: un Stream<R>
        System.out.println(".".repeat(10)+"map()"+".".repeat(10));
        List.of("Eloy","Java","Stream","Hitss","Taller")
            .stream()
            .filter(s -> s.length()>5)
//            .map(s -> s.toUpperCase()),
            .map(String::toUpperCase)
            .forEach(System.out::println);
        //Complejidad en el tiempo ==>O(n*k)
        //Complejidad en espacio ==> O(1), O(n log n)



        //flatMap(Function<T,Stream<R>> mapper)
        //Que hace: aplana multiples streams en uno solo 
        //Devuelve: Un Stream<R> con todos los elementos unidos
        
        System.err.println("==============Flatmal()=====================");
        List<List<String>> datos = List.of(
            List.of("A"+"B"+"C"+"D"+"E")
            ,List.of("F"+"G"+"I"+"J")
            ,List.of("K"+"L"+"M")
            );
        System.out.println(datos);
        List<String> aplanar =datos.stream()
        .flatMap(List::stream)
        .map(String::toLowerCase)
        .collect(Collectors.toList());
//            .flatMap(l -> l.stream())
//            .forEach(System.out::println);
        System.out.println(aplanar);


        //distinct 
        //que hace: elimina elementos duplicados (usa equals() y hashcode())
        //Devuelve un flujo sin loselementos duplciados
        System.out.println("Antes del distict:\n"+enteros+"\nDespues: \n");
        
        enteros.stream()
            .distinct()
            .forEach(System.out::println);
        System.out.println("============sorted()=================");
            //sorted()/sorted(Comparator)
            //que hace: ordena los elementos en orden natural( o con un Comparator(objetos))
        List<Integer> unicos = enteros.stream().distinct().collect(Collectors.toList());
        unicos.stream()
            .sorted()
            .forEach(System.out::println);
        System.out.println("============Sorted(Comparator)===============");
        unicos.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        
        

        //peek(Consumer<T> action)
        //que hace: pemite realizar una accion intermedia(debug/log)
        //no aplica cambios, no modifica el stream
        System.out.println("============peek()==============");
        enteros.stream()
            .distinct()
            .peek(n -> System.out.println("Unico: "+n))
            .filter(n -> n%2 !=0)
            .peek(n -> System.out.println("Par: "+n))
            .sorted()
            .forEach(System.out::println);

        //limit(long maxsize)
        //que hace: delimita, toma solo los primeros n elementos
        System.out.println("==================limit(5)============");
        enteros.stream()
            .limit(5)
            .forEach(System.out::println);
        //skip(long n)
        //que hace: delimita, salta los primeros n elementos 
        System.out.println("==================skip(5)============");
        enteros.stream()
            .skip(5)
            .forEach(System.out::println);
        //mapToInt(),mapToLong(),mapToDouble()
        //que hacen: transforman elementos a streams primitivos(IntStream, LongStream, DoubleStream)
        System.out.println("=============mapToInt============");
        List.of("5","20","33").stream()
            .mapToInt(s -> Integer.parseInt(s))
            .filter(n  -> n % 2 !=0)
            .forEach(System.out::println); 
        //flatMapToInt,flatMapToLong,FlatMapToDouble
        //que hace: version primitiva de flatMap
        //se usa cuando cada elemento produce un stream de primitivos
        Stream<String> flujos = Stream.of("3 4 5 8 ","7 4 5 6","12 34 55");
        flujos.flatMapToInt(s -> Arrays.stream(s.split(" "))
            .mapToInt(s1 -> Integer.parseInt(s1))
        )
        .forEach(System.out::println);
    }

}
