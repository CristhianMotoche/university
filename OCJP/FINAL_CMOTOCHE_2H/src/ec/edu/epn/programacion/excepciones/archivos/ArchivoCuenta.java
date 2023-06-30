package ec.edu.epn.programacion.excepciones.archivos;

import ec.edu.epn.programacion.interfaces.InterfazAdministracion;
import ec.edu.epn.programacion.pojos.Cuenta;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class ArchivoCuenta
    implements InterfazAdministracion {

    private File archivoClientes;
    private FileReader fr;
    private BufferedReader br;
    private ArrayList<Cuenta> cuentas;

    /**
     * Constructor que carga las cuentas
     */
    public ArchivoCuenta() {
        cargarCuentas();
    }

    /**
     * Registra las cuentas en el archivo de cuentas
     * @return bolean si pudo o no guardar las cuentas.
     */
    public boolean registrarCuentas(){
        try{
            FileWriter fw = new FileWriter(this.archivoClientes, false);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Cuenta cuenta : this.cuentas) {
                bw.write( cuenta.getNumeroCta()+ " "
                        + cuenta.getSaldoInicial()+ " "
                        + cuenta.getSaldoActual()+ " "
                        + cuenta.getNombreCliente()
                );
                bw.newLine();
            }
            bw.close();
            return true;
        } catch(IOException io){
            JOptionPane.showMessageDialog(null, "Error en la escritura del archivo.");
            System.err.println("No existe el fichero.\n" + io);
            System.exit(0);
        }
        return false;
    }

    @Override
    public String crear(Object obj) {
        Cuenta cuenta = (Cuenta) obj;
        this.cuentas.add(cuenta);
        if (registrarCuentas()) {
            return "Se ha creado una cuenta nueva.";
        } else {
            return "Existió un error interno.\nNo se creó la cuenta.";
        }
    }

    @Override
    public String actualizar(Object obj) {
        Cuenta cuenta = (Cuenta) obj;
        for (int i = 0; i < this.cuentas.size(); i++) {
            if (this.cuentas.get(i).equals(cuenta)) {
                this.cuentas.get(i).setNumeroCta(cuenta.getNumeroCta());
                this.cuentas.get(i).setSaldoActual(cuenta.getSaldoActual());
                this.cuentas.get(i).setSaldoInicial(cuenta.getSaldoInicial());
            }
        }

        if (registrarCuentas()) {
            return "Se actualizó la cuenta";
        } else {
            return "Existió un error interno.\nNo se actualizó la cuenta.";
        }
    }

    @Override
    public String borrar(Object obj) {
        Cuenta cuenta  = (Cuenta) obj;
        for (int i = 0; i < this.cuentas.size(); i++) {
            if (this.cuentas.get(i).equals(cuenta )) {
                this.cuentas.remove(i);
            }
        }

        if (registrarCuentas()) {
            return "Se eliminó la cuenta";
        } else {
            return "No se eliminó la cuenta";
        }
    }

    @Override
    public Object buscarPorParametro(List lista, Object parametro) {
        return new Object();
    }

    @Override
    public List listar() {
        cargarCuentas();
        return this.cuentas;
    }

    private void cargarCuentas(){
        try {
            this.cuentas = new ArrayList();
            this.archivoClientes = new File("./cuentas.txt");
            fr = new FileReader(this.archivoClientes);
            br = new BufferedReader(fr);

            try {
                String linea;
                while((linea = br.readLine())!= null){
                    String contenidoLinea [] = linea.split(" ");
                    String numeroCuenta = contenidoLinea[0];
                    double saldoInicial = Double.parseDouble(contenidoLinea[1]);
                    double sueldoActual = Double.parseDouble(contenidoLinea[2]);
                    String nombre = contenidoLinea[3];
                    Cuenta cuenta = new Cuenta(numeroCuenta, saldoInicial, sueldoActual, nombre);
                    this.cuentas.add(cuenta);
                }
                br.close();
            } catch (IOException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al leer el archivo");
                System.err.println("Ocurrió un error al leer el archivo: \n" + ex);
                System.exit(0);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "No existe el fichero de clientes");
            System.err.println("No existe el fichero.");
            System.exit(0);
        }
    }
}
