package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ingre_recipeModel;
import utils.JdbcSingleton;

public class ingre_recipeDAO {

    public void insertRecipeIngredient(ingre_recipeModel recipe) {
        Connection conn = JdbcSingleton.getInstance().getConnection(); 
        String sql = "INSERT INTO RecipeIngredient (Recipe_ID, Ingredient_ID, Ingredient_QUANTITY, unit, Recipe_TITLE, Ingredient_NAME) VALUES (?, ?, ?, ?, ?, ?)";
        try (
                
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, recipe.getRecipe_ID());
            stmt.setString(2, recipe.getIngredient_ID());
            stmt.setInt(3, recipe.getIngredient_QUANTITY());
            stmt.setString(4, recipe.getUnit());
            stmt.setString(5, recipe.getRecipe_TITLE());
            stmt.setString(6, recipe.getIngredient_NAME());
            stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteAllRecipeIngredients(String ingre_recipe) {
        Connection conn = JdbcSingleton.getInstance().getConnection();
        String sql = "DELETE FROM RecipeIngredient";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<ingre_recipeModel> getIngredient_NAME() {
        List<ingre_recipeModel> recipeIngredients = new ArrayList<ingre_recipeModel>();
        Connection conn = JdbcSingleton.getInstance().getConnection();
        String sql = "SELECT * FROM RecipeIngredient";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs  = ps.executeQuery();
            while (rs.next()) {
                ingre_recipeModel recipe = new ingre_recipeModel();
                recipe.setRecipe_ID(rs.getString("Recipe_ID"));
                recipe.setIngredient_ID(rs.getString("Ingredient_ID"));
                recipe.setIngredient_QUANTITY(rs.getInt("Ingredient_QUANTITY"));
                recipe.setUnit(rs.getString("unit"));
                recipe.setRecipe_TITLE(rs.getString("Recipe_TITLE"));
                recipe.setIngredient_NAME(rs.getString("Ingredient_NAME"));
                recipeIngredients.add(recipe);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return recipeIngredients;
    }
    
//    public int getRecipeIngredientsByRecipeID(String recipeID) {
//        List<ingre_recipeModel> recipeIngredients = new ArrayList<>();
//        Connection connection = JdbcSingleton.getInstance().getConnection();
//        String sql = "SELECT Ingredient_ID, Ingredient_QUANTITY, unit, Ingredient_NAME FROM RecipeIngredient WHERE Recipe_ID = ?";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, recipeID);
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                ingre_recipeModel recipe = new ingre_recipeModel();
//                recipe.setRecipe_ID(recipeID); // Assuming recipe ID is already available
//                recipe.setIngredient_ID(resultSet.getString("Ingredient_ID"));
//                recipe.setIngredient_QUANTITY(resultSet.getInt("Ingredient_QUANTITY"));
//                recipe.setUnit(resultSet.getString("unit"));
//                recipe.setIngredient_NAME(resultSet.getString("Ingredient_NAME"));
//                recipeIngredients.add(recipe);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return 
//    }
//    public int getRecipeIngredientsByRecipeID(String recipeID) {
//  int ingredientCount = 0;
//  Connection connection = JdbcSingleton.getInstance().getConnection();
//  String sql = "SELECT Ingredient_ID, Ingredient_QUANTITY, unit, Ingredient_NAME FROM RecipeIngredient WHERE Recipe_ID = ?";
//  try {
//    PreparedStatement preparedStatement = connection.prepareStatement(sql);
//    preparedStatement.setString(1, recipeID);
//    ResultSet resultSet = preparedStatement.executeQuery();
//
//    while (resultSet.next()) {
//      ingredientCount++; // Increment the count for each ingredient
//    }
//  } catch (Exception e) {
//    e.printStackTrace();
//  } 
//  return ingredientCount;
//}
    public List<ingre_recipeModel> getRecipeIngredientsByRecipeID(String recipeID) {
    List<ingre_recipeModel> ingredientsList = new ArrayList<ingre_recipeModel>();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    try {
        connection = JdbcSingleton.getInstance().getConnection();
        String sql = "SELECT Ingredient_ID, Ingredient_QUANTITY, unit, Ingredient_NAME FROM RecipeIngredient WHERE Recipe_ID = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, recipeID);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            ingre_recipeModel ingredient = new ingre_recipeModel();
            ingredient.setIngredient_ID(resultSet.getString("Ingredient_ID"));
            ingredient.setIngredient_QUANTITY(resultSet.getInt("Ingredient_QUANTITY"));
            ingredient.setUnit(resultSet.getString("unit"));
            ingredient.setIngredient_NAME(resultSet.getString("Ingredient_NAME"));
            ingredientsList.add(ingredient);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Close ResultSet, PreparedStatement, and Connection in reverse order
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    return ingredientsList;
}



}
