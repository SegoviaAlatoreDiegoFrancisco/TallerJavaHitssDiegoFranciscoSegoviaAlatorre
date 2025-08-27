public class CuentaBancaria {
    private static int contadorCuentas = 1;
    private int id;
    private String titular;
    private double saldo;
    
    public CuentaBancaria(String titular, double depositoIncial) {
        this.id=contadorCuentas++;
        this.titular = titular;
        this.saldo = depositoIncial;
    }

    public int getId() {
        return id;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean  retirar(double monto){
        if (monto <= saldo){
            saldo-=monto;
            return true;
        }
        return false;
    }
    public void depositar(double monto){
        saldo+=monto;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return String.format(
        "{\n" +
        "  \"id\": %d,\n" +
        "  \"titular\": \"%s\",\n" +
        "  \"saldo\": %.2f\n" +
        "}", id, titular, saldo
        );
    }
    
    
}
