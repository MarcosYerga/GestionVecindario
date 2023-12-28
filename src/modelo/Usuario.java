package modelo;

import javax.swing.JOptionPane;

/**
 * Clase de los usuarios
 * @Marcos Yerga Gómez
 */
public class Usuario {

    //atributos de la clase
    /**
     * Variable referente al nombre del usuario
     */
    private String nombre;
    /**
     * Variable referente al nombre del usuario
     */
    private String apellido;
    /**
     * Variable referente al ID del usuario
     */
    private int ID;
    /**
     * Variable referente al email del usuario
     */
    private String email;

    /**
     * Variable referente al teléfono del usuario
     */
    private String telefono;
    /**
     * Variable referente a la clave o contraeña del usuario
     */
    private String clave; //Contraseña de acceso
    /**
     * Variable referente a los permisos del usuario
     */
    private int isAdmin;

    /**
     * Contructor de la clase
     * @param nombre
     * @param apellido
     * @param email
     * @param telefono
     * @param clave
     * @param isAdmin
     */
    public Usuario(String nombre, String apellido, String email, String telefono, String clave, int isAdmin) {
        setNombre(nombre);
        setApellido(apellido);
        setEmail(email);
        setTelefono(telefono);
        setClave(clave);
        setIsAdmin(isAdmin);
    }

    /**
     * Constructor sin parametros
     */
    public Usuario() {
        
    }

    /**
     * Constructor para las consultas
     * @param nombre
     * @param clave
     */
    public Usuario(String nombre, String clave){
        setNombre(nombre);
        setClave(clave);
    }
    
    /**
     * Sirve para recuperar el nombre
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sirve para establecer el nombre
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
     * Sirve para recuperar el apellido
     * @return
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Sirve para establecer el apellido
     * @param apellido
     */
    public void setApellido(String apellido) {
        if(apellido.equals("")){
            JOptionPane.showMessageDialog(null, "Debes rellenar el campo apellido ");
        }else{
        this.apellido = apellido;
        }
    }

    /**
     * Sirve para recuperar el ID
     * @return
     */
    public int getID() {
        return ID;
    }

    /**
     * Sirve para establecer el ID
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Sirve para recuperar el email
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sirve para establecer el email
     * @param email
     */
    public void setEmail(String email) {
        if(email.equals("")){
            JOptionPane.showMessageDialog(null, "Debes rellenar el campo email");
        }else{
        this.email = email;
        }
    }

    /**
     * Sirve para recuperar el telefono
     * @return
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Sirve para establecer el telefono
     * @param telefono
     */
    public void setTelefono(String telefono) {
        if(telefono.equals("")){
            JOptionPane.showMessageDialog(null, "Debes rellenar el campo Telefono");
        }else{
        this.telefono = telefono;
        }
    }

    /**
     * Sirve para recuperar la clave
     * @return
     */
    public String getClave() {
        return clave;
    }

    /**
     * Sirve para establecer la clave
     * @param clave
     */
    public void setClave(String clave) {
        if(clave.equals("")){
            JOptionPane.showMessageDialog(null, "Debes rellenar el campo Clave");
        }else{
        this.clave = clave;
        }
    }

    /**
     * Sirve para recuperar el tipo de usuario
     * @return
     */
    public int getIsAdmin() {
        return isAdmin;
    }

    /**
     * Sirve para establecer el tipo de usuario
     * @param isAdmin
     */
    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

}
