package vista;

import controlador.ConceptoController;
import controlador.FacturaController;

/**
 * Clase que sirve para visualizar la interfaz de registro de los conceptos
 * @author Marcos Yerga Gomez
 */
public class RegistroConcepto extends javax.swing.JFrame {
    /**
     *Atributo que sirve para consultar ID del gasto seleccionado antes
     */
    int IDGasto = VerGastosAdmin.idGasto;
    /**
     *Atributo que sirve para obtener ID del proveedor seleccionado 
     */
    public static int idProveedor;
    /**
     * atributo que crea objeto de la clase ConceptoController
     */
    ConceptoController mensajero = new ConceptoController();
    /**
     * atributo que crea objeto de la clase FacturaController
     */
    FacturaController mensajeroFactura= new FacturaController();
    /**
     * Constructor de la clase
     */
    public RegistroConcepto() {
        initComponents();
        setLocationRelativeTo(null);
        
        txt_registro.setText(mensajero.consultarFecha());
        txt_descripcion.setText(mensajero.consultarDescripcion());
        txt_factura.setText(""+mensajeroFactura.consultarID());
        txt_proveedor.setText(mensajeroFactura.consultarProveedor());
    }

    /**
     * Codigo autogenerado al diseña el JFRAME
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_registro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_descripcion = new javax.swing.JTextArea();
        boton_volver = new javax.swing.JButton();
        boton_actualizar = new javax.swing.JButton();
        boton_eliminar = new javax.swing.JButton();
        boton_factura = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_factura = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_proveedor = new javax.swing.JTextField();
        boton_proveedor = new javax.swing.JButton();
        boton_crear = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Registro de Concepto");

        jLabel2.setText("Fecha Registro");

        jLabel3.setText("Descripcion");

        txt_descripcion.setColumns(20);
        txt_descripcion.setRows(5);
        jScrollPane1.setViewportView(txt_descripcion);

        boton_volver.setText("Volver");
        boton_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_volverActionPerformed(evt);
            }
        });

        boton_actualizar.setText("Actualizar");
        boton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_actualizarActionPerformed(evt);
            }
        });

        boton_eliminar.setText("Eliminar");
        boton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_eliminarActionPerformed(evt);
            }
        });

        boton_factura.setText("Crear factura");
        boton_factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_facturaActionPerformed(evt);
            }
        });

        jLabel4.setText("ID Factura");

        jLabel5.setText("Proveedor");

        boton_proveedor.setText("Consultar proveedor");
        boton_proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_proveedorActionPerformed(evt);
            }
        });

        boton_crear.setText("Crear");
        boton_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_crearActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        jLabel6.setText("El boton actualizar sirve para modificar el campo Descripcion y actualizar la fecha de registro");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 9)); // NOI18N
        jLabel7.setText("La opcion para crear proveedores esta dentro de consultar proveedor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                                .addGap(55, 55, 55))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(boton_actualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(boton_crear, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(boton_eliminar)
                                .addGap(74, 74, 74)
                                .addComponent(boton_volver))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_registro)
                                    .addComponent(txt_factura)
                                    .addComponent(jScrollPane1)
                                    .addComponent(txt_proveedor))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(boton_proveedor)
                                    .addComponent(boton_factura, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7))
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_registro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_factura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_factura))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boton_proveedor))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_volver)
                    .addComponent(boton_actualizar)
                    .addComponent(boton_eliminar)
                    .addComponent(boton_crear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_volverActionPerformed
        dispose();
        new VerGastosAdmin().setVisible(true);
    }//GEN-LAST:event_boton_volverActionPerformed

    private void boton_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_crearActionPerformed
        new CrearConcepto().setVisible(true);
    }//GEN-LAST:event_boton_crearActionPerformed

    private void boton_facturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_facturaActionPerformed
        new CrearFactura().setVisible(true);
    }//GEN-LAST:event_boton_facturaActionPerformed

    private void boton_proveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_proveedorActionPerformed
        idProveedor = Integer.parseInt(txt_proveedor.getText());
        new RegistroProveedor().setVisible(true);
    }//GEN-LAST:event_boton_proveedorActionPerformed

    private void boton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_actualizarActionPerformed
        String descripcion;
        descripcion = txt_descripcion.getText().trim();
        
        ConceptoController modificar = new ConceptoController();
        modificar.modificarConcepto(descripcion);
        txt_registro.setText(mensajero.consultarFecha());
        
    }//GEN-LAST:event_boton_actualizarActionPerformed

    private void boton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_eliminarActionPerformed
        mensajero.eliminarConcepto();
        new VerGastosAdmin().setVisible(true);
    }//GEN-LAST:event_boton_eliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_actualizar;
    private javax.swing.JButton boton_crear;
    private javax.swing.JButton boton_eliminar;
    private javax.swing.JButton boton_factura;
    private javax.swing.JButton boton_proveedor;
    private javax.swing.JButton boton_volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txt_descripcion;
    private javax.swing.JTextField txt_factura;
    private javax.swing.JTextField txt_proveedor;
    private javax.swing.JTextField txt_registro;
    // End of variables declaration//GEN-END:variables
}
