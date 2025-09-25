package test;

import model.*;

public class Main {
public static void main(String[] args) {
    Inventario inventario = new Inventario();
    inventario.registrarProducto(new Producto("Tennis", "Raqueta Grande", "SKU0001"));
    inventario.registrarProducto(new Producto("Baseball", "Guante Wilson gris", "SKU0202"));
    inventario.registrarProducto(new Producto("Basquetbol", "Tenis Nike Air", "SKU0104"));

    inventario.actualizarStock("SKU0001", "Villa Hermosa", 200);
    inventario.actualizarStock("SKU0202", "San Jeronimo", 300);
    inventario.actualizarStock("SKU0104", "Centro, Madero", 1000);

    System.out.println("Consulta por SKU:");
    System.out.println(inventario.consultarPorSku("SKU0202"));

    inventario.reportePorInsercion();
    inventario.reportePorNombre();
}
}
