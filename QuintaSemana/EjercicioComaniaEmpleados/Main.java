public class Main {
    public static void main(String[] args) {
        Gerente gerente = new Gerente("Francisco", "202110SU3306", 50000, 100000);
        Empleado empleado1= new Empleado("Diego", "202202AP1483", 22000);

        empleado1.aumentarSueldo(10); 
        gerente.setPresupuesto(120000); 

        System.out.println(gerente.toString());
        System.out.println(empleado1.toString());
    }
}

