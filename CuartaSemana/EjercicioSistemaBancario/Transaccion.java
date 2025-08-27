public class Transaccion {
    private static int contadorTransacciones = 1;
    private int id;
    private String tipo;
    private double monto;
    private CuentaBancaria cuenta;

    public Transaccion( String tipo, double monto, CuentaBancaria cuenta) {
        this.id = contadorTransacciones++;
        this.tipo = tipo;
        this.monto = monto;
        this.cuenta = cuenta;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format(
        "{\n" +
        "  \"id\": %d,\n" +
        "  \"tipo\": \"%s\",\n" +
        "  \"monto\": %.2f,\n" +
        "  \"cuentaId\": %d,\n" +
        "  \"titularCuenta\": \"%s\"\n" +
        "}", id, tipo, monto, cuenta.getId(), cuenta.getTitular()
    );
    }


    

    
}
