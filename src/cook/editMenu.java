/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cook;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.MenuModel;
import model.RecipeModel;
import services.MenuService;
import services.RecipeService;

/**
 *
 * @author Bao Ngoc
 */
public class editMenu extends javax.swing.JFrame {
    RecipeService recipe_service;
    DefaultTableModel defaultTableModel;
    DefaultTableModel firstTableModel;
    DefaultTableModel secondTableModel;
    DefaultTableModel thirdTableModel;
    RecipeModel recipe;
    MenuService menuService;
    MenuModel menu;
    String recipe_ID;
    public editMenu(String Menu_ID) {
        initComponents();
        recipe_service = new RecipeService();
        recipe = new RecipeModel();
        menuService = new MenuService();
//        menu = new MenuModel();
        menu = menuService.getMenuById(Menu_ID);
        

        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        firstTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        secondTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        thirdTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        RecipeTable.setModel(defaultTableModel);
        BreakfastTable.setModel(firstTableModel);
        LunchTable.setModel(secondTableModel);
        DinnerTable.setModel(thirdTableModel);
        
        
        jtfnameid.setText(menu.getName_ID());
        jtfname.setText(menu.getMenu_Name());

        

        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("Name");
        defaultTableModel.addColumn("Breakfast");
        defaultTableModel.addColumn("Lunch");
        defaultTableModel.addColumn("Dinner");

        
       firstTableModel.addColumn("ID");
        firstTableModel.addColumn("Name");
        
        secondTableModel.addColumn("ID");
        secondTableModel.addColumn("Name");
        
        thirdTableModel.addColumn("ID");
        thirdTableModel.addColumn("Name");
        
        
        
        RecipeTable.setRowHeight(50);
        TableColumn column = RecipeTable.getColumnModel().getColumn(1); 
        column.setPreferredWidth(200); 
        TableColumn column1 = RecipeTable.getColumnModel().getColumn(2); // Lấy cột đầu tiên
        column1.setPreferredWidth(30);
        TableColumn column2 = RecipeTable.getColumnModel().getColumn(3); // Lấy cột đầu tiên
        column2.setPreferredWidth(30);
        TableColumn column3 = RecipeTable.getColumnModel().getColumn(4); // Lấy cột đầu tiên
        column3.setPreferredWidth(30);
        
        
        
        RecipeTable.getColumnModel().getColumn(2).setCellRenderer(new CheckBoxRenderer());
        RecipeTable.getColumnModel().getColumn(3).setCellRenderer(new CheckBoxRenderer());
        RecipeTable.getColumnModel().getColumn(4).setCellRenderer(new CheckBoxRenderer());

        setTableData(recipe_service.getRecipe(recipe_ID));
        
        
        RecipeTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Lấy chỉ số hàng và cột khi người dùng click vào ô checkbox
                int column = RecipeTable.getColumnModel().getColumnIndexAtX(e.getX());
                int row = e.getY() / RecipeTable.getRowHeight();

                // Kiểm tra xem người dùng click vào ô checkbox không
                if (row < RecipeTable.getRowCount() && row >= 0 && column < RecipeTable.getColumnCount() && column >= 0) {
                    Object value = RecipeTable.getValueAt(row, column);
                    // Nếu ô đó là ô checkbox
                    if (value instanceof JCheckBox) {
                        JCheckBox checkBox = (JCheckBox) value;
                        // Đảo ngược trạng thái của checkbox (chọn hoặc bỏ chọn)
                        checkBox.setSelected(!checkBox.isSelected());
                        // Cập nhật giá trị trong bảng để hiển thị trạng thái mới của checkbox
                        RecipeTable.getModel().setValueAt(checkBox, row, column);
                    }
                }
            }
        });
    }

    public class CheckBoxRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) value;
                return checkBox;
            }
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }

    private void setTableData(List<RecipeModel> recipes) {
        for (RecipeModel recipe : recipes) {
            // Add the recipe data to the table
            Object[] rowData = new Object[5];
            rowData[0] = recipe.getRecipe_ID(); // Add the recipe ID
            rowData[1] = recipe.getRecipe_TITLE(); // Add the recipe title
            JCheckBox checkBox1 = new JCheckBox();
            JCheckBox checkBox2 = new JCheckBox();
            JCheckBox checkBox3 = new JCheckBox();
            checkBox1.setSelected(false);
            // Set checkboxes in each column separately
            rowData[2] = checkBox1;
            rowData[3] = checkBox2;
            rowData[4] = checkBox3;

            // Add row to the defaultTableModel
            defaultTableModel.addRow(rowData);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        RecipeTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfname = new javax.swing.JTextField();
        jtfnameid = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        DinnerTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        LunchTable = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        BreakfastTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(210, 238, 245));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        RecipeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Recipe ID", "Recipe Name", "Image"
            }
        ));
        jScrollPane2.setViewportView(RecipeTable);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, 630, 260));

        jButton2.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 560, 160, 40));

        jButton3.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jButton3.setText("Save");
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 160, 40));

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Name:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 370, 80, 50));

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Name ID:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 80, 50));

        jtfname.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jPanel1.add(jtfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 380, 170, 30));

        jtfnameid.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jPanel1.add(jtfnameid, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 170, 30));

        jPanel2.setBackground(new java.awt.Color(210, 238, 245));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Edit Menu"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton5.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jButton5.setText("Clear");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 160, 40));

        jButton4.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 160, 40));

        DinnerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Breakfast", "Lunch", "Dinner"
            }
        ));
        jScrollPane3.setViewportView(DinnerTable);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 40, 210, 170));

        LunchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Breakfast", "Lunch", "Dinner"
            }
        ));
        jScrollPane4.setViewportView(LunchTable);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 210, 170));

        BreakfastTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Breakfast", "Lunch", "Dinner"
            }
        ));
        jScrollPane1.setViewportView(BreakfastTable);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 210, 170));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 1080, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(editMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BreakfastTable;
    private javax.swing.JTable DinnerTable;
    private javax.swing.JTable LunchTable;
    private javax.swing.JTable RecipeTable;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jtfname;
    private javax.swing.JTextField jtfnameid;
    // End of variables declaration//GEN-END:variables
}
