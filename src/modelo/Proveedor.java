package modelo;

import javax.swing.JOptionPane;

/**
 * Clase que define la entidad proveedor
 * @author Marcos Yerga Gómez
 */
public class Proveedor {
    //atributos de la clase
    /**
     *Variable referente al nombre del proveedor
     */
    private String nombre;
    /**
     *Variable referente al email del proveedor
     */
    private String email;
    /**
     *Variable referente al telefono del proveedor
     */
    private String telefono;
    /**
     *Variable referente al direccion del proveedor
     */
    private String direccion;
    
   /**
    * Constructor de la clase
     * @param nombre
     * @param email
     * @param telefono
     * @param direccion
    */
    public Proveedor(String nombre,String email,String telefono,String direccion){
        setNombre(nombre);
        setEmail(email);
        setTelefono(telefono);
        setDireccion(direccion);
    }

    /**
     * Retorna el nombre del proveedor
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Estable el nombre del proveedor
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
     *  Retorna el email del proveedor
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *  Estable el email del proveedor
     * @param email
     */
    public void setEmail(String email) {
        if(email.equals("")){
            JOptionPane.showMessageDialog(null, "Debes rellenar el campo nombre");
        }else{
        this.email = email;
        }
    }

    /**
     * Retorna el telefono del proveedor
     * @return
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     *  Estable el telefono del proveedor
     * @param telefono
     */
    public void setTelefono(String telefono) {
        if(telefono.equals("")){
            JOptionPane.showMessageDialog(null, "Debes rellenar el campo nombre");
        }else{
        this.telefono = telefono;
        }
    }

    /**
     *  Retorna la direccion del proveedor
     * @return
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     *  Estable la direccion del proveedor
     * @param direccion
     */
    public void setDireccion(String direccion) {
        if(direccion.equals("")){
            JOptionPane.showMessageDialog(null, "Debes rellenar el campo nombre");
        }else{
        this.direccion = direccion;
        }
    }
}
