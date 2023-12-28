package vista;
import java.sql.*;
import controlador.ConexionController;
import javax.swing.JOptionPane;
import controlador.LogginController;

/**
 * Clase se usa para visualizar la interfaz de loggin
 * @author Marcos Yerga Gomez
 */
public class LogginVista extends javax.swing.JFrame {

    /**
     * atributo para guardar el nombre de usuario
     */
    public static String nombreUsuario = "";

    /**
     * atributo para guardar el nombre de usuario
     */
    public static String contraseña = "";
    /**
     * Constructor
     */
    public LogginVista() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new javax.swing.JLabel();
        botonAceptar = new javax.swing.JButton();
        labelNombre = new javax.swing.JLabel();
        labelContraseña = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_clave = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label1.setText("Inicio de sesión");

        botonAceptar.setText("Acceder");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        labelNombre.setText("Usuario");

        labelContraseña.setText("Contraseña");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(labelNombre)
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelContraseña)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_clave, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botonAceptar)
                        .addGap(155, 155, 155))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(label1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelNombre))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_clave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelContraseña))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(botonAceptar)
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        nombreUsuario = txt_nombre.getText().trim();
        contraseña = txt_clave.getText().trim();
        String controlar = "";
        LogginController validar = new LogginController(nombreUsuario, contraseña);
        validar.isValid();
        controlar = validar.getCorrect();
        if(!nombreUsuario.equals("")|| !contraseña.equals("")){
            if(controlar.equals("1")){
                controlar = validar.getValid();
                if(controlar.equals("1")){
                    dispose();
                    new MenuAdmin().setVisible(true);
                }else if(controlar.equals("0")){
                    dispose();
                    new MenuVecino().setVisible(true);
                }
            }else if(controlar.equals("0")){
                JOptionPane.showMessageDialog(null,"Datos de acceso incorrectos");
                txt_nombre.setText("");
                txt_clave.setText("");
            }
        }else{
                JOptionPane.showMessageDialog(null,"Debes rellenar todos los campos");
                }
    }//GEN-LAST:event_botonAceptarActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel labelContraseña;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JPasswordField txt_clave;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables

}
