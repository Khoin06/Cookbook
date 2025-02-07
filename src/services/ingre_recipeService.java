package services;

import dao.ingre_recipeDAO;
import model.ingre_recipeModel;
import java.sql.SQLException;
import java.util.List;
import model.IngredientModel;

public class ingre_recipeService {
    private ingre_recipeDAO ingre_recipeDao;

    public ingre_recipeService() {
        ingre_recipeDao = new ingre_recipeDAO();
    }
    public List<ingre_recipeModel> getIngredient_NAME() {
       return ingre_recipeDao.getIngredient_NAME();
    } 
    public void saveRecipeIngredient(ingre_recipeModel recipe)  {
        ingre_recipeDao.insertRecipeIngredient(recipe);
    }
    public void deleteAllRecipeIngredients(String ingre_recipe){
        ingre_recipeDao.deleteAllRecipeIngredients(ingre_recipe);
    }
//        public int getRecipeIngredientsByRecipeID(String recipeID) {
//           return ingre_recipeDao.getRecipeIngredientsByRecipeID(recipeID);
//    }
    public List<ingre_recipeModel> getRecipeIngredientsByRecipeID(String recipeID) {
        return ingre_recipeDao.getRecipeIngredientsByRecipeID(recipeID);
    }
    
    // Các phương thức khác nếu cần thiết
}
