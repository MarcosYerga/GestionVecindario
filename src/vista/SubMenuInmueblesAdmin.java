package vista;

import controlador.ConexionController;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que sirve para visualizar la interfaz del menu de inmuebels del administrador
 * @author Marcos Yerga Gomez
 */
public class SubMenuInmueblesAdmin extends javax.swing.JFrame {
    /**
     * atributo para enviar el atributo ID de inmueble a otras clases
     */
    public static int idInmueble = 0;
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
     *Conctructor de la clase
     */
    public SubMenuInmueblesAdmin() {
        initComponents();
        setLocationRelativeTo(null);

        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT ID, calle,numero, portal, piso, propietario FROM inmuebles");
            ResultSet rs = pst.executeQuery();

            tabla_inmuebles = new JTable(modelo);
            scroll_inmuebles.setViewportView(tabla_inmuebles);

            modelo.addColumn("ID");
            modelo.addColumn("Calle");
            modelo.addColumn("Numero");
            modelo.addColumn("Portal");
            modelo.addColumn("Piso");
            modelo.addColumn("ID Propietario");


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
        tabla_inmuebles.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tabla_inmuebles.rowAtPoint(e.getPoint());
                int columna_point = 0;
                idInmueble = (int) modelo.getValueAt(fila_point, columna_point);

                RegistroInmueble nuevo = new RegistroInmueble();
                dispose();
                nuevo.setVisible(true);

            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        scroll_inmuebles = new javax.swing.JScrollPane();
        tabla_inmuebles = new javax.swing.JTable();
        boton_volver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        boton_crear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Menu Inmuebles");

        tabla_inmuebles.setModel(new javax.swing.table.DefaultTableModel(
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
        scroll_inmuebles.setViewportView(tabla_inmuebles);

        boton_volver.setText("Volver");
        boton_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_volverActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel2.setText("Para modificar los atributos de un inmueble haga click sobre él");

        boton_crear.setText("Crear Inmueble");
        boton_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_crearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(286, 286, 286)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(scroll_inmuebles)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                .addComponent(boton_crear, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(boton_volver)
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll_inmuebles, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_volver)
                    .addComponent(jLabel2)
                    .addComponent(boton_crear))
                .addGap(0, 34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_volverActionPerformed
        dispose();
        new MenuAdmin().setVisible(true);
    }//GEN-LAST:event_boton_volverActionPerformed

    private void boton_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_crearActionPerformed
        dispose();
        new CrearInmueble().setVisible(true);
    }//GEN-LAST:event_boton_crearActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_crear;
    private javax.swing.JButton boton_volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane scroll_inmuebles;
    private javax.swing.JTable tabla_inmuebles;
    // End of variables declaration//GEN-END:variables
}
