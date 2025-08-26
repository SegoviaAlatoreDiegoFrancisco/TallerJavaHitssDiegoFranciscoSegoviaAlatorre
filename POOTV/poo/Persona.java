package poo;

public class Persona {
      //Ejemplos
    /*Automovil automovil;

    public Persona(){
        automovil = new Automovil();
    }
    public void CrearObjeto(){
        automovil.setMarca("Audi");
        automovil.setColor("Rojo");
        automovil.setAnio(2025);

    }
    
    public void descripcion(){
        System.out.println("Marca: " + automovil.getMarca());
        System.out.println("Color: " + automovil.getColor());
        System.out.println("Año: "+ automovil.getAnio());
        System.out.println("Número de puertas " +  automovil.getNumeroPuertas());
    }
        */
    private String nombre;
    private int edad;

    public Persona(){}
    
    public Persona(int edad, String nombre) {
        this(edad);     //solo puede hacerse con el primer atributo
        this.nombre = nombre;
    }
    
   
    public Persona(int edad) {
        this.edad = edad;
    }

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        //return super.toString();
        return "Sobre escritura de metodo";
    }

    

}
