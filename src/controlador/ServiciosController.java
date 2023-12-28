package controlador;

import dao.ServicioDAO;
import modelo.Servicio;
import vista.SubMenuServiciosAdmin;

/**
 * Clase que sirve para gestionar la parte logica de los servicios
 *
 * @author Marcos Yerga Gómez
 */
public class ServiciosController {
    /**
     * Constructor para crear servicios
     */
    public ServiciosController() {
    }


    //Métodos
    /**
     * sirve para crear un nuevo servicio
     * @param nombre
     * @param isObligatorio
     */
    public void crearServicio(String nombre, int isObligatorio) {
        Servicio servicio = new Servicio(nombre, isObligatorio);
        ServicioDAO servicioDAO = new ServicioDAO();
        servicioDAO.crearServicio(servicio);
    }

    /**
     * sirve para eliminar servicio
     */
    public void eliminarServicio() {
        int ID = SubMenuServiciosAdmin.idServicio;   
        ServicioDAO servicioDAO = new ServicioDAO();
        servicioDAO.eliminarServicio(ID);
    }

    /**
     * Sirve para consultar el nombre del servicio
     *
     * @return
     */
    public String consultarNombre() {
        int ID = SubMenuServiciosAdmin.idServicio;
        String result = "";
        ServicioDAO servicioDAO = new ServicioDAO();
        result = servicioDAO.consultarNombre(ID);
        return result;
    }

    /**
     * Sirve para consultar si el servicio es obligatorio
     *
     * @return
     */
    public String consultarObligatorio() {
        int ID = SubMenuServiciosAdmin.idServicio;
        String result = "";
        ServicioDAO servicioDAO = new ServicioDAO();
        result = servicioDAO.consultarObligatorio(ID);
        return result;
    }

    /**
     * Sirve para consultar la tarifa del servicio
     *
     * @return
     */
    public int consultarTarifa() {
        int ID = SubMenuServiciosAdmin.idServicio;
        int result = 0;
        ServicioDAO servicioDAO = new ServicioDAO();
        result = servicioDAO.consultarTarifa(ID);
        return result;
    }

    /**
     * Sirve para modificar los servicios
     * @param nombre
     * @param isObligatorio
     */
    public void modificarServicio(String nombre, int isObligatorio) {
        Servicio servicio = new Servicio(nombre, isObligatorio);
        ServicioDAO servicioDAO = new ServicioDAO();
        servicioDAO.modificarServicio(servicio);
    }

}
