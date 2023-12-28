package dao;

import controlador.ConexionController;
import java.sql.*;
import javax.swing.JOptionPane;
import modelo.Inmueble;
import vista.SubMenuInmueblesAdmin;

/**
 * Clase que gestiona la parte de los datos de los inmuebles
 *
 * @author Marcos Yerga Gomez
 */
public class InmuebleDAO {

    /**
     * Constructor de la clase
     */
    public InmuebleDAO() {
    }

    public void crearInmueble(Inmueble inmueble) {
        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "insert into inmuebles values(?,?,?,?,?,?)");
            pst.setInt(1, 0);
            pst.setString(2, inmueble.getCalle());
            pst.setInt(3, inmueble.getNumero());
            pst.setString(4, inmueble.getPortal());
            pst.setString(5, inmueble.getPiso());
            pst.setString(6, null);

            pst.executeUpdate();
            cn.close();

            JOptionPane.showMessageDialog(null, "Nuevo inmueble registrado");
        } catch (SQLException E) {
            System.err.println("Error en el registro" + E);
            JOptionPane.showMessageDialog(null, "Error en el registro");
        }
    }

    /**
     * sirve para eliminar inmubles
     */
    public void eliminarInmueble(int ID) {
        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("DELETE FROM inmuebles WHERE ID='" + ID + "'");

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "El inmueble ha sido eliminado");

        } catch (SQLException E) {
            System.err.println("Error en el registro es aqui??" + E);
            JOptionPane.showMessageDialog(null, "Error al eliminar el inmueble");
        }
    }

    /**
     * sirve para consultar la calle de un inmueble
     *
     * @return
     */
    public String consultarCalle(int ID) {
        String result = "";
        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM inmuebles WHERE ID='" + ID + "'");

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                result = rs.getString("calle");
            } else {
                JOptionPane.showMessageDialog(null, "No existe ningun inmueble con ese ID");
            }
        } catch (SQLException e) {
            System.err.println("Error en el registro" + e);
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
        return result;
    }

    /**
     * sirve para consultar el numero de la calle
     *
     * @return
     */
    public String consultarNumero(int ID) {
        String result = "";
        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM inmuebles WHERE ID='" + ID + "'");

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                result = rs.getString("numero");
            } else {
                JOptionPane.showMessageDialog(null, "No existe ningun inmueble con ese ID");
            }
        } catch (SQLException e) {
            System.err.println("Error en el registro" + e);
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
        return result;
    }

    /**
     * sirve para consultar el numero de la calle
     *
     * @return
     */
    public String consultarPiso(int ID) {
        String result = "";
        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM inmuebles WHERE ID='" + ID + "'");

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                result = rs.getString("piso");
            } else {
                JOptionPane.showMessageDialog(null, "No existe ningun inmueble con ese ID");
            }
        } catch (SQLException e) {
            System.err.println("Error en el registro" + e);
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
        return result;
    }

    /**
     * sirve para consultar el numero de la calle
     *
     * @return
     */
    public String consultarPortal(int ID) {
        String result = "";
        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM inmuebles WHERE ID='" + ID + "'");

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                result = rs.getString("portal");
            } else {
                JOptionPane.showMessageDialog(null, "No existe ningun inmueble con ese ID");
            }
        } catch (SQLException e) {
            System.err.println("Error en el registro" + e);
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
        return result;
    }

    /**
     * sirve para consultar el propietario del inmueble
     *
     * @return
     */
    public String consultarPropietario(int ID) {
        String result = "";
        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM inmuebles WHERE ID='" + ID + "'");

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                result = rs.getString("propietario");
            } else {
                JOptionPane.showMessageDialog(null, "No existe ningun inmueble con ese ID");
            }
        } catch (SQLException e) {
            System.err.println("Error en el registro" + e);
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
        return result;
    }

    /**
     * Sirve para modificar los datos de un Inmuebles
     */
    public void modificarInmueble(Inmueble inmueble) {
        int ID = SubMenuInmueblesAdmin.idInmueble;
        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("UPDATE inmuebles SET ID=?, calle=?, numero=?, portal=?, piso=?" + "WHERE ID='" + ID + "'");
            pst.setInt(1, ID);
            pst.setString(2, inmueble.getCalle());
            pst.setInt(3, inmueble.getNumero());
            pst.setString(4, inmueble.getPortal());
            pst.setString(5, inmueble.getPiso());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Los datos del inmueble han sido modificados");

        } catch (SQLException E) {
            System.err.println("Error en el registro " + E);
            JOptionPane.showMessageDialog(null, "Error al actualizar los datos ");
        }
    }
    /**
     * Sirve para asociar el inmueble a un usuario
     */
    public void asociarInmueble(int ID,int idPropietario) {
        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("Select * From usuarios WHERE ID='" + idPropietario + "'");

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                try {
                    Connection cn2 = ConexionController.conectar();
                    PreparedStatement pst2 = cn2.prepareStatement("UPDATE inmuebles SET propietario='" + idPropietario + "'" + "WHERE ID='" + ID + "'");

                    pst2.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Nuevo propietario asociado al inmueble");
                } catch (SQLException E) {
                    System.err.println("Error en el registro " + E);
                    JOptionPane.showMessageDialog(null, "Error al asociar el inmueble ");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No existe ningún usuario con ese ID");
            }

        } catch (SQLException E) {
            System.err.println("Error en el registro " + E);
            JOptionPane.showMessageDialog(null, "Error al asociar el inmueble");
        }
    }
}
