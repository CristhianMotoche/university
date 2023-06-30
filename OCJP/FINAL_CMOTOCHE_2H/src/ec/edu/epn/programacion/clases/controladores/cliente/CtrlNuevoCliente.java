package ec.edu.epn.programacion.clases.controladores.cliente;

import ec.edu.epn.programacion.clases.vista.cliente.DlgCrearCliente;
import ec.edu.epn.programacion.excepciones.archivos.ArchivoCliente;
import ec.edu.epn.programacion.pojos.Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class CtrlNuevoCliente
        implements ActionListener {

    private DlgCrearCliente dialogCrearCliente;
    private ArchivoCliente modeloCliente;
    private boolean editar;

    /**
     *
     * @param dialogCrearCliente
     */
    public CtrlNuevoCliente(DlgCrearCliente dialogCrearCliente) {
        this.dialogCrearCliente = dialogCrearCliente;
        this.modeloCliente = new ArchivoCliente();
        this.editar = false;

        this.dialogCrearCliente.getBtnAceptar().addActionListener(this);
        this.dialogCrearCliente.getBtnCancelar().addActionListener(this);
    }

    /**
     *
     * @param dialogCrearCliente
     * @param cliente
     */
    public CtrlNuevoCliente(DlgCrearCliente dialogCrearCliente, Cliente cliente) {
        this.dialogCrearCliente = dialogCrearCliente;
        this.modeloCliente = new ArchivoCliente();
        this.editar = true;

        this.dialogCrearCliente.setTxtId(cliente.getId());
        this.dialogCrearCliente.setTxtNombre(cliente.getNombre());
        this.dialogCrearCliente.setTxtEdad(Byte.toString(cliente.getEdad()));
        this.dialogCrearCliente.setTxtEmail(cliente.getEmail());
        this.dialogCrearCliente.setDateFechaNac(cliente.getFechaNacimiento());
        this.dialogCrearCliente.setTxtCelular(cliente.getCelular());
        this.dialogCrearCliente.setTxtSueldo(Double.toString(cliente.getSueldo()));

        this.dialogCrearCliente.getBtnAceptar().addActionListener(this);
        this.dialogCrearCliente.getBtnCancelar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.dialogCrearCliente.getBtnAceptar() && this.editar) {
            String mensajesDeError = camposValidos();
            if(mensajesDeError.isEmpty()){
                Cliente cliente = getDatosCliente();
                cliente.setId(this.dialogCrearCliente.getTxtId());
                String result = this.modeloCliente.actualizar(cliente);
                JOptionPane.showMessageDialog(this.dialogCrearCliente, result);
                this.dialogCrearCliente.dispose();
            } else {
                JOptionPane.showMessageDialog(this.dialogCrearCliente
                        , mensajesDeError
                        , "Errores"
                        , JOptionPane.ERROR_MESSAGE
                        , null);
            }
        }
        if (e.getSource() == this.dialogCrearCliente.getBtnAceptar() && !this.editar) {
            String mensajesDeError = camposValidos();
            if(mensajesDeError.isEmpty()){
                Cliente cliente = getDatosCliente();
                cliente.setId();
                String result = this.modeloCliente.crear(cliente);
                JOptionPane.showMessageDialog(this.dialogCrearCliente, result);
                this.dialogCrearCliente.dispose();
            } else {
                JOptionPane.showMessageDialog(this.dialogCrearCliente
                        , mensajesDeError
                        , "Errores"
                        , JOptionPane.ERROR_MESSAGE
                        , null);
            }
        }
        if (e.getSource() == this.dialogCrearCliente.getBtnCancelar()) {
            this.dialogCrearCliente.dispose();
        }
    }

    /*
    * String con los mensajes de error
    */
    private String camposValidos() {
        String errores = "";
        String nombre = this.dialogCrearCliente.getTxtNombre();
        String celular = this.dialogCrearCliente.getTxtCelular();
        String email = this.dialogCrearCliente.getTxtEmail();

        if (nombre.isEmpty()) {
            errores += "\n-El nombre no puede estar vacio.";
        }
        if (nombre.contains(" ")) {
            errores += "\n-El nombre no debe contener espacios.";
        }
        if (celular.isEmpty()) {
            errores += "\n-El número de celular debe estar lleno.";
        }
        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
        Matcher m = p.matcher(email);
        if (!m.matches()) {
            errores += "\n-Email no válido (Ej: usuario@domain.com)";
        }
        double sueldo = 0;
        try {
            sueldo = new Double(this.dialogCrearCliente.getTxtSueldo());
        } catch (NumberFormatException e){
            errores += "\n-El sueldo debe ser un número.";
        }

        if (sueldo <= 0) {
            errores += "\n-El sueldo debe ser positivo.";
        }

        byte edad = 0;
        try {
            edad = new Byte(this.dialogCrearCliente.getTxtEdad());
        } catch (NumberFormatException e){
            errores += "\n*La edad debe ser un número";
        }

        if (edad <= 0) {
            errores += "\n*La edad debe ser un número entero positivo";
        }

        return errores;
    }

    private Cliente getDatosCliente() {
        Cliente cliente = new Cliente();
        cliente.setId();
        cliente.setNombre(this.dialogCrearCliente.getTxtNombre());
        cliente.setEdad(new Byte(this.dialogCrearCliente.getTxtEdad()));
        cliente.setFechaNacimiento(this.dialogCrearCliente.getDateFechaNac());
        cliente.setEmail(this.dialogCrearCliente.getTxtEmail());
        cliente.setCelular(this.dialogCrearCliente.getTxtCelular());
        cliente.setSueldo(new Double(this.dialogCrearCliente.getTxtSueldo()));
        return cliente;
    }

    /**
     * Permite iniciar la visualización de la ventana
     */
    public void start() {
        this.dialogCrearCliente.setTitle("Cliente");
        this.dialogCrearCliente.setLocationRelativeTo(null);
        this.dialogCrearCliente.setVisible(true);
    }
}
