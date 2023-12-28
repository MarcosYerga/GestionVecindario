package dao;

import controlador.ConexionController;
import java.sql.*;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Gasto;
import vista.VerGastosAdmin;

/**
 * Clase qeu gestiona la parte de los datos de los gastos
 *
 * @author Marcos Yerga Gomez
 */
public class GastoDAO {

    /**
     * Contructor de la clase
     */
    public GastoDAO() {
    }

    public void crearGasto(Gasto gasto) {
        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "insert into gastos values (?,?,?,?,?)");
            pst.setInt(1, 0);
            pst.setString(2, gasto.getServicioAsociado());
            pst.setString(3, gasto.getFechaPago());
            pst.setString(4, gasto.getFechaRegistro());
            pst.setFloat(5, gasto.getImporte());

            pst.executeUpdate();
            cn.close();

            JOptionPane.showMessageDialog(null, "Nuevo gasto registrado");
        } catch (SQLException E) {
            System.err.println("Error en el registro" + E);
            JOptionPane.showMessageDialog(null, "Error en el registro, fallo al introducir en base de datos");
        }
    }

    /**
     * Sirve para actualizar los atributos del gasto
     */
    public void modificarGasto(Gasto gasto, String servicioAsociado) {
        int ID = VerGastosAdmin.idGasto;
        try {
            Connection cn = ConexionController.conectar();
            Statement consulta = cn.createStatement();
            ResultSet registro = consulta.executeQuery("Select nombre FROM servicios WHERE nombre='" + servicioAsociado + "'");
            if (registro.next()) {
                try {
                    Connection cn2 = ConexionController.conectar();
                    PreparedStatement pst = cn2.prepareStatement("UPDATE gastos SET ID=?, ServicioAsociado=?, fechaPago=?, fechaRegistro=?, importe=?" + "WHERE ID='" + ID + "'");
                    pst.setInt(1, ID);
                    pst.setString(2, gasto.getServicioAsociado());
                    pst.setString(3, gasto.getFechaPago());
                    pst.setString(4, gasto.getFechaRegistro());
                    pst.setFloat(5, gasto.getImporte());

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Los datos del gasto han sido actualizados");

                } catch (SQLException E) {
                    System.err.println("Error en el registro " + E);
                    JOptionPane.showMessageDialog(null, "Error al actualizar los datos ");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No existe ningun servicio con ese nombre");
            }
        } catch (SQLException E) {
            System.err.println("Error en el registro " + E);
            JOptionPane.showMessageDialog(null, "Error al actualizar los datos ");
        }
    }

    /**
     * Sirve para eliminar gastos
     */
    public void eliminarGasto(int ID) {
        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("DELETE FROM gastos WHERE ID='" + ID + "'");

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "El gasto ha sido eliminado");

        } catch (SQLException E) {
            System.err.println("Error en el registro es aqui??" + E);
            JOptionPane.showMessageDialog(null, "Error al actualizar los datos");
        }
    }
    /**
     * Sirve para consultar fecha de pago
     *
     * @return
     */
    public String consultarFechaPago(int ID) {
        String result = "";
        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM gastos WHERE ID='" + ID + "'");
            
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                result = rs.getString("fechaPago");
            } else {
                JOptionPane.showMessageDialog(null, "No existe ningun gasto con ese ID");
            }
        } catch (SQLException e) {
            System.err.println("Error en el registro" + e);
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
        return result;
    }
    /**
     * Sirve para consultar la fecha de Registro
     *
     * @return
     */
    public String consultarFechaRegistro(int ID) {
        String result = "";
        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM gastos WHERE ID='" + ID + "'");
            
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                result = rs.getString("fechaRegistro");
            } else {
                JOptionPane.showMessageDialog(null, "No existe ningun gasto con ese ID");
            }
        } catch (SQLException e) {
            System.err.println("Error en el registro" + e);
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
        return result;
    }
    /**
     * Sirve para consultar el importe
     *
     * @return
     */
    public String consultarImporte(int ID) {
        String result = "";
        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM gastos WHERE ID='" + ID + "'");
            
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                result = rs.getString("importe");
            } else {
                JOptionPane.showMessageDialog(null, "No existe ningun gasto con ese ID");
            }
        } catch (SQLException e) {
            System.err.println("Error en el registro" + e);
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
        return result;
    }
    /**
     * Sirve para consultar servicio asociado
     *
     * @return
     */
    public String consultarServicio(int ID) {
        String result = "";
        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM gastos WHERE ID='" + ID + "'");
            
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                result = rs.getString("ServicioAsociado");
            } else {
                JOptionPane.showMessageDialog(null, "No existe ningun gasto con ese ID");
            }
        } catch (SQLException e) {
            System.err.println("Error en el registro" + e);
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
        return result;
    }
}
