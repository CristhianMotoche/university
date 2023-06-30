package ec.edu.epn.programacion.pojos;

/**
 *
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class Cuenta {
    private String numeroCta;
    private double saldoInicial;
    private double saldoActual;
    private String nombreCliente;

    /**
     *
     */
    public Cuenta() {
    }

    /**
     *
     * @param numeroCta
     * @param saldoInicial
     * @param saldoActual
     */
    public Cuenta(String numeroCta, double saldoInicial, double saldoActual) {
        this.numeroCta = numeroCta;
        this.saldoInicial = saldoInicial;
        this.saldoActual = saldoActual;
    }

    /**
     *
     * @param numeroCta
     * @param saldoInicial
     * @param saldoActual
     * @param nombreCliente
     */
    public Cuenta(String numeroCta, double saldoInicial, double saldoActual, String nombreCliente) {
        this.numeroCta = numeroCta;
        this.saldoInicial = saldoInicial;
        this.saldoActual = saldoActual;
        this.nombreCliente = nombreCliente;
    }

    /**
     *
     * @return
     */
    public String getNumeroCta() {
        return numeroCta;
    }

    /**
     *
     * @param numeroCta
     */
    public void setNumeroCta(String numeroCta) {
        this.numeroCta = numeroCta;
    }

    /**
     *
     * @return
     */
    public double getSaldoInicial() {
        return saldoInicial;
    }

    /**
     *
     * @param saldoInicial
     */
    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    /**
     *
     * @return
     */
    public double getSaldoActual() {
        return saldoActual;
    }

    /**
     *
     * @param saldoActual
     */
    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }

    /**
     *
     * @return
     */
    public String getNombreCliente() {
        return this.nombreCliente;
    }

    /**
     *
     * @param nombreCliente
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    @Override
    public String toString() {
        return this.numeroCta;
    }
}
