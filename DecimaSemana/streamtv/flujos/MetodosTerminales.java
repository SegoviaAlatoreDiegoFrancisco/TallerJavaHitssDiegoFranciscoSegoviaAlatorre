package flujos;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MetodosTerminales {
    public static void main(String[] args) {
        //forEach(Consumer) -> List, Set
        //forEach(BiConsumer) -> Map
        //que hace; itera sobre cada elemento y ejecuta una accion
        //Devuelve: void
        
        //toArrau()
        //Que hace: convierte el stream a un array
        //Devuelve un arreglo de tipo Objeto[] o tipo especifico si se pasa un generador
        String[] letras = List.of("a","b","c","d","e").stream().toArray(String[]::new);
        

        for (String elemento : letras) {
            System.out.println(elemento +" ");
        }
        //reduce 
        //que hace: combina el los elementos en un unico resultado ( acumulacopm
        //devuelve un valor
        int suma=List.of(12,56,58,42,41,8,15)
            .stream()
            .reduce(0, Integer::sum);
        System.out.println("Suma: "+ suma);
        //Collec(Collector<T,A,R> collector)
        //Que hace: acumula los elementos en una coleccion o resultado mutable
        //Muys usado en collectors
        List<String> lista = Stream.of("a","b","c","f","g"). collect(Collectors.toList());
        System.out.println(lista);
        //java16
        List<String> listaj16 = Stream.of("a","b","c","f","g").toList();
        System.out.println(listaj16);

        Map<Integer,String> mapa = List.of("uno","tres","cuatro","cinco")
            .stream()
            .collect(Collectors.toMap(String::length, s -> s));
        mapa.forEach((k,v) -> System.out.println(k+" -> "+v));
        
        //min(Comparator <? super T> comparator)
        //que hace: Encuentra el elemento minimo
        //Devuelve: Optional<T>
        List<Integer> numeros = List.of(4,6,3,9,5);
        Optional<Integer> minimo = List.of(4,6,3,9,5)
            .stream()
            .min(Integer::compareTo);
            if( minimo.isPresent()){
                System.out.println("Minimo: " + minimo.get());
            }
        System.out.println("=====================max()==========");
        System.out.println("Minimo:" + minimo.orElseThrow());
        //max(Comparator< ? super T> comparator)
        //que hace: Encuentra el elemento máximo 
        //Devuelve un Optional<T>
        System.out.println("=====================max()==========");
        Optional<Integer> maximo = numeros
            .stream()
            .max(Integer::compareTo);
        System.out.println("Maximo:" + maximo.orElseThrow());
        maximo.ifPresent(n -> System.out.println("Maximo: "+ n));
        
        //count
        //que hace: cuenta los elementos
        //devuelve long
        System.out.println("================count()=================");
        long total = numeros.stream().count();
        System.out.println("Total: "+total);
        
        //anyMatch(Predicate<T> predicate)
        //Que hace: verifica si algun elementos cumple con la condicion
        //devuelve boolean
        boolean hayPar = numeros.stream().anyMatch(n -> n % 2 ==0);
        System.out.println("¿Hay numeros par? : "+ hayPar);

        //noneMatch(Predicate <T> predicate)
        //que hace: verifica si ningun elemento cumple con la condicion
        //Devuelve: boolean 

        //allMatch(Predicate<T> predicate)
        //quehace: verifica qeu si todos los elementos cumplen con lacondicion
        
        //findFirst()
        //que hace: Devuelve el primer elemento del stream
        //Devuelve: Optional<T>
        System.out.println("=============findFirst()=====");
        Optional<Integer> primero = numeros.stream().findFirst();
        System.out.println("Primer elemento: "+ primero.orElseThrow());

        //
    }
}       
