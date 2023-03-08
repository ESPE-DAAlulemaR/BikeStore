package app.views;
import app.controllers.StaffController;
import app.models.Staff;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jeyner
 */
public class Employee extends javax.swing.JPanel {

    /**
     * Creates new form Empleado
     */
    public Employee() {
        initComponents();
         refreshTable();   
    }
    
    
     public void refreshTable()
    {
       DefaultTableModel model = (DefaultTableModel) this.jTable_staff.getModel();

        model.setRowCount(0);

        ArrayList<Staff> staff = StaffController.index();
        for (Staff staf : staff) {
             Object[] row = {staf.staff_id, staf.store_id, staf.manager_id,staf.staff_first_name, 
                 staf.staff_last_name, staf.staff_email, staf.staff_phone, staf.staff_active};
            model.addRow(row);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        seller_first_name_txt = new javax.swing.JLabel();
        seller_last_name_txt = new javax.swing.JLabel();
        seller_phone_txt = new javax.swing.JLabel();
        seller_email_txt = new javax.swing.JLabel();
        btn_Guardar = new javax.swing.JButton();
        btn_Eliminar = new javax.swing.JButton();
        first_name = new javax.swing.JTextField();
        last_name = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_staff = new javax.swing.JTable();
        jComboBox_manager = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox_store = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        seller_first_name_txt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        seller_first_name_txt.setText("Nombres :");
        add(seller_first_name_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 35, -1, -1));

        seller_last_name_txt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        seller_last_name_txt.setText("Apellidos :");
        add(seller_last_name_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 69, -1, -1));

        seller_phone_txt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        seller_phone_txt.setText("Telefono :");
        add(seller_phone_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 109, -1, -1));

        seller_email_txt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        seller_email_txt.setText("Email :");
        add(seller_email_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 141, -1, -1));

        btn_Guardar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Guardar.setText("Guardar");
        btn_Guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_GuardarMouseClicked(evt);
            }
        });
        add(btn_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 190, -1, -1));

        btn_Eliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Eliminar.setText("Eliminar");
        btn_Eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_EliminarMouseClicked(evt);
            }
        });
        add(btn_Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 190, -1, -1));
        add(first_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 35, 375, -1));
        add(last_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 69, 374, -1));
        add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 107, 372, -1));
        add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 141, 372, -1));

        jTable_staff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "staff_id", "store_id", "manager_id", "Nombres", "Apellido", "Email", "Phone", "active"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable_staff);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 258, 845, 293));

        jComboBox_manager.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBox_manager, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 40, 150, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Manager");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(647, 38, 74, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Store");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, -1, -1));

        jComboBox_store.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBox_store, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 80, 150, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_GuardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_GuardarMouseClicked
        // añadir un resgistro
          if (!(this.first_name.getText().isEmpty() || this.first_name.getText().isBlank())||
               (this.last_name.getText().isEmpty() || this.last_name.getText().isBlank())||
               (this.phone.getText().isEmpty() || this.phone.getText().isBlank())||
               (this.email.getText().isEmpty() || this.email.getText().isBlank())){
         //   StaffController.store(this.jComboBox_store.getText());
            this.first_name.setText("");
            refreshTable();
        }
        
    }//GEN-LAST:event_btn_GuardarMouseClicked

    private void btn_EliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_EliminarMouseClicked
        //Elimar registros
        DefaultTableModel model = (DefaultTableModel) this.jTable_staff.getModel();
        if (model.getRowCount() > 0) {
            if (this.jTable_staff.getSelectedRow() != -1) {
                int row = jTable_staff.getSelectedRow();
                int id = (int) jTable_staff.getValueAt(row, 0);
                StaffController.destroy(id);
                refreshTable();
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione Una Fila");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay Filas en la Tabla");
        }
    }//GEN-LAST:event_btn_EliminarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_Guardar;
    private javax.swing.JTextField email;
    private javax.swing.JTextField first_name;
    private javax.swing.JComboBox<String> jComboBox_manager;
    private javax.swing.JComboBox<String> jComboBox_store;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_staff;
    private javax.swing.JTextField last_name;
    private javax.swing.JTextField phone;
    private javax.swing.JLabel seller_email_txt;
    private javax.swing.JLabel seller_first_name_txt;
    private javax.swing.JLabel seller_last_name_txt;
    private javax.swing.JLabel seller_phone_txt;
    // End of variables declaration//GEN-END:variables
}
