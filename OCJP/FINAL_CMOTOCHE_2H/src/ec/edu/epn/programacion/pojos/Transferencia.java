package ec.edu.epn.programacion.pojos;

/**
 * POJO Transferencia, para realizar las transacciones.
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class Transferencia {
    /**
     * Metodo que permite reducir el saldo de una cuenta
     * @param cuenta Cuenta a la que se va a despositar
     * @param monto Cantidad de dinero que se va a retirar
     * @return
     */
    public String realizarRetiro(Cuenta cuenta, double monto){
        if (!(cuenta.getSaldoActual() - monto < 0.0)) {
            cuenta.setSaldoActual(cuenta.getSaldoActual() - monto);
            return "Transacción realizada con éxito";
        } else {
            return "No se realizó la transacción porque se exedió el saldo";
        }
    }
    /**
     * Metodo que permite aumentar el saldo de una cuenta
     * @param cuenta Cuenta a la que se va a despositar
     * @param monto Cantidad de dinero que se va a depositar
     * @return
     */
    public String realizarDeposito(Cuenta cuenta, double monto){
        cuenta.setSaldoActual(cuenta.getSaldoActual() + monto);
        return "Transacción realizada con éxito";
    }
}
