/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.IngredientModel;
import utils.JdbcSingleton;

/**
 *
 * @author khoi ngo
 */
public class IngredientDAO {
    public List<IngredientModel> getIngredient() {
        List<IngredientModel>ingredient = new ArrayList<IngredientModel>();        
        Connection connection = JdbcSingleton.getInstance().getConnection();

        String sql = "SELECT * FROM Ingredient;";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs  = ps.executeQuery();
            
            while (rs.next()) {
                IngredientModel nguyenlieu = new IngredientModel();
                
                nguyenlieu.setIngredient_ID(rs.getString("Ingredient_ID"));
                nguyenlieu.setIngredient_NAME(rs.getString("Ingredient_NAME"));
//                nguyenlieu.setIngredient_QUANTITY(rs.getFloat("Ingredient_QUANTITY"));

                ingredient.add(nguyenlieu);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }  
        return ingredient;
    }
    public void AddIngredient(IngredientModel ingredient) {
        Connection connection = JdbcSingleton.getInstance().getConnection();
        String sql = "INSERT INTO [Ingredient] (Ingredient_ID, Ingredient_NAME) VALUES ( ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, ingredient.getIngredient_ID());
            ps.setString(2, ingredient.getIngredient_NAME());
//            ps.setFloat(3, ingredient.getIngredient_QUANTITY());

            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
//public void UpdateIngredient(IngredientModel ingredient) {
//    Connection connection = JdbcSingleton.getInstance().getConnection();
//    String sql = "DUPDATE [Ingredient] SET Ingredient_NAME = ? WHERE Ingredient_ID = ?";
//    try {
//        PreparedStatement ps = connection.prepareStatement(sql);
//        ps.setString(1, ingredient.getIngredient_NAME());
//        ps.setString(2, ingredient.getIngredient_ID());
//        int rowsUpdated = ps.executeUpdate();
//        if (rowsUpdated > 0) {
//            System.out.println("An existing ingredient was updated successfully!");
//        } else {
//            System.out.println("No ingredient found with the given ID.");
//        }
//    } catch (Exception ex) {
//        ex.printStackTrace();
//    }
//}
public void UpdateIngredient(String Ingredient_ID, String Ingredient_NAME) {
    Connection connection = JdbcSingleton.getInstance().getConnection();
    String sql = "UPDATE [Ingredient] SET Ingredient_NAME = ? WHERE Ingredient_ID = ?";
    try {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(2, Ingredient_NAME);
        ps.setString(1, Ingredient_ID);
        int rowsUpdated = ps.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing ingredient was updated successfully!");
        } else {
            System.out.println("No ingredient found with the given ID.");
        }
                    ps.executeUpdate();

    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

    public void DeleteIngredient(String Ingredient_ID)
    {
        Connection connection = JdbcSingleton.getInstance().getConnection();
        String sql = "delete from Ingredient where Ingredient_ID = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,Ingredient_ID);

            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public IngredientModel getIngredientById(String Ingredient_ID) {   
        Connection connection = JdbcSingleton.getInstance().getConnection();

        String sql = "SELECT * FROM Ingredient where Ingredient_ID = ? ";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,Ingredient_ID);
            ResultSet rs  = ps.executeQuery();
            
            while (rs.next()) {
                IngredientModel monan = new IngredientModel();
                monan. setIngredient_ID(rs.getString("Ingredient_ID"));
                monan.setIngredient_NAME(rs.getString("Ingredient_NAME"));

                return monan;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return null;
    }
    public boolean isIngredientDuplicated(String ingredientName) {
        Connection connection = JdbcSingleton.getInstance().getConnection();
        String sql = "SELECT COUNT(*) FROM Ingredient WHERE Ingredient_NAME = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, ingredientName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
//    public List<IngredientModel> searchIngredientByName(String ingredientName) {
//    List<IngredientModel> searchResult = new ArrayList<>();
//    
//    // Kết nối CSDL và thực hiện truy vấn để tìm kiếm
//    Connection connection = JdbcSingleton.getInstance().getConnection();
//    String sql = "SELECT * FROM Ingredient WHERE Ingredient_NAME LIKE ?";
//    try {
//        PreparedStatement ps = connection.prepareStatement(sql);
//        ps.setString(1, "%" + ingredientName + "%"); // Sử dụng phần truy vấn để tìm kiếm các bản ghi có tên chứa phần tìm kiếm
//        ResultSet rs = ps.executeQuery();
//        while (rs.next()) {
//            IngredientModel ingredient = new IngredientModel();
//            ingredient.setIngredient_ID(rs.getString("Ingredient_ID"));
//            ingredient.setIngredient_NAME(rs.getString("Ingredient_NAME"));
//            // Thêm ingredient vào danh sách kết quả tìm kiếm
//            searchResult.add(ingredient);
//        }
//    } catch (SQLException ex) {
//        ex.printStackTrace();
//    }
//    
//    return searchResult;
//}

}
