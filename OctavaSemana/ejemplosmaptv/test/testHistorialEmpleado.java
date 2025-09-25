import java.time.LocalDate;

public class testHistorialEmpleado {
    public static void main(String[] args) {
        Empleado empleado = new Empleado(101, "Francisco");

        //registrar cambios en el historial
        empleado.registrarCambio(LocalDate.of(2020, 3, 14),"Residente");
        empleado.registrarCambio(LocalDate.of(2021, 7, 2), "Programador Jr A");
        empleado.registrarCambio(LocalDate.of(2022, 7, 24), "ProgramadorJr B");
        empleado.registrarCambio(LocalDate.of(2021, 8, 12), "Programador jR");
        //Mostrar el orden cronologico
        empleado.MostrarHistorial();
        //Mostrar historial de orden descendente
        empleado.MostrarHistorialDesc();
    }
}
