package controlador;


import dao.LiquidacionDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import modelo.Liquidacion;
import vista.LiquidacionesServicioAdmin;
import vista.LogginVista;
import vista.SubMenuLiquidacionesAdmin;

/**
 * Sirve para llevar la parte logica de las liquidaciones
 *
 * @author Marcos Yerga Gomez
 */
public class LiquidacionController {

    /**
     * Constructor que sirve para crear liquidaciones
     */
    public LiquidacionController() {
    }

    /**
     * Sirve para crear liquidacion
     */
    public void crearLiquidacion() {
        int idServicio = SubMenuLiquidacionesAdmin.idServicio;
        int importeTotal = 0;
        String fechaInicio = obtenerFecha();
        String fechaFinal = "";
        int isPagado = 0;
        Liquidacion liquidacion = new Liquidacion(idServicio, fechaInicio, fechaFinal, isPagado, importeTotal);
        LiquidacionDAO liquidacionDAO = new LiquidacionDAO();
        liquidacionDAO.crearLiquidacion(liquidacion);
        new LiquidacionesServicioAdmin().setVisible(true);
    }

    /**
     * Sirve para modificar la liquidacion
     * @param idServicio
     * @param fechaFinal
     * @param fechaInicio
     * @param isPagado
     * @param importeTotal
     */
    public void actualizarLiquidacion(int idServicio, String fechaInicio, String fechaFinal, int isPagado, float importeTotal) {
        Liquidacion liquidacion = new Liquidacion(idServicio, fechaInicio, fechaFinal, isPagado, importeTotal);
        LiquidacionDAO liquidacionDAO = new LiquidacionDAO();
        liquidacionDAO.actualizarLiquidacion(liquidacion);
    }

    /**
     * Sirve para eliminar liquidacion
     */
    public void eliminarLiquidacion() {
        int IDLiquidacion = LiquidacionesServicioAdmin.idLiquidacion;
        LiquidacionDAO liquidacionDAO = new LiquidacionDAO();
        liquidacionDAO.eliminarLiquidacion(IDLiquidacion);
    }

    /**
     * Sirve para cerrar las liquidaciones
     *
     * @throws java.text.ParseException
     */
    public void cerrarLiquidación() throws ParseException {
        int IDLiquidacion = LiquidacionesServicioAdmin.idLiquidacion;
        String fechaFinal = obtenerFecha();
        LiquidacionDAO liquidacionDAO = new LiquidacionDAO();
        liquidacionDAO.cerrarLiquidación(IDLiquidacion, fechaFinal);
    }

    /**
     * Metodo que sirve para calcular el importe total.
     *
     * @return
     * @throws java.text.ParseException
     */
    public float calcularImporte() throws ParseException {
        String nombreServicio = "";
        float importeTotal = 0;
        int idServicio = SubMenuLiquidacionesAdmin.idServicio;
        String fechaInicio = consultarInicio();
        String fechaFinal = consultarFinal();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

        Date fecha1 = formato.parse(fechaInicio);
        Date fecha2 = formato.parse(fechaFinal);
        LiquidacionDAO liquidacionDAO = new LiquidacionDAO();
        importeTotal = liquidacionDAO.calcularImporte(nombreServicio, importeTotal, idServicio, fecha1, fecha2);
        return importeTotal;
    }

    /**
     * Sirve para relacionar el servicio con la liquidación
     *
     * @return
     */
    public int relacionarServicio() {
        int idUsuario = consultarIDUsuario();
        int idInmueble = consultarIDInmueble();
        int result = 0;
        LiquidacionDAO liquidacionDAO = new LiquidacionDAO();
        liquidacionDAO.relacionarServicio(idUsuario, idInmueble);
        return result;
    }

    /**
     * sirve para generar un detalle de liquidacion
     */
    public void detalleLiquidacion() {
        int IDLiquidacion = LiquidacionesServicioAdmin.idLiquidacion;
        int idServicio = SubMenuLiquidacionesAdmin.idServicio;
        float importeIndividual = 0;
        float importeTotal = 0;
        LiquidacionDAO liquidacionDAO = new LiquidacionDAO();
        liquidacionDAO.detalleLiquidacion(IDLiquidacion, idServicio, importeIndividual, importeTotal);
    }

    /**
     * Sirve para consultar la fecha de inicio
     *
     * @return
     */
    public String consultarInicio() {
        int IDLiquidacion = LiquidacionesServicioAdmin.idLiquidacion;
        String result = "";
        LiquidacionDAO liquidacionDAO = new LiquidacionDAO();
        result = liquidacionDAO.consultarInicio(IDLiquidacion);
        return result;
    }

    /**
     * Sirve para consultar la fecha de cierre
     *
     * @return
     */
    public String consultarFinal() {
        int IDLiquidacion = LiquidacionesServicioAdmin.idLiquidacion;
        String result = "";
        LiquidacionDAO liquidacionDAO = new LiquidacionDAO();
        result = liquidacionDAO.consultarFinal(IDLiquidacion);
        return result;
    }

    /**
     * Sirve para consultar la si la liquidacion ha sido pagada
     *
     * @return
     */
    public String consultarPagado() {
        int IDLiquidacion = LiquidacionesServicioAdmin.idLiquidacion;
        String result = "";
        LiquidacionDAO liquidacionDAO = new LiquidacionDAO();
        result = liquidacionDAO.consultarPagado(IDLiquidacion);
        return result;
    }

    /**
     * Sirve para consultar el importe total de la liquidacion
     *
     * @return
     */
    public float consultarImporte() {
        int IDLiquidacion = LiquidacionesServicioAdmin.idLiquidacion;
        float result = 0;
        LiquidacionDAO liquidacionDAO = new LiquidacionDAO();
        liquidacionDAO.consultarImporte(IDLiquidacion);
        return result;
    }

    /**
     * Método que sirve para obtener el ID usuario
     *
     * @return
     */
    public int consultarIDUsuario() {
        String usuario = LogginVista.nombreUsuario;
        String clave = LogginVista.contraseña;
        int result = 0;
        LiquidacionDAO liquidacionDAO = new LiquidacionDAO();
        result = liquidacionDAO.consultarIDUsuario(usuario, clave);
        return result;
    }

    /**
     * método que sirve para obtener el ID de l inmueble
     */
    private int consultarIDInmueble() {
        int idUsuario = consultarIDUsuario();
        int result = 0;
        LiquidacionDAO liquidacionDAO = new LiquidacionDAO();
        result = liquidacionDAO.consultarIDInmueble(idUsuario);
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
