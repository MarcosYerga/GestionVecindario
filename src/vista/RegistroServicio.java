package vista;

import controlador.ServiciosController;
import javax.swing.JOptionPane;

/**
 * Clase que sirve para visualizar la interfaz de registro de los servicios
 * @author Marcos Yerga Gomez
 */
public class RegistroServicio extends javax.swing.JFrame {
    /**
     *Atributo que sirve para consultar ID del servicio seleccionado antes
     */
    int ID = SubMenuServiciosAdmin.idServicio;
    /**
     * atributo que crea objeto de la clase ServiciosController
     */
    ServiciosController mensajero = new ServiciosController();
    
    /**
     * constructor de la clase
     */
    public RegistroServicio() {
        initComponents();
        setLocationRelativeTo(null);
        
        txt_nombre.setText(mensajero.consultarNombre());
        
        String comboSelect = mensajero.consultarObligatorio();
        if (comboSelect.equals("0")) {
            combo_obligatorio.setSelectedItem("No");
        }
        if (comboSelect.equals("1")) {
            combo_obligatorio.setSelectedItem("Si");
        }
        
    }

    /**
     * codigo generado automaticamente al diseñar el JFrame.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        boton_volver = new javax.swing.JButton();
        boton_eliminar = new javax.swing.JButton();
        boton_actualizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        combo_obligatorio = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Registro Servicio");

        boton_volver.setText("Volver");
        boton_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_volverActionPerformed(evt);
            }
        });

        boton_eliminar.setText("Eliminar");
        boton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_eliminarActionPerformed(evt);
            }
        });

        boton_actualizar.setText("Actualizar");
        boton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_actualizarActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre");

        combo_obligatorio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Si" }));

        jLabel3.setText("Obligatorio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(boton_actualizar)
                        .addGap(41, 41, 41)
                        .addComponent(boton_eliminar)
                        .addGap(35, 35, 35)
                        .addComponent(boton_volver)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(combo_obligatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(44, 44, 44)
                                .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(41, 41, 41))))
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_obligatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_volver)
                    .addComponent(boton_eliminar)
                    .addComponent(boton_actualizar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_volverActionPerformed
        dispose();
        new SubMenuServiciosAdmin().setVisible(true);
    }//GEN-LAST:event_boton_volverActionPerformed

    private void boton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_actualizarActionPerformed
        String nombre, isObligatorio;
        int obligatorio = 0;
        
        nombre = txt_nombre.getText().trim();
        isObligatorio =""+ combo_obligatorio.getSelectedItem();
        if (isObligatorio.equals("Si")) {
            obligatorio = 1;
        } else if (isObligatorio.equals("No")) {
            obligatorio = 0;
        }
        ServiciosController modificar = new ServiciosController();
        modificar.modificarServicio(nombre,obligatorio);
        
    }//GEN-LAST:event_boton_actualizarActionPerformed

    private void boton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_eliminarActionPerformed
        mensajero.eliminarServicio();
        JOptionPane.showMessageDialog(null, "Se ha eliminado el servicio");
        dispose();
        new SubMenuServiciosAdmin().setVisible(true);
    }//GEN-LAST:event_boton_eliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_actualizar;
    private javax.swing.JButton boton_eliminar;
    private javax.swing.JButton boton_volver;
    private javax.swing.JComboBox<String> combo_obligatorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
