/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.epn.pojos;

import java.util.Date;

/**
 *
 * @author Cristhian Motoche
 */
public class Persona {
    private int id;

    /**
     * Protected attributes
     */
    protected String nombre;
    protected byte edad;
    protected String email;

    /**
     * Private attributes
     */
    private Date fechaNacimiento;
    private Double sueldo;

    /**
     * Public attributes
     */
    public static char PAIS = 'E';
    public static int COUNTER = 0;

    /**
     * Empty Constructor
     */
    public Persona() {
    }

    /**
     *
     * Constructor with parameters
     *
     * @param nombre
     * @param edad
     * @param fechaNacimiento
     * @param sueldo
     * @param email
     */
    public Persona(String nombre, byte edad, Date fechaNacimiento, Double sueldo, String email) {
        this.nombre = nombre;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.sueldo = sueldo;
        this.email = email;
        this.id = ++Persona.COUNTER;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @return
     */
    public byte getEdad() {
        return edad;
    }

    /**
     *
     * @return
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     *
     * @return
     */
    public Double getSueldo() {
        return sueldo;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param id
     */
    public void setId() {
        this.id = ++Persona.COUNTER;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @param edad
     */
    public void setEdad(byte edad) {
        this.edad = edad;
    }

    /**
     *
     * @param fechaNacimiento
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     *
     * @param sueldo
     */
    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
