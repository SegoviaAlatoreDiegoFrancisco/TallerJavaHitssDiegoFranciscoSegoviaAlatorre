package test;

import interfaces.Operacion;
import interfaces.Transformador;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Cliente;

public class PruebaInterface {
    public static void main(String[] args) {
        Operacion suma = (a, b) -> a + b;
        System.out.println("Suma: " + suma.calcular(10, 5));
        Operacion multiplicacion = (a,b) -> a*b;
        System.out.println("Multiplicacion: "+multiplicacion.calcular(3, 5));

        //lambda qeu transforma un string a mayusculas (String)
        Transformador<String, String> aMayusculas = s -> s.toUpperCase();
        System.out.println(aMayusculas.transformar("Pedro Paramo"));
        
        Transformador<String,Integer> medirCadena = s -> s.length();
        System.out.println(medirCadena.transformar("Carlitos"));
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Paramo", 1, "Pedro"));
        clientes.add(new Cliente("Paramo", 2, "Pedro"));
        clientes.add(new Cliente("Paramo", 3, "Pedro"));
        clientes.add(new Cliente("Paramo", 4, "Pedro"));

        clientes.forEach(System.out::println);
        clientes.forEach(c -> System.out.println(aMayusculas.transformar(c.getNombre())));

        System.out.println("=========Clientes========");
        clientes
        .forEach(
            c -> {
                String nombre = c.getNombre();
                System.out.println(aMayusculas.transformar(nombre));
            }
        );
        Transformador<String, String> fraseATransformar = s -> s.replaceAll("[ ,.]", "").toUpperCase();
        System.out.println("Transformar fase (Elimina espacios, comas, puntos y transforma a mayusculas)");
        String fraseOriginal = "Pepe Pecas, pica papas, con un pico. Con un pico...";
        System.out.println("Frase: "+ fraseOriginal);
        System.out.println(fraseATransformar.transformar(fraseOriginal));


        //labmda qeu cuenta las palabras y devuelce la mas repetida en un map
        Transformador<String,Map<String,Integer>> palabraMasRepetida = frase ->{
             String[] palabras = frase.toLowerCase().replaceAll("[^a-záéíóúüñ ]", "").split("\\s+");
            Map<String, Integer> conteo = new HashMap<>();
            for(String palabra : palabras){
                if(!palabra.isEmpty()){
                    conteo.put(palabra, conteo.getOrDefault(palabra, 0)+1);
                }
            }
            
            int maxConteo=0;
            for(int cantidad : conteo.values()){
                if(cantidad >maxConteo){
                    maxConteo = cantidad;
                }
            }
            Map<String, Integer> resultado = new HashMap<>();
            for(var entry :conteo.entrySet()){
                if(entry.getValue()== maxConteo){
                    resultado.put(entry.getKey(),entry.getValue());
                }
            }
            return resultado;
        };  
        Map<String,Integer> resultado = palabraMasRepetida.transformar(fraseOriginal);
        System.out.println("Palabra mas repetida y su conteo dentro de la frase \n\t'" +fraseOriginal+"'");
        resultado.forEach((palabra,cantidad) -> 
        System.out.println("Palabra: '"+palabra+ "'\t Repeticiones: "+cantidad)
        );
        
/* 
        if(!resultado.isEmpty()){
            String palabra = resultado.keySet().iterator().next();
            System.out.println("La palabra mas repetida es '"+palabra+"' con "+resultado.get(palabra)+" repeticiones");
        }
        */
    
    }
}
