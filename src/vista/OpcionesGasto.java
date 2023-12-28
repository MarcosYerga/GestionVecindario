package vista;

/**
 * Clase que sirve para visualizar la interfaz de las opciones a realizar con los gastos
 * @author Marcos Yerga Gomez
 */
public class OpcionesGasto extends javax.swing.JFrame {

    /**
     * Creates new form OpcionesGasto
     */
    public OpcionesGasto() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        boton_Volver = new javax.swing.JButton();
        boton_modificar = new javax.swing.JButton();
        boton_consultar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("¿Que desea hacer?");

        boton_Volver.setText("Volver");
        boton_Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_VolverActionPerformed(evt);
            }
        });

        boton_modificar.setText("Modificar ");
        boton_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_modificarActionPerformed(evt);
            }
        });

        boton_consultar.setText("Consultar");
        boton_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_consultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(boton_modificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(boton_consultar)
                .addGap(45, 45, 45)
                .addComponent(boton_Volver)
                .addGap(10, 10, 10))
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_Volver)
                    .addComponent(boton_modificar)
                    .addComponent(boton_consultar))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_VolverActionPerformed
        dispose();
        new VerGastosAdmin().setVisible(true);
    }//GEN-LAST:event_boton_VolverActionPerformed

    private void boton_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_modificarActionPerformed
        dispose();
        new RegistroGasto().setVisible(true);
    }//GEN-LAST:event_boton_modificarActionPerformed

    private void boton_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_consultarActionPerformed
        dispose();
        new RegistroConcepto().setVisible(true);
    }//GEN-LAST:event_boton_consultarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_Volver;
    private javax.swing.JButton boton_consultar;
    private javax.swing.JButton boton_modificar;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
