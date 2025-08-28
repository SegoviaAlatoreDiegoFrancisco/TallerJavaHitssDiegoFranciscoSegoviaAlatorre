package Enums;

public enum PaymentMethod {
    CASH("Efectivo"),
    CARD("Tarjeta de crédito o débito"),
    TRANSFER("Transferencia bancaria"); // ← corregido el typo

    private final String descripcion;

    PaymentMethod(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
