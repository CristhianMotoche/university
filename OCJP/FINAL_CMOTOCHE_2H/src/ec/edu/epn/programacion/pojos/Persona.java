package ec.edu.epn.programacion.pojos;

import java.util.Date;
import java.util.Random;

/**
 *
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class Persona {
    private int id;
    private String nombre;
    private byte edad;
    private Date fechaNacimiento;
    private String email;

    /**
     *
     */
    public static char PAIS = 'E';
    public static int PERSONAS = 9999999;
    private final Random random = new Random();

    /**
     *
     */
    public Persona() {
        setId();
    }

    /**
     *
     * @param nombre
     * @param edad
     * @param fechaNacimiento
     * @param email
     */
    public Persona(String nombre, byte edad, Date fechaNacimiento, String email) {
        setId();
        this.nombre = nombre;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
    }

    /**
     *
     * @param id
     * @param nombre
     * @param edad
     * @param fechaNacimiento
     * @param email
     */
    public Persona(int id, String nombre, byte edad, Date fechaNacimiento, String email) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
    }

    /**
     *
     */
    public final void setId() {
        this.id = random.nextInt(Persona.PERSONAS);
    }

    /**
     *
     */
    public void setId(int id) {
        this.id = id;
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
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
     * @param edad
     */
    public void setEdad(byte edad) {
        this.edad = edad;
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
     * @param fechaNacimiento
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        Persona persona = (Persona) obj;
        return persona.getId() == this.id;
    }
}
