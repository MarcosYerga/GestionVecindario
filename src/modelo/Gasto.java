package modelo;

import javax.swing.JOptionPane;

/**
 * Sirve gestionar la entidad gasto
 * @author Marcos Yerga Gómez
 */
public class Gasto {
    //Atributos de clase  
    /**
     *servicio al que se asocia el gasto
     */
    private String servicioAsociado;
    /**
     *fecha en la que se realiza el pago
     */
    private String fechaPago;
    /**
     * Fecha en la que se registra el gasto
     */
    private String fechaRegistro;
    /**
     *importe del pago
     */
    private float importe;
    /**
     *Contructor de la clase
     * @param importe
     * @param servicioAsociado
     * @param fechaRegistro
     * @param fechaPago
     */
    public Gasto(float importe, String servicioAsociado, String fechaRegistro, String fechaPago){
        setServicioAsociado(servicioAsociado);
        setFechaPago(fechaPago);
        setImporte(importe);
        setFechaRegistro(fechaRegistro);
    }

    public String getServicioAsociado() {
        return servicioAsociado;
    }

    public void setServicioAsociado(String servicioAsociado) {
        if(servicioAsociado.equals("")){
            JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");
        }else{
        this.servicioAsociado = servicioAsociado;
        }
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        if(fechaPago.equals("")){
            JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");
        }else{
        this.fechaPago = fechaPago;
        }
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        if(fechaRegistro.equals("")){
            JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");
        }else{
        this.fechaRegistro = fechaRegistro;
        }
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }
}
