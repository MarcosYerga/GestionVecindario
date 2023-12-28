package controlador;

import dao.UsuarioDAO;
import vista.LogginVista;

/**
 * Clase absatracta que sirve para gestionar parte logica de los usuarios en
 * general
 *
 * @author Marcos Yerga Gomez
 */
public abstract class UsuariosController {

    /**
     * Método que sirve para consultar el inmueble.
     * @return
     */
    public String consultarInmueble() {
        String usuario = LogginVista.nombreUsuario;
        String clave = LogginVista.contraseña;
        int idUsuario;
        idUsuario = consultarID();
        String result = "";
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        result = usuarioDAO.consultarInmueble(usuario,clave);
        return result;
    }

    /**
     * Metodo que sirve para consultar el email
     *
     * @return
     */
    public abstract String consultarEmail();

    /**
     * Metodo que sirve para consultar la clave o contraseña
     *
     * @return
     */
    public abstract String consultarClave();

    /**
     * Metodo que sirve para consultar el teléfono
     *
     * @return
     */
    public abstract String consultarTelefono();

    /**
     * Método que sirve para consultar el ID del usuario
     *
     * @return
     */
    public abstract int consultarID();

    /**
     * Método que sirve para consultar el apellido del usuario.
     *
     * @return
     */
    public abstract String consultarApellido();

    /**
     * Metodo que sirve para consultar el nombre
     *
     * @return
     */
    public abstract String consultarNombre();
}
