import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class Empleado {
    private int id;
    private String nombre;
    private String departamento;
    private double salario;
    private int aniosExperiencia;
    private List<Evaluacion> evaluaciones = new ArrayList<>();

    public Empleado(int aniosExperiencia, String departamento, int id, String nombre, double salario) {
        this.aniosExperiencia = aniosExperiencia;
        this.departamento = departamento;
        this.id = id;
        this.nombre = nombre;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    public List<Evaluacion> getEvaluaciones() {
        return evaluaciones;
    }

    public void addEvaluacion(Evaluacion e) {
        this.evaluaciones.add(e);
    }

    public OptionalDouble promedioPuntajes() {
        return evaluaciones.stream().mapToInt(Evaluacion::getPuntaje).average();
    }


    public OptionalInt puntajeUltimaEvaluacion() {
        return evaluaciones.stream()
                .max(Comparator.comparingInt(e -> e.getAnio()))
                .map(Evaluacion::getPuntaje)
                .map(OptionalInt::of)
                .orElse(OptionalInt.empty());
    }

    @Override
    public String toString() {
        String avg = promedioPuntajes().isPresent() ? String.format("%.2f", promedioPuntajes().getAsDouble()) : "N/A";
        return String.format("Empleado{\nid=%d, \nnombre='%s', \ndepartamento='%s', \nsalario=%.2f, \naños=%d, \nPuntaje promedio=%s \n}",
                id, nombre, departamento, salario, aniosExperiencia, avg);
    }

}
