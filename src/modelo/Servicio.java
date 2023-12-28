package modelo;

import javax.swing.JOptionPane;

/**
 * Clase que estable la entidad servicio
 * @author Marcos Yerga Gómez
 */
public class Servicio {
     //Atributos de la clase
    /**
     *Nombre del servicio
     */
    private String nombre;
    /**
     *para marcar si es un servicio para todos los vecinos
     */
    private int isObligatorio;
    /**
     * Constructor de la clase
     * @param nombre
     * @param isObligatorio
     */
    public Servicio(String nombre, int isObligatorio){
        setNombre(nombre);
        setIsObligatorio(isObligatorio);
    }

    /**
     * Sirve para obtener nombre de servicio
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sirve para obtener tipo de servicio
     * @return
     */
    public int getIsObligatorio() {
        return isObligatorio;
    }

    /**
     * Sirve para marcar nombre de servicio
     * @param nombre
     */
    public void setNombre(String nombre) {
        if(nombre.equals("")){
            JOptionPane.showMessageDialog(null, "Debes rellenar el campo nombre");
        }else{
        this.nombre = nombre;
        }
    }

    /**
     * Sirve para marcar tipo de servicio
     * @param isObligatorio
     */
    public void setIsObligatorio(int isObligatorio) {
        this.isObligatorio = isObligatorio;

    }
}
