package ec.edu.epn.programacion.clases.controladores.usuario;

import ec.edu.epn.programacion.clases.vista.usuario.DlgCrearUsuario;
import ec.edu.epn.programacion.excepciones.archivos.ArchivoUsuario;
import ec.edu.epn.programacion.pojos.UsuarioSistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class CtrlNuevoUsuario
        implements ActionListener {

    private DlgCrearUsuario dialogCrearUsuario;
    private ArchivoUsuario modeloUsuario;
    private boolean editar;

    /**
     *
     * @param dialogCrearUsuario
     */
    public CtrlNuevoUsuario(DlgCrearUsuario dialogCrearUsuario) {
        this.dialogCrearUsuario = dialogCrearUsuario;
        this.modeloUsuario = new ArchivoUsuario();
        this.editar = false;

        this.dialogCrearUsuario.getBtnAceptar().addActionListener(this);
        this.dialogCrearUsuario.getBtnCancelar().addActionListener(this);
    }

    /**
     *
     * @param dialogCrearUsuario
     * @param usuarioEditar
     */
    public CtrlNuevoUsuario(DlgCrearUsuario dialogCrearUsuario, UsuarioSistema usuarioEditar) {
        this.dialogCrearUsuario = dialogCrearUsuario;
        this.modeloUsuario = new ArchivoUsuario();
        this.editar = true;

        this.dialogCrearUsuario.setTxtId(usuarioEditar.getId());
        this.dialogCrearUsuario.setTxtNombre(usuarioEditar.getNombre());
        this.dialogCrearUsuario.setTxtEdad(Byte.toString(usuarioEditar.getEdad()));
        this.dialogCrearUsuario.setDateFechaNac(usuarioEditar.getFechaNacimiento());
        this.dialogCrearUsuario.setTxtEmail(usuarioEditar.getEmail());
        this.dialogCrearUsuario.setTxtLogin(usuarioEditar.getLogin());
        this.dialogCrearUsuario.setTxtPass(usuarioEditar.getPassword());

        this.dialogCrearUsuario.getBtnAceptar().addActionListener(this);
        this.dialogCrearUsuario.getBtnCancelar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.dialogCrearUsuario.getBtnAceptar() && editar) {
            String mensajesDeError = camposValidos();
            if(mensajesDeError.isEmpty()){
                UsuarioSistema user = getDatosUsuario();
                user.setId(this.dialogCrearUsuario.getId());
                String result = this.modeloUsuario.actualizar(user);
                JOptionPane.showMessageDialog(this.dialogCrearUsuario, result);
                this.dialogCrearUsuario.dispose();
            } else {
                JOptionPane.showMessageDialog(this.dialogCrearUsuario
                        , mensajesDeError
                        , "Errores"
                        , JOptionPane.ERROR_MESSAGE
                        , null);
            }
        }
        if (e.getSource() == this.dialogCrearUsuario.getBtnAceptar() && !editar) {
            String mensajesDeError = camposValidos();
            if(mensajesDeError.isEmpty()){
                UsuarioSistema user = getDatosUsuario();
                user.setId();
                String result = this.modeloUsuario.crear(user);
                JOptionPane.showMessageDialog(this.dialogCrearUsuario, result);
                this.dialogCrearUsuario.dispose();
            } else {
                JOptionPane.showMessageDialog(this.dialogCrearUsuario
                        , mensajesDeError
                        , "Errores"
                        , JOptionPane.ERROR_MESSAGE
                        , null);
            }
        }
        if (e.getSource() == this.dialogCrearUsuario.getBtnCancelar()) {
            this.dialogCrearUsuario.dispose();
        }
    }

    private UsuarioSistema getDatosUsuario() {
        UsuarioSistema user = new UsuarioSistema();
        user.setNombre(this.dialogCrearUsuario.getTxtNombre());
        user.setEdad(new Byte(this.dialogCrearUsuario.getTxtEdad()));
        user.setFechaNacimiento(this.dialogCrearUsuario.getDateFechaNac());
        user.setEmail(this.dialogCrearUsuario.getTxtEmail());
        user.setLogin(this.dialogCrearUsuario.getTxtLogin());
        user.setPassword(this.dialogCrearUsuario.getPass());
        return user;
    }

    /**
     * Despliega la vista
     */
    public void start() {
        this.dialogCrearUsuario.setTitle("Usuario");
        this.dialogCrearUsuario.setLocationRelativeTo(null);
        this.dialogCrearUsuario.setVisible(true);
    }

    private String camposValidos(){
        String errores = "";
        String nombre = this.dialogCrearUsuario.getTxtNombre();
        String login = this.dialogCrearUsuario.getTxtLogin();
        String password = this.dialogCrearUsuario.getPass();
        String email = this.dialogCrearUsuario.getTxtEmail();

        if (nombre.isEmpty()) {
            errores += "\n-El nombre no puede estar vacio.";
        }
        if (nombre.contains(" ")) {
            errores += "\n-El nombre no debe tener espacios.";
        }
        if (login.isEmpty()) {
            errores += "\n-El login no puede estar vacio.";
        }
        if (password.isEmpty()) {
            errores += "\n-La contraseña no puede estar vacia.";
        }
        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
        Matcher m = p.matcher(email);
        if (!m.matches()) {
            errores += "\n-Email no válido (Ej: usuario@domain.com)";
        }
        try {
            byte edad = new Byte(this.dialogCrearUsuario.getTxtEdad());
        } catch (NumberFormatException e){
            errores += "\n-La edad debe ser un número";
        }
        return errores;
    }
}
