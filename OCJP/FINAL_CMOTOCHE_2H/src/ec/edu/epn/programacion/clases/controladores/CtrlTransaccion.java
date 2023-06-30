package ec.edu.epn.programacion.clases.controladores;

import ec.edu.epn.programacion.clases.vista.DlgTransaccion;
import ec.edu.epn.programacion.excepciones.archivos.ArchivoCuenta;
import ec.edu.epn.programacion.pojos.Transferencia;
import ec.edu.epn.programacion.pojos.Cuenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class CtrlTransaccion
        implements ActionListener {

    private DlgTransaccion dialogTransaccion;
    private String opcion;
    private ArchivoCuenta modeloCuenta;

    /**
     *
     * @param dialogTransaccion
     * @param opcion
     */
    public CtrlTransaccion(DlgTransaccion dialogTransaccion, String opcion) {
        this.dialogTransaccion = dialogTransaccion;
        this.opcion = opcion;

        if (opcion.equals("deposito")) {
            this.dialogTransaccion.setTitle("Depósito");
            this.dialogTransaccion.setTextLblTransaccion("Depósito");
            this.dialogTransaccion.setTextBtnOpcion("Depositar");
        }

        if (opcion.equals("retiro")) {
            this.dialogTransaccion.setTitle("Retiro");
            this.dialogTransaccion.setTextLblTransaccion("Retiro");
            this.dialogTransaccion.setTextBtnOpcion("Retirar");
        }

        this.dialogTransaccion.getComboBoxCuenta().addActionListener(this);
        this.dialogTransaccion.getBtnCancelar().addActionListener(this);
        this.dialogTransaccion.getBtnOpcion().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.dialogTransaccion.getBtnOpcion() && this.opcion.equals("deposito")) {
            String mensajesDeError = camposValidos();
            if (mensajesDeError.isEmpty()) {
                Transferencia transaccion = new Transferencia();
                double monto = Double.parseDouble(this.dialogTransaccion.getTxtMonto());
                Cuenta cuenta = this.dialogTransaccion.getCmbCuenta();
                String result = transaccion.realizarDeposito(cuenta, monto);
                JOptionPane.showMessageDialog(dialogTransaccion, result);
                this.modeloCuenta.actualizar(cuenta);
                this.dialogTransaccion.dispose();
            } else {
                JOptionPane.showMessageDialog(this.dialogTransaccion
                        , mensajesDeError
                        , "Errores"
                        , JOptionPane.ERROR_MESSAGE
                        , null);
            }
        }
        if (e.getSource() == this.dialogTransaccion.getBtnOpcion() && this.opcion.equals("retiro")) {
            String mensajesDeError = camposValidos();
            if (mensajesDeError.isEmpty()) {
                Transferencia transaccion = new Transferencia();
                double monto = Double.parseDouble(this.dialogTransaccion.getTxtMonto());
                Cuenta cuenta = this.dialogTransaccion.getCmbCuenta();
                String result = transaccion.realizarRetiro(cuenta, monto);
                JOptionPane.showMessageDialog(dialogTransaccion, result);
                this.modeloCuenta.actualizar(cuenta);
                this.dialogTransaccion.dispose();
            } else {
                JOptionPane.showMessageDialog(this.dialogTransaccion
                        , mensajesDeError
                        , "Errores"
                        , JOptionPane.ERROR_MESSAGE
                        , null);
            }
        }
        if (e.getSource() == this.dialogTransaccion.getComboBoxCuenta()) {
            Cuenta cuenta = this.dialogTransaccion.getCmbCuenta();
            this.dialogTransaccion.setTxtNombreCliente(cuenta.getNombreCliente());
            this.dialogTransaccion.setTxtSaldoActual(cuenta.getSaldoActual());
        }
        if (e.getSource() == this.dialogTransaccion.getBtnCancelar()) {
            this.dialogTransaccion.dispose();
        }
    }

    /**
     *
     * @return String con los mensajes de error
     */
    public String camposValidos(){
        String messages = "";

        double monto = 0;
        try {
            monto = Double.parseDouble(this.dialogTransaccion.getTxtMonto());
        } catch(NumberFormatException e) {
            messages += "*El monto debe ser un número.";
        }

        if (monto < 0) {
            messages += "*El monto debe ser positivo.";
        }
        return messages;
    }

    private void updateCmb(){
        this.modeloCuenta = new ArchivoCuenta();
        List<String> nombres = new  ArrayList<>();
        List<Cuenta> cuentas = modeloCuenta.listar();
        cuentas.forEach(client -> nombres.add(client.getNumeroCta()));
        this.dialogTransaccion.setCmbCuentas(cuentas);
    }

    /**
     * Permite iniciar la visualización de la ventana
     */
    public void start() {
        updateCmb();
        this.dialogTransaccion.setLocationRelativeTo(null);
        this.dialogTransaccion.setVisible(true);
    }
}
