package cook;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.MenuModel;
import model.RecipeModel;
import services.MenuService;
import services.RecipeService;

public class addMenu extends javax.swing.JFrame {
    RecipeService recipe_service;
    DefaultTableModel defaultTableModel;
    DefaultTableModel firstTableModel;
    DefaultTableModel secondTableModel;
    DefaultTableModel thirdTableModel;
    RecipeModel recipe;
    String recipe_ID;
    MenuService menuService;
    MenuModel menu;
    public addMenu() {
        initComponents();
        recipe_service = new RecipeService();
        recipe = new RecipeModel();
        menuService = new MenuService();
        menu = new MenuModel();

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

    private void setTableDatarecipe(List<RecipeModel> recipes) {
    // Clear existing rows in the table model
    defaultTableModel.setRowCount(0);

    for (RecipeModel recipe : recipes) {


        // Add the recipe data to the table
        defaultTableModel.addRow(new Object[]{
            recipe.getRecipe_ID(), // Add the recipe ID
            recipe.getRecipe_TITLE(), // Add the recipe title
   
        });
    }
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        BreakfastTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        RecipeTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jtfname = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        LunchTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        DinnerTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfnameid = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(210, 238, 245));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BreakfastTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Breakfast", "Lunch", "Dinner"
            }
        ));
        jScrollPane1.setViewportView(BreakfastTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 180, 170));

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
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 160, 40));

        jButton4.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jButton4.setText("Auto Create");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 160, 40));

        jPanel2.setBackground(new java.awt.Color(210, 238, 245));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Create Menu"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtfname.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jPanel2.add(jtfname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 170, 30));

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Name:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 80, 50));

        jButton5.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jButton5.setText("Delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 160, 40));

        LunchTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Breakfast", "Lunch", "Dinner"
            }
        ));
        jScrollPane3.setViewportView(LunchTable);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, 180, 170));

        DinnerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Breakfast", "Lunch", "Dinner"
            }
        ));
        jScrollPane4.setViewportView(DinnerTable);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 40, 180, 170));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Breakfast");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 80, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Lunch");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Dinner");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Name ID:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 480, -1, -1));
        jPanel2.add(jtfnameid, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 472, 170, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 1080, 590));

        jButton6.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jButton6.setText("Clear");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 160, 40));

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
        //
            for (int i = 0; i < RecipeTable.getRowCount(); i++) {
            // Lấy giá trị của ô checkbox trong hàng đó
            JCheckBox checkBox1 = (JCheckBox) RecipeTable.getValueAt(i, 2); // 2 là chỉ số cột của ô checkbox
            JCheckBox checkBox2 = (JCheckBox) RecipeTable.getValueAt(i, 3); // 2 là chỉ số cột của ô checkbox
            JCheckBox checkBox3 = (JCheckBox) RecipeTable.getValueAt(i, 4); // 2 là chỉ số cột của ô checkbox

            // Kiểm tra xem ô checkbox có được chọn không
            if (checkBox1.isSelected()) {
                // Nếu được chọn, lấy dữ liệu từ các cột khác trong hàng đó
                Object[] rowData = new Object[2];
                rowData[0] = RecipeTable.getValueAt(i, 0);
                rowData[1] =RecipeTable.getValueAt(i, 1);
                firstTableModel.addRow(rowData);    
                checkBox1.setSelected(false);
                
            }
            if (checkBox2.isSelected()) {
                // Nếu được chọn, lấy dữ liệu từ các cột khác trong hàng đó
                Object[] rowData = new Object[2];
                rowData[0] = RecipeTable.getValueAt(i, 0);
                rowData[1] =RecipeTable.getValueAt(i, 1);
                secondTableModel.addRow(rowData);    
                checkBox2.setSelected(false);
            }
            if (checkBox3.isSelected()) {
                // Nếu được chọn, lấy dữ liệu từ các cột khác trong hàng đó
                Object[] rowData = new Object[2];
                rowData[0] = RecipeTable.getValueAt(i, 0);
               rowData[1] =RecipeTable.getValueAt(i, 1);
                thirdTableModel.addRow(rowData);    
                checkBox3.setSelected(false);
            }
            
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

int row = BreakfastTable.getSelectedRow();
int row1 = LunchTable.getSelectedRow();
int row2 = DinnerTable.getSelectedRow();

if (row != -1) {
    int confirm1 = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa không");
    if (confirm1 == JOptionPane.YES_OPTION) {
        firstTableModel.removeRow(row);
    }
} else {
    JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng từ bảng Breakfast.", "Lỗi", JOptionPane.ERROR_MESSAGE);
}

if (row1 != -1) {
    int confirm2 = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa không");
    if (confirm2 == JOptionPane.YES_OPTION) {
        secondTableModel.removeRow(row1);
    }
} else {
    JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng từ bảng Lunch.", "Lỗi", JOptionPane.ERROR_MESSAGE);
}

if (row2 != -1) {
    int confirm3 = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa không");
    if (confirm3 == JOptionPane.YES_OPTION) {
        thirdTableModel.removeRow(row2);
    }
} else {
    JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng từ bảng Dinner.", "Lỗi", JOptionPane.ERROR_MESSAGE);
}

//int row3 = RecipeTable.getSelectedRow();
//if (row3 != -1) {
//    int confirm = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa không");
//    if (confirm == JOptionPane.YES_OPTION) {
//        String Recipe_ID = (String) RecipeTable.getValueAt(row3, 0);
//        recipe_service.deleteRecipe(Recipe_ID);
//        defaultTableModel.setRowCount(0);
//        setTableData(recipe_service.getRecipe(Recipe_ID));
//    }
//} else {
//    JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng từ bảng Recipe.", "Lỗi", JOptionPane.ERROR_MESSAGE);
//}

    
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

String jtfmenuid = "M000";
int breakfastMenuID = Integer.parseInt(jtfmenuid.substring(1));
int lunchMenuID = breakfastMenuID + BreakfastTable.getRowCount();
int dinnerMenuID = lunchMenuID + LunchTable.getRowCount();

// Duyệt qua các hàng của bảng BreakfastTable và thêm vào menuService
for (int i = 0; i < BreakfastTable.getRowCount(); i++) {
    MenuModel breakfastMenu = new MenuModel();
    breakfastMenu.setMenu_ID("M" + breakfastMenuID);
    breakfastMenu.setMenu_Name(jtfname.getText());
    breakfastMenu.setName_ID(jtfnameid.getText());
    breakfastMenu.setRecipe_ID((String) BreakfastTable.getValueAt(i, 0));
    breakfastMenu.setRecipe_TITLE((String) BreakfastTable.getValueAt(i, 1));
    breakfastMenu.setTime_Menu(jLabel3.getText());
    menuService.addMenu(breakfastMenu);

    
    breakfastMenuID += 1; // Tăng giá trị của menuID cho bữa sáng
}
((DefaultTableModel) BreakfastTable.getModel()).setRowCount(0);
// Duyệt qua các hàng của bảng LunchTable và thêm vào menuService
for (int i = 0; i < LunchTable.getRowCount(); i++) {
    MenuModel lunchMenu = new MenuModel();
    lunchMenu.setMenu_ID("M" + lunchMenuID);
    lunchMenu.setMenu_Name(jtfname.getText());
    lunchMenu.setName_ID(jtfnameid.getText());
    lunchMenu.setRecipe_ID((String) LunchTable.getValueAt(i, 0));
    lunchMenu.setRecipe_TITLE((String) LunchTable.getValueAt(i, 1));
    lunchMenu.setTime_Menu(jLabel4.getText());
    menuService.addMenu(lunchMenu);
    
    lunchMenuID += 1; // Tăng giá trị của menuID cho bữa trưa
}
((DefaultTableModel) LunchTable.getModel()).setRowCount(0);
// Duyệt qua các hàng của bảng DinnerTable và thêm vào menuService
for (int i = 0; i < DinnerTable.getRowCount(); i++) {
    MenuModel dinnerMenu = new MenuModel();
    dinnerMenu.setMenu_ID("M" + dinnerMenuID);
    dinnerMenu.setMenu_Name(jtfname.getText());
    dinnerMenu.setName_ID(jtfnameid.getText());
    dinnerMenu.setRecipe_ID((String) DinnerTable.getValueAt(i, 0));
    dinnerMenu.setRecipe_TITLE((String) DinnerTable.getValueAt(i, 1));
    dinnerMenu.setTime_Menu(jLabel5.getText());
    menuService.addMenu(dinnerMenu);
    
    dinnerMenuID += 1; // Tăng giá trị của menuID cho bữa tối
}
((DefaultTableModel) DinnerTable.getModel()).setRowCount(0);


  
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(addMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addMenu().setVisible(true);
            }
        });
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
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
