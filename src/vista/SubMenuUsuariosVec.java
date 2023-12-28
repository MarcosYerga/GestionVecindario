package vista;

import controlador.VecinoController;

/**
 * Clase que sirve para visualizar la interfaz del menu de usuarios del vecino
 * @author Marcos Yerga Gomez
 */
public class SubMenuUsuariosVec extends javax.swing.JFrame {
    /**
     * Atributo para otener resultado tipo INT
     **/
    int resultadoInt ;
    /**
     * Atributo para otener resultado tipo String
     **/
    String resultadoString;

    /**
     * Constructor
     */
    public SubMenuUsuariosVec() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * Código generado al usar el diseño de JFRAME
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        botonID = new javax.swing.JButton();
        botonNombre = new javax.swing.JButton();
        botonInmuebles = new javax.swing.JButton();
        botonEmail = new javax.swing.JButton();
        botonVolver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        labelRespuesta = new javax.swing.JLabel();
        botonTelefono = new javax.swing.JButton();
        boton_apellido = new javax.swing.JButton();
        boton_clave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Menú usuario");

        botonID.setText("Consultar ID");
        botonID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIDActionPerformed(evt);
            }
        });

        botonNombre.setText("Consultar Nombre");
        botonNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNombreActionPerformed(evt);
            }
        });

        botonInmuebles.setText("Consultar Inmuebles");
        botonInmuebles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInmueblesActionPerformed(evt);
            }
        });

        botonEmail.setText("Consultar Email");
        botonEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEmailActionPerformed(evt);
            }
        });

        botonVolver.setText("Volver");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });

        jLabel2.setText("Resultado de la consulta:");

        labelRespuesta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        botonTelefono.setText("Consultar Telefono");
        botonTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTelefonoActionPerformed(evt);
            }
        });

        boton_apellido.setText("Consultar Apellido");
        boton_apellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_apellidoActionPerformed(evt);
            }
        });

        boton_clave.setText("Consultar Clave");
        boton_clave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_claveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelRespuesta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 191, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(207, 207, 207))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(botonTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botonInmuebles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botonID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botonNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botonEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(boton_apellido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(boton_clave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(175, 175, 175))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(botonID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(boton_apellido)
                .addGap(15, 15, 15)
                .addComponent(botonInmuebles)
                .addGap(18, 18, 18)
                .addComponent(botonEmail)
                .addGap(18, 18, 18)
                .addComponent(botonTelefono)
                .addGap(18, 18, 18)
                .addComponent(boton_clave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonVolver)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(labelRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        dispose();
        new MenuVecino().setVisible(true);
    }//GEN-LAST:event_botonVolverActionPerformed

    private void botonIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIDActionPerformed
      VecinoController vecino = new VecinoController();
      resultadoInt = vecino.consultarID();
      labelRespuesta.setText(""+resultadoInt);
    }//GEN-LAST:event_botonIDActionPerformed

    private void botonNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNombreActionPerformed
      VecinoController vecino = new VecinoController();
      resultadoString= vecino.consultarNombre();
      labelRespuesta.setText(resultadoString);
    }//GEN-LAST:event_botonNombreActionPerformed

    private void botonInmueblesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInmueblesActionPerformed
      VecinoController vecino = new VecinoController();
      resultadoString = vecino.consultarInmueble();
      labelRespuesta.setText(resultadoString); 
    }//GEN-LAST:event_botonInmueblesActionPerformed

    private void botonEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEmailActionPerformed
      VecinoController vecino = new VecinoController();
      resultadoString = vecino.consultarEmail();
      labelRespuesta.setText(resultadoString); 
    }//GEN-LAST:event_botonEmailActionPerformed

    private void botonTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTelefonoActionPerformed
      VecinoController vecino = new VecinoController();
      resultadoString = vecino.consultarTelefono();
      labelRespuesta.setText(""+resultadoString);
    }//GEN-LAST:event_botonTelefonoActionPerformed

    private void boton_apellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_apellidoActionPerformed
      VecinoController vecino = new VecinoController();
      resultadoString = vecino.consultarApellido();
      labelRespuesta.setText(resultadoString);
    }//GEN-LAST:event_boton_apellidoActionPerformed

    private void boton_claveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_claveActionPerformed
      VecinoController vecino = new VecinoController();
      resultadoString = vecino.consultarClave();
      labelRespuesta.setText(resultadoString);
    }//GEN-LAST:event_boton_claveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEmail;
    private javax.swing.JButton botonID;
    private javax.swing.JButton botonInmuebles;
    private javax.swing.JButton botonNombre;
    private javax.swing.JButton botonTelefono;
    private javax.swing.JButton botonVolver;
    private javax.swing.JButton boton_apellido;
    private javax.swing.JButton boton_clave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel labelRespuesta;
    // End of variables declaration//GEN-END:variables
}
