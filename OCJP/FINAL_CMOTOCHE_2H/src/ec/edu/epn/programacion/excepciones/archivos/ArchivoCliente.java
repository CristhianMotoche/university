package ec.edu.epn.programacion.excepciones.archivos;

import ec.edu.epn.programacion.interfaces.InterfazAdministracion;
import ec.edu.epn.programacion.pojos.Cliente;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class ArchivoCliente
    implements InterfazAdministracion {

    private File archivoClientes;
    private FileReader fr;
    private BufferedReader br;
    private ArrayList<Cliente> clientes;

    /**
     * Constructor que carga clientes
     */
    public ArchivoCliente() {
        cargarClientes();
    }

    /**
     * Registra las cuentas en el archivo de clientes
     * @return bolean si pudo o no guardar los clientes.
     */
    public boolean registrarClientes(){
        try{
            FileWriter fw = new FileWriter(this.archivoClientes, false);
            BufferedWriter bw = new BufferedWriter(fw);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
            for (Cliente cliente : this.clientes) {
                bw.write( cliente.getId() + " "
                        + cliente.getCelular()+ " "
                        + cliente.getSueldo()+ " "
                        + cliente.getNombre() + " "
                        + cliente.getEdad() + " "
                        + sdf.format(cliente.getFechaNacimiento()) + " "
                        + cliente.getEmail()
                );
                bw.newLine();
            }
            bw.close();
            return true;
        } catch(IOException io){
            JOptionPane.showMessageDialog(null, "Error al intentar escribir en el archivo.");
            System.err.println("No existe el fichero.\n" + io);
            System.exit(0);
        }
        return false;
    }

    @Override
    public String crear(Object obj) {
        Cliente cliente = (Cliente) obj;
        this.clientes.add(cliente);
        if (registrarClientes()) {
            return "Se ha creado un nuevo cliente";
        } else {
            return "Existió un error interno.\nNo se creó el cliente";
        }
    }

    @Override
    public String actualizar(Object obj) {
        Cliente cliente = (Cliente) obj;
        for (int i = 0; i < this.clientes.size(); i++) {
            if (this.clientes.get(i).equals(cliente)) {
                this.clientes.get(i).setNombre(cliente.getNombre());
                this.clientes.get(i).setEmail(cliente.getEmail());
                this.clientes.get(i).setFechaNacimiento(cliente.getFechaNacimiento());
                this.clientes.get(i).setEdad(cliente.getEdad());
                this.clientes.get(i).setCelular(cliente.getCelular());
                this.clientes.get(i).setSueldo(cliente.getSueldo());
            }
        }

        if (registrarClientes()) {
            return "Se actualizó el cliente";
        } else {
            return "Existió un error interno.\nNo se actualizó el cliente";
        }
    }

    @Override
    public String borrar(Object obj) {
        Cliente cliente  = (Cliente) obj;
        for (int i = 0; i < this.clientes.size(); i++) {
            if (this.clientes.get(i).equals(cliente )) {
                this.clientes.remove(i);
            }
        }

        if (registrarClientes()) {
            return "Se eliminó al  cliente";
        } else {
            return "No se eliminó al cliente";
        }
    }

    @Override
    public Object buscarPorParametro(List lista, Object parametro) {
        List<Cliente> clientes = lista;
        int id = (int) parametro;
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public List listar() {
        cargarClientes();
        return this.clientes;
    }

    private void cargarClientes(){
        try {
            this.clientes = new ArrayList();
            this.archivoClientes = new File("./clientes.txt");
            fr = new FileReader(this.archivoClientes);
            br = new BufferedReader(fr);

            try {
                String linea;
                while((linea = br.readLine())!= null){
                    String contenidoLinea [] = linea.split(" ");
                    int id = Integer.parseInt(contenidoLinea[0]);
                    String telefono = contenidoLinea[1];
                    Double sueldo = Double.parseDouble(contenidoLinea[2]);
                    String nombre = contenidoLinea[3];
                    byte edad = new Byte(contenidoLinea[4]);
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    Date fechaNac = sdf.parse(contenidoLinea[5]);
                    String email = contenidoLinea[6];
                    Cliente cliente = new Cliente(id, telefono, sueldo, nombre, edad, fechaNac, email);
                    clientes.add(cliente);
                }
                br.close();
            } catch (IOException | NumberFormatException | ParseException ex) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error al intentar leer el archivo");
                System.err.println("Ocurrió un error al intentar leer el archivo: \n" + ex);
                System.exit(0);
            }
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "No existe el archivo de clientes");
            System.err.println("No existe el archivo.");
            System.exit(0);
        }
    }
}
