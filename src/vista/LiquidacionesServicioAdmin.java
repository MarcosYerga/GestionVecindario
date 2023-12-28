package vista;

import controlador.ConexionController;
import controlador.LiquidacionController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static vista.SubMenuLiquidacionesAdmin.idServicio;

/**
 * Clase se usa para visualizar la interfaz que gestiona liquidaciones de un servicio
 * @author Marcos Yerga Gomez
 */
public class LiquidacionesServicioAdmin extends javax.swing.JFrame {
    /**
     * Atributos
     */
    public static int idLiquidacion;
    DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    /**
     * Constructor de la clase
     */
    public LiquidacionesServicioAdmin() {
        initComponents();
        setLocationRelativeTo(null);
        
        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT ID,ImporteTotal,IsPagado,FechaInicio,FechaFinal,IDservicio FROM liquidaciones");

            ResultSet rs = pst.executeQuery();

            tabla_liquidaciones = new JTable(modelo);
            scroll_liquidaciones.setViewportView(tabla_liquidaciones);
            
            modelo.addColumn("ID");
            modelo.addColumn("Importe Total");
            modelo.addColumn("Pagado");
            modelo.addColumn("Fecha Inicio");
            modelo.addColumn("Fecha Final");
            modelo.addColumn("ID Servicio");
            

            while (rs.next()) {
                Object[] fila = new Object[6];

                for (int i = 0; i < 6; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
            cn.close();

        } catch (SQLException E) {
            System.err.println("Error en el registro" + E);
            JOptionPane.showMessageDialog(null, "Error en la visualizacion");
        }
        tabla_liquidaciones.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tabla_liquidaciones.rowAtPoint(e.getPoint());
                int columna_point = 0;
                idLiquidacion = (int)modelo.getValueAt(fila_point, columna_point);
                
                dispose();
                new RegistroLiquidacion().setVisible(true);
            }
        });
    }

    /**
     * Codigo generado al hacer el diseño por JFrame
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        boton_volver = new javax.swing.JButton();
        scroll_liquidaciones = new javax.swing.JScrollPane();
        tabla_liquidaciones = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Liquidaciones del servicio");

        boton_volver.setText("Volver");
        boton_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_volverActionPerformed(evt);
            }
        });

        tabla_liquidaciones.setModel(new javax.swing.table.DefaultTableModel(
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
        scroll_liquidaciones.setViewportView(tabla_liquidaciones);

        jButton1.setText("Crear Liquidacion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel2.setText("Para ver modificar los atributos de una liquidacion haga click sobre ella");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(boton_volver)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(scroll_liquidaciones, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scroll_liquidaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_volver)
                    .addComponent(jButton1)
                    .addComponent(jLabel2))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_volverActionPerformed
        dispose();
        new SubMenuLiquidacionesAdmin().setVisible(true);
    }//GEN-LAST:event_boton_volverActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        LiquidacionController crear = new LiquidacionController();
        crear.crearLiquidacion();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_volver;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane scroll_liquidaciones;
    private javax.swing.JTable tabla_liquidaciones;
    // End of variables declaration//GEN-END:variables
}
