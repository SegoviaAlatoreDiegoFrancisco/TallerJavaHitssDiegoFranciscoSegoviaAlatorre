package test;
import poo.Calculadora;
import poo.Persona;

public class TestMain {
    public static void main(String[] args) {
        /* 
        Automovil automovil = new Automovil();
        Persona persona = new Persona();
        // 
        persona.descripcion();
        System.out.println("-".repeat(20));
        persona.CrearObjeto();
        persona.descripcion();
        //
        automovil.setMarca("Ford");
        automovil.setColor("Azul");
        automovil.setAnio(2024);
        automovil.setNumeroPuertas(2);

        System.out.println("-".repeat(20));
        System.out.println("Marca: " + automovil.getMarca());
        System.out.println("Color: " + automovil.getColor());
        System.out.println("Año: "+ automovil.getAnio());
        System.out.println("Número de puertas " +  automovil.getNumeroPuertas());
        */
        Calculadora calculadora= new Calculadora();
        int suma = calculadora.suma(4,5);
        System.out.println("Suma: " + suma);
        System.out.println("Suma: "+ calculadora.suma(7,8));
        System.out.println("Suma: "+calculadora.suma(suma,6.1));
        calculadora.saludar("Francisco");

        Persona p4 = new Persona(20, "Chucho");
        System.out.println(p4.toString());
                
    }    
}
