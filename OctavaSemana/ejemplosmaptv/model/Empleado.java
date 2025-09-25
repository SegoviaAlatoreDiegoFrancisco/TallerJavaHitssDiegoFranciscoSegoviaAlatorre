
import java.time.LocalDate;
import java.util.Comparator;
import java.util.TreeMap;

public class Empleado{
    private int id;
    private String nombre;
    private String departamento;
    private TreeMap<LocalDate, CambioPuesto> historial;
    public Empleado(){
        
    }
    public Empleado(int id, String nombre, String departamento) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
    }
    public Empleado(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        //Comparator para ordenar por fecha de menor a mayor
        //instanciando el objeto o mapa historial
        this.historial = new TreeMap<>(Comparator.naturalOrder());

}
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
/*     public String getDepartamento() {
        return departamento;
    }
        */
    //registrar un nuevo ascenso o cambio
    public void registrarCambio(LocalDate fecha,String nuevopuesto){
        historial.put(fecha, new CambioPuesto(fecha, nuevopuesto));
    }

    //Mostrar historial en orden
    public void MostrarHistorial(){
        System.out.println("Historial de "+ nombre +":");
        for (var h : historial.entrySet()) {
            System.out.println(h.getValue());
            
        }
    }
    //Mostrar el historial en orden inverso ( del mas reciente al mas antiguo)
    public void MostrarHistorialDesc(){
        System.out.println("Hisotiral (mas reciente a primero) de "+ nombre + ":");
        for (var empleo : historial.descendingMap().entrySet()) {
            System.out.println(empleo.getValue());            
        }
    }
    @Override
    public String toString() {
        return "Empleado [id=" + id + ", nombre=" + nombre +", historial: "+ historial/* ", departamento=" + departamento */+ "]";
    }  
}
