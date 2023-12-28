package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;

/**
 * Clase que gestiona la parte logica del loggin de los usuarios
 * @author Marcos Yerga Gomez
 */
public class LogginController {
    //Atributos
    String nombreUsuario;
    String contraseña;
    //Atributos que sirven para verificar que la informacion introducida es correcta
    String isCorrect = "";
    String isAdmin = "0";
    //método

    /**
     * Constructor de la clase
     * @param nombre
     * @param contraseña
     */
    public LogginController(String nombre, String contraseña){
        this.nombreUsuario = nombre;
        this.contraseña = contraseña;
    }

    /**
     * Metodo que comprueba si los datos son correctos
     */
    public void isValid(){
        try{
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement(
                "select isAdmin from usuarios where nombre = '" + nombreUsuario + 
                    "' and clave = '" + contraseña + "'");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                isCorrect = "1";
                isAdmin = rs.getString("isAdmin");
            }else{
                isCorrect = "0";
            }
            }catch(SQLException e){
                System.err.println("Error en el boton acceder" + e);
                JOptionPane.showMessageDialog(null,"!Error al iniciar sesión");
            }
}

    /**
     * Metodo que envia el atributo isValid
     * @return
     */
    public String getValid(){
        return isAdmin;
    }

    /**
     *  Metodo que envia el atributo isCorrect
     * @return
     */
    public String getCorrect(){
        return isCorrect;
    }
}
