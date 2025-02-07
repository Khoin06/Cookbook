package dao;

import java.beans.Statement;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.RecipeModel;
import utils.JdbcSingleton;

public class RecipeDAO  {

    
public List<RecipeModel> getRecipe(String recipe_ID) {
    List<RecipeModel> recipes = new ArrayList<RecipeModel>();
    Connection connection = JdbcSingleton.getInstance().getConnection();
//    try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM Recipe WHERE Recipe_ID = ?")) {
//        statement.setString(1, recipe_ID);
//        var resultSet = statement.executeQuery();
//        while (resultSet.next()) {
//            RecipeModel recipe = new RecipeModel(
//                    resultSet.getString("Recipe_ID"),
//                    resultSet.getString("Recipe_TITLE"),
//                    resultSet.getString("Recipe_Steps"),
//                    resultSet.getString("Descriptions_Nutrient"),
//                    resultSet.getString("Descriptions_Time"),
//                    resultSet.getDouble("Descriptions_Difficult"),
//                    resultSet.getString("Descriptions_Type"),
//                    resultSet.getDouble("Descriptions_Rate"),
//                    resultSet.getString("Descriptions_Note"),
//                    resultSet.getBytes("Recipe_Image")
//            );
//            recipes.add(recipe);
//        }
    String sql = "SELECT * FROM Recipe";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs  = ps.executeQuery();
            
            while (rs.next()) {
                RecipeModel monan = new RecipeModel();
                monan. setRecipe_ID(rs.getString("Recipe_ID"));
                monan.setRecipe_TITLE(rs.getString("Recipe_TITLE"));
                monan.setRecipe_Steps(rs.getString("Recipe_STEPS"));
                monan.setDescriptions_Nutrient(rs.getString("Descriptions_NUTRIENT"));
                monan.setDescriptions_Time(rs.getString("Descriptions_TIME"));
                monan.setDescriptions_Difficult(rs.getString("Descriptions_DIFFICULT"));
                monan.setDescriptions_Rate(rs.getString("Descriptions_RATE"));
                monan.setDescriptions_Note(rs.getString("Descriptions_NOTE"));
                monan.setRecipe_Image(rs.getBytes("Recipe_IMAGE"));


                recipes.add(monan);
            }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return recipes;
}

 
    public void addRecipe(RecipeModel recipe) {
        Connection connection = JdbcSingleton.getInstance().getConnection();
        try (PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO Recipe (Recipe_ID, Recipe_TITLE, Recipe_Steps, Descriptions_Nutrient, Descriptions_Time , Descriptions_Difficult, Descriptions_Rate, Descriptions_Note, Recipe_Image) VALUES (?, ?, ?, ?, ?,  ?, ?, ?, ?)")) {
            statement.setString(1, recipe.getRecipe_ID());
            statement.setString(2, recipe.getRecipe_TITLE());
            statement.setString(3, recipe.getRecipe_Steps());
            statement.setString(4, recipe.getDescriptions_Nutrient());
            statement.setString(5, recipe.getDescriptions_Time());
            statement.setString(6, recipe.getDescriptions_Difficult());
            statement.setString(7, recipe.getDescriptions_Rate());
            statement.setString(8, recipe.getDescriptions_Note());
            statement.setBytes(9, recipe.getRecipe_Image());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 



//    public void updateRecipe(RecipeModel recipe) {
//    Connection connection = JdbcSingleton.getInstance().getConnection();
//    try (PreparedStatement statement = connection.prepareStatement(
//            "UPDATE Recipe SET Recipe_TITLE = ?, Recipe_Steps = ?, Descriptions_Nutrient = ?, Descriptions_Time = ?, Descriptions_Difficult = ?, Descriptions_Type = ?, Descriptions_Rate = ?, Descriptions_Note = ?, Recipe_Image = ? WHERE Recipe_ID = ?")) {
//        statement.setString(1, recipe.getRecipe_TITLE());
//        statement.setString(2, recipe.getRecipe_Steps());
//        statement.setString(3, recipe.getDescriptions_Nutrient());
//        statement.setString(4, recipe.getDescriptions_Time());
//        statement.setString(5, recipe.getDescriptions_Difficult());
//        statement.setString(6, recipe.getDescriptions_Type());
//        statement.setString(7, recipe.getDescriptions_Rate());
//        statement.setString(8, recipe.getDescriptions_Note());
//        statement.setBytes(9, recipe.getRecipe_Image());
////        statement.setString(10, recipe.getRecipe_ID());
//        
//        statement.executeUpdate();
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }

//}
    public void updateRecipe(RecipeModel recipe) {
        Connection connection = JdbcSingleton.getInstance().getConnection();
        String sql = "UPDATE Recipe SET Recipe_TITLE = ?, Recipe_Steps = ?, Descriptions_Nutrient = ?, Descriptions_Time = ?, Descriptions_Difficult = ?,  Descriptions_Rate = ?, Descriptions_Note = ?, Recipe_Image = ? WHERE Recipe_ID = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, recipe.getRecipe_TITLE());
            statement.setString(2, recipe.getRecipe_Steps());
            statement.setString(3, recipe.getDescriptions_Nutrient());
            statement.setString(4, recipe.getDescriptions_Time());
            statement.setString(5, recipe.getDescriptions_Difficult());
            statement.setString(6, recipe.getDescriptions_Rate());
            statement.setString(7, recipe.getDescriptions_Note());
            statement.setBytes(8, recipe.getRecipe_Image());
            statement.setString(9, recipe.getRecipe_ID());
            
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Recipe updated successfully!");
            } else {
                System.out.println("No recipe found with the given ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public void deleteRecipe(String recipe_ID) {
        Connection connection = JdbcSingleton.getInstance().getConnection();
//        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM Recipe WHERE Recipe_ID = ?")) {
//            statement.setString(1, recipe_ID);
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
        String sql = "DELETE FROM Recipe WHERE Recipe_ID = ? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,recipe_ID);

            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }    
        public RecipeModel getRecipeById(String Recipe_ID) {   
        Connection connection = JdbcSingleton.getInstance().getConnection();

        String sql = "SELECT * FROM Recipe where Recipe_ID = ? ";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,Recipe_ID);
            ResultSet rs  = ps.executeQuery();
            
            while (rs.next()) {
                RecipeModel monan = new RecipeModel();
                monan. setRecipe_ID(rs.getString("Recipe_ID"));
                monan.setRecipe_TITLE(rs.getString("Recipe_TITLE"));
                monan.setRecipe_Steps(rs.getString("Recipe_STEPS"));
                monan.setDescriptions_Nutrient(rs.getString("Descriptions_NUTRIENT"));
                monan.setDescriptions_Time(rs.getString("Descriptions_TIME"));
                monan.setDescriptions_Difficult(rs.getString("Descriptions_DIFFICULT"));
                monan.setDescriptions_Rate(rs.getString("Descriptions_RATE"));
                monan.setDescriptions_Note(rs.getString("Descriptions_NOTE"));
                monan.setRecipe_Image(rs.getBytes("Recipe_IMAGE"));

                return monan;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return null;
    }
}