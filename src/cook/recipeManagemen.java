package cook;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.RecipeModel;
import services.MenuService;
import services.RecipeService;
import services.ingre_recipeService;

/**
 *
 * @author Bao Ngoc
 */
public class recipeManagemen extends javax.swing.JFrame {

    RecipeService recipe_service;
    DefaultTableModel defaultTableModel;
    RecipeModel recipe;
    String recipe_ID;
    private TableRowSorter<TableModel> rowSorter = null;
    private int imageColumnIndex;
    private ingre_recipeService ingre_recipeService = new ingre_recipeService();
    private MenuService menuService = new MenuService();

    public recipeManagemen() {
        initComponents();
        recipe_service = new RecipeService();
        recipe = new RecipeModel();
        
        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        RecipeTable.setModel(defaultTableModel);
        rowSorter = new TableRowSorter<>(defaultTableModel);
        RecipeTable.setRowSorter(rowSorter);

        defaultTableModel.addColumn("STT");
        defaultTableModel.addColumn("Tên Món ăn");
        defaultTableModel.addColumn("Ảnh Minh Họa");
        RecipeTable.getColumnModel().getColumn(2).setCellRenderer(new ImageRenderer());
        RecipeTable.setRowHeight(100);
        RecipeTable.setPreferredScrollableViewportSize(new Dimension(900, 400));
       
        List<RecipeModel> recipes = recipe_service.getRecipe(recipe_ID);
        if (recipes != null) {
            setTableData(recipes);
        } else {
            // Optionally handle the case when recipes is null
            System.out.println("No recipes found for the given ID");
        }
        
        jtfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfSearch.getText();
                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
        });

}

    class ImageRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel label = new JLabel();
            if (value instanceof ImageIcon) {
                ImageIcon icon = (ImageIcon) value;
                Image image = icon.getImage();
                // Resize the image to desired dimensions
                int width = 100; // Set your desired width
                int height = 100; // Set your desired height
                Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                // Set the scaled image to the label
                label.setIcon(new ImageIcon(scaledImage));
                label.setHorizontalAlignment(JLabel.CENTER);
            }
            return label;
        }
    }


private void setTableData(List<RecipeModel> recipes) {
    // Clear existing rows in the table model
    defaultTableModel.setRowCount(0);

    for (RecipeModel recipe : recipes) {
        // Convert the byte array to an ImageIcon
        byte[] imageBytes = recipe.getRecipe_Image();
        ImageIcon imageIcon = null;
        if (imageBytes != null) {
            imageIcon = new ImageIcon(imageBytes);
        }

        // Add the recipe data to the table
        defaultTableModel.addRow(new Object[]{
            recipe.getRecipe_ID(), // Add the recipe ID
            recipe.getRecipe_TITLE(), // Add the recipe title
            imageIcon // Add the ImageIcon
        });
    }
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        RecipeTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jtfSearch = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

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
        jScrollPane1.setViewportView(RecipeTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 790, 360));

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("RECIPE MANAGEMEN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 660, -1));

        jButton1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 520, 100, 40));

        jButton2.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 520, 100, 40));

        jButton3.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jButton3.setText("New");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 520, 90, 40));

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Find:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 520, 60, 40));

        jtfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfSearchActionPerformed(evt);
            }
        });
        jPanel1.add(jtfSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 520, 250, 40));

        jButton4.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jButton4.setText("FULL");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 520, 100, 40));

        jLabel3.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Recipe Managemen"));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 990, 580));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                                        
    int row = RecipeTable.getSelectedRow();
    if (row == -1) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn", "Lỗi", JOptionPane.ERROR_MESSAGE);
    } else {
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa không");
        if (confirm == JOptionPane.YES_OPTION) {
            String Recipe_ID =  (String) RecipeTable.getValueAt(row, 0);
            
            menuService.deleteMenu(Recipe_ID);

            // Trước tiên, hãy xóa các bản ghi liên quan từ các bảng khác có tham chiếu đến "Menu"
            ingre_recipeService.deleteAllRecipeIngredients(Recipe_ID);
            
            // Sau đó, xóa bản ghi từ bảng "Menu"
            menuService.deleteMenu(Recipe_ID);
            
            // Cuối cùng, xóa bản ghi từ bảng "Recipe"
            recipe_service.deleteRecipe(Recipe_ID);
            
            // Cập nhật lại dữ liệu trong bảng hiển thị
            defaultTableModel.setRowCount(0);
            setTableData(recipe_service.getRecipe(Recipe_ID));
        }
    }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        addRecipe add = new addRecipe();
        add.setLocationRelativeTo(null);
        add.setResizable(false);
        add.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row = RecipeTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                String recipeID = (String)RecipeTable.getValueAt(row, 0);
//            new editRecipe(recipeID).setVisible(true);
//            this.dispose();
                editRecipe suaWindow = new editRecipe(recipeID);
                suaWindow.setLocationRelativeTo(null);
                suaWindow.setResizable(false);
                suaWindow.setVisible(true);
                this.dispose();

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }  
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jtfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfSearchActionPerformed
        rowSorter = new TableRowSorter<>(RecipeTable.getModel());
        RecipeTable.setRowSorter(rowSorter);
    }//GEN-LAST:event_jtfSearchActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         int row = RecipeTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                String recipeID = (String)RecipeTable.getValueAt(row, 0);
//            new editRecipe(recipeID).setVisible(true);
//            this.dispose();
                Recipe suaWindow = new Recipe(recipeID);
                suaWindow.setLocationRelativeTo(null);
                suaWindow.setResizable(false);
                suaWindow.setVisible(true);
                this.dispose();

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }  
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(recipeManagemen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(recipeManagemen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(recipeManagemen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(recipeManagemen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new recipeManagemen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable RecipeTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtfSearch;
    // End of variables declaration//GEN-END:variables
}
