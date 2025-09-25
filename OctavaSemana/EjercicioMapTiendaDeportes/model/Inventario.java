package model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import model.Producto;

public class Inventario {
    private Map<String,Producto> productosPorSku= new HashMap<>();
    private Map<String,Producto> productosPorInsercion = new LinkedHashMap<>();
    private TreeMap<String,Producto> productosPorNombre = new TreeMap<>();

    public void registrarProducto(Producto producto){
        productosPorSku.put(producto.getSku(), producto);
        productosPorInsercion.put(producto.getSku(),producto);
        productosPorNombre.put(producto.getNombre(),producto);
    }
    public void actualizarStock(String sku, String sucursal, int cantidad){
        Producto producto =productosPorSku.get(sku);
        if(producto!=null){
            producto.actualizarStock(sucursal,cantidad);
        }
    }
    public void reportePorInsercion(){
        System.out.println("Reporte por orden de insersion ");
        for(Producto p : productosPorInsercion.values()){
            System.out.println(p);
        }
    }
    public void reportePorNombre(){
        System.out.println("Reporte ordenado por nombre ");
        for(Producto p : productosPorNombre.values()){
            System.out.println(p);
        }
    }
    public Producto consultarPorSku(String sku){
        return productosPorSku.get(sku);
    }
}
