public class Gerente extends Empleado {
    private double presupuesto;

    public Gerente(String nombre, String dni, double sueldo, double presupuesto) {
        super(nombre, dni, sueldo);
        this.presupuesto = presupuesto;
    }

    public double getPresupuesto() { return presupuesto; }
    public void setPresupuesto(double presupuesto) { this.presupuesto = presupuesto; }

    @Override
    public String toString() {
        return super.toString() + ", Presupuesto: $" + presupuesto;
    }
}
