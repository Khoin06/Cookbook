package cook;

import dao.RecipeDAO;
import java.io.File;

import java.nio.file.Files;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import model.RecipeModel;
import model.ingre_recipeModel;
import services.RecipeService;
import services.ingre_recipeService;

/**
 *
 * @author Bao Ngoc
 */
public class addRecipe extends javax.swing.JFrame {

    private File file;
    int xx, xy;
    private RecipeService recipeService = new RecipeService();
    private ingre_recipeService ingre_recipeService = new ingre_recipeService();
    RecipeModel recipe;
    

    public addRecipe() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jtfMonAn = new javax.swing.JTextField();
        jtfthoigian = new javax.swing.JTextField();
        jtfdanhgia = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtfmotadinhduong = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jtfmotachinh = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtfStep = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtfghichu = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();
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
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(209, 237, 246));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(209, 237, 246));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 650));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("X");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1159, 12, 18, 22));

        jPanel2.setBackground(new java.awt.Color(210, 238, 245));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "New Recipe", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 510));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, 120, 20));

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("ID: ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 40, 134, -1));

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("TIME:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 120, 134, -1));

        jLabel3.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("NAME:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 80, 134, -1));

        jLabel4.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("RATE:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 160, 134, -1));

        jLabel5.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("IMAGE:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 360, 134, -1));

        jLabel6.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("NUTRIENT:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 250, 134, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 205, -1));
        jPanel2.add(jtfMonAn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 205, -1));
        jPanel2.add(jtfthoigian, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 205, -1));
        jPanel2.add(jtfdanhgia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 205, -1));

        jtfmotadinhduong.setColumns(20);
        jtfmotadinhduong.setRows(5);
        jScrollPane1.setViewportView(jtfmotadinhduong);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 205, -1));

        jLabel8.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("DIFFICULT:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 210, 134, -1));

        jtfmotachinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfmotachinhActionPerformed(evt);
            }
        });
        jPanel2.add(jtfmotachinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 205, -1));

        jButton2.setText("BROWSE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, -1, -1));

        jtfStep.setColumns(20);
        jtfStep.setRows(5);
        jScrollPane2.setViewportView(jtfStep);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 40, 260, 410));

        jLabel10.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("STEPS:");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 70, -1));

        jLabel11.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("NOTE:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 100, -1));

        jtfghichu.setColumns(20);
        jtfghichu.setRows(5);
        jScrollPane3.setViewportView(jtfghichu);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 220, 110));

        jButton4.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jButton4.setText("DONE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 470, 80, 49));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 760, 530));

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
                "ID", "Name", "Quantity", "Unit"
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

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 30, 440, 530));

        jButton3.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        jButton3.setText("SUBMIT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 570, 100, 49));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 1240, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
//            for(int i = 0 ; i <jTable1.getRowCount();i++){
//                RecipeModel recipe = new RecipeModel();
//                recipe.set
//            }
        
           try {
            if (this.file != null) {
            RecipeModel recipe = new RecipeModel(
                    jTextField1.getText().trim(),
                    jtfMonAn.getText().trim(),
                    jtfStep.getText().trim(),
                    jtfmotadinhduong.getText().trim(),
                    jtfthoigian.getText().trim(),
                    jtfmotachinh.getText().trim(),
                    jtfdanhgia.getText().trim(),
                    jtfghichu.getText().trim(),
                    Files.readAllBytes(this.file.toPath()));
            recipeService.addRecipe(recipe);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "" + e, "Warning", 2);

        } // GEN-LAST:event_jButton3ActionPerformed
    
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jtfmaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfmaKeyTyped
        //        // TODO add your handling code here:
        //         char input = evt.getKeyChar();
        //        if (!(input > '0' && input < '9')){
            //            evt.consume();
            //            JOptionPane.showMessageDialog(this, "Chi dung cac chu so ban nhe!!!", "WARNING",2);
            //        }
    }//GEN-LAST:event_jtfmaKeyTyped

    private void jtften1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtften1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtften1ActionPerformed

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
        // TODO add your handling code here:
      
        
//        recipeManagemen add1 = new recipeManagemen();
//        add1.setLocationRelativeTo(null);
//        add1.setResizable(false);
//        add1.setVisible(true);
//
//        try {
//            if (this.file != null) {
//                RecipeModel recipe = new RecipeModel(
//                    jtfma.getText().trim(),
//                    jtften.getText().trim());
//
//                recipeService.ingre_recipe(recipe);
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "" + e, "Warning", 2);
//
//        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jtften2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtften2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtften2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

       
//    try {
//        ingre_recipeModel recipeIngredient = new ingre_recipeModel(
//                jTextField1.getText().trim(), // Recipe_ID
//                jtfma.getText().trim(), // Ingredient_NAME
//                jtften1.getText().trim(), // Ingredient_ID
//                Integer.parseInt(jtften2.getText().trim()), // Ingredient_QUANTITY
//                jtften.getText().trim(), // unit
//                jtfMonAn.getText().trim() // Recipe_TITLE
//                
//        );
//        
//        ingre_recipeService.saveRecipeIngredient(recipeIngredient);//add

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

//        //JOptionPane.showMessageDialog(null, "Thêm thành phần công thức thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
//    } catch (Exception e) {
//        JOptionPane.showMessageDialog(null, "Lỗi: " + e.getMessage(), "Cảnh báo", JOptionPane.WARNING_MESSAGE);
//    }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
            for(int i = 0 ; i <jTable1.getRowCount();i++){
                ingre_recipeModel recipeIngredient = new ingre_recipeModel();
                recipeIngredient.setIngredient_ID((String)jTable1.getValueAt(i, 0));
                recipeIngredient.setRecipe_ID(jTextField1.getText());
                recipeIngredient.setIngredient_NAME((String) jTable1.getValueAt(i, 1));
                recipeIngredient.setIngredient_QUANTITY(Integer.parseInt((String) jTable1.getValueAt(i, 2)));
                recipeIngredient.setRecipe_TITLE(jtfMonAn.getText());
                recipeIngredient.setUnit((String)jTable1.getValueAt(i, 3));
                ingre_recipeService.saveRecipeIngredient(recipeIngredient);//add
            }  
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextField7ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setMultiSelectionEnabled(false);
        if (jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION);
        this.file = jFileChooser.getSelectedFile();
        jLabel12.setText(file.getName());
    }// GEN-LAST:event_jButton2ActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel9MouseClicked
        setVisible(false); // TODO add your handling code here:
    }// GEN-LAST:event_jLabel9MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton3ActionPerformed
//                try {
//            if (this.file != null) {
//            RecipeModel recipe = new RecipeModel(
//                    jTextField1.getText().trim(),
//                    jtfMonAn.getText().trim(),
//                    jtfStep.getText().trim(),
//                    jtfmotadinhduong.getText().trim(),
//                    jtfthoigian.getText().trim(),
//                    jtfmotachinh.getText().trim(),
//                    jtfdanhgia.getText().trim(),
//                    jtfghichu.getText().trim(),
//                    Files.readAllBytes(this.file.toPath()));
//            recipeService.addRecipe(recipe);

//             if (recipeService.addRecipe(recipe)) {
//                 JOptionPane.showMessageDialog(null, "Add new Recipe succesfully!!!");
//             } else {
//                 JOptionPane.showMessageDialog(null, "Failed!!!", "Warning", 2);
//             }
        recipeManagemen add = new recipeManagemen();
        add.setLocationRelativeTo(null);
        add.setResizable(false);
        add.setVisible(true);
        this.dispose();
                
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "" + e, "Warning", 2);
//
//        } // GEN-LAST:event_jButton3ActionPerformed
    
     

    }

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jTextField1KeyTyped
        
    }// GEN-LAST:event_jTextField1KeyTyped

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jComboBox1ActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();
    }// GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jPanel1MouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);

    }// GEN-LAST:event_jPanel1MouseDragged

    private void formWindowOpened(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowOpened
        
    }// GEN-LAST:event_formWindowOpened

    

    private void clear() {
        jTextField1.setText(null);
        jtfMonAn.setText(null);
        jtfthoigian.setText(null);
        jtfdanhgia.setText(null);
        jtfmotachinh.setText(null);
        jtfmotadinhduong.setText(null);
        jtfStep.setText(null);
        jtfghichu.setText(null);
        jLabel12.setText(null);
        file = null;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(addRecipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addRecipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addRecipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addRecipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new addRecipe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JTextField jTextField1;
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
