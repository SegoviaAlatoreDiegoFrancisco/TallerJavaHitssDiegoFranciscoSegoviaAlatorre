package models;

import java.time.LocalDate;

public class Venta {
    private String factura;
    private double monto;
    private LocalDate fecha;
    
    public Venta(String factura, double monto, LocalDate fecha) {
        this.factura = factura;
        this.monto = monto;
        this.fecha = fecha;
    }
    
    public Venta() {
    }

    public String getFactura() {
        return factura;
    }

    public double getMonto() {
        return monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return  factura + " - monto=" + monto + "(" + fecha + ")";
    }

    
}
