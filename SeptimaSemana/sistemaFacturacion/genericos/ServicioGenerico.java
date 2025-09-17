package genericos;

import java.util.ArrayList;
import java.util.List;

//ServicioGenerico<Cliente, String>
public class ServicioGenerico<T extends Identificable<ID>, ID> {
    private final List<T> datos = new ArrayList<>();
    public void agregar(T elemento){
        //VALIDACION PARA NO PERMITIR DUPLICADOS
        if(buscarPorId(elemento.getId())!=null){
            System.out.println("El elemento ya existe.\nNo se pudo agregar.");
        }else{
        System.out.println("El elemento "+ elemento+ " se ha guardado.");
        datos.add(elemento);
        }
    }
    public List<T> listar(){
        return new ArrayList<>(datos);
    }
    public T buscarPorId( ID id){
        for (T elemento : datos) {
            if(elemento.getId().equals(id)){
                return elemento;
            }
        }
        return null;
    }
    public boolean eliminarPorId(ID id){
        for (int i=0; i < datos.size(); i++){
            if(datos.get(i).getId().equals(id)){
                datos.remove(i);
                System.out.println("eliminando ID: "+id);
                return true;
            }else{
                System.out.println("No se encontró el ID "+id);
            }
        }
        return false;
    }
    public boolean actualizar(ID id, T nuevoElemento){
        for (int i=0;i<datos.size();i++){
            if (datos.get(i).getId().equals(id)){
                datos.set(i,nuevoElemento);
                System.out.println("Se actualizó Id: "+id+"Con el elemento: "+nuevoElemento);
                return true;
            }
        }
        System.out.println("El elemento "+id+" no pudo actualizarse");
        return false;
    }

}
