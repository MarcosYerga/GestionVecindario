package controlador;

import java.sql.*;
import javax.swing.JOptionPane;
import dao.InmuebleDAO;
import modelo.Inmueble;
import vista.SubMenuInmueblesAdmin;

/**
 * clase que sirve para llevar la parte logica de los inmuebles
 *
 * @author Marcos Yerga Gomez
 */
public class InmuebleController {
    /**
     * Constructor de la clase para usar métodos que no requieren parametros de
     * entrada
     */
    public InmuebleController() {
    }
    /**
     * Metodo que sirve para crear inmuebles
     */
    public void crearInmueble(String calle, int numero, String portal, String piso) {
        Inmueble inmueble = new Inmueble(calle,numero,portal,piso);
        InmuebleDAO inmuebleDAO = new InmuebleDAO();
        inmuebleDAO.crearInmueble(inmueble);

    }

    /**
     * sirve para eliminar inmubles
     */
    public void eliminarInmueble() {
        int ID = SubMenuInmueblesAdmin.idInmueble;
        InmuebleDAO inmuebleDAO = new InmuebleDAO();
        inmuebleDAO.eliminarInmueble(ID);
    }

    /**
     * sirve para consultar la calle de un inmueble
     *
     * @return
     */
    public String consultarCalle() {
        int ID = SubMenuInmueblesAdmin.idInmueble;
        String result = "";
        InmuebleDAO inmuebleDAO = new InmuebleDAO();
        result = inmuebleDAO.consultarCalle(ID);
        return result;
    }

    /**
     * sirve para consultar el numero de la calle
     *
     * @return
     */
    public String consultarNumero() {
        int ID = SubMenuInmueblesAdmin.idInmueble;
        String result = "";
        InmuebleDAO inmuebleDAO = new InmuebleDAO();
        result = inmuebleDAO.consultarNumero(ID);
        return result;
    }

    /**
     * sirve para consultar el numero de la calle
     *
     * @return
     */
    public String consultarPiso() {
        int ID = SubMenuInmueblesAdmin.idInmueble;
        String result = "";
        InmuebleDAO inmuebleDAO = new InmuebleDAO();
        result = inmuebleDAO.consultarPiso(ID);
        return result;
    }

    /**
     * sirve para consultar el numero de la calle
     *
     * @return
     */
    public String consultarPortal() {
        int ID = SubMenuInmueblesAdmin.idInmueble;
        String result = "";
        InmuebleDAO inmuebleDAO = new InmuebleDAO();
        result = inmuebleDAO.consultarPortal(ID);
        return result;
    }

    /**
     * sirve para consultar el propietario del inmueble
     *
     * @return
     */
    public String consultarPropietario() {
        int ID = SubMenuInmueblesAdmin.idInmueble;
        String result = "";
        InmuebleDAO inmuebleDAO = new InmuebleDAO();
        result = inmuebleDAO.consultarPropietario(ID);
        return result;
    }

    /**
     * Sirve para modificar los datos de un Inmuebles
     */
    public void modificarInmueble(String calle, int numero, String portal, String piso) {
        Inmueble inmueble = new Inmueble(calle,numero,portal,piso);
        InmuebleDAO inmuebleDAO = new InmuebleDAO();
        inmuebleDAO.modificarInmueble(inmueble);
    }

    /**
     * Sirve para asociar el inmueble a un usuario
     */
    public void asociarInmueble(int idPropietario) {
        int ID = SubMenuInmueblesAdmin.idInmueble;
        InmuebleDAO inmuebleDAO = new InmuebleDAO();
        inmuebleDAO.asociarInmueble(ID, idPropietario);
    }
}
