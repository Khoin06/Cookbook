package services;

import dao.RecipeDAO;
import java.util.List;
import model.RecipeModel;

public class RecipeService {
    private RecipeDAO recipeDao;

    public RecipeService() {
        recipeDao = new RecipeDAO();
    }

    public List<RecipeModel> getRecipe(String recipe_ID) {
        return recipeDao.getRecipe(recipe_ID);
    }

    public void addRecipe(RecipeModel recipe) {
        recipeDao.addRecipe(recipe);
    }

    public void updateRecipe(RecipeModel recipe) {
        recipeDao.updateRecipe(recipe);
    }

    public void deleteRecipe(String recipe_ID) {
        recipeDao.deleteRecipe(recipe_ID);
    }

    public RecipeModel getRecipeById(String recipe_ID) {
        return recipeDao.getRecipeById(recipe_ID);
    }
    
    public void ingre_recipe(RecipeModel recipe) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
