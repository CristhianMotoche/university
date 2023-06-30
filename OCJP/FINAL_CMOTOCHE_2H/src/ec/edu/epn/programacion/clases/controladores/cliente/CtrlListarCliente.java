package ec.edu.epn.programacion.clases.controladores.cliente;

import ec.edu.epn.programacion.clases.vista.cliente.DlgCrearCliente;
import ec.edu.epn.programacion.clases.vista.cliente.DlgOpcionesCliente;
import ec.edu.epn.programacion.excepciones.archivos.ArchivoCliente;
import ec.edu.epn.programacion.pojos.Cliente;
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
public class CtrlListarCliente
    implements ActionListener, KeyListener {
    private DlgOpcionesCliente dialogOpcionesCliente;
    private ArchivoCliente modeloCliente;
    private boolean remover;
    private boolean editar;

    /**
     *
     * @param dialogOpcionesCliente
     * @param remover
     * @param editar
     */
    public CtrlListarCliente(DlgOpcionesCliente dialogOpcionesCliente, boolean remover, boolean editar) {
        this.dialogOpcionesCliente = dialogOpcionesCliente;
        this.modeloCliente = new ArchivoCliente();
        this.remover = remover;
        this.editar = editar;

        if (remover) {
            this.dialogOpcionesCliente.getBtnOpcion().setText("Eliminar");
        } else if (editar) {
            this.dialogOpcionesCliente.getBtnOpcion().setText("Editar");
        } else {
            this.dialogOpcionesCliente.getBtnOpcion().setVisible(false);
        }
        this.dialogOpcionesCliente.getBtnOpcion().addActionListener(this);
        this.dialogOpcionesCliente.getTextFieldBuscar().addKeyListener(this);
        this.dialogOpcionesCliente.getBtnCancelar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.dialogOpcionesCliente.getBtnOpcion() && this.remover) {
            int row = this.dialogOpcionesCliente.getTableClientes().getSelectedRow();
            int rows = this.dialogOpcionesCliente.getTableClientes().getSelectedRowCount();
            if (row < 1 && rows == 0) {
                JOptionPane.showMessageDialog(dialogOpcionesCliente
                        , "-Debe seleccionar una sola fila"
                        , "Error"
                        , JOptionPane.ERROR_MESSAGE, null);
            } else {
                // Actualizar modelo
                List<Cliente> clientes = this.modeloCliente.listar();
                TableModel tableModel = listToModel(clientes);
                this.dialogOpcionesCliente.setTableClientes(tableModel);

                // Buscar usuario por id
                int id = Integer.parseInt(this.dialogOpcionesCliente.getTableClientes().getStringAt(row, 0));
                Cliente cliente = (Cliente) this.modeloCliente.buscarPorParametro(this.modeloCliente.listar(), id);

                // Borrar usuario
                if (JOptionPane.showConfirmDialog(dialogOpcionesCliente, "¿Esta seguro?")
                        == JOptionPane.YES_OPTION) {
                    String result = this.modeloCliente.borrar(cliente);
                    JOptionPane.showMessageDialog(dialogOpcionesCliente, result);
                }

                // Actualizar modelo
                clientes = this.modeloCliente.listar();
                tableModel = listToModel(clientes);
                this.dialogOpcionesCliente.setTableClientes(tableModel);
                removerColumnaId();
            }
        }
        if(e.getSource() == this.dialogOpcionesCliente.getBtnOpcion() && this.editar){
            int row = this.dialogOpcionesCliente.getTableClientes().getSelectedRow();
            int rows = this.dialogOpcionesCliente.getTableClientes().getSelectedRowCount();
            if (row < 1 && rows == 0) {
                JOptionPane.showMessageDialog(dialogOpcionesCliente
                        , "-Debe seleccionar una sola fila"
                        , "Error"
                        , JOptionPane.ERROR_MESSAGE, null);
            } else {
                // Actualizar modelo
                List<Cliente> clientes = this.modeloCliente.listar();
                TableModel tableModel = listToModel(clientes);
                this.dialogOpcionesCliente.setTableClientes(tableModel);

                // Buscar usuario por login y password
                int id = Integer.parseInt(this.dialogOpcionesCliente.getTableClientes().getStringAt(row, 0));
                Cliente cliente = (Cliente) this.modeloCliente.buscarPorParametro(this.modeloCliente.listar(), id);

                DlgCrearCliente dcc = new DlgCrearCliente(dialogOpcionesCliente, true);
                CtrlNuevoCliente cnc = new CtrlNuevoCliente(dcc, cliente);
                cnc.start();

                // Actualizar modelo
                clientes = this.modeloCliente.listar();
                tableModel = listToModel(clientes);
                this.dialogOpcionesCliente.setTableClientes(tableModel);
                ((DefaultTableModel) this.dialogOpcionesCliente.getTableClientes().getModel()).fireTableDataChanged();
                removerColumnaId();
            }
        }
        if (e.getSource() == this.dialogOpcionesCliente.getBtnCancelar()) {
            this.dialogOpcionesCliente.dispose();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        DefaultTableModel dtm = (DefaultTableModel) this.dialogOpcionesCliente.getTableClientes().getModel();
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(dtm);
        this.dialogOpcionesCliente.getTableClientes().setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter(this.dialogOpcionesCliente.getTextFieldBuscar().getText()));
    }

    /**
     * Permite iniciar la visualización de la ventana
     */
    public void start() {
        List<Cliente> clientes = this.modeloCliente.listar();
        TableModel tableModel = listToModel(clientes);
        this.dialogOpcionesCliente.setTableClientes(tableModel);
        removerColumnaId();
        this.dialogOpcionesCliente.setTitle("Clientes");
        this.dialogOpcionesCliente.setLocationRelativeTo(null);
        this.dialogOpcionesCliente.setVisible(true);
    }

    private DefaultTableModel listToModel(List<Cliente> clientes) {
        Object [] columns = {"Id", "Nombre", "Edad", "Fecha Nac.", "Email", "Teléfono", "Sueldo"};
        Object [][] data = new Object[clientes.size()][columns.length];
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 0; i < clientes.size(); i++) {
            data[i][0] = clientes.get(i).getId();
            data[i][1] = clientes.get(i).getNombre();
            data[i][2] = clientes.get(i).getEdad();
            data[i][3] = sdf.format(clientes.get(i).getFechaNacimiento());
            data[i][4] = clientes.get(i).getEmail();
            data[i][5] = clientes.get(i).getCelular();
            data[i][6] = clientes.get(i).getSueldo();
        }
        return new DefaultTableModel(data, columns);
    }

    private void removerColumnaId() {
        TableColumnModel tcm = this.dialogOpcionesCliente.getTableClientes().getColumnModel();
        tcm.removeColumn(tcm.getColumn(tcm.getColumnIndex("Id")));
    }
}
