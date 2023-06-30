package ec.edu.epn.programacion.interfaces;

import java.util.*;

/**
 * Esta interface nos permite manejar las operaciones CRUD al momento de persistir los datos del programa.
 * CRUD --> Create (crear), Read (Listar), Update (actualizar), Delete (borrar)
 * 
 * @author nelson salgado 
 * @version 2017-01-07
 */

public interface InterfazAdministracion {
    /**
     * Metodo que permite crear en la coleccion un nuevo Objeto de cualquier clase.
     * @param obj Es el nuevo Objeto que se va a crear
     * @return Un mensaje para alertar al usuario
     */    
    public String crear(Object obj);
    
    /**
     * Metodo que permite actualizar el estado de un Objeto de la coleccion.
     * @param obj El Objeto a ser actualizado
     * @return Un mensaje para alertar al usuario
     */
    public String actualizar(Object obj);
    
    /**
     * Metodo que permite eliminar un Objeto de la coleccion
     * @param obj El Objeto a ser eliminado
     * @return Un mensaje para alertar al usuario
     */
    public String borrar(Object obj);
    
    /**
     * Metodo que permite buscar un Objeto dentro de la coleccion
     * @param lista La coleccion donde se va a buscar
     * @param parametro El parametro del Objeto que se está buscando
     * @return El Objeto encontrado, si el objeto no existe, retorna null
     */
    public Object buscarPorParametro(List lista, Object parametro);
        
    /**
     * Metodo que permita listar los Objetos que se encuentran en la coleccion
     * @return La lista de Objetos almacenados
     */
    public List listar();
}
