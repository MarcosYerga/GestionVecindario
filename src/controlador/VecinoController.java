package controlador;

import dao.UsuarioDAO;
import vista.LogginVista;

/**
 * Clase que sirve para gestionar la parte logica de los usuarios del tipo vecino
 * @author Marcos Yerga Gomez
 */
public class VecinoController extends UsuariosController {
    /**
     * Constructor de la clase
     */
    public VecinoController() {
    }
    /**
     * Metodo que sirve para consultar el nombre del usuario
     * @return
     */
    @Override
    public String consultarNombre() {
        String usuario = LogginVista.nombreUsuario;
        return usuario;
    }

    /**
     *  Metodo que sirve para consultar el email del usuario
     * @return
     */
    @Override
    public String consultarEmail() {
        String usuario = LogginVista.nombreUsuario;
        String clave = LogginVista.contraseña;
        String result = "";
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        result = usuarioDAO.consultarEmail(usuario,clave);
        return result;
    }

    /**
     *  Metodo que sirve para consultar la clave del usuario
     * @return
     */
    public String consultarClave() {
        String clave = LogginVista.contraseña;
        return clave;
    }

    /**
     *  Metodo que sirve para consultar el telefono del usuario
     * @return
     */
    @Override
    public String consultarTelefono() {
        String usuario = LogginVista.nombreUsuario;
        String clave = LogginVista.contraseña;
        String result ;
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        result = usuarioDAO.consultarTelefono(usuario,clave);
        return result;
    }

    /**
     *  Metodo que sirve para consultar el ID del usuario
     * @return
     */
    @Override
    public int consultarID() {
        String usuario = LogginVista.nombreUsuario;
        String clave = LogginVista.contraseña;
        int result = 0;
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        result = usuarioDAO.consultarID(usuario,clave);
        return result;
    }

    /**
     *  Metodo que sirve para consultar el apellido del usuario
     * @return
     */
    @Override
    public String consultarApellido() {
        String usuario = LogginVista.nombreUsuario;
        String clave = LogginVista.contraseña;
        String result = "";
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        result = usuarioDAO.consultarApellido(usuario,clave);
        return result;
    }
}
