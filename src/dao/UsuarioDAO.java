package dao;

import controlador.ConexionController;
import java.sql.*;
import javax.swing.JOptionPane;
import modelo.Usuario;
import vista.SubMenuUsuariosAdmin;

/**
 * Clase que gestiona los datos de los usuarios
 *
 * @author Marcos Yerga Gomez
 */
public class UsuarioDAO {

    /**
     *Construcor de la clase
     */
    public UsuarioDAO() {
    }

    /**
     * Metodo que sirve para crear usuarios en base de datos
     * @param usuario
     */
    public void crearUsuario(Usuario usuario) {

        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "insert into usuarios values (?,?,?,?,?,?,?)");
            pst.setInt(1, 0);
            pst.setString(2, usuario.getEmail());
            pst.setString(3, usuario.getTelefono());
            pst.setString(4, usuario.getClave());
            pst.setInt(5, usuario.getIsAdmin());
            pst.setString(6, usuario.getNombre());
            pst.setString(7, usuario.getApellido());

            pst.executeUpdate();
            cn.close();

            JOptionPane.showMessageDialog(null, "Nuevo usuario registrado");
        } catch (SQLException E) {
            System.err.println("Error en el registro" + E);
            JOptionPane.showMessageDialog(null, "Error en el registro");
        }
    }

    /**
     * Metodo que sirve para eliminar usuarios de la base de datos
     * @param usuario
     */
    public void eliminarUsuario(Usuario usuario) {
        int ID = SubMenuUsuariosAdmin.IDUsuario;

        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("DELETE FROM usuarios WHERE ID='" + ID + "'");

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "El usuario ha sido eliminado");

        } catch (SQLException E) {
            System.err.println("Error en el registro es aqui??" + E);
            JOptionPane.showMessageDialog(null, "Error al eliminar los datos");
        }

    }

    /**
     * Metodo que sirve para modificar usuarios
     * @param usuario
     */
    public void modificarUsuario(Usuario usuario) {
        Boolean admin = false;
        int ID = SubMenuUsuariosAdmin.IDUsuario;
        int isAdmin = usuario.getIsAdmin();
        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("UPDATE usuarios SET ID=?, email=?, telefono=?, clave=?, isAdmin=?, nombre=?, apellido=?" + "WHERE ID='" + ID + "'");

            if (isAdmin == 1) {
                admin = true;
            } else if (isAdmin == 0) {
                admin = false;
            }

            pst.setInt(1, ID);
            pst.setString(2, usuario.getEmail());
            pst.setString(3, usuario.getTelefono());
            pst.setString(4, usuario.getClave());
            pst.setBoolean(5, admin);
            pst.setString(6, usuario.getNombre());
            pst.setString(7, usuario.getApellido());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Los datos del usuario han sido modificados");

        } catch (SQLException E) {
            System.err.println("Error en el registro " + E);
            JOptionPane.showMessageDialog(null, "Error al actualizar los datos");
        }
    }

    /**
     * Metodo que sirve para consultar el email de la base de datos
     * @param usuario
     * @param clave
     * @return
     */
    public String consultarEmail(String usuario, String clave) {
        String result = "";
        try {
            Connection cn = ConexionController.conectar();
            Statement consulta = cn.createStatement();
            ResultSet registro = consulta.executeQuery("Select email FROM usuarios WHERE nombre='" + usuario + "' AND clave='" + clave + "'");
            if (registro.next()) {
                result = registro.getString("email");
            }
        } catch (SQLException ex) {
            System.err.println("Error en el registro" + ex);
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
        return result;
    }

    /**
     * Metodo que sirve para consultar la clave de la base de datos
     * @param nombre
     * @param ID
     * @return
     */
    public String consultarClave(String nombre, int ID) {
        
        String result = "";
        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM usuarios WHERE nombre='" + nombre + "' AND ID='" + ID + "'");

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                result = rs.getString("clave");
            }
        } catch (SQLException E) {
            System.err.println("Error en el registro" + E);
            JOptionPane.showMessageDialog(null, "Error al consultar la clave");
        }
        return result;
    }

    /**
     * Metodo que sirve para consultar el telefono de la base de datos
     * @param usuario
     * @param clave
     * @return
     */
    public String consultarTelefono(String usuario, String clave) {
        String result = "";
        try {
            Connection cn = ConexionController.conectar();
            Statement consulta = cn.createStatement();
            ResultSet registro = consulta.executeQuery("Select telefono FROM usuarios WHERE nombre='" + usuario + "' AND clave='" + clave + "'");
            if (registro.next()) {
                result = (""+registro.getInt("telefono"));
            }
        } catch (SQLException ex) {
            System.err.println("Error en el registro" + ex);
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
        return result;
    }

    /**
     * Metodo que sirve para consultar el ID de la base de datos
     * @param usuario
     * @param clave
     * @return
     */
    public int consultarID(String usuario, String clave) {
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
     * Metodo que sirve para consultar el apellido de la base de datos
     * @param usuario
     * @param clave
     * @return
     */
    public String consultarApellido(String usuario, String clave) {
        String result = "";
        try {
            Connection cn = ConexionController.conectar();
            Statement consulta = cn.createStatement();
            ResultSet registro = consulta.executeQuery("Select apellido FROM usuarios WHERE nombre='" + usuario + "' AND clave='" + clave + "'");
            if (registro.next()) {
                result = registro.getString("apellido");
            }
        } catch (SQLException ex) {
            System.err.println("Error en el registro" + ex);
            JOptionPane.showMessageDialog(null, "Error en el registro");
        }
        return result;
    }

    /**
     * Metodo que sirve para consultar el tipo de usuario de la base de datos
     * @param nombre
     * @param ID
     * @return
     */
    public String consultarAdministrador(String nombre, int ID) {
        String result = "";
        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT * FROM usuarios WHERE nombre='" + nombre + "' AND ID='" + ID + "'");

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                result = rs.getString("isAdmin");
            }
        } catch (SQLException E) {
            System.err.println("Error en el registro" + E);
            JOptionPane.showMessageDialog(null, "Error al consultar el tipo de usuario");
        }
        return result;
}

    /**
     * Metodo que sirve para consultar el inmueble asociado al usuario de la base de datos
     * @param usuario
     * @param clave
     * @return
     */
    public String consultarInmueble(String usuario, String clave) {
        int idUsuario;
        idUsuario = consultarID(usuario,clave);
        String result = "";
        try {
            Connection cn = ConexionController.conectar();
            Statement consulta = cn.createStatement();
            ResultSet registro = consulta.executeQuery("Select * FROM inmuebles WHERE propietario='" + idUsuario + "'");
            if (registro.next()) {
                result = "ID: " + registro.getString("ID") + ", Calle: " + registro.getString("calle") + ", Numero: " + registro.getString("numero");
            } else {
                JOptionPane.showMessageDialog(null, "No tiene usted ningún inmueble asociado");
            }
        } catch (SQLException ex) {
            System.err.println("Error en el registro" + ex);
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
        return result;
    }
}
