package controlador;

import java.sql.*;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import dao.ConceptoDAO;
import modelo.Concepto;
import vista.VerGastosAdmin;

/**
 * Clase que lleva la parte logica de los conceptos
 *
 * @author Marcos Yerga Gomez
 */
public class ConceptoController {

    /**
     * Constructor para usar metodos que no requieren de parametros
     */
    public ConceptoController() {
    }

    //métodos
    /**
     * Sirve para crear nuevo concepto
     */
    public void crearConcepto(String descripcion) {
        int idGasto = VerGastosAdmin.idGasto;
        String fecha = obtenerFecha();
        Concepto concepto = new Concepto(idGasto, fecha, descripcion);
        ConceptoDAO conceptoDAO = new ConceptoDAO();
        conceptoDAO.crearConcepto(concepto);
    }

    /**
     * Sirve para eliminar un concepto
     */
    public void eliminarConcepto() {
        int idGasto = VerGastosAdmin.idGasto;
        ConceptoDAO conceptoDAO = new ConceptoDAO();
        conceptoDAO.eliminarConcepto(idGasto);
    }

    /**
     * Sirve para actualizar los valores del concepto
     */
    public void modificarConcepto(String descripcion) {
        int idGasto = VerGastosAdmin.idGasto;
        String fecha = obtenerFecha();
        Concepto concepto = new Concepto(idGasto, fecha, descripcion);
        ConceptoDAO conceptoDAO = new ConceptoDAO();
        conceptoDAO.modificarConcepto(concepto);
    }

    /**
     * Sirve para consultar la fecha en la que se ha registrado
     *
     * @return
     */
    public String consultarFecha() {
        int idGasto = VerGastosAdmin.idGasto;
        String result = "";
        ConceptoDAO conceptoDAO = new ConceptoDAO();
        result = conceptoDAO.consultarFecha(idGasto);
        return result;
    }

    /**
     * Este metodo sirve para consultar la descripcion
     *
     * @return
     */
    public String consultarDescripcion() {
        int idGasto = VerGastosAdmin.idGasto;
        String result = "";
        ConceptoDAO conceptoDAO = new ConceptoDAO();
        result = conceptoDAO.consultarDescripcion(idGasto);
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
