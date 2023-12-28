package dao;

import controlador.ConexionController;
import controlador.LiquidacionController;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import modelo.Liquidacion;
import vista.LiquidacionesServicioAdmin;


/**
 * Clase que sirve para gestionar los datos de las liquidaciones
 *
 * @author Marcos Yerga Gomez
 */
public class LiquidacionDAO {

    /**
     * Constructor de la clase
     */
    public LiquidacionDAO() {
    }

    /**
     *
     * @param liquidacion
     */
    public void crearLiquidacion(Liquidacion liquidacion) {
        try {
            String query = "insert into liquidaciones values (?,?,?,?,?,?)";
            try ( Connection cn = ConexionController.conectar()) {
                PreparedStatement pst;
                pst = cn.prepareStatement(query);
                pst.setDouble(1, 0);
                pst.setFloat(2, liquidacion.getImporteTotal());
                pst.setString(4, liquidacion.getFechaInicio());
                pst.setString(5, liquidacion.getFechaFinal());
                pst.setInt(6, liquidacion.getIdServicio());
                pst.setInt(3, liquidacion.getIsPagado());

                pst.executeUpdate();

            }
            JOptionPane.showMessageDialog(null, "Nueva liquidación creada");
        } catch (SQLException E) {
            System.err.println("Error en el registro" + E);
            JOptionPane.showMessageDialog(null, "Error en el registro");
        }
    }

    /**
     * Sirve para modificar la liquidacion
     * @param liquidacion
     */
    public void actualizarLiquidacion(Liquidacion liquidacion) {
        Boolean pagado = false;
        int IDLiquidacion = LiquidacionesServicioAdmin.idLiquidacion;
        int isPagado = liquidacion.getIsPagado();
        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("UPDATE liquidaciones SET ID=?, ImporteTotal=?, IsPagado=?, FechaInicio=?, FechaFinal=?, IDservicio=? WHERE ID='" + IDLiquidacion + "'");

            if (isPagado == 1) {
                pagado = true;
            } else if (isPagado == 0) {
                pagado = false;
            }

            pst.setInt(1, IDLiquidacion);
            pst.setFloat(2, liquidacion.getImporteTotal());
            pst.setBoolean(3, pagado);
            pst.setString(4, liquidacion.getFechaInicio());
            pst.setString(5, liquidacion.getFechaFinal());
            pst.setInt(6, liquidacion.getIdServicio());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Los datos de la liquidación han sido modificados");

        } catch (SQLException E) {
            System.err.println("Error en el registro " + E);
            JOptionPane.showMessageDialog(null, "Error al actualizar los datos");
        }
    }

    /**
     * Sirve para eliminar liquidacion
     * @param IDLiquidacion
     */
    public void eliminarLiquidacion(int IDLiquidacion) {
        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("DELETE FROM liquidaciones WHERE ID='" + IDLiquidacion + "'");

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "La liquidacion ha sido eliminada");

        } catch (SQLException E) {
            System.err.println("Error en el registro " + E);
            JOptionPane.showMessageDialog(null, "Error al eliminar los datos");
        }
    }

    /**
     * Sirve para cerrar las liquidaciones
     *
     * @param IDLiquidacion
     * @param fechaFinal
     * @throws java.text.ParseException
     */
    public void cerrarLiquidación(int IDLiquidacion, String fechaFinal) throws ParseException {
        LiquidacionController liquidacionController = new LiquidacionController();
        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("UPDATE liquidaciones SET FechaFinal=? WHERE ID='" + IDLiquidacion + "'");
            pst.setString(1, fechaFinal);
            pst.executeUpdate();
            float importeTotal = liquidacionController.calcularImporte();
            PreparedStatement pst2 = cn.prepareStatement("UPDATE liquidaciones SET ImporteTotal=? WHERE ID='" + IDLiquidacion + "'");
            pst2.setFloat(1, importeTotal);
            pst2.executeUpdate();
            JOptionPane.showMessageDialog(null, "La liquidacion se ha cerrado");
        } catch (SQLException e) {
            System.err.println("Error en el registro " + e);
            JOptionPane.showMessageDialog(null, "Error al cerrar la liquidacion");
        }
    }

    /**
     * Metodo que sirve para calcular el importe total.
     *
     * @param nombreServicio
     * @param importeTotal
     * @param idServicio
     * @param fecha1
     * @param fecha2
     * @return
     * @throws java.text.ParseException
     */
    public float calcularImporte(String nombreServicio, float importeTotal, int idServicio, java.util.Date fecha1, java.util.Date fecha2) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("Select * FROM servicios WHERE ID='" + idServicio + "'");

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                nombreServicio = rs.getString("nombre");
                try {
                    Connection cn2 = ConexionController.conectar();
                    PreparedStatement pst2 = cn2.prepareStatement("Select * FROM gastos WHERE ServicioAsociado='" + nombreServicio + "'");
                    ResultSet rs2 = pst2.executeQuery();
                    while (rs2.next()) {
                        String fechaPago;
                        float importeGasto;

                        fechaPago = rs2.getString("fechaPago");
                        importeGasto = rs2.getFloat("importe");
                        Date fecha3 = (Date) formato.parse(fechaPago);
                        if (fecha1.before(fecha3) && fecha2.after(fecha3)) {
                            importeTotal = importeTotal + importeGasto;
                        }
                    }

                } catch (SQLException e) {
                    System.err.println("Error en el registro " + e);
                    JOptionPane.showMessageDialog(null, "Error al calcular importe total");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay ningun gasto asociado a este servicio");
            }

        } catch (SQLException es) {
            System.err.println("Error en el registro " + es);
            JOptionPane.showMessageDialog(null, "No hay ningun gasto asociado a este servicio");
        }
        return importeTotal;
    }

    /**
     * Sirve para relacionar el servicio con la liquidación
     *
     * @param idUsuario
     * @param idInmueble
     * @return
     */
    public int relacionarServicio(int idUsuario, int idInmueble) {
        int result = 0;
        try {
            Connection cn = ConexionController.conectar();
            Statement consulta = cn.createStatement();
            ResultSet registro = consulta.executeQuery("Select ID FROM suscripcion WHERE IDUsuario='" + idUsuario + "' AND IDInmueble='" + idInmueble + "'");
            if (registro.next()) {
                result = registro.getInt("ID");
            }
        } catch (SQLException ex) {
            System.err.println("Error en el registro" + ex);
            JOptionPane.showMessageDialog(null, "Error al relacionar servicio a la liquidacion");
        }
        return result;
    }

    /**
     * sirve para generar un detalle de liquidacion
     * @param IDLiquidacion
     * @param idServicio
     * @param importeIndividual
     * @param importeTotal
     */
    public void detalleLiquidacion(int IDLiquidacion, int idServicio, float importeIndividual, float importeTotal) {
        String obligatorio;
        int numeroInmuebles;
        try {
            Connection cn = ConexionController.conectar();
            Statement consulta = cn.createStatement();
            ResultSet registro = consulta.executeQuery("Select * FROM liquidaciones WHERE ID='" + IDLiquidacion + "'");
            if (registro.next()) {
                importeTotal = registro.getFloat("ImporteTotal");
                Statement consulta2 = cn.createStatement();
                ResultSet registro2 = consulta2.executeQuery("Select * FROM servicios WHERE ID='" + idServicio + "'");

                if (registro2.next()) {
                    obligatorio = registro2.getString("isObligatorio");
                    System.out.print("hasta aqui llega?1 " + obligatorio);
                    if (obligatorio.equals("1")) {
                        Statement consulta3 = cn.createStatement();
                        ResultSet registro3 = consulta3.executeQuery("Select COUNT(ID) FROM inmuebles ");
                        numeroInmuebles = registro3.getInt("COUNT(ID)");
                        importeIndividual = importeTotal / numeroInmuebles;

                    } else {
                        Statement consulta4 = cn.createStatement();
                        System.out.print("Aqui llega 2 ");
                        ResultSet registro4 = consulta4.executeQuery("Select COUNT(IDInmueble) FROM suscripcion WHERE IDServicio='" + idServicio + "' AND isActivo = 1");
                        if (registro4.next()) {
                            numeroInmuebles = registro4.getInt("COUNT(IDInmueble)");
                            System.out.print("hasta aqui llega? " + numeroInmuebles);
                            importeIndividual = importeTotal / numeroInmuebles;
                        } else {
                            System.out.print("No hay suscripciones");
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Todavia no se ha calculado el importe total");
            }

        } catch (SQLException ex) {
            System.err.println("Error en el registro" + ex);
            JOptionPane.showMessageDialog(null, "Error al crear el detalle");
        }
        try {
            Connection cn2 = ConexionController.conectar();
            PreparedStatement pst = cn2.prepareStatement("UPDATE servicios SET tarifa=? WHERE ID='" + idServicio + "'");
            pst.setFloat(1, importeIndividual);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha calculado el detalle de liquidacion correctamente y se ha enviado a tarifa, el importe individual es: " + importeIndividual);
        } catch (SQLException ex) {
            System.err.println("Error en el registro" + ex);
            JOptionPane.showMessageDialog(null, "Ha habido un error al trasferir el valor calculado a tarifa");
        }
    }

    /**
     * Sirve para consultar la fecha de inicio
     *
     * @param IDLiquidacion
     * @return
     */
    public String consultarInicio(int IDLiquidacion) {
        String result = "";
        try {
            Connection cn = ConexionController.conectar();
            Statement consulta = cn.createStatement();
            ResultSet registro = consulta.executeQuery("Select * FROM liquidaciones WHERE ID='" + IDLiquidacion + "'");
            if (registro.next()) {
                result = registro.getString("FechaInicio");
            }
        } catch (SQLException ex) {
            System.err.println("Error en el registro" + ex);
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
        return result;
    }

    /**
     * Sirve para consultar la fecha de cierre
     *
     * @param IDLiquidacion
     * @return
     */
    public String consultarFinal(int IDLiquidacion) {
        String result = "";
        try {
            Connection cn = ConexionController.conectar();
            Statement consulta = cn.createStatement();
            ResultSet registro = consulta.executeQuery("Select * FROM liquidaciones WHERE ID='" + IDLiquidacion + "'");
            if (registro.next()) {
                result = registro.getString("FechaFinal");
            }
        } catch (SQLException ex) {
            System.err.println("Error en el registro" + ex);
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
        return result;
    }

    /**
     * Sirve para consultar la si la liquidacion ha sido pagada
     *
     * @param IDLiquidacion
     * @return
     */
    public String consultarPagado(int IDLiquidacion) {
        String result = "";
        try {
            Connection cn = ConexionController.conectar();
            Statement consulta = cn.createStatement();
            ResultSet registro = consulta.executeQuery("Select * FROM liquidaciones WHERE ID='" + IDLiquidacion + "'");
            if (registro.next()) {
                result = registro.getString("IsPagado");
            }
        } catch (SQLException ex) {
            System.err.println("Error en el registro" + ex);
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
        return result;
    }

    /**
     * Sirve para consultar el importe total de la liquidacion
     *
     * @param IDLiquidacion
     * @return
     */
    public float consultarImporte(int IDLiquidacion) {
        float result = 0;
        try {
            Connection cn = ConexionController.conectar();
            Statement consulta = cn.createStatement();
            ResultSet registro = consulta.executeQuery("Select * FROM liquidaciones WHERE ID='" + IDLiquidacion + "'");
            if (registro.next()) {
                result = registro.getFloat("ImporteTotal");
            }
        } catch (SQLException ex) {
            System.err.println("Error en el registro" + ex);
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
        return result;
    }

    /**
     * Método que sirve para obtener el ID usuario
     *
     * @param usuario
     * @param clave
     * @return
     */
    public int consultarIDUsuario(String usuario, String clave) {
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
     * método que sirve para obtener el ID de l inmueble
     * @param idUsuario
     * @return 
     */
    public int consultarIDInmueble(int idUsuario) {
        int result = 0;
        try {
            Connection cn = ConexionController.conectar();
            Statement consulta = cn.createStatement();
            ResultSet registro = consulta.executeQuery("Select ID FROM inmuebles WHERE propietario='" + idUsuario + "'");
            if (registro.next()) {
                result = registro.getInt("ID");
            }
        } catch (SQLException ex) {
            System.err.println("Error en el registro" + ex);
            JOptionPane.showMessageDialog(null, "Error en la consulta");
        }
        return result;
    }
}
