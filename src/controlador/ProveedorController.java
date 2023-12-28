package controlador;

import dao.ProveedorDAO;
import modelo.Proveedor;
import vista.RegistroConcepto;

/**
 * Clase que sirve para gestionar la parte logica de los proveedores
 *
 * @author Marcos Yerga Gomez
 */
public class ProveedorController {

    /**
     * Constructor de la clase
     */
    public ProveedorController() {
    }

    /**
     * sirve para crear un nuevo proveedor
     * @param nombre
     * @param email
     * @param telefono
     * @param direccion
     */
    public void crearProveedor(String nombre, String email, String telefono, String direccion) {
        Proveedor proveedor = new Proveedor(nombre, email, telefono, direccion);
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        proveedorDAO.crearProveedor(proveedor);
    }

    /**
     * Sirve para obtener el email
     *
     * @return
     */
    public String consultarEmail() {
        int ID = RegistroConcepto.idProveedor;
        String result;
        ProveedorDAO proveedor = new ProveedorDAO();
        result = proveedor.consultarEmail(ID);
        return result;
    }

    /**
     * Sirve para obtener el nombre
     *
     * @return
     */
    public String consultarNombre() {
        int ID = RegistroConcepto.idProveedor;
        String result;
        ProveedorDAO proveedor = new ProveedorDAO();
        result = proveedor.consultarNombre(ID);
        return result;
    }

    /**
     * Sirve para obtener el telefono
     *
     * @return
     */
    public String consultarTelefono() {
        int ID = RegistroConcepto.idProveedor;
        String result;
        ProveedorDAO proveedor = new ProveedorDAO();
        result = proveedor.consultarTelefono(ID);
        return result;
    }

    /**
     * Sirve para obtener la direccion
     *
     * @return
     */
    public String consultarDireccion() {
        int ID = RegistroConcepto.idProveedor;
        String result;
        ProveedorDAO proveedor = new ProveedorDAO();
        result = proveedor.consultarDireccion(ID);
        return result;
    }

    /**
     * sirve para modificar los datos del proveedor
     * @param nombre
     * @param email
     * @param telefono
     * @param direccion
     */
    public void modificarProveedor(String nombre, String email, String telefono, String direccion) {
        Proveedor proveedor = new Proveedor(nombre, email, telefono, direccion);
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        proveedorDAO.modificarProveedor(proveedor);

    }

    /**
     * sirve para eliminar el proveedor
     */
    public void eliminarProveedor() {
        int ID = RegistroConcepto.idProveedor;
        ProveedorDAO proveedorDAO = new ProveedorDAO();
        proveedorDAO.eliminarProveedor(ID);
    }
}
