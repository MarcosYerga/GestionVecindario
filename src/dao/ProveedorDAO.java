package dao;

import controlador.ConexionController;
import java.sql.*;
import javax.swing.JOptionPane;
import modelo.Proveedor;
import vista.RegistroConcepto;

/**
 * Clase que gestiona la parte de los datos de los proveedores
 *
 * @author Marcos Yerga Gomez
 */
public class ProveedorDAO {

    /**
     * Constructor de la clase
     *
     * @param proveedor
     */
    public void crearProveedor(Proveedor proveedor) {

        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "insert into proveedores values(?,?,?,?,?)");
            pst.setInt(1, 0);
            pst.setString(2, proveedor.getNombre());
            pst.setString(3, proveedor.getTelefono());
            pst.setString(4, proveedor.getEmail());
            pst.setString(5, proveedor.getDireccion());

            pst.executeUpdate();
            cn.close();

            JOptionPane.showMessageDialog(null, "Nuevo proveedor registrado");
        } catch (SQLException E) {
            System.err.println("Error en el registro" + E);
            JOptionPane.showMessageDialog(null, "Error en el registro");
        }
    }

    /**
     * sirve para eliminar el proveedor
     *
     * @param ID
     */
    public void eliminarProveedor(int ID) {
        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("DELETE FROM proveedor WHERE ID='" + ID + "'");

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "El proveedor ha sido eliminado");

        } catch (SQLException E) {
            System.err.println("Error en el registro" + E);
            JOptionPane.showMessageDialog(null, "Error al eliminar los datos");
        }
    }

    /**
     * sirve para modificar los datos del proveedor
     *
     * @param proveedor
     */
    public void modificarProveedor(Proveedor proveedor) {
        int ID = RegistroConcepto.idProveedor;
        try {
            Connection cn = ConexionController.conectar();
            Statement consulta = cn.createStatement();
            ResultSet registro = consulta.executeQuery("Select * FROM proveedores WHERE ID='" + ID + "'");
            if (registro.next()) {
                try {
                    Connection cn2 = ConexionController.conectar();
                    PreparedStatement pst = cn2.prepareStatement("UPDATE proveedores SET ID=?, nombre=?, telefono=?, email=?, direccion=? WHERE ID='" + ID + "'");
                    pst.setInt(1, ID);
                    pst.setString(2, proveedor.getNombre());
                    pst.setString(3, proveedor.getTelefono());
                    pst.setString(4, proveedor.getEmail());
                    pst.setString(5, proveedor.getDireccion());

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Los datos del proveedor han sido actualizados");

                } catch (SQLException E) {
                    System.err.println("Error en el registro " + E);
                    JOptionPane.showMessageDialog(null, "Error al actualizar los datos ");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No existe ningun proveedor con ese ID");
            }
        } catch (SQLException E) {
            System.err.println("Error en el registro " + E);
            JOptionPane.showMessageDialog(null, "Error al consultar los datos ");
        }
    }

    /**
     * Sirve para obtener el email
     *
     * @param ID
     * @return
     */
    public String consultarEmail(int ID) {
        String result = "";
        try {
            Connection cn = ConexionController.conectar();
            Statement consulta = cn.createStatement();
            ResultSet registro = consulta.executeQuery("Select * FROM proveedores WHERE ID='" + ID + "'");
            if (registro.next()) {
                result = registro.getString("email");
            } else {
                JOptionPane.showMessageDialog(null, "No proveedores con ese ID");
            }
        } catch (SQLException ex) {
            System.err.println("Error en el registro" + ex);
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
        return result;
    }

    /**
     * Sirve para obtener el nombre
     *
     * @param ID
     * @return
     */
    public String consultarNombre(int ID) {
        String result = "";
        try {
            Connection cn = ConexionController.conectar();
            Statement consulta = cn.createStatement();
            ResultSet registro = consulta.executeQuery("Select * FROM proveedores WHERE ID='" + ID + "'");
            if (registro.next()) {
                result = registro.getString("nombre");
            }
        } catch (SQLException ex) {
            System.err.println("Error en el registro" + ex);
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
        return result;
    }

    /**
     * Sirve para obtener el telefono
     *
     * @param ID
     * @return
     */
    public String consultarTelefono(int ID) {
        String result = "";
        try {
            Connection cn = ConexionController.conectar();
            Statement consulta = cn.createStatement();
            ResultSet registro = consulta.executeQuery("Select * FROM proveedores WHERE ID='" + ID + "'");
            if (registro.next()) {
                result = registro.getString("telefono");
            }
        } catch (SQLException ex) {
            System.err.println("Error en el registro" + ex);
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
        return result;
    }

    /**
     * Sirve para obtener la direccion
     *
     * @param ID
     * @return
     */
    public String consultarDireccion(int ID) {
        String result = "";
        try {
            Connection cn = ConexionController.conectar();
            Statement consulta = cn.createStatement();
            ResultSet registro = consulta.executeQuery("Select * FROM proveedores WHERE ID='" + ID + "'");
            if (registro.next()) {
                result = registro.getString("direccion");
            }
        } catch (SQLException ex) {
            System.err.println("Error en el registro" + ex);
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
        return result;
    }
}
