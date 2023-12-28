package controlador;
import java.sql.*;

/**
 * Clase que establece la conexion con el servidor
 * @author Marcos Yerga Gomez
 */
public class ConexionController {
    /**
     * Metodo que establece la conexion
     * @return
     */
    public static Connection conectar(){
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/actividad_21giin","root","");
            return cn;
        } catch (SQLException e){
        System.out.println("Error en la conexión" + e);
        }
        return(null);
    }
}
