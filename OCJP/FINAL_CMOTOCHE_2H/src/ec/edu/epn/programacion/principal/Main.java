package ec.edu.epn.programacion.principal;

import ec.edu.epn.programacion.clases.controladores.CtrlLogin;
import ec.edu.epn.programacion.clases.vista.FrmLogin;

/**
 * Clase principal que ejecuta la aplicación
 * @author Cristhian Motoche (cristhian.motoche@epn.edu.ec)
 */
public class Main {
    
    /**
     * Función principal para ejecutar la aplicación
     * @param args
     */
    public static void main(String args[]){
        FrmLogin frmLogin = new FrmLogin();
        CtrlLogin ctrlLogin = new CtrlLogin(frmLogin);
        ctrlLogin.start();
    }
}
