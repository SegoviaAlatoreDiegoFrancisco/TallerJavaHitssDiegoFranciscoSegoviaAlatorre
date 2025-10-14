
import java.util.List;
import java.util.Map;



public class Test {
    public static void main(String[] args) {
        // Crear empleados de ejemplo
        Empleado e1 = new Empleado(6, "IT", 1, "Ana Perez", 60000);
        e1.addEvaluacion(new Evaluacion(2021, 85));
        e1.addEvaluacion(new Evaluacion(2022, 92));
        e1.addEvaluacion(new Evaluacion(2023, 88));

        Empleado e2 = new Empleado(3, "HHRR", 2, "Bruno Diaz", 48000);
        e2.addEvaluacion(new Evaluacion(2022, 78));
        e2.addEvaluacion(new Evaluacion(2023, 82));

        Empleado e3 = new Empleado(8, "IT", 3, "Carlos Gomez", 75000);
        e3.addEvaluacion(new Evaluacion(2021, 90));
        e3.addEvaluacion(new Evaluacion(2023, 95));

        Empleado e4 = new Empleado(10, "Finanzas", 4, "Diana Ruiz", 82000);
        e4.addEvaluacion(new Evaluacion(2020, 88));
        e4.addEvaluacion(new Evaluacion(2023, 91));

        Empleado e5 = new Empleado(2, "IT", 5, "Esteban Morales", 52000);
        e5.addEvaluacion(new Evaluacion(2023, 89));

        Empleado e6 = new Empleado(7, "HHRR", 6, "Fabiana Lopez", 55000);
        e6.addEvaluacion(new Evaluacion(2022, 71));
        e6.addEvaluacion(new Evaluacion(2023, 93));

        List<Empleado> empleados = List.of(e1, e2, e3, e4, e5, e6);

        System.out.println("1) Empleados del departamento HHRR, ordenados por nombre:");
        RecursosHumanosServices.listarPorDepartamentoOrdenNombre(empleados, "HHRR").forEach(System.out::println);

        System.out.println("\n2) Salario promedio por departamento:");
        Map<String, Double> promedios = RecursosHumanosServices.salarioPromedioPorDepartamento(empleados);
        promedios.forEach((d, s) -> System.out.printf("%s -> %.2f\n", d, s));

        System.out.println("\n3) Empleado con mayor salario:");
        RecursosHumanosServices.empleadoConMayorSalario(empleados).ifPresent(System.out::println);

        System.out.println("\n4) Empleados con >5 años exp y salario >50000:");
        RecursosHumanosServices.filtrarExperienciaYSalario(empleados, 5, 50000).forEach(System.out::println);

        System.out.println("\n5) Top 3 por última evaluación:");
        RecursosHumanosServices.topTresPorUltimaEvaluacion(empleados, 3).forEach(e ->
                System.out.printf("%s - Ultimo puntaje: %s\n", e.getNombre(),
                        e.puntajeUltimaEvaluacion().isPresent() ? e.puntajeUltimaEvaluacion().getAsInt() : "N/A")
        );

        System.out.println("\n6) Cantidad de empleados con al menos una evaluación >90:");
        System.out.println(RecursosHumanosServices.contarConEvaluacionMayorA(empleados, 90));

        System.out.println("\n7) Ranking de promedio de puntajes por empleado:");
        RecursosHumanosServices.rankingPromedioPuntajes(empleados).forEach(entry ->
                System.out.printf("%s -> %.2f\n", entry.getKey().getNombre(), entry.getValue())
        );
    }
}
