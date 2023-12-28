package modelo;

import javax.swing.JOptionPane;

/**
 * Sirve para crear entidades del tipo liquidación
 * @author Marcos Yerga Gómez
 */
public class Liquidacion {
    //Atributos de la clase
    /**
     *identificador servicio asociado
     */
    private int idServicio;

    /**
     *Total de gastos que se tienen que pagar
     */
    private float importeTotal;

    /**
     *Estado de la liquidación
     */
    private int isPagado;

    /**
     *inicio periodo asociado a la liquidacion
     */
    private String fechaInicio;

    /**
     *Final periodo asociado a liquidación
     */
    private String fechaFinal;
    /**
     * Constructor de la clase
     * @param idServicio
     * @param fechaInicio
     * @param fechaFinal
     * @param isPagado
     * @param importeTotal 
     */
    public Liquidacion(int idServicio ,String fechaInicio ,String fechaFinal,int isPagado, float importeTotal){
        setIdServicio(idServicio);
        setImporteTotal(importeTotal);
        setIsPagado(isPagado);
        setFechaInicio(fechaInicio);
        setFechaFinal(fechaFinal);
    }

    /**
     * Retorna ID del servicio de la liquidacion
     * @return
     */
    public int getIdServicio() {
        return idServicio;
    }

    /**
     * Establece ID del servicio de la liquidacion
     * @param idServicio
     */
    public void setIdServicio(int idServicio) {
        if(idServicio == 0){
            JOptionPane.showMessageDialog(null, "Debes rellenar el campo servico asociado");
        }else{
        this.idServicio = idServicio;
        }
    }

    /**
     * Retorna importe total del servicio de la liquidacion
     * @return
     */
    public float getImporteTotal() {
        return importeTotal;
    }

    /**
     * Establece importe total del servicio de la liquidacion
     * @param importeTotal
     */
    public void setImporteTotal(float importeTotal) {
        this.importeTotal = importeTotal;
    }

    /**
     * Retorna si ha sido pagada la liquidacion
     * @return
     */
    public int getIsPagado() {
        return isPagado;
    }

    /**
     *  Establece si ha sido pagada la liquidacion
     * @param isPagado
     */
    public void setIsPagado(int isPagado) {
        this.isPagado = isPagado;
    }

    /**
     * Retorna la fecha de incio de la liquidacion
     * @return
     */
    public String getFechaInicio() {
        
        return fechaInicio;
    }

    /**
     * Establece la fecha de incio de la liquidacion
     * @param fechaInicio
     */
    public void setFechaInicio(String fechaInicio) {
        if(fechaInicio.equals("")){
            JOptionPane.showMessageDialog(null, "Debes rellenar el campo Fecha de inicio");
        }else{
        this.fechaInicio = fechaInicio;
        }
    }

    /**
     * Retorna la fecha final de la liquidacion
     * @return
     */
    public String getFechaFinal() {
        return fechaFinal;
    }

    /**
     * Etablece la fecha final de la liquidacion
     * @param fechaFinal
     */
    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }
}
