
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class InterfaceFuncional {
    public static void main(String[] args) {
        //Predicate<T> -> recibe un argumento de tipo T, develve un boolean
        //Uso: validaciones ofiltros
        Predicate<String> longitud = s -> s.length() >5;
        //System.out.println(longitud.test("Hola"));
        Predicate<String>longitud2 = s ->{
            return s.length()>5;
        };
        //Consumer<T> -> recibe un argumento de tipo T, no devuelve nada
        //uso: Imprimir, guardar en loc, etc.
        Consumer<String> mayusculas = s-> System.out.println(s.toUpperCase());
        List<String> nombres = List.of("Pedro","Juan","Arturo");
        nombres.forEach(mayusculas);

        //Supplier<T> no recibe argumentos, devuelve un valor de tipo T
        ///Uso: Generar valores bajo demanda, Generar ID
        Supplier<Integer> numero = () -> new Random().nextInt(100);
        System.out.println("Numero Aleatorio: "+numero.get());
        System.out.println("Numero Aleatorio: "+numero.get());
        System.out.println("Numero Aleatorio: "+numero.get());
        
        Supplier<String> codigo = () -> UUID.randomUUID().toString();
        System.out.println("ID: "+codigo.get());
        System.out.println("ID: "+codigo.get());
        System.out.println("ID: "+codigo.get());
        
        //BiPredicate<T, U> ->recibe dos argumentos (T, U), devuelve un boolean
        //Uso: Validaciones con dos entradas
        BiPredicate<String, Integer> evaluarCadena = (s,I) -> s.length() > I;
        System.out.println(evaluarCadena.test("Hola",5));
        System.out.println(evaluarCadena.test("Programacion",10));

        //BiFunction<T,U,R> -> recibe dos argumentos (T, U), devuelve de
        //Uso: Operaciones matematicas, combinacion de objetos
        BiFunction<Integer, Integer, Integer> suma= (a,b) -> a+b;
        BiFunction<Integer, Integer, Integer> mul= (a,b) -> a*b;
        System.out.println("Suma: "+suma.apply(6, 4)); 
        System.out.println("Suma: "+mul.apply(6, 4)); 
        
        //BiConsumer <T,U> -> recibe dos argumentos (T, U), no devuelve nada
        //Uso: Trabajar con Mapas. Operaciones con Map(Clave, valor)
        BiConsumer<String,Integer> imprimir = (k,v) -> System.out.println(k+ " tiene edad: " + v);
        Map<String, Integer> personas = Map.of("Edgar", 27,"Augusto",12);
        personas.forEach(imprimir); 
        //UnaryOperator, BinaryOperator -> son especiales de function
        UnaryOperator<Integer> cuadrado = x-> x*x;
        System.out.println("Cuadrado ("+9+"): "+cuadrado.apply(9)); 
        
    }   
}
