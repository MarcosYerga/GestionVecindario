package vista;


import controlador.ConexionController;
import controlador.GastoController;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 * Clase se usa para visualizar la interfaz que crea Gastos
 * @author MArcos Yerga Gomez
 */
public class CrearGasto extends javax.swing.JFrame {
    SimpleDateFormat formatoFecha;
    /**
     * Constructor
     */
    public CrearGasto() {
        this.formatoFecha = new SimpleDateFormat("y-M-d");
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_importe = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Servicio = new javax.swing.JLabel();
        boton_aceptar = new javax.swing.JButton();
        txt_servicio = new javax.swing.JTextField();
        datachooser_fecha = new com.toedter.calendar.JDateChooser();
        boton_volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Crear Gasto");

        jLabel2.setText("Importe");

        txt_importe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_importeKeyTyped(evt);
            }
        });

        jLabel3.setText("Fecha de pago");

        Servicio.setText("Servicio");

        boton_aceptar.setText("Aceptar");
        boton_aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_aceptarActionPerformed(evt);
            }
        });

        datachooser_fecha.setDateFormatString("yyyy-MM-dd");

        boton_volver.setText("Volver");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(boton_aceptar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(boton_volver))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(Servicio)
                                    .addComponent(jLabel3))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(datachooser_fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_importe)
                                    .addComponent(txt_servicio, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_importe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Servicio)
                    .addComponent(txt_servicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(datachooser_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_volver)
                    .addComponent(boton_aceptar))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_aceptarActionPerformed
        float importe;
        String fecha, servicio;
        if(txt_importe.getText().equals("")){
            importe = 0 ;
        }else{
            importe = Float.parseFloat(txt_importe.getText().trim());
        }
        if(datachooser_fecha.getDate()==null){
            fecha = "";
        }else{
        fecha = formatoFecha.format(datachooser_fecha.getDate());
        }
        servicio = txt_servicio.getText().trim();
        try {
            Connection cn = ConexionController.conectar();
            Statement consulta = cn.createStatement();
            ResultSet registro = consulta.executeQuery("Select nombre FROM servicios WHERE nombre='"+txt_servicio.getText()+"'");
            if(registro.next()){
                GastoController crear = new GastoController();
                crear.crearGasto(importe,servicio,fecha);
                dispose();
                new VerGastosAdmin().setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null,"No existe ningun servicio con ese nombre");
            }
        } catch (SQLException ex) {
            System.err.println("Error en el registro" + ex);
            JOptionPane.showMessageDialog(null,"Error en el registro");
        }
        
        
    }//GEN-LAST:event_boton_aceptarActionPerformed

    private void txt_importeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_importeKeyTyped
        char validar = evt.getKeyChar();
        if(Character.isLetter(validar)){
            getToolkit().beep();
            JOptionPane.showMessageDialog(null,"Este campo solo admite números");
        }
    }//GEN-LAST:event_txt_importeKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Servicio;
    private javax.swing.JButton boton_aceptar;
    private javax.swing.JButton boton_volver;
    private com.toedter.calendar.JDateChooser datachooser_fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txt_importe;
    private javax.swing.JTextField txt_servicio;
    // End of variables declaration//GEN-END:variables
}
