import java.util.*;
public class Banco {
    private List<CuentaBancaria> cuentas = new ArrayList<>();
    private List<Transaccion> transacciones = new ArrayList<>();

    public CuentaBancaria crearCuenta(String titular, double depositoInicial){
        CuentaBancaria cuenta = new CuentaBancaria(titular, depositoInicial);
        cuentas.add(cuenta);
        return cuenta;
    }
    public void realizarRetiro(CuentaBancaria cuenta, double monto){
        if(cuenta.retirar(monto)){
            transacciones.add( new Transaccion("Retiro", monto, cuenta));
        }else{
            System.out.println("Fondos Insuficientes para la cuenta " + cuenta.getId());
        }
    }
    public void realizarDeposito(CuentaBancaria cuenta, double monto) {
        cuenta.depositar(monto);
        transacciones.add(new Transaccion("Depósito", monto, cuenta));
    }
    public void mostrarCuentas() {
        for (CuentaBancaria cuenta : cuentas) {
            System.out.println(cuenta);
        }
    }

    public void mostrarTransacciones() {
        for (Transaccion transaccion : transacciones) {
            System.out.println(transaccion);
        }
    }
}
