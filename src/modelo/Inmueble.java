package modelo;

import javax.swing.JOptionPane;

/**
 * Clase que define entidad inmueble
 * @author Marcos Yerga Gómez
 */
public class Inmueble {
    //Atributos de la clase
    /**
     * Variable que hace referente al nombre de la calle donde se ubica de cada
     * inmueble
     */
    private String calle;
    /**
     * Variable que hace referente al numero de la calle donde se ubica de cada
     * inmueble
     */
    private int numero;
    /**
     * Variable que hace referente al portal donde se ubica de cada inmueble
     */
    private String portal;
    /**
     * Variable que hace referente al piso donde se ubica de cada inmueble
     */
    private String piso;
     /**
     * Constructor de la clase
     *
     * @param calle
     * @param numero
     */
    public Inmueble(String calle, int numero) {
        setCalle(calle);
        setNumero(numero);
        portal = "";
        piso = "";
    }
    /**
     * Constructor de la clase para apartamentos
     * @param calle
     * @param numero
     * @param portal
     * @param piso
     */
    public Inmueble(String calle, int numero, String portal, String piso) {
        setCalle(calle);
        setNumero(numero);
        setPortal(portal);
        setPiso(piso);
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        if(calle.equals("")){
            JOptionPane.showMessageDialog(null, "Debes rellenar el campo apellido ");
        }else{
        this.calle = calle;
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if(numero == 0){
            JOptionPane.showMessageDialog(null, "Debes rellenar el campo apellido ");
        }else{
        this.numero = numero;
        }
    }

    public String getPortal() {
        return portal;
    }

    public void setPortal(String portal) {
        if(portal.equals("")){
            JOptionPane.showMessageDialog(null, "Debes rellenar el campo apellido ");
        }else{
        this.portal = portal;
        }
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        if(piso.equals("")){
            JOptionPane.showMessageDialog(null, "Debes rellenar el campo apellido ");
        }else{
        this.piso = piso;
        }
    }
}
