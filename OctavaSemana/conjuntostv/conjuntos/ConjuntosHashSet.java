import java.util.*;
public class ConjuntosHashSet {
    public static void main(String[] args){
        Set<String> colores = new HashSet<>();
        colores.add("Blanco"); 
        colores.add("Rojo"); 
        colores.add("Verde"); 
        colores.add("Amarillo"); 
        colores.add("Rojo");//duplicado, set no acepta duplicados, será ignorado 
        colores.add("Rosa"); 
        
        System.out.println("Colores: "+ colores);
        System.out.println("Colores está vacío: "+ colores.isEmpty());
        System.err.println("verificar (Blanco): " +colores.contains("Blanco"));
        System.err.println("verificar (Negro):"+colores.contains("Negro"));
        for (String color : colores) {
            System.out.println("Color: "+color);
        }
        System.out.println("========Iterator=======");
        Iterator<String> iterator = colores.iterator();
        while(iterator.hasNext()){
            var color = iterator.next();
            System.out.println("Color:"+ color);
            if(color.equals("Rosa")){
                iterator.remove();
            }    
        }
        System.out.println("Colores: "+colores);

    }
}
