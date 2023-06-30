package ec.edu.epn.programacion.clases.controladores;

import ec.edu.epn.programacion.clases.vista.FrmLogin;
import ec.edu.epn.programacion.clases.vista.FrmMenuPrincipal;
import ec.edu.epn.programacion.excepciones.archivos.ArchivoUsuario;
import ec.edu.epn.programacion.pojos.UsuarioSistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class CtrlLogin
    implements ActionListener {

    private FrmLogin frmLogin;
    private ArchivoUsuario modelo;

    /**
     *
     * @param frmLogin
     */
    public CtrlLogin(FrmLogin frmLogin) {
        this.modelo = new ArchivoUsuario();
        this.frmLogin = frmLogin;
        this.frmLogin.getBtnAceptar().addActionListener(this);
        this.frmLogin.getBtnCerrar().addActionListener(this);
    }

    /**
     * Permite iniciar la visualización de la ventana
     */
    public void start(){
        this.frmLogin.setTitle("Login");
        this.frmLogin.setLocationRelativeTo(null);
        this.frmLogin.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.frmLogin.getBtnAceptar()) {
            String userName = this.frmLogin.getUsername();
            String password = this.frmLogin.getPassword();

            UsuarioSistema user = this.modelo.buscarUsuario(userName, password);
            String mensajesDeError = camposValidos(user);

            if (mensajesDeError.isEmpty()) {
                FrmMenuPrincipal frmMenuPrincipal = new FrmMenuPrincipal();
                CtrlMenuPrincipal ctrlMenuPrincipal = new CtrlMenuPrincipal(frmMenuPrincipal);
                ctrlMenuPrincipal.start();
                this.frmLogin.dispose();
            } else {
                JOptionPane
                        .showMessageDialog(this.frmLogin
                        , mensajesDeError
                        , "Errores de usuario"
                        , JOptionPane.ERROR_MESSAGE
                        , null);
            }
        }
        if (e.getSource() == this.frmLogin.getBtnCerrar()) {
            System.exit(0);
        }
    }

    private String camposValidos(UsuarioSistema user) {
        if (user == null) {
            return "-Credenciales inválidas";
        }
        return "";
    }
}
