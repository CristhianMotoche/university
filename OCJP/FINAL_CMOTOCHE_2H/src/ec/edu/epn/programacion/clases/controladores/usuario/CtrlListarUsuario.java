package ec.edu.epn.programacion.clases.controladores.usuario;

import ec.edu.epn.programacion.clases.vista.usuario.DlgCrearUsuario;
import ec.edu.epn.programacion.clases.vista.usuario.DlgOpcionesUsuario;
import ec.edu.epn.programacion.excepciones.archivos.ArchivoUsuario;
import ec.edu.epn.programacion.pojos.UsuarioSistema;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class CtrlListarUsuario
        implements ActionListener, KeyListener {

    private DlgOpcionesUsuario dialogOpcionesUsuario;
    private ArchivoUsuario modeloUsuario;
    private boolean remover;
    private boolean editar;

    /**
     *
     * @param dialogOpcionesUsuario
     * @param remover
     * @param editar
     */
    public CtrlListarUsuario(DlgOpcionesUsuario dialogOpcionesUsuario, boolean remover, boolean editar) {
        this.dialogOpcionesUsuario = dialogOpcionesUsuario;
        this.modeloUsuario = new ArchivoUsuario();
        this.remover = remover;
        this.editar = editar;

        if (remover) {
            this.dialogOpcionesUsuario.getBtnOpcion().setText("Eliminar");
        } else if (editar) {
            this.dialogOpcionesUsuario.getBtnOpcion().setText("Editar");
        } else {
            this.dialogOpcionesUsuario.getBtnOpcion().setVisible(false);
        }
        this.dialogOpcionesUsuario.getBtnOpcion().addActionListener(this);
        this.dialogOpcionesUsuario.getTextFieldBuscar().addKeyListener(this);
        this.dialogOpcionesUsuario.getBtnCancelar().addActionListener(this);
    }

    /**
     * Despliega la vista
     */
    public void start(){
        List<UsuarioSistema> usuarios = this.modeloUsuario.listar();
        TableModel tableModel = listToModel(usuarios);
        this.dialogOpcionesUsuario.setTableUsuarios(tableModel);

        this.dialogOpcionesUsuario.setTitle("Usuarios");

        removerColumnaId();

        this.dialogOpcionesUsuario.setLocationRelativeTo(null);
        this.dialogOpcionesUsuario.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.dialogOpcionesUsuario.getBtnOpcion() && this.remover) {
            int row = this.dialogOpcionesUsuario.getTableUsuarios().getSelectedRow();
            int rows = this.dialogOpcionesUsuario.getTableUsuarios().getSelectedRowCount();
            if (row < 1 && rows == 0) {
                JOptionPane.showMessageDialog(dialogOpcionesUsuario
                        , "Seleccione una fila"
                        , "Error"
                        , JOptionPane.ERROR_MESSAGE, null);
            } else {
                // Actualizar modelo
                List<UsuarioSistema> usuarios = this.modeloUsuario.listar();
                TableModel tableModel = listToModel(usuarios);
                this.dialogOpcionesUsuario.setTableUsuarios(tableModel);

                // Buscar usuario por id
                int id = Integer.parseInt(this.dialogOpcionesUsuario.getTableUsuarios().getStringAt(row, 0));
                UsuarioSistema user = new UsuarioSistema();
                for (UsuarioSistema usuario : usuarios) {
                    if (usuario.getId() == id) {
                        user = usuario;
                    }
                }

                // Borrar usuario
                if (JOptionPane.showConfirmDialog(dialogOpcionesUsuario, "¿Esta seguro?")
                        == JOptionPane.YES_OPTION) {
                    String result = this.modeloUsuario.borrar(user);
                    JOptionPane.showMessageDialog(dialogOpcionesUsuario, result);
                }

                // Actualizar modelo
                usuarios = this.modeloUsuario.listar();
                tableModel = listToModel(usuarios);
                this.dialogOpcionesUsuario.setTableUsuarios(tableModel);
                removerColumnaId();
            }
        }
        if (e.getSource() == this.dialogOpcionesUsuario.getBtnOpcion() && this.editar) {
            int row = this.dialogOpcionesUsuario.getTableUsuarios().getSelectedRow();
            int rows = this.dialogOpcionesUsuario.getTableUsuarios().getSelectedRowCount();
            if (row < 1 && rows == 0) {
                JOptionPane.showMessageDialog(dialogOpcionesUsuario
                        , "Seleccione una sola fila"
                        , "Error"
                        , JOptionPane.ERROR_MESSAGE, null);
            } else {
                // Actualizar modelo
                List<UsuarioSistema> usuarios = this.modeloUsuario.listar();
                DefaultTableModel tableModel = listToModel(usuarios);
                this.dialogOpcionesUsuario.setTableUsuarios(tableModel);

                // Buscar usuario por id
                UsuarioSistema user = new UsuarioSistema();
                int identificador = Integer.parseInt(this.dialogOpcionesUsuario.getTableUsuarios().getStringAt(row, 0));

                for (UsuarioSistema usuario : usuarios) {
                    if (usuario.getId() == identificador) {
                        user = usuario;
                    }
                }

                // Editar usuario
                DlgCrearUsuario dcu = new DlgCrearUsuario(dialogOpcionesUsuario, true);
                CtrlNuevoUsuario cnu = new CtrlNuevoUsuario(dcu, user);
                cnu.start();

                // Actualizar modelo
                usuarios = this.modeloUsuario.listar();
                tableModel = listToModel(usuarios);
                this.dialogOpcionesUsuario.setTableUsuarios(tableModel);
                ((DefaultTableModel) this.dialogOpcionesUsuario.getTableUsuarios().getModel()).fireTableDataChanged();
                removerColumnaId();
            }
        }
        if (e.getSource() == this.dialogOpcionesUsuario.getBtnCancelar()) {
            this.dialogOpcionesUsuario.dispose();
        }
    }

    private DefaultTableModel listToModel(List<UsuarioSistema> usuarios) {
        Object [] columns = {"Id", "Nombre", "Edad", "Fecha Nac.", "Email"};
        Object [][] data = new Object[usuarios.size()][columns.length];
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < usuarios.size(); i++) {
            data[i][0] = usuarios.get(i).getId();
            data[i][1] = usuarios.get(i).getNombre();
            data[i][2] = usuarios.get(i).getEdad();
            data[i][3] = sdf.format(usuarios.get(i).getFechaNacimiento());
            data[i][4] = usuarios.get(i).getEmail();
        }
        return new DefaultTableModel(data, columns);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        DefaultTableModel dtm = (DefaultTableModel) this.dialogOpcionesUsuario.getTableUsuarios().getModel();
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(dtm);
        this.dialogOpcionesUsuario.getTableUsuarios().setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter(this.dialogOpcionesUsuario.getTextFieldBuscar().getText()));
    }

    private void removerColumnaId() {
        TableColumnModel tcm = this.dialogOpcionesUsuario.getTableUsuarios().getColumnModel();
        tcm.removeColumn(tcm.getColumn(tcm.getColumnIndex("Id")));
    }
}
