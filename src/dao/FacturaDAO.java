package dao;
import controlador.ConexionController;
import java.sql.*;
import javax.swing.JOptionPane;
import modelo.Factura;

/**
 * Clase que gestiona la parte de los datos de las facturas
 * @author marcos Yerga Gomez 
 */
public class FacturaDAO {
    /**
     * 
     */
    public FacturaDAO(){
    }
    public void crearFactura(Factura factura){
        try{
            String query = "insert into facturas values (?,?,?,?,?)";
            try (Connection cn = ConexionController.conectar()) {
                PreparedStatement pst;
                pst = cn.prepareStatement(query);
                pst.setInt(1,0);
                pst.setFloat(2, factura.getImporte());
                pst.setInt(3, factura.getIdGasto());
                pst.setString(4,factura.getFecha());
                pst.setString(5, factura.getProveedor());
                
                pst.executeUpdate();
                
            }
            JOptionPane.showMessageDialog(null,"Nueva factura registrado");
        } catch (SQLException E){
            System.err.println("Error en el registro" + E);
            JOptionPane.showMessageDialog(null,"Error en el registro");
        }
    }
    /**
     * Sirve para consultar el proveedor
     *
     * @return 
     */
    public String consultarProveedor(int ID) {
        String result = "";
        String mensajero = "";
        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM facturas WHERE ID='" + ID + "'");

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                mensajero =  (String) rs.getString("proveedor");
                try {
                    Connection cn2 = ConexionController.conectar();
                    PreparedStatement pst2 = cn2.prepareStatement("SELECT * FROM proveedores WHERE nombre='" + mensajero + "'");
                    ResultSet rs2 = pst2.executeQuery();
                    
                    if (rs2.next()) {
                        result = (String) rs2.getString("ID");
                    }else{
                        JOptionPane.showMessageDialog(null, "Error al buscar proveedor");
                    }
                }catch(SQLException e) {
                    System.err.println("Error en el registro" + e);
                    JOptionPane.showMessageDialog(null, "Error en la consulta");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No existe ninguna factura con ese ID");
            }
        } catch (SQLException e) {
            System.err.println("Error en el registro" + e);
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
        return result;
    }
    /**
     * Sirve para obtener el ID de la factura
     * @return 
     */
    public int consultarID(int idGasto) {
        int result = 0;
        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM facturas WHERE idGasto='" + idGasto + "'");

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                result = (int) Integer.parseInt(rs.getString("ID"));
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
