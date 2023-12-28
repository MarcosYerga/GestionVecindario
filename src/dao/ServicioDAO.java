package dao;

import controlador.ConexionController;
import java.sql.*;
import javax.swing.JOptionPane;
import modelo.Servicio;
import vista.SubMenuServiciosAdmin;

/**
 * Clase que gestiona la parte de los datos de los servicios
 * @author Marcos Yerga Gomez
 */
public class ServicioDAO {
    /**
     *Constructor de la clase
     */
    public ServicioDAO(){
        
    }

    /**
     * Metedo que sirve para crear el servicio en la base de datos
     * @param servicio
     */
    public void crearServicio(Servicio servicio){
         try{
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement(
                "insert into servicios values (?,?,?,?)");
            pst.setInt(1,0);
            pst.setString(2, servicio.getNombre());
            pst.setInt(3, servicio.getIsObligatorio());
            pst.setInt(4, 0);

                
            pst.executeUpdate();
            cn.close();
                
            JOptionPane.showMessageDialog(null,"Nuevo servicio registrado");
        } catch (SQLException E){
            System.err.println("Error en el registro" + E);
            JOptionPane.showMessageDialog(null,"Error en el registro");
        }
    }
        /**
     * sirve para eliminar servicio
     * @param ID
     */
    public void eliminarServicio(int ID) {
        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("DELETE FROM servicios WHERE ID='" + ID + "'");

            pst.executeUpdate();

        } catch (SQLException E) {
            System.err.println("Error en el registro " + E);
            JOptionPane.showMessageDialog(null, "Error al eliminar el servicio");
        }
    }
        /**
     * Sirve para consultar el nombre del servicio
     *
     * @param ID
     * @return
     */
    public String consultarNombre(int ID) {
        String result = "";
        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM servicios WHERE ID='" + ID + "'");

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                result = rs.getString("nombre");
            } else {
                JOptionPane.showMessageDialog(null, "No existe ningun servicios con ese ID");
            }
        } catch (SQLException e) {
            System.err.println("Error en el registro" + e);
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
        return result;
    }
        /**
     * Sirve para consultar si el servicio es obligatorio
     *
     * @param ID
     * @return
     */
    public String consultarObligatorio(int ID) {

        String result = "";
        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM servicios WHERE ID='" + ID + "'");

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                result = rs.getString("isObligatorio");
            }
        } catch (SQLException E) {
            System.err.println("Error en el registro" + E);
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
        return result;
    }
        /**
     * Sirve para consultar la tarifa del servicio
     *
     * @param ID
     * @return
     */
    public int consultarTarifa(int ID) {
        int result = 0;
        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM servicios WHERE ID='" + ID + "'");

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                result = rs.getInt("tarifa");
            }
        } catch (SQLException E) {
            System.err.println("Error en el registro" + E);
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
        return result;
    }
        /**
     * Sirve para modificar los servicios
     * @param servicio
     */
    public void modificarServicio(Servicio servicio) {
        Boolean obligatorio = false;
        int ID = SubMenuServiciosAdmin.idServicio;
        int isObligatorio = 0;
            try {
                if (isObligatorio == 1) {
                    obligatorio = true;
                } else if (isObligatorio == 0) {
                    obligatorio = false;
                }

                Connection cn = ConexionController.conectar();
                PreparedStatement pst = cn.prepareStatement("UPDATE servicios SET ID=?, nombre=?, isObligatorio=?, tarifa=? WHERE ID='" + ID + "'");

                pst.setInt(1, ID);
                pst.setString(2, servicio.getNombre());
                pst.setBoolean(3, obligatorio);
                pst.setInt(4, consultarTarifa(ID));

                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Los datos del servicio han sido actualizados");

            } catch (SQLException E) {
                System.err.println("Error en el registro " + E);
                JOptionPane.showMessageDialog(null, "Error al actualizar los datos");
            }
        } 
    }

