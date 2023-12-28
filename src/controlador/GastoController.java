package controlador;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import dao.ConceptoDAO;
import dao.FacturaDAO;
import dao.GastoDAO;
import modelo.Gasto;
import vista.VerGastosAdmin;

/**
 * Clase que lleva toda la parte logica de los gastos
 *
 * @author Marcos Yerga Gomez
 */
public class GastoController {

    /**
     * Contructor que se usa para los métodos que no llevan parametros
     */
    public GastoController() {
    }

    //metodos
    /**
     * Sirve para crear nuevo gasto asociado a un servicio
     */
    public void crearGasto(float importe, String servicioAsociado, String fechaPago) {
        String fechaRegistro = obtenerFecha();
        Gasto gasto = new Gasto(importe, servicioAsociado, fechaRegistro, fechaPago);
        GastoDAO gastoDAO = new GastoDAO();
        gastoDAO.crearGasto(gasto);
    }

    /**
     * Sirve para actualizar los atributos del gasto
     */
    public void modificarGasto(float importe, String servicioAsociado, String fechaRegistro, String fechaPago) {
        Gasto gasto = new Gasto(importe, servicioAsociado, fechaRegistro, fechaPago);
        GastoDAO gastoDAO = new GastoDAO();
        gastoDAO.modificarGasto(gasto, servicioAsociado);
    }

    /**
     * Sirve para eliminar gastos
     */
    public void eliminarGasto() {
        int ID = VerGastosAdmin.idGasto;
        GastoDAO gastoDAO = new GastoDAO();
        gastoDAO.eliminarGasto(ID);
    }

    /**
     * Sirve para consultar fecha de pago
     *
     * @return
     */
    public String consultarFechaPago() {
        int ID = VerGastosAdmin.idGasto;
        String result = "";
        GastoDAO gastoDAO = new GastoDAO();
        result = gastoDAO.consultarFechaPago(ID);
        return result;
    }

    /**
     * Sirve para consultar la fecha de Registro
     *
     * @return
     */
    public String consultarFechaRegistro() {
        int ID = VerGastosAdmin.idGasto;
        String result = "";
        GastoDAO gastoDAO = new GastoDAO();
        result = gastoDAO.consultarFechaRegistro(ID);
        return result;
    }

    /**
     * Sirve para consultar el importe
     *
     * @return
     */
    public String consultarImporte() {
        int ID = VerGastosAdmin.idGasto;
        String result = "";
        GastoDAO gastoDAO = new GastoDAO();
        result = gastoDAO.consultarImporte(ID);
        return result;
    }

    /**
     * Sirve para consultar servicio asociado
     *
     * @return
     */
    public String consultarServicio() {
        int ID = VerGastosAdmin.idGasto;
        String result = "";
        GastoDAO gastoDAO = new GastoDAO();
        result = gastoDAO.consultarServicio(ID);
        return result;
    }

    /**
     * Este metodo sirve para obtener la fecha de hoy
     *
     * @return
     */
    private String obtenerFecha() {
        LocalDate fecha = LocalDate.now();
        String mensajero = "" + fecha;
        return mensajero;
    }
}
