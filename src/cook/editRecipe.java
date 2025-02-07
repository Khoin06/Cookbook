/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cook;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.RecipeModel;
import model.ingre_recipeModel;
import services.RecipeService;
import services.ingre_recipeService;
import utils.JdbcSingleton;
import java.sql.ResultSet;

/**
 *
 * @author Bao Ngoc
 */
public class editRecipe extends javax.swing.JFrame {
    private File file;

    private RecipeModel recipe;
    RecipeService recipe_service;
    private DefaultTableModel defaultTableModel;
    private ingre_recipeService ingre_recipeService = new ingre_recipeService();
    String recipeID;
    private  ingre_recipeModel ingre_recipeModel = new ingre_recipeModel();

    public editRecipe(String Recipe_ID) {
        initComponents();
        recipe_service = new RecipeService();
        recipe = recipe_service.getRecipeById(Recipe_ID);
         
        this.recipeID = Recipe_ID;
        jtfMaMonAn.setText(recipe.getRecipe_ID());
        jtfMonAn.setText(recipe.getRecipe_TITLE());
        jtfStep.setText(recipe.getRecipe_Steps());
        jtfmotadinhduong.setText(recipe.getDescriptions_Nutrient());
        jtfthoigian.setText(String.valueOf(recipe.getDescriptions_Time()));
        jtfmotachinh.setText(String.valueOf(recipe.getDescriptions_Difficult()));
        jtfdanhgia.setText(recipe.getDescriptions_Rate());
        jtfghichu.setText(recipe.getDescriptions_Note());
    }
        
        
//        defaultTableModel = new DefaultTableModel() {
//            @Override
//            public boolean isCellEditable(int row, int column) {
//                return false;
//            }
//        };
//        jTable1.setModel(defaultTableModel);
//        defaultTableModel.addColumn("ID");
//        defaultTableModel.addColumn("Name");
//        defaultTableModel.addColumn("Quantity");
//        defaultTableModel.addColumn("Unit");
//        
//              List<ingre_recipeModel> ingredients = ingre_recipeService.getRecipeIngredientsByRecipeID(Recipe_ID);
//        System.out.println("Ingredients found: " + ingredients);
//              setTableData(ingredients);
//        
//        byte[] binaryData = recipe.getRecipe_Image();
//        if (binaryData != null) {
//            
//            StringBuilder hexString = new StringBuilder();
//            for (byte b : binaryData) {
//                hexString.append(String.format("%02X ", b));
//            }
//
//
//            String hexText = hexString.toString();
//            jLabel12.setText(hexText);
//        } 
//       
//    }private void setTableData(List<ingre_recipeModel> ingredients) {
//        // Clear existing rows in the table model
//        defaultTableModel.setRowCount(0);
//
//        if (ingredients != null) {
//            for (ingre_recipeModel ingredient : ingredients) {
//                // Add the ingredient data to the table
//                defaultTableModel.addRow(new Object[]{
//                    ingredient.getIngredient_ID(),
//                    ingredient.getIngredient_NAME(),
//                    ingredient.getIngredient_QUANTITY(),
//                    ingredient.getUnit()
//                });
//            }
//        } else {
//            // Handle the case where ingredients list is null
//            System.out.println("No ingredients found for recipe ID: " + recipeID);
//        }
//    }
    
//public void displayRecipeIngredientsInTable(String recipeID) {
//    try {
//        // Kết nối đến cơ sở dữ liệu
//        Connection connection = JdbcSingleton.getInstance().getConnection();
//
//        // Tạo câu truy vấn SQL để lấy dữ liệu từ bảng RecipeIngredient
//        String sql = "SELECT Ingredient_ID, Ingredient_QUANTITY, unit, Ingredient_NAME FROM RecipeIngredient WHERE Recipe_ID = ?";
//
//        // Tạo câu lệnh thực thi truy vấn
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        
//        // Thiết lập tham số cho câu lệnh truy vấn
//        preparedStatement.setString(1, recipeID);
//
//        // Thực thi truy vấn và nhận kết quả
//        ResultSet resultSet = preparedStatement.executeQuery();
//
//        // Xóa dữ liệu hiện tại của bảng jTable1 (nếu cần)
//        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//        model.setRowCount(0);
//
//        // Lặp qua các kết quả từ truy vấn và thêm chúng vào bảng
//        while (resultSet.next()) {
//            String ingredientID = resultSet.getString("Ingredient_ID");
//            int quantity = resultSet.getInt("Ingredient_QUANTITY");
//            String unit = resultSet.getString("unit");
//            String ingredientName = resultSet.getString("Ingredient_NAME");
//
//            // Tạo một mảng chứa dữ liệu của hàng mới
//            Object[] rowData = {ingredientID, quantity, unit, ingredientName};
//
//            // Thêm hàng mới vào bảng jTable1
//            model.addRow(rowData);
//        }
//
//        // Đóng kết nối đến cơ sở dữ liệu
//        connection.close();
//    } catch (SQLException e) {
//        // Xử lý các ngoại lệ SQL
//        e.printStackTrace();
//        JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage(), "Cảnh báo", JOptionPane.WARNING_MESSAGE);
//    }
//}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfMaMonAn = new javax.swing.JTextField();
        jtfMonAn = new javax.swing.JTextField();
        jtfthoigian = new javax.swing.JTextField();
        jtfdanhgia = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtfmotadinhduong = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jtfmotachinh = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtfStep = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtfghichu = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jtfma = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jtften1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jtften = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jtften2 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(209, 237, 246));

        jPanel1.setBackground(new java.awt.Color(209, 237, 246));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(153, 0, 102));
        jLabel9.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("X");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 0, 40, 30));

        jPanel2.setBackground(new java.awt.Color(210, 238, 245));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Edit Recipe", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("ID: ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 36, 134, -1));

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("TIME:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 116, 134, -1));

        jLabel3.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("NAME:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 76, 134, -1));

        jLabel4.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("RATE:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 156, 134, -1));

        jLabel5.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("IMAGE:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 354, 134, -1));

        jLabel6.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("NUTRIENT:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 248, 134, -1));

        jtfMaMonAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfMaMonAnActionPerformed(evt);
            }
        });
        jPanel2.add(jtfMaMonAn, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 35, 205, -1));
        jPanel2.add(jtfMonAn, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 75, 205, -1));
        jPanel2.add(jtfthoigian, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 115, 205, -1));
        jPanel2.add(jtfdanhgia, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 155, 205, -1));

        jtfmotadinhduong.setColumns(20);
        jtfmotadinhduong.setRows(5);
        jScrollPane1.setViewportView(jtfmotadinhduong);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 248, 205, -1));

        jLabel8.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("DIFFICULT:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 206, 134, -1));

        jtfmotachinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfmotachinhActionPerformed(evt);
            }
        });
        jPanel2.add(jtfmotachinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 205, 205, -1));

        jtfStep.setColumns(20);
        jtfStep.setRows(5);
        jScrollPane2.setViewportView(jtfStep);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 300, 300));

        jLabel10.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("STEPS:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 100, -1));

        jLabel11.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("NOTE:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 90, -1));

        jtfghichu.setColumns(20);
        jtfghichu.setRows(5);
        jScrollPane3.setViewportView(jtfghichu);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 210, 100));

        jButton3.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jButton3.setText("SAVE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 370, 95, 49));

        jButton2.setText("BROWSE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 353, -1, -1));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 356, 120, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 23, 830, 590));

        jPanel3.setBackground(new java.awt.Color(210, 238, 245));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Add Ingredient"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("ID:");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, 40, 30));

        jtfma.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jtfma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfmaKeyTyped(evt);
            }
        });
        jPanel3.add(jtfma, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 190, 30));

        jLabel14.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("QUANTITY:");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 130, 40));

        jtften1.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jtften1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtften1ActionPerformed(evt);
            }
        });
        jPanel3.add(jtften1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 80, 30));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, -1, 30));

        jtften.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jtften.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtftenActionPerformed(evt);
            }
        });
        jPanel3.add(jtften, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 90, 30));

        jLabel15.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("UNIT:");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 130, 40));

        jButton5.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jButton5.setText("DELETE");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 110, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane4.setViewportView(jTable1);

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 240, 270));

        jButton6.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jButton6.setText("DONE");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 80, 50));

        jLabel7.setFont(new java.awt.Font("Courier New", 1, 36)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("ADD INGREDIENT");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 450, 30));

        jLabel16.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("NAME:");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 60, 40));

        jtften2.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jtften2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtften2ActionPerformed(evt);
            }
        });
        jPanel3.add(jtften2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 90, 30));

        jButton7.setText("Save");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 110, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 30, 440, 530));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfMaMonAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfMaMonAnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfMaMonAnActionPerformed

    private void jtfmotachinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfmotachinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfmotachinhActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
try {
        if (this.file != null) {
            recipe = new RecipeModel(
                    jtfMaMonAn.getText(),
                    jtfMonAn.getText(),
                    jtfStep.getText(),
                    jtfmotadinhduong.getText(),
                    jtfthoigian.getText(),
                    jtfmotachinh.getText(),
                    jtfdanhgia.getText(),
                    jtfghichu.getText().trim(),
                    Files.readAllBytes(this.file.toPath()));
            recipe_service.updateRecipe(recipe);
            JOptionPane.showMessageDialog(this, "Recipe updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            recipe = new RecipeModel(
                    jtfMaMonAn.getText(),
                    jtfMonAn.getText(),
                    jtfStep.getText(),
                    jtfmotadinhduong.getText(),
                    jtfthoigian.getText(),
                    jtfmotachinh.getText(),
                    jtfdanhgia.getText(),
                    jtfghichu.getText().trim(),
                    recipe.getRecipe_Image());  // Keep the old image if no new image is selected
            recipe_service.updateRecipe(recipe);
            JOptionPane.showMessageDialog(this, "Recipe updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (Exception ex) {
        Logger.getLogger(editRecipe.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error reading file: " + ex.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
    }
    new recipeManagemen().setVisible(true);
    this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setMultiSelectionEnabled(false);
        if (jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            ;
        this.file = jFileChooser.getSelectedFile();
        jLabel12.setText(file.getName());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jtfmaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfmaKeyTyped

    }//GEN-LAST:event_jtfmaKeyTyped

    private void jtften1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtften1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtften1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String ingredientName = jtfma.getText().trim();
        String quantityString = jtften2.getText().trim();
        String id = jtften1.getText().trim();
        String unit = jtften.getText().trim();
        

        // Chuyển đổi chuỗi thành kiểu int
        int quantity = Integer.parseInt(quantityString);

        // Tạo một mảng chứa dữ liệu của hàng mới
        String[] rowData = {id,ingredientName, String.valueOf(quantity),unit};

        // Thêm hàng mới vào bảng jTable1
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(rowData);
//        List<ingre_recipeModel> length = ingre_recipeService.getRecipeIngredientsByRecipeID(recipeID);
//        for (int i = 0; i < length.size(); i++) {
//            String ingredientName = ingre_recipeModel.getIngredient_ID() ;
//            String quantityString = ingre_recipeModel.getIngredient_NAME() ;
//            int id = ingre_recipeModel.getIngredient_QUANTITY();
//            String unit = ingre_recipeModel.getUnit();
//        }
////            String ingredientName = jtfma.getText().trim();
////            String quantityString = jtften2.getText().trim();
////            String id = jtften1.getText().trim();
////            String unit = jtften.getText().trim();
//
//            // Chuyển đổi chuỗi thành kiểu int
//            int quantity = Integer.parseInt(quantityString);
//
//            // Tạo một mảng chứa dữ liệu của hàng mới
//            String[] rowData = {id,ingredientName, String.valueOf(quantity),unit};
//
//            // Thêm hàng mới vào bảng jTable1
//            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
//            model.addRow(rowData);

            //        //JOptionPane.showMessageDialog(null, "Thêm thành phần công thức thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            //    } catch (Exception e) {
            //        JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage(), "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            //    }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtftenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtftenActionPerformed

    }//GEN-LAST:event_jtftenActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hàng cần xóa", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa không?");
            if (confirm == JOptionPane.YES_OPTION) {
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.removeRow(row);
            }
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jtften2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtften2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtften2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        
        for(int i = 0 ; i <jTable1.getRowCount();i++){
            ingre_recipeModel recipeIngredient = new ingre_recipeModel();
            recipeIngredient.setIngredient_ID((String)jTable1.getValueAt(i, 0));
            recipeIngredient.setRecipe_ID(jtfMaMonAn.getText());
            recipeIngredient.setIngredient_NAME((String) jTable1.getValueAt(i, 1));
            recipeIngredient.setIngredient_QUANTITY(Integer.parseInt((String) jTable1.getValueAt(i, 2)));
            recipeIngredient.setRecipe_TITLE(jtfMonAn.getText());
            recipeIngredient.setUnit((String)jTable1.getValueAt(i, 3));
            ingre_recipeService.saveRecipeIngredient(recipeIngredient);//add
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//               new editRecipe().setVisible(true);
//            }
//       });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jtfMaMonAn;
    private javax.swing.JTextField jtfMonAn;
    private javax.swing.JTextArea jtfStep;
    private javax.swing.JTextField jtfdanhgia;
    private javax.swing.JTextArea jtfghichu;
    private javax.swing.JTextField jtfma;
    private javax.swing.JTextField jtfmotachinh;
    private javax.swing.JTextArea jtfmotadinhduong;
    private javax.swing.JTextField jtften;
    private javax.swing.JTextField jtften1;
    private javax.swing.JTextField jtften2;
    private javax.swing.JTextField jtfthoigian;
    // End of variables declaration//GEN-END:variables
}
