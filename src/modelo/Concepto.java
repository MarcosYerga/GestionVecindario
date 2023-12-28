package modelo;

import javax.swing.JOptionPane;

/**
 * Sirve para gestionar la entidad concepto
 * @author Marcos Yerga Gómez
 */
public class Concepto {
    //atributos
    /**
     *breve descripcion del nuevo gasto
     */
    private String descripcion;

    /**
     *identificador del  gasto al que va asociado
     */
    private int idGasto;

    /**
     *fecha en la que se añade nuevo concepto
     */
    private String fecha;
    
    public Concepto(int idGasto,String descripcion,String fecha){
        setIdGasto(idGasto);
        setDescripcion(descripcion);
        setFecha(fecha);
    }
    //Métodos
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if(descripcion.equals("")){
            JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");
        }else{
        this.descripcion = descripcion;
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
            JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");
        }else{
        this.fecha = fecha;
        }
    }
}
