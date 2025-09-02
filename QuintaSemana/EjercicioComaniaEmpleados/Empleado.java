public class Empleado extends Persona {
    private double sueldo;

    public Empleado(String nombre, String dni, double sueldo) {
        super(nombre, dni);
        this.sueldo = sueldo;
    }

    public Empleado(String direccion, String dni, String nombre, String numeroFiscal, double sueldo) {
        super(direccion, dni, nombre, numeroFiscal);
        this.sueldo = sueldo;
    }

    public double getSueldo() {
         return sueldo; 
        }

    public void aumentarSueldo(double porcentaje) {
        sueldo += sueldo * porcentaje / 100;
    }

    @Override
    public String toString() {
        return super.toString() + ", Sueldo: $" + sueldo;
    }
}