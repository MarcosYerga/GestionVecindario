package controlador;

import dao.UsuarioDAO;
import modelo.Usuario;
import vista.SubMenuUsuariosAdmin;

/**
 * Clase con la parte logica de la gestion de usuarios
 *
 * @author Marcos Yerga Gómez
 */
public class AdministradorController extends UsuariosController {
    /**
    * Contructor para usar métodos que no requieren de parametros
    */
    public AdministradorController() {

    }

    /**
     * Metodo que sirve para crear usuarios
     * @param nombre
     * @param apellido
     * @param email
     * @param telefono
     * @param clave
     * @param isAdmin
     */
    public void crearUsuario(String nombre, String apellido, String email, String telefono, String clave, int isAdmin) {

        Usuario usuario = new Usuario(nombre, apellido, email, telefono, clave, isAdmin);

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        usuarioDAO.crearUsuario(usuario);

    }

    /**
     * Metodo que sirve para eliminar usuarios
     */
    public void eliminarUsuarios() {
        Usuario usuario = new Usuario();

        UsuarioDAO usuarioDAO = new UsuarioDAO();

        usuarioDAO.eliminarUsuario(usuario);

    }

    /**
     * Metodo que sirve para modificar usuarios
     * @param nombre
     * @param apellido
     * @param telefono
     * @param clave
     * @param email
     * @param isAdmin
     */
    public void modificarUsuario(String nombre, String apellido, String email, String telefono, String clave, int isAdmin) {
        
            Usuario usuario = new Usuario(nombre, apellido, email, telefono, clave, isAdmin);

            UsuarioDAO usuarioDAO = new UsuarioDAO();

            usuarioDAO.modificarUsuario(usuario);

    }

    /**
     * Metodo que sirve para consultar el email
     *
     * @return
     */
    @Override
    public String consultarEmail() {
        String usuario = SubMenuUsuariosAdmin.actualizarUsuario;
        String clave = consultarClave();
        String result = "";
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        result = usuarioDAO.consultarEmail(usuario,clave);
        return result;
    }

    /**
     * Metodo que sirve para consultar la clave o contraseña
     *
     * @return
     */
    @Override
    public String consultarClave() {
        String nombre = SubMenuUsuariosAdmin.actualizarUsuario;
        int ID = SubMenuUsuariosAdmin.IDUsuario;
        String result = "";
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        result = usuarioDAO.consultarClave(nombre,ID);
        return result;
    }

    /**
     * Metodo que sirve para consultar el teléfono
     *
     * @return
     */
    @Override
    public String consultarTelefono() {
        String usuario = SubMenuUsuariosAdmin.actualizarUsuario;
        String clave = consultarClave();
        String result = "";
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        result = usuarioDAO.consultarTelefono(usuario,clave);
        return result;
    }

    /**
     * Método que sirve para consultar el apellido del usuario.
     *
     * @return
     */
    @Override
    public String consultarApellido() {
        String usuario = SubMenuUsuariosAdmin.actualizarUsuario;
        String clave = consultarClave();
        String result;
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        result = usuarioDAO.consultarApellido(usuario,clave);
        return result;
    }

    /**
     * Metodo que sirve para consultar el nombre
     *
     * @return
     */
    @Override
    public String consultarNombre() {
        String nombre = SubMenuUsuariosAdmin.actualizarUsuario;
        String result = nombre;
        return result;
    }

    /**
     * Metodo que sirve para consultar si el usuario es administrador
     *
     * @return
     */
    public String consultarAdministrador() {
        String nombre = SubMenuUsuariosAdmin.actualizarUsuario;
        int ID = SubMenuUsuariosAdmin.IDUsuario;
        String result = "";
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        result = usuarioDAO.consultarAdministrador(nombre,ID);
        return result;

    }

    /**
     * Método que sirve para consultar el ID
     *
     * @return
     */
    @Override
    public int consultarID() {
        int ID = SubMenuUsuariosAdmin.IDUsuario;
        return ID;
    }
}
