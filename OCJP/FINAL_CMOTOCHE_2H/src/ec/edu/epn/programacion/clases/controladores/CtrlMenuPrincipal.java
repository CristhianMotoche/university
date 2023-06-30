package ec.edu.epn.programacion.clases.controladores;

import ec.edu.epn.programacion.clases.controladores.cliente.CtrlNuevoCliente;
import ec.edu.epn.programacion.clases.controladores.cliente.CtrlListarCliente;
import ec.edu.epn.programacion.clases.controladores.cuenta.CtrlListarCuentas;
import ec.edu.epn.programacion.clases.controladores.cuenta.CtrlNuevaCuenta;
import ec.edu.epn.programacion.clases.controladores.usuario.CtrlNuevoUsuario;
import ec.edu.epn.programacion.clases.controladores.usuario.CtrlListarUsuario;
import ec.edu.epn.programacion.clases.vista.DlgTransaccion;
import ec.edu.epn.programacion.clases.vista.FrmMenuPrincipal;
import ec.edu.epn.programacion.clases.vista.cliente.DlgCrearCliente;
import ec.edu.epn.programacion.clases.vista.cliente.DlgOpcionesCliente;
import ec.edu.epn.programacion.clases.vista.cuenta.DlgCrearCuenta;
import ec.edu.epn.programacion.clases.vista.cuenta.DlgListaCuenta;
import ec.edu.epn.programacion.clases.vista.usuario.DlgCrearUsuario;
import ec.edu.epn.programacion.clases.vista.usuario.DlgOpcionesUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class CtrlMenuPrincipal
        implements ActionListener {

    private FrmMenuPrincipal frmMenuPrincipal;

    public CtrlMenuPrincipal(FrmMenuPrincipal frmMenuPrincipal) {
        this.frmMenuPrincipal = frmMenuPrincipal;

        /* USUARIOS */
        this.frmMenuPrincipal.getMenuItemNuevoUsuario().addActionListener(this);
        this.frmMenuPrincipal.getMenuItemEditarUsuario().addActionListener(this);
        this.frmMenuPrincipal.getMenuItemEliminarUsuario().addActionListener(this);
        this.frmMenuPrincipal.getMenuItemListarUsuario().addActionListener(this);

        /* CLIENTES */
        this.frmMenuPrincipal.getMenuItemNuevoCliente().addActionListener(this);
        this.frmMenuPrincipal.getMenuItemEditarCliente().addActionListener(this);
        this.frmMenuPrincipal.getMenuItemEliminarCliente().addActionListener(this);
        this.frmMenuPrincipal.getMenuItemListarClientes().addActionListener(this);

        /* CUENTAS */
        this.frmMenuPrincipal.getMenuItemNuevaCuenta().addActionListener(this);
        this.frmMenuPrincipal.getMenuItemListarCuenta().addActionListener(this);

        /* TRANSACCIONES */
        this.frmMenuPrincipal.getMenuItemDepositar().addActionListener(this);
        this.frmMenuPrincipal.getMenuItemRetirar().addActionListener(this);

        /* SALIR */
        this.frmMenuPrincipal.getMenuSalir().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /* USUARIOS */
        if (e.getSource() == this.frmMenuPrincipal.getMenuItemNuevoUsuario()) {
            DlgCrearUsuario dialogCrearUsuario =
                    new DlgCrearUsuario(this.frmMenuPrincipal, true);
            CtrlNuevoUsuario ctrlNuevoUsuario =
                    new CtrlNuevoUsuario(dialogCrearUsuario);
            ctrlNuevoUsuario.start();
        }
        if (e.getSource() == this.frmMenuPrincipal.getMenuItemEditarUsuario()){
            DlgOpcionesUsuario dialogOpcionesUsuario =
                    new DlgOpcionesUsuario(this.frmMenuPrincipal, true);
            CtrlListarUsuario ctrlOpcionesUsuario =
                    new CtrlListarUsuario(dialogOpcionesUsuario, false, true);
            ctrlOpcionesUsuario.start();
        }
        if (e.getSource() == this.frmMenuPrincipal.getMenuItemEliminarUsuario()) {
            DlgOpcionesUsuario dialogOpcionesUsuario =
                    new DlgOpcionesUsuario(this.frmMenuPrincipal, true);
            CtrlListarUsuario ctrlOpcionesUsuario =
                    new CtrlListarUsuario(dialogOpcionesUsuario, true, false);
            ctrlOpcionesUsuario.start();
        }
        if (e.getSource() == this.frmMenuPrincipal.getMenuItemListarUsuario()) {
            DlgOpcionesUsuario dialogOpcionesUsuario =
                    new DlgOpcionesUsuario(this.frmMenuPrincipal, true);
            CtrlListarUsuario ctrlOpcionesUsuario =
                    new CtrlListarUsuario(dialogOpcionesUsuario, false, false);
            ctrlOpcionesUsuario.start();
        }

        /* USUARIOS */
        if (e.getSource() == this.frmMenuPrincipal.getMenuItemNuevoCliente()) {
            DlgCrearCliente dialogCrearCliente =
                    new DlgCrearCliente(this.frmMenuPrincipal, true);
            CtrlNuevoCliente ctrlNuevoCliente =
                    new CtrlNuevoCliente(dialogCrearCliente);
            ctrlNuevoCliente.start();
        }
        if (e.getSource() == this.frmMenuPrincipal.getMenuItemEditarCliente()){
            DlgOpcionesCliente dialogOpcionesCliente =
                    new DlgOpcionesCliente(frmMenuPrincipal, true);
            CtrlListarCliente ctrlOpcionesCliente =
                    new CtrlListarCliente(dialogOpcionesCliente, false, true);
            ctrlOpcionesCliente.start();
        }
        if (e.getSource() == this.frmMenuPrincipal.getMenuItemEliminarCliente()) {
            DlgOpcionesCliente dialogOpcionesCliente =
                    new DlgOpcionesCliente(this.frmMenuPrincipal, true);
            CtrlListarCliente ctrlOpcionesCliente =
                    new CtrlListarCliente(dialogOpcionesCliente, true, false);
            ctrlOpcionesCliente.start();
        }
        if (e.getSource() == this.frmMenuPrincipal.getMenuItemListarClientes()) {
            DlgOpcionesCliente dialogOpcionesCliente =
                    new DlgOpcionesCliente(this.frmMenuPrincipal, true);
            CtrlListarCliente ctrlOpcionesCliente =
                    new CtrlListarCliente(dialogOpcionesCliente, false, false);
            ctrlOpcionesCliente.start();
        }

        /* CUENTAS */
        if (e.getSource() == this.frmMenuPrincipal.getMenuItemNuevaCuenta()) {
            DlgCrearCuenta dialogCrearCuenta =
                    new DlgCrearCuenta(this.frmMenuPrincipal, true);
            CtrlNuevaCuenta ctrlNuevaCuenta = new CtrlNuevaCuenta(dialogCrearCuenta);
            ctrlNuevaCuenta.start();
        }
        if (e.getSource() == this.frmMenuPrincipal.getMenuItemListarCuenta()) {
            DlgListaCuenta dialogListaCuenta =
                    new DlgListaCuenta(this.frmMenuPrincipal, true);
            CtrlListarCuentas ctrlListarCuentas =
                    new CtrlListarCuentas(dialogListaCuenta);
            ctrlListarCuentas.start();
        }

        /* TRANSACCIONES */
        if (e.getSource() == this.frmMenuPrincipal.getMenuItemDepositar()) {
            DlgTransaccion dialogTransaccion =
                    new DlgTransaccion(this.frmMenuPrincipal, true);
            CtrlTransaccion ctrlTransaccion =
                    new CtrlTransaccion(dialogTransaccion, "deposito");
            ctrlTransaccion.start();
        }
        if (e.getSource() == this.frmMenuPrincipal.getMenuItemRetirar()) {
            DlgTransaccion dialogTransaccion =
                    new DlgTransaccion(this.frmMenuPrincipal, true);
            CtrlTransaccion ctrlTransaccion =
                    new CtrlTransaccion(dialogTransaccion, "retiro");
            ctrlTransaccion.start();
        }
        /* SALIR */
        if (e.getSource() == this.frmMenuPrincipal.getMenuSalir()) {
            this.frmMenuPrincipal.dispose();
        }
    }

    void start() {
        this.frmMenuPrincipal.setTitle("Menú Principal");
        this.frmMenuPrincipal.setLocationRelativeTo(null);
        this.frmMenuPrincipal.setVisible(true);
    }
}
