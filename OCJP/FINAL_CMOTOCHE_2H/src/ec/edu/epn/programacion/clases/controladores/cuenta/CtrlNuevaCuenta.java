package ec.edu.epn.programacion.clases.controladores.cuenta;

import ec.edu.epn.programacion.clases.controladores.cliente.CtrlNuevoCliente;
import ec.edu.epn.programacion.clases.vista.cliente.DlgCrearCliente;
import ec.edu.epn.programacion.clases.vista.cuenta.DlgCrearCuenta;
import ec.edu.epn.programacion.excepciones.archivos.ArchivoCliente;
import ec.edu.epn.programacion.excepciones.archivos.ArchivoCuenta;
import ec.edu.epn.programacion.pojos.Cliente;
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
public class CtrlNuevaCuenta
    implements ActionListener {
    private DlgCrearCuenta crearCuenta;
    private ArchivoCuenta modeloCuenta;

    /**
     *
     * @param crearCuenta
     */
    public CtrlNuevaCuenta(DlgCrearCuenta crearCuenta) {
        this.crearCuenta = crearCuenta;
        this.modeloCuenta = new ArchivoCuenta();

        this.crearCuenta.getBtnAceptar().addActionListener(this);
        this.crearCuenta.getBtnCancelar().addActionListener(this);
        this.crearCuenta.getBtnCrearCliente().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.crearCuenta.getBtnAceptar()) {
            String mensajesDeError = camposValidos();
            if (mensajesDeError.isEmpty()) {
                // Mapear cuenta
                Cuenta cuenta = new Cuenta();
                cuenta.setNombreCliente(this.crearCuenta.getCmbClientes());
                cuenta.setNumeroCta(this.crearCuenta.getTxtNumeroCuenta());
                double saldo = Double.parseDouble(this.crearCuenta.getTxtSaldoInicial());
                cuenta.setSaldoInicial(saldo);
                cuenta.setSaldoActual(saldo);

                // Crear cuenta
                String result = this.modeloCuenta.crear(cuenta);
                JOptionPane.showMessageDialog(crearCuenta, result);

                // Cerrar ventana
                this.crearCuenta.dispose();
            } else {
                JOptionPane
                        .showMessageDialog(this.crearCuenta
                        , mensajesDeError
                        , "Errores"
                        , JOptionPane.ERROR_MESSAGE
                        , null);
            }
        }
        if (e.getSource() == this.crearCuenta.getBtnCrearCliente()) {
            DlgCrearCliente dcc = new DlgCrearCliente(this.crearCuenta, true);
            CtrlNuevoCliente cnc = new CtrlNuevoCliente(dcc);
            cnc.start();
            updateCmb();
        }
        if (e.getSource() == this.crearCuenta.getBtnCancelar()) {
            this.crearCuenta.dispose();
        }
    }

    /**
     * Permite iniciar la visualización de la ventana
     */
    public void start(){
        updateCmb();
        this.crearCuenta.setTitle("Cuenta");
        this.crearCuenta.setLocationRelativeTo(null);
        this.crearCuenta.setVisible(true);
    }

    /**
     * Recarga el combobox después del cambio
     */
    private void updateCmb() {
        ArchivoCliente modeloCliente = new ArchivoCliente();
        List<String> nombres = new  ArrayList<>();
        List<Cliente> clientes = modeloCliente.listar();
        clientes.forEach(client -> nombres.add(client.getNombre()));
        this.crearCuenta.setCmbClientes(nombres);
    }

    private String camposValidos(){
        String errores = "";
        String numeroCuenta = this.crearCuenta.getTxtNumeroCuenta();

        if (numeroCuenta.isEmpty()) {
            errores += "-El número de cuenta debe estar lleno.";
        }

        if (numeroCuenta.contains(" ")) {
            errores += "\n-El número de cuenta no debe tener espacios.";
        }

        try {
            double cuenta = Double.parseDouble(this.crearCuenta.getTxtSaldoInicial());
        } catch (NumberFormatException e) {
            errores += "-El saldo inicial deber ser un decimal.";
        }

        return errores;
    }
}
