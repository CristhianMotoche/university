package ec.edu.epn.programacion.pojos;

import java.util.Date;

/**
 * POJO Cliente
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class Cliente
    extends Persona {

    // Atributos de la clase
    private String celular;
    private double sueldo;

    /**
     * Constructor sin parámetros
     */
    public Cliente() {
        super.setId();
    }

    /**
     * Constructor
     * @param nombre Nombre del cliente
     */
    public Cliente(String nombre){
        this.setNombre(nombre);
    }

    /**
     * Constructor con todos los parámetros para crear un cliente
     * @param celular
     * @param sueldo
     * @param nombre Nombre del cliente
     * @param edad
     * @param fechaNacimiento
     * @param email
     */
    public Cliente(String celular, double sueldo, String nombre, byte edad, Date fechaNacimiento, String email) {
        super(nombre, edad, fechaNacimiento, email);
        this.celular = celular;
        this.sueldo = sueldo;
    }

    /**
     * Constructor con todos los parámetros para crear un cliente
     * @param celular
     * @param sueldo
     * @param nombre Nombre del cliente
     * @param edad
     * @param fechaNacimiento
     * @param email
     */
    public Cliente(int id, String celular, double sueldo, String nombre, byte edad, Date fechaNacimiento, String email) {
        super(id, nombre, edad, fechaNacimiento, email);
        this.celular = celular;
        this.sueldo = sueldo;
    }

    /**
     * Obtener celular
     * @return Celular del usuario
     */
    public String getCelular() {
        return celular;
    }

    /**
     * Asignar celular
     * @param celular
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * Obtener celular
     * @return Celular del usuario
     */
    public double getSueldo() {
        return sueldo;
    }

    /**
     * Asignar sueldo
     * @param sueldo
     */
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}
