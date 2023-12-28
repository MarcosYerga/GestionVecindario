package controlador;

import java.sql.*;
import javax.swing.JOptionPane;
import dao.FacturaDAO;
import modelo.Factura;
import vista.VerGastosAdmin;

/**
 * Calse que lleva la parte lógica de las facturas
 * @author Marcos Yerga Gomez
 */
public class FacturaController {
    /**
     * Constructor que sirve para crear facturas
     */
    public FacturaController() {
    }
    /**
    * Método que crea facturas 
    *
    */
    public void crearFactura(int idGasto, String proveedor) {
        GastoController mensajero = new GastoController();
        String fecha = mensajero.consultarFechaPago();
        float importe = Float.parseFloat(mensajero.consultarImporte());
        Factura factura = new Factura(idGasto, proveedor, importe, fecha);
        FacturaDAO facturaDAO = new FacturaDAO();
        facturaDAO.crearFactura(factura);
    }
    /**
     * Sirve para consultar el proveedor
     *
     * @return 
     */
    public String consultarProveedor() {
        int ID = consultarID();
        String result = "";
        FacturaDAO facturaDAO = new FacturaDAO();
        result = facturaDAO.consultarProveedor(ID);
        return result;
    }

    /**
     * Sirve para obtener el ID de la factura
     * @return 
     */
    public int consultarID() {
        int idGasto = VerGastosAdmin.idGasto;
        int result = 0;
        FacturaDAO facturaDAO = new FacturaDAO();
        result = facturaDAO.consultarID(idGasto);
        return result;
    }
}
