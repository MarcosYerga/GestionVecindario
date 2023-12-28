package dao;

import controlador.ConexionController;
import java.sql.*;
import javax.swing.JOptionPane;
import modelo.Concepto;
import vista.VerGastosAdmin;

/**
 * Clase que gestiona la parte de los datos de los conceptos
 *
 * @author Marcos Yerga Gomez
 */
public class ConceptoDAO {

    /**
     * Constructor de la clase
     */
    public ConceptoDAO() {
    }

    public void crearConcepto(Concepto concepto) {
        try {
            String query = "insert into conceptos values (?,?,?,?)";
            try ( Connection cn = ConexionController.conectar()) {
                PreparedStatement pst;
                pst = cn.prepareStatement(query);
                pst.setInt(1, 0);
                pst.setString(2, concepto.getDescripcion());
                pst.setInt(3, concepto.getIdGasto());
                pst.setString(4, concepto.getFecha());

                pst.executeUpdate();

            }
            JOptionPane.showMessageDialog(null, "Nuevo concepto registrado");
        } catch (SQLException E) {
            System.err.println("Error en el registro" + E);
            JOptionPane.showMessageDialog(null, "Error en el registro");
        }
    }

    /**
     * Sirve para eliminar un concepto
     */
    public void eliminarConcepto(int idGasto) {
        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("DELETE FROM conceptos WHERE idGasto='" + idGasto + "'");

            pst.executeUpdate();

        } catch (SQLException E) {
            System.err.println("Error en el registro " + E);
            JOptionPane.showMessageDialog(null, "Error al eliminar el concepto");
        }
    }

    /**
     * Sirve para actualizar los valores del concepto
     */
    public void modificarConcepto(Concepto concepto) {
        int idGasto = VerGastosAdmin.idGasto;

        try {
            Connection cn = ConexionController.conectar();
            Statement consulta = cn.createStatement();
            ResultSet registro = consulta.executeQuery("Select * FROM conceptos WHERE idGasto='" + idGasto + "'");
            if (registro.next()) {
                int ID = Integer.parseInt(registro.getString("ID"));
                try {
                    Connection cn2 = ConexionController.conectar();
                    PreparedStatement pst = cn2.prepareStatement("UPDATE conceptos SET ID=?, Descripcion=?, idGasto=?, Fecha=?" + "WHERE idGasto='" + idGasto + "'");
                    pst.setInt(1, ID);
                    pst.setString(2, concepto.getDescripcion());
                    pst.setInt(3, idGasto);
                    pst.setString(4, concepto.getFecha());

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Los datos del concepto han sido modificados");

                } catch (SQLException E) {
                    System.err.println("Error en el registro " + E);
                    JOptionPane.showMessageDialog(null, "Error al actualizar los datos ");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No existe ningun gasto con ese ID");
            }
        } catch (SQLException E) {
            System.err.println("Error en el registro " + E);
            JOptionPane.showMessageDialog(null, "Error al mostrar los datos ");
        }
    }
    /**
     * Sirve para consultar la fecha en la que se ha registrado
     *
     * @return
     */
    public String consultarFecha(int idGasto) {
        String result = "";
        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM conceptos WHERE idGasto='" + idGasto + "'");

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                result = rs.getString("Fecha");

            }
        } catch (SQLException e) {
            System.err.println("Error en el registro" + e);
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
        return result;
    }
    /**
     * Este metodo sirve para consultar la descripcion
     *
     * @return
     */
    public String consultarDescripcion(int idGasto) {
        String result = "";
        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM conceptos WHERE idGasto='" + idGasto + "'");

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                result = rs.getString("Descripcion");
            }
        } catch (SQLException e) {
            System.err.println("Error en el registro" + e);
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
        return result;
    }
}
