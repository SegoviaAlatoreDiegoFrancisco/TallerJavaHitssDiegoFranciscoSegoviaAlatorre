package test;

import java.util.List;

public class Expresiones{
    public static void main(String[] args){
        //Sintaxis basica de expresiones lambda
        //(parametros)->extpresion(sentencia)
        //Cuando utilizo un bloque de instrucciones
        //(parametros)->{bloque de instrucciones}

        //ejemplo sin parametros. debe estar dentro de una interfaz
        //() -> System.out.println("Hola Mundo");
        
        //parametros con tipo explicito
        //(int x, int y) -> x + y;

        //parametro (s) con tipo inferidoel compilador lo deduce
        //(x, y) -> x + y;

        //Una sola instruccion (no requiere llaves, ni return)
        //x -> x * x;

        //Bloque de código con varias instrucciones 
        /* 
        (x, y)->{  System.out.println("Sumando...");
                    int r = x+y;
                    return r;
                }*/
        List<String> nombres = List.of("Juan","Pedro","Carlos","Augusto","Marcelo");
        //Imperativo
        System.out.println("Paradigma imperativo");
        for (String nombreString : nombres) {
            System.out.println(nombreString);
        }
        //Declarativo -> programación funcional con lambda 
        System.out.println("==========Paradigma declaratico==========");
        nombres.forEach(n -> System.out.println(n));

        //Funcional con referencia de metodo
        System.out.println("=".repeat(5)+"Referencia de metodo"+"=".repeat(5));
        nombres.forEach(System.out::println);

        //
        Runnable proceso = () -> System.out.println("Ejecutando tarea");
        new Thread(proceso).start();
    }
}