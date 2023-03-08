/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package app.views;

import app.controllers.BrandController;
import app.models.Brand;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marys
 */
public class Brands extends javax.swing.JPanel {

    
    public Brands() {
        initComponents();
        refreshTable();   
    } 
    
    public void refreshTable()
    {
       DefaultTableModel model = (DefaultTableModel) this.tblBrands.getModel();

        model.setRowCount(0);

        ArrayList<Brand> brands = BrandController.index();
        for (Brand brand : brands) {
            Object[] row = { brand.brand_id, brand.brand_name };
            model.addRow(row);
        }
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        brand_name_txt = new javax.swing.JLabel();
        btn_brand_name_añadir = new javax.swing.JButton();
        btn_brand_name_modificar = new javax.swing.JButton();
        btn_brand_name_guardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBrands = new javax.swing.JTable();
        brand_name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        brand_id = new javax.swing.JTextField();
        btn_brand_name_eliminar1 = new javax.swing.JButton();

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        brand_name_txt.setText("Nombre :");
        bg.add(brand_name_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, -1));

        btn_brand_name_añadir.setText("Añadir ");
        btn_brand_name_añadir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_brand_name_añadirMouseClicked(evt);
            }
        });
        bg.add(btn_brand_name_añadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, -1, -1));

        btn_brand_name_modificar.setText("Modificar");
        btn_brand_name_modificar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_brand_name_modificarMouseClicked(evt);
            }
        });
        bg.add(btn_brand_name_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, -1, -1));

        btn_brand_name_guardar.setText("Guardar");
        btn_brand_name_guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_brand_name_guardarMouseClicked(evt);
            }
        });
        bg.add(btn_brand_name_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, -1, -1));

        tblBrands.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nombre"
            }
        ));
        jScrollPane1.setViewportView(tblBrands);

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, -1, -1));
        bg.add(brand_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 320, -1));

        jLabel1.setText("Id");
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, -1));

        brand_id.setEditable(false);
        brand_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brand_idActionPerformed(evt);
            }
        });
        bg.add(brand_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 320, -1));

        btn_brand_name_eliminar1.setText("Eliminar");
        btn_brand_name_eliminar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_brand_name_eliminar1MouseClicked(evt);
            }
        });
        bg.add(btn_brand_name_eliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 1036, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void brand_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brand_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brand_idActionPerformed

    private void btn_brand_name_añadirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_brand_name_añadirMouseClicked
        if (!(this.brand_name.getText().isEmpty() || this.brand_name.getText().isBlank())) {
            BrandController.store(this.brand_name.getText());
            this.brand_name.setText("");
            refreshTable();
        }
    }//GEN-LAST:event_btn_brand_name_añadirMouseClicked

    private void btn_brand_name_eliminar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_brand_name_eliminar1MouseClicked
        //Elimar registros
        DefaultTableModel model = (DefaultTableModel) this.tblBrands.getModel();
        if (model.getRowCount() > 0) {
            if (this.tblBrands.getSelectedRow() != -1) {
                int row = tblBrands.getSelectedRow();
                int id = (int) tblBrands.getValueAt(row, 0);
                BrandController.destroy(id);
                refreshTable();
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione Una Fila");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay Filas en la Tabla");
        }
    }//GEN-LAST:event_btn_brand_name_eliminar1MouseClicked

    private void btn_brand_name_modificarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_brand_name_modificarMouseClicked
        // Modificar un registro
      DefaultTableModel model = (DefaultTableModel) this.tblBrands.getModel();
        if (model.getRowCount() > 0) {
            if (this.tblBrands.getSelectedRow() != -1) {
                int row = tblBrands.getSelectedRow();
                int id = (int) tblBrands.getValueAt(row, 0);
                BrandController.get(id);
                Brand obj =BrandController.get(id);
                this.brand_id.setText(Integer.toString(id));
                this.brand_name.setText(obj.brand_name);
                refreshTable();
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione Una Fila");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay Filas en la Tabla");
        }
        
    }//GEN-LAST:event_btn_brand_name_modificarMouseClicked

    private void btn_brand_name_guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_brand_name_guardarMouseClicked

        if (!(this.brand_name.getText().isEmpty() || this.brand_name.getText().isBlank())) {
            BrandController.update(Integer.parseInt(this.brand_id.getText()), this.brand_name.getText());
            this.brand_name.setText("");
            this.brand_id.setText(" ");
            refreshTable();
        }
    }//GEN-LAST:event_btn_brand_name_guardarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JTextField brand_id;
    private javax.swing.JTextField brand_name;
    private javax.swing.JLabel brand_name_txt;
    private javax.swing.JButton btn_brand_name_añadir;
    private javax.swing.JButton btn_brand_name_eliminar1;
    private javax.swing.JButton btn_brand_name_guardar;
    private javax.swing.JButton btn_brand_name_modificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBrands;
    // End of variables declaration//GEN-END:variables
}
