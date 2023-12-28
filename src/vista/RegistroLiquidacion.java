package vista;

import controlador.LiquidacionController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que sirve para visualizar la interfaz de registro de las liquidaciones
 * @author Marcos Yerga Gomez
 */
public class RegistroLiquidacion extends javax.swing.JFrame {
    /**
     * atributo para crea objeto de la clase SimpleDateFormat para manipular fechas
     */
    SimpleDateFormat formatoFecha;
    /**
     *Atributo que sirve para consultar ID de la liquidacion seleccionado antes
     */
    int IDLiquidacion = LiquidacionesServicioAdmin.idLiquidacion;
    /**
     *Atributo que sirve para consultar ID del servicio seleccionado antes
     */
    int IDServicio = SubMenuLiquidacionesAdmin.idServicio;
    /**
     * atributo que crea objeto de la clase LiquidacionController
     */
    LiquidacionController mensajero = new LiquidacionController();
    
    /**
     * Constructor de la clase
     */
    public RegistroLiquidacion() {
        initComponents();
        setLocationRelativeTo(null);
        
        txt_inicio.setText(mensajero.consultarInicio());
        txt_fin.setText(mensajero.consultarFinal());
        txt_servicio.setText(""+IDServicio);
        txt_total.setText(""+mensajero.consultarImporte());
        
        String comboSelect = mensajero.consultarPagado();
        if (comboSelect.equals("0")) {
            combo_pagado.setSelectedItem("No");
        }
        if (comboSelect.equals("1")) {
            combo_pagado.setSelectedItem("Si");
        }
    }

    /**
     * Codigo generado automaticamente al diseñar el Jframe
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        boton_volver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        boton_eliminar = new javax.swing.JButton();
        boton_actualizar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        txt_inicio = new javax.swing.JTextField();
        txt_fin = new javax.swing.JTextField();
        txt_servicio = new javax.swing.JTextField();
        combo_pagado = new javax.swing.JComboBox<>();
        date_inicio = new com.toedter.calendar.JDateChooser();
        date_fin = new com.toedter.calendar.JDateChooser();
        boton_cerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        boton_volver.setText("Volver");
        boton_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_volverActionPerformed(evt);
            }
        });

        jLabel1.setText("Registro de Liquidacion");

        jLabel2.setText("Importe Total");

        jLabel3.setText("Fecha de inicio");

        jLabel4.setText("Fecha de fin");

        jLabel5.setText("Servicio Asociado");

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

        jButton4.setText("Detalle liquidacion");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel6.setText("Pagado");

        combo_pagado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Si" }));

        date_inicio.setDateFormatString("yyyy-mm-dd");

        date_fin.setDateFormatString("yyyy-mm-dd");

        boton_cerrar.setText("Cerrar Liquidacion");
        boton_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_cerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_total)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_inicio, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                            .addComponent(txt_fin))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(date_inicio, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                            .addComponent(date_fin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(txt_servicio)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(boton_cerrar)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(boton_actualizar)
                                        .addGap(18, 18, 18)
                                        .addComponent(boton_eliminar)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(combo_pagado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(boton_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(30, 30, 30))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txt_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(date_inicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txt_fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(date_fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_servicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(combo_pagado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(boton_cerrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_volver)
                    .addComponent(boton_eliminar)
                    .addComponent(boton_actualizar)
                    .addComponent(jButton4))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_volverActionPerformed
        dispose();
        new LiquidacionesServicioAdmin().setVisible(true);
    }//GEN-LAST:event_boton_volverActionPerformed

    private void boton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_actualizarActionPerformed
        this.formatoFecha = new SimpleDateFormat("y-M-d");
        String isPagado,fechaInicio,fechaFinal;
        float importeTotal;
        int pagado = 0, idServicio;
        idServicio = Integer.parseInt(txt_servicio.getText().trim());
        importeTotal = Float.parseFloat(txt_total.getText().trim());
        isPagado = "" + combo_pagado.getSelectedItem();
        if (isPagado.equals("Si")) {
            pagado = 1;
        } else if (isPagado.equals("No")) {
            pagado = 0;
        }
        if(date_inicio.getDate()==null){
            fechaInicio = "";
        }else{
        fechaInicio = formatoFecha.format(date_inicio.getDate());
        }
        if(date_fin.getDate()==null){
            fechaFinal = txt_fin.getText();
        }else{
        fechaFinal = formatoFecha.format(date_fin.getDate());
        }
        LiquidacionController modificar = new LiquidacionController();
        modificar.actualizarLiquidacion(idServicio, fechaInicio, fechaFinal,pagado,importeTotal);
        txt_inicio.setText(mensajero.consultarInicio());
        txt_fin.setText(mensajero.consultarFinal());
        
    }//GEN-LAST:event_boton_actualizarActionPerformed

    private void boton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_eliminarActionPerformed
        mensajero.eliminarLiquidacion();
        dispose();
        new LiquidacionesServicioAdmin().setVisible(true);
    }//GEN-LAST:event_boton_eliminarActionPerformed

    private void boton_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_cerrarActionPerformed
        try {
            mensajero.cerrarLiquidación();
            txt_total.setText(""+mensajero.consultarImporte());
            txt_fin.setText(mensajero.consultarFinal());
        } catch (ParseException ex) {
            Logger.getLogger(RegistroLiquidacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        txt_total.setText(""+mensajero.consultarImporte());
        txt_fin.setText(mensajero.consultarFinal());
        
    }//GEN-LAST:event_boton_cerrarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        mensajero.detalleLiquidacion();
    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_actualizar;
    private javax.swing.JButton boton_cerrar;
    private javax.swing.JButton boton_eliminar;
    private javax.swing.JButton boton_volver;
    private javax.swing.JComboBox<String> combo_pagado;
    private com.toedter.calendar.JDateChooser date_fin;
    private com.toedter.calendar.JDateChooser date_inicio;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txt_fin;
    private javax.swing.JTextField txt_inicio;
    private javax.swing.JTextField txt_servicio;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
