package poo;

public class Calculadora {
    //Atributos
    //acceso tipoRetorno nombreMetodo (tipoParametro parametro,tipoParametro parametro,...)
    public int suma(int a, int b){
        return a + b;
    }
    public int suma(int a, int b, int c){
        return a + b + c;
    }
    public double suma(int a, double b){
        return a+b;
    }
    public double suma ( double a, double b){
        return a+b;
    }
    public void saludar(String nombre){
        System.out.println("Hola " + nombre);
    }
}
