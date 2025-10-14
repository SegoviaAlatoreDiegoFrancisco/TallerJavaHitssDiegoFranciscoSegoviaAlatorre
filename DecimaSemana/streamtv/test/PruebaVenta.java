package test;

import java.time.LocalDate;
import java.util.List;
import java.util.OptionalDouble;
import models.Venta;

public class PruebaVenta {
    public static void main(String[] args) {
        List<Venta> ventas = List.of( new Venta("F001", 1000, LocalDate.of(2025, 10, 1)),
                                ( new Venta("F002", 7000, LocalDate.of(2025, 10, 1))),
                                ( new Venta("F003", 5000, LocalDate.of(2025, 10, 2))));
                                /* 
                                 
                                List<Venta> ventas = List.of;
                                List<Venta> ventas = List.of( new Venta("F004", 2000, LocalDate.of(2025, 10, 3)));
                                List<Venta> ventas = List.of( new Venta("F006", 3000, LocalDate.of(2025, 10, 4)));
                                List<Venta> ventas = List.of( new Venta("F006", 4000, LocalDate.of(2025, 10, 7)));
                                */
        
        //Total de las ventas ($)
        double total = ventas.stream()
        //    .reduce(0,Integer::sum);
            .mapToDouble(Venta::getMonto)
            .sum();
        System.out.println("Total: "+ total);

        //Ventas mayor = $2000
        List<Venta> ventasAlatas = ventas.stream()
            .filter(v -> v.getMonto() > 2000)
            .toList();
        System.out.println(ventasAlatas);
        //Agrupar por fechas
       /*
        Map<LocalDate, List<Venta>> grupoVentas = ventas.stream()
                            .collect(Collectors.groupingBy(v -> v.getMonto()));
        System.out.println("Ventas agrupadas: "+grupoVentas);
*/
        //Promedio Ventas
        OptionalDouble promedioVentas = ventas.stream()
                    .mapToDouble(v -> v.getMonto())
                    .average();
        System.out.println("Promedio de ventas: $" + promedioVentas.getAsDouble());

    }
}
