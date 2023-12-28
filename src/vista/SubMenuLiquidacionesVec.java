package vista;

import controlador.ConexionController;
import controlador.LiquidacionController;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que sirve para visualizar la interfaz del menu de liquidaciones del vecino
 * @author Marcos Yerga Gomez
 */
public class SubMenuLiquidacionesVec extends javax.swing.JFrame {
    /**
     * Atributo ID de servicio
     */
    int idServicios;
    /**
     * Atributo ID de usuario
     */
    int idUsuario;
    /**
     * atributo que sirve para modificar la tabla y metodo que hace que no se pueda escribir en las casillas
     */
    DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    /**
     * Creates new form SubMenuLiquidacionesVec
     */
    public SubMenuLiquidacionesVec() {
        initComponents();
        setLocationRelativeTo(null);
        LiquidacionController liquidacion = new LiquidacionController();
        idUsuario = liquidacion.consultarIDUsuario();
        tabla_servicios = new JTable(modelo);
        scroll_servicios.setViewportView(tabla_servicios);

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Tarifa");


        try {
            Connection cn = ConexionController.conectar();
            Statement consulta = cn.createStatement();
            ResultSet registro = consulta.executeQuery(" Select IDServicio FROM suscripcion where IDUsuario='" + idUsuario + "' AND isActivo='" + 1 + "'");
            while (registro.next()) {

                idServicios = registro.getInt("IDServicio");
                Statement consulta2 = cn.createStatement();
                ResultSet rs = consulta2.executeQuery("SELECT ID, nombre, tarifa FROM servicios WHERE ID='" + idServicios + "'");
                if (rs.next()) {
                    Object[] fila = new Object[3];

                    for (int i = 0; i < 3; i++) {
                        fila[i] = rs.getObject(i + 1);

                    }
                    modelo.addRow(fila);
                }
            }
            Statement consulta2 = cn.createStatement();
            ResultSet rs3 = consulta2.executeQuery("SELECT ID, nombre, tarifa FROM servicios WHERE isObligatorio='" + 1 + "'");
            while(rs3.next()){
                Object[] fila = new Object[3];

                    for (int i = 0; i < 3; i++) {
                        fila[i] = rs3.getObject(i + 1);

                    }
                    modelo.addRow(fila);
            }
            
            cn.close();

        } catch (SQLException E) {
            System.err.println("Error en el registro " + E);
            JOptionPane.showMessageDialog(null, "Error en la visualizacion");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        scroll_servicios = new javax.swing.JScrollPane();
        tabla_servicios = new javax.swing.JTable();
        boton_volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Menú Liquidaciones");

        tabla_servicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scroll_servicios.setViewportView(tabla_servicios);

        boton_volver.setText("Volver");
        boton_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_volverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(291, 291, 291)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(scroll_servicios, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boton_volver)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scroll_servicios, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(boton_volver)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_volverActionPerformed
        dispose();
        new MenuVecino().setVisible(true);
    }//GEN-LAST:event_boton_volverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane scroll_servicios;
    private javax.swing.JTable tabla_servicios;
    // End of variables declaration//GEN-END:variables
}
