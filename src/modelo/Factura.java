package modelo;

import javax.swing.JOptionPane;

/**
 * Sirve para gestionar la entidad factura
 * @author Marcos Yerga Gomez
 */
public class Factura {
    //atributos
    /**
     *importe de la factura
     */
    private float importe;
    /**
     *identificador gasto asociado
     */
    private int idGasto;

    /**
     *fecha de emisión de la factura
     */
    private String fecha;
    /**
     *Este es el proveedor de la factura
     */
    private String proveedor;
    /**
     *Constructor de la clase
     * @param idGasto
     * @param proveedor
     * @param importe
     * @param fecha
     */
    public Factura(int idGasto, String proveedor,float importe, String fecha){
        setIdGasto(idGasto);
        setProveedor(proveedor);
        setImporte(importe);
        setFecha(fecha);
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        if(importe == 0){
            JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");
        }else{
        this.importe = importe;
        }
    }

    public int getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(int idGasto) {
        if(idGasto == 0){
            JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");
        }else{
        this.idGasto = idGasto;
        }
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        if(fecha.equals("")){
            JOptionPane.showMessageDialog(null, "Debes rellenar el campo nombre");
        }else{
        this.fecha = fecha;
        }
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        if(proveedor.equals("")){
            JOptionPane.showMessageDialog(null, "Debes rellenar el campo nombre");
        }else{
        this.proveedor = proveedor;
        }
    }
}
