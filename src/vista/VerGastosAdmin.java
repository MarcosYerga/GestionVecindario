package vista;

import controlador.ConexionController;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que sirve para visualizar la interfaz del menu que vee los gastos de un servicio del administrador
 * @author Marcos Yerga Gomez
 */
public class VerGastosAdmin extends javax.swing.JFrame {
    /**
     *Atributo que sirve para consultar nombre del servicio seleccionado antes
     */
    String Servicio =SubMenuGastosAdmin.nombreServicio;

    /**
     * atributo para enviar el atributo ID de gasto a otras clases
     */
    public static int idGasto;
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
     * Contructor de la clase
     */
    public VerGastosAdmin() {
        initComponents();
        setLocationRelativeTo(null);
        
        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT ID, Importe, fechaPago, fechaRegistro FROM gastos WHERE ServicioAsociado='"+Servicio+"'");

            ResultSet rs = pst.executeQuery();

            tabla_gastos = new JTable(modelo);
            scroll_gastos.setViewportView(tabla_gastos);

            modelo.addColumn("ID");
            modelo.addColumn("Importe");
            modelo.addColumn("Fecha de pago");
            modelo.addColumn("Fecha de Registro");

            while (rs.next()) {
                Object[] fila = new Object[4];

                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                modelo.addRow(fila);
            }
            cn.close();

        } catch (SQLException E) {
            System.err.println("Error en el registro " + E);
            JOptionPane.showMessageDialog(null, "Error en la visualizacion");
        }
        tabla_gastos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tabla_gastos.rowAtPoint(e.getPoint());
                int columna_point = 0;
                idGasto = (int)modelo.getValueAt(fila_point, columna_point);
                
                dispose();
                new OpcionesGasto().setVisible(true);
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        scroll_gastos = new javax.swing.JScrollPane();
        tabla_gastos = new javax.swing.JTable();
        boton_volver = new javax.swing.JButton();
        boton_crear = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Gastos del Servicio");

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

        boton_crear.setText("Crear Gasto");
        boton_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_crearActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel2.setText("Para ver el concepto relacionado al gasto haga click en el gasto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(309, 309, 309)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(scroll_gastos)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                .addComponent(boton_crear)
                .addGap(34, 34, 34)
                .addComponent(boton_volver)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll_gastos, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_volver)
                    .addComponent(boton_crear)
                    .addComponent(jLabel2))
                .addGap(0, 40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_volverActionPerformed
        dispose();
        new SubMenuGastosAdmin().setVisible(true);
    }//GEN-LAST:event_boton_volverActionPerformed

    private void boton_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_crearActionPerformed
        dispose();
        new CrearGasto().setVisible(true);
    }//GEN-LAST:event_boton_crearActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_crear;
    private javax.swing.JButton boton_volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane scroll_gastos;
    private javax.swing.JTable tabla_gastos;
    // End of variables declaration//GEN-END:variables
}
