package vista;

import controlador.ConexionController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que sirve para visualizar la interfaz del menu de gastos del administrador
 * @author Marcos Yerga Gomez
 */
public class SubMenuGastosAdmin extends javax.swing.JFrame {
    /**
     * atributo para enviar el atributo nombre de servicio a otras clases
     */
    public static String nombreServicio ;
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
     * Constructor
     */
    public SubMenuGastosAdmin() {
        initComponents();
        setLocationRelativeTo(null);
        
        try{
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT ID, nombre, isObligatorio, tarifa FROM servicios");

            ResultSet rs = pst.executeQuery();

            tabla_servicios = new JTable(modelo);
            scroll_servicios.setViewportView(tabla_servicios);

            modelo.addColumn("ID");
            modelo.addColumn("Nombre");
            modelo.addColumn("Obligatorio");
            modelo.addColumn("Tarifa");

            while (rs.next()) {
                Object[] fila = new Object[4];

                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
            cn.close();
        }catch(SQLException e){
            System.err.println("Error en el registro" + e);
            JOptionPane.showMessageDialog(null, "Error en la visualizacion");
        }
        tabla_servicios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tabla_servicios.rowAtPoint(e.getPoint());
                int columna_point = 1;
                nombreServicio = (String)modelo.getValueAt(fila_point, columna_point);
                
                dispose();
                new VerGastosAdmin().setVisible(true);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        boton_volver = new javax.swing.JButton();
        scroll_servicios = new javax.swing.JScrollPane();
        tabla_servicios = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Menu de Gastos");

        boton_volver.setText("Volver");
        boton_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_volverActionPerformed(evt);
            }
        });

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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel2.setText("Para ver los gastos asociados a un servicio haz click en el servicio");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(294, 294, 294)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(scroll_servicios, javax.swing.GroupLayout.DEFAULT_SIZE, 721, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boton_volver)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll_servicios, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_volver)
                    .addComponent(jLabel2))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_volverActionPerformed
        dispose();
        new MenuAdmin().setVisible(true);
    }//GEN-LAST:event_boton_volverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane scroll_servicios;
    private javax.swing.JTable tabla_servicios;
    // End of variables declaration//GEN-END:variables
}
