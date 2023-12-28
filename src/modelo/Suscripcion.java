package modelo;

import javax.swing.JOptionPane;

/**
 * Clase entidad de las suscripciones
 * @author Marcos Yerga Gómez
 */
public class Suscripcion {
    //Atributos
    /**
     *Variable referente al nombre del servicio
     */
    private int idServicio;
    /**
     *Variable referente al nombre al id del inmueble asociado a la suscripcion
     */
    private int IdInmueble;
    /**
     *Variable referente al nombre de usuario asociado a la suscripcion
     */
    private int idUsuario;
    /**
     *Variable referente a la fecha de alta de la suscripcion
     */
    private String fechaAlta;
    /**
     * Contructor de la clase
     * @param fechaAlta
     * @param idUsuario
     * @param idServicio
     * @param idInmueble 
     */
    public Suscripcion(String fechaAlta,int idUsuario, int idServicio,int idInmueble){
        setFechaAlta(fechaAlta);
        setIdUsuario(idUsuario);
        setIdServicio(idServicio);
        setIdInmueble(idInmueble);
    }

    /**
     * Sirve para obtener el ID del servico asociado
     * @return
     */
    public int getIdServicio() {
        return idServicio;
    }

    /**
     * Sirve para cambiar el id del servicio
     * @param idServicio
     */
    public void setIdServicio(int idServicio) {
        if(idServicio == 0){
            JOptionPane.showMessageDialog(null, "Debes rellenar el campo nombre");
        }else{
        this.idServicio = idServicio;
        }
    }

    /**
     * Sirve para obtener el Id del inmueble asociado
     * @return
     */
    public int getIdInmueble() {
        return IdInmueble;
    }

    /**
     * Sirve para marcar el Id del inmueble asociado
     * @param IdInmueble
     */
    public void setIdInmueble(int IdInmueble) {
         if(IdInmueble== 0){
            JOptionPane.showMessageDialog(null, "Debes rellenar el campo nombre");
        }else{
        this.IdInmueble = IdInmueble;
        }
    }

    /**
     * Sirve para obtener el Id del usuario asociado
     * @return
     */
    public int getIdUsuario() {
        return idUsuario;
    }

    /**
     * Sirve para marcar el ID del usuario asociado
     * @param idUsuario
     */
    public void setIdUsuario(int idUsuario) {
         if(idUsuario == 0){
            JOptionPane.showMessageDialog(null, "Debes rellenar el campo nombre");
        }else{
        this.idUsuario = idUsuario;
         }
    }

    /**
     * Sirve para obtener la fecha de alta
     * @return
     */
    public String getFechaAlta() {
        return fechaAlta;
    }

    /**
     * Sirve para marcar la fecha de alta
     * @param fechaAlta
     */
    public void setFechaAlta(String fechaAlta) {
         if(fechaAlta.equals("")){
            JOptionPane.showMessageDialog(null, "Debes rellenar el campo nombre");
        }else{
        this.fechaAlta = fechaAlta;
        }
    }
}
