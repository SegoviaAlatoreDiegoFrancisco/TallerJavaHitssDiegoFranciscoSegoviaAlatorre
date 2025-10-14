import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class RecursosHumanosServices {

    // 1. Listar todos los empleados de un departamento específico, ordenados alfabéticamente.
    // 2. Calcular el salario promedio por departamento.
    // 3. Obtener el empleado con mayor salario en toda la empresa.
    // 4. Listar todos los empleados con más de 5 años de experiencia y salario mayor a 50,000.
    // 5. Obtener el top N de empleados con mejor puntaje en la última evaluación (último año).
    // 6. Contar cuántos empleados tienen al menos una evaluación superior a 90 puntos.
    // 7. Generar un ranking de promedio de puntajes por empleado (de mayor a menor).
    public static List<Empleado> listarPorDepartamentoOrdenNombre(List<Empleado> lista, String departamento) {
        return lista.stream()
                .filter(e -> e.getDepartamento().equalsIgnoreCase(departamento))
                .sorted(Comparator.comparing(Empleado::getNombre))
                .collect(Collectors.toList());
    }

    public static Map<String, Double> salarioPromedioPorDepartamento(List<Empleado> lista) {
        return lista.stream()
                .collect(Collectors.groupingBy(Empleado::getDepartamento,
                        Collectors.averagingDouble(Empleado::getSalario)));
    }

    public static Optional<Empleado> empleadoConMayorSalario(List<Empleado> lista) {
        return lista.stream().max(Comparator.comparingDouble(Empleado::getSalario));
    }

    public static List<Empleado> filtrarExperienciaYSalario(List<Empleado> lista, int anios, double salarioMin) {
        return lista.stream()
                .filter(e -> e.getAniosExperiencia() > anios)
                .filter(e -> e.getSalario() > salarioMin)
                .collect(Collectors.toList());
    }

    public static List<Empleado> topTresPorUltimaEvaluacion(List<Empleado> lista, int n) {
        return lista.stream()
                .filter(e -> e.puntajeUltimaEvaluacion().isPresent())
                .sorted((a, b) -> Integer.compare(
                        b.puntajeUltimaEvaluacion().orElse(0),
                        a.puntajeUltimaEvaluacion().orElse(0)))
                .limit(n)
                .collect(Collectors.toList());
    }

    public static long contarConEvaluacionMayorA(List<Empleado> lista, int umbral) {
        return lista.stream()
                .filter(e -> e.getEvaluaciones().stream().anyMatch(ev -> ev.getPuntaje() > umbral))
                .count();
    }

    public static List<Map.Entry<Empleado, Double>> rankingPromedioPuntajes(List<Empleado> lista) {
        return lista.stream()
                .map(e -> Map.entry(e, e.promedioPuntajes().orElse(Double.NaN)))
                .sorted((a, b) -> Double.compare(b.getValue(), a.getValue()))
                .collect(Collectors.toList());
    }

}
