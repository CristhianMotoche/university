package ec.edu.epn.programacion.clases.controladores.cuenta;

import ec.edu.epn.programacion.clases.vista.cuenta.DlgListaCuenta;
import ec.edu.epn.programacion.excepciones.archivos.ArchivoCuenta;
import ec.edu.epn.programacion.pojos.Cuenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class CtrlListarCuentas
        implements ActionListener, KeyListener {

    private DlgListaCuenta dialogListaCuenta;
    private ArchivoCuenta modeloCuenta;

    /**
     *
     * @param dialogListaCuenta
     */
    public CtrlListarCuentas(DlgListaCuenta dialogListaCuenta) {
        this.dialogListaCuenta = dialogListaCuenta;
        this.modeloCuenta = new ArchivoCuenta();

        this.dialogListaCuenta.getBtnCancelar().addActionListener(this);
        this.dialogListaCuenta.getTextFieldBuscar().addKeyListener(this);
    }

    /**
     * Permite iniciar la visualización de la ventana
     */
    public void start(){
        List<Cuenta> cuentas = this.modeloCuenta.listar();
        this.dialogListaCuenta.setTitle("Cuentas");
        this.dialogListaCuenta.setTableCuentas(listToModel(cuentas));
        this.dialogListaCuenta.setLocationRelativeTo(null);
        this.dialogListaCuenta.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.dialogListaCuenta.getBtnCancelar()) {
            this.dialogListaCuenta.dispose();
        }
    }

    private TableModel listToModel(List<Cuenta> cuentas) {
        String columnNames[] = { "Cuenta", "Clienta", "Saldo Inicial", "Saldo Actual" };
        Object data[][] = new Object [cuentas.size()][columnNames.length];
        for (int i = 0; i < cuentas.size(); i++) {
            data[i][0] = cuentas.get(i).getNumeroCta();
            data[i][1] = cuentas.get(i).getNombreCliente();
            data[i][2] = cuentas.get(i).getSaldoInicial();
            data[i][3] = cuentas.get(i).getSaldoActual();
        }

        DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
        return dtm;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        DefaultTableModel dtm = (DefaultTableModel) this.dialogListaCuenta.getTableCuentas().getModel();
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(dtm);
        this.dialogListaCuenta.getTableCuentas().setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter(this.dialogListaCuenta.getTxtBuscar()));
    }
}
