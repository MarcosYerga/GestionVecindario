package vista;

import controlador.ConexionController;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que sirve para visualizar la interfaz del menu que sirve para ver gastos de un servicio del vecino
 * @author Marcos Yerga Gomez
 */
public class VerGastosVec extends javax.swing.JFrame {
    /**
     *Atributo que sirve para consultar nombre del servicio seleccionado antes
     */
    String nombreServicio =SubMenuGastosVec.gastosServicio;
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
     * Constructor de la clase
     */
    public VerGastosVec() {
        initComponents();
        setLocationRelativeTo(null);
        
        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT ID, Importe, fechaPago FROM gastos WHERE ServicioAsociado='"+nombreServicio+"'");

            ResultSet rs = pst.executeQuery();

            tabla_gastos = new JTable(modelo);
            scroll_gastos.setViewportView(tabla_gastos);

            modelo.addColumn("ID");
            modelo.addColumn("Importe");
            modelo.addColumn("fechaPago");

            while (rs.next()) {
                Object[] fila = new Object[3];

                for (int i = 0; i < 3; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
            cn.close();

        } catch (SQLException E) {
            System.err.println("Error en el registro " + E);
            JOptionPane.showMessageDialog(null, "Error en la visualizacion");
        }
    }

    /**
     * Codigo generado de forma automatica al hacer el diseño de JFRAME.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        scroll_gastos = new javax.swing.JScrollPane();
        tabla_gastos = new javax.swing.JTable();
        boton_volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Gastos asociados");

        tabla_gastos.setModel(new javax.swing.table.DefaultTableModel(
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
        scroll_gastos.setViewportView(tabla_gastos);

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
                .addGap(330, 330, 330)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(scroll_gastos, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boton_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scroll_gastos, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(boton_volver)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_volverActionPerformed
        dispose();
        new SubMenuGastosVec().setVisible(true);
    }//GEN-LAST:event_boton_volverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane scroll_gastos;
    private javax.swing.JTable tabla_gastos;
    // End of variables declaration//GEN-END:variables
}
