package vista;

import controlador.ConexionController;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * Clase que sirve para visualizar la interfaz del menu de usuarios del administrador
 * @author Marcos Yerga Gomez
 */
public class SubMenuUsuariosAdmin extends javax.swing.JFrame {

    /**
     * atributo para enviar el atributo nombre de usuario a otras clases
     */
    public static String actualizarUsuario = "";
    /**
     * atributo para enviar el atributo nombre de usuario a otras clases
     */
    public static String actualizarClave = "";

    /**
     * atributo para enviar el atributo ID de usuario a otras clases
     */
    public static int IDUsuario;
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
    public SubMenuUsuariosAdmin() {
        initComponents();
        setLocationRelativeTo(null);

        try {
            Connection cn = ConexionController.conectar();
            PreparedStatement pst = cn.prepareStatement("SELECT ID, nombre,apellido, email,telefono,isAdmin tarifa FROM usuarios");

            ResultSet rs = pst.executeQuery();

            tabla_usuarios = new JTable(modelo);
            scroll_usuarios.setViewportView(tabla_usuarios);

            modelo.addColumn("ID");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Email");
            modelo.addColumn("Telefono");
            modelo.addColumn("Administrador");

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
        tabla_usuarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = tabla_usuarios.rowAtPoint(e.getPoint());
                int columna_point = 1;
                actualizarUsuario = (String) modelo.getValueAt(fila_point, columna_point);
                int columna_point2 = 0;
                IDUsuario = (int) modelo.getValueAt(fila_point, columna_point2);
                
                RegistroUsuario nuevo = new RegistroUsuario();
                dispose();
                nuevo.setVisible(true);

            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        boton_volver = new javax.swing.JButton();
        scroll_usuarios = new javax.swing.JScrollPane();
        tabla_usuarios = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txt_crear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Menú usuarios");

        boton_volver.setText("Volver");
        boton_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_volverActionPerformed(evt);
            }
        });

        tabla_usuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        scroll_usuarios.setViewportView(tabla_usuarios);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel2.setText("Para modificar los atributos de un usuario haga click sobre él");

        txt_crear.setText("Crear Usuario");
        txt_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_crearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(txt_crear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(boton_volver)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(scroll_usuarios)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(scroll_usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(boton_volver)
                        .addComponent(txt_crear))
                    .addComponent(jLabel2))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boton_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_volverActionPerformed
        dispose();
        new MenuAdmin().setVisible(true);
    }//GEN-LAST:event_boton_volverActionPerformed

    private void txt_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_crearActionPerformed
        dispose();
        new CrearUsuario().setVisible(true);
    }//GEN-LAST:event_txt_crearActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_volver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane scroll_usuarios;
    private javax.swing.JTable tabla_usuarios;
    private javax.swing.JButton txt_crear;
    // End of variables declaration//GEN-END:variables
}
