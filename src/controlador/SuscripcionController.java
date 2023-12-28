package controlador;

import java.time.LocalDate;
import dao.SuscripcionDAO;
import modelo.Suscripcion;
import vista.LogginVista;
import vista.SubMenuServiciosVec;

/**
 * Clase qeu sirve para gestionar la parte lógica de las suscripciones
 * @author Marcos Yerga Gomez
 */
public class SuscripcionController {

    /**
     *Constructor de la clase
     */
    public SuscripcionController() {

    }
    /**
     * sirve para darse de alta de suscripcion a un servicio
     */
    public void altaSuscripcion() {
        String fechaAlta = obtenerFecha();
        int idUsuario = consultarIDUsuario();
        int idServicio = SubMenuServiciosVec.actualizarServicio;
        int idInmueble = consultarIDInmueble();
        Suscripcion suscripcion = new Suscripcion(fechaAlta, idUsuario, idServicio, idInmueble);
        SuscripcionDAO suscripcionDAO = new SuscripcionDAO();
        suscripcionDAO.altaSuscripcion(suscripcion);
        
    }

    /**
     * sirve para darse de baja en la  suscripcion a un servicio
     */
    public void bajaSuscripcion() {
        int idUsuario = consultarIDUsuario();
        int idInmueble = consultarIDInmueble();
        int idServicio = SubMenuServiciosVec.actualizarServicio;
        String fechaBaja = obtenerFecha();
        SuscripcionDAO suscripcionDAO = new SuscripcionDAO();
        suscripcionDAO.bajaSuscripcion(idUsuario, idInmueble, idServicio, fechaBaja);
    }

    /**
     * Sirve para obtener el ID del inmueble que se va a asociar
     */
    private int consultarIDInmueble() {
        int idUsuario = consultarIDUsuario();
        int result = 0;
        SuscripcionDAO suscripcionDAO = new SuscripcionDAO();
        result = suscripcionDAO.consultarIDInmueble(idUsuario);
        return result;
    }

    /**
     * Sirve para obtener el ID del usuario que se va a suscribir
     */
    private int consultarIDUsuario() {
        String usuario = LogginVista.nombreUsuario;
        String clave = LogginVista.contraseña;
        int result = 0;
        SuscripcionDAO suscripcionDAO = new SuscripcionDAO();
        result = suscripcionDAO.consultarIDUsuario(usuario,clave);
        return result;
    }

    /**
     * Sirve para comprobar si el usuario está suscrito al servicio.
     *
     * @return result
     */
    public String comprobarSuscripcion() {
        int idUsuario = consultarIDUsuario();
        int idServicio = SubMenuServiciosVec.actualizarServicio;
        String result = "";
        SuscripcionDAO suscripcionDAO = new SuscripcionDAO();
        result = suscripcionDAO.comprobarSuscripcion(idUsuario,idServicio);
        return result;
    }

    /**
     * Este metodo sirve para obtener la fecha de hoy
     *
     * @return
     */
    private String obtenerFecha() {
        LocalDate fecha = LocalDate.now();
        String mensajero = "" + fecha;
        return mensajero;
    }

}
