package dao;

import controlador.ConexionController;
import java.sql.*;

import javax.swing.JOptionPane;
import modelo.Suscripcion;

/**
 * Clase que gestiona la parte de los datos de las suscripciones
 * @author Marcos Yerga Gomez
 */
public class SuscripcionDAO {
    /**
     *Constructor de la clase
     * @param suscripcion
     */
    public void altaSuscripcion(Suscripcion suscripcion){
        
        try{
            String query = "insert into suscripcion values (?,?,?,?,?,?,?)";
            try (Connection cn = ConexionController.conectar()) {
                PreparedStatement pst;
                pst = cn.prepareStatement(query);
                pst.setInt(1,suscripcion.getIdServicio());
                pst.setInt(2, suscripcion.getIdInmueble());
                pst.setInt(3, suscripcion.getIdUsuario());
                pst.setString(4,suscripcion.getFechaAlta());
                pst.setString(5,"");
                pst.setInt(6,1);
                pst.setInt(7,0);
                
                pst.executeUpdate();
                
            }
            JOptionPane.showMessageDialog(null,"Se ha dado de alta correctamente");
        } catch (SQLException E){
            System.err.println("Error en el registro " + E);
            JOptionPane.showMessageDialog(null,"Error en el registro");
        }
    }
    /**
     * sirve para darse de baja en la  suscripcion a un servicio
     * @param idUsuario
     * @param idInmueble
     * @param idServicio
     * @param fechaBaja
     */
    public void bajaSuscripcion(int idUsuario,int idInmueble,int idServicio,String fechaBaja) {
        try {
            Connection cn3 = ConexionController.conectar();
            Statement st = cn3.createStatement();

            ResultSet resultado = st.executeQuery("SELECT * FROM suscripcion WHERE IDUsuario='" + idUsuario + "' AND IDInmueble=+'" + idInmueble + "'AND IDServicio='" + idServicio + "'");
            if (resultado.next()) {
                PreparedStatement st2 = cn3.prepareStatement("Update suscripcion SET isActivo='" + 0 + "' WHERE IDUsuario='" + idUsuario + "' AND IDInmueble=+'" + idInmueble + "'AND IDServicio='" + idServicio + "'");
                PreparedStatement st3 = cn3.prepareStatement("Update suscripcion SET fechaBaja='" + fechaBaja + "' WHERE IDUsuario='" + idUsuario + "' AND IDInmueble=+'" + idInmueble + "'AND IDServicio='" + idServicio + "'");
                st2.executeUpdate();
                st3.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se ha anulado la suscripcion correctamente");
            }
        } catch (SQLException ex) {
            System.err.println("Error en el registro esta aqui el error" + ex);
            JOptionPane.showMessageDialog(null, "Error en al darse de baja");
        }
    }
    /**
     * Sirve para obtener el ID del inmueble que se va a asociar
     * @param idUsuario
     * @return 
     */
    public int consultarIDInmueble(int idUsuario) {
        int result = 0;
        try {
            Connection cn = ConexionController.conectar();
            Statement consulta = cn.createStatement();
            ResultSet registro = consulta.executeQuery("Select ID FROM inmuebles WHERE propietario='" + idUsuario + "'");
            if (registro.next()) {
                result = registro.getInt("ID");
            }
        } catch (SQLException ex) {
            System.err.println("Error en el registro" + ex);
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
        return result;
    }
    /**
     * Sirve para obtener el ID del usuario que se va a suscribir
     * @param usuario
     * @param clave
     * @return 
     */
    public int consultarIDUsuario(String usuario,String clave) {
        int result = 0;
        try {
            Connection cn = ConexionController.conectar();
            Statement consulta = cn.createStatement();
            ResultSet registro = consulta.executeQuery("Select ID FROM usuarios WHERE nombre='" + usuario + "' AND clave='" + clave + "'");
            if (registro.next()) {
                result = registro.getInt("ID");
            }
        } catch (SQLException ex) {
            System.err.println("Error en el registro" + ex);
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
        return result;
    }
    /**
     * Sirve para comprobar si el usuario está suscrito al servicio.
     *
     * @param idUsuario
     * @param idServicio
     * @return result
     */
    public String comprobarSuscripcion(int idUsuario, int idServicio) {
        String isActivo;
        String result = "";
        int reset = 0;
        try {
            Connection cn = ConexionController.conectar();
            Statement consulta = cn.createStatement();
            ResultSet registro = consulta.executeQuery("Select * FROM inmuebles WHERE propietario='" + idUsuario + "'");
            if (registro.next()) {
                Statement consulta2 = cn.createStatement();
                ResultSet registro2 = consulta2.executeQuery("Select isActivo,fechaBaja FROM suscripcion WHERE IDUsuario='" + idUsuario + "'AND IDServicio='" + idServicio + "'");
                if (registro2.next()) {
                    while(registro2.next()){
                    isActivo = registro2.getString("isActivo");
                    if (isActivo.equals("1")) {
                        reset = 0;
                    } else if (isActivo.equals("0")) {
                        reset++;
                    }
                    if(reset == 0){
                        result = "Si";
                    }else{
                        result = "No";
                    }
                    }
                }else{
                    result = "No";
                }
            } else {
                JOptionPane.showMessageDialog(null, "Es necesario tener un inmueble para suscribirse a los servicios");
            }
        } catch (SQLException ex) {
            System.err.println("Error en el registro" + ex);
            JOptionPane.showMessageDialog(null, "Error en la comprobacion");
        }
        return result;
    }
}
