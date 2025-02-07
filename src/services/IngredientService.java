/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.IngredientDAO;
import java.util.List;
import model.IngredientModel;
import model.ingre_recipeModel;

/**
 *
 * @author khoi ngo
 */
public class IngredientService {
    private IngredientDAO igredientDao;
    
    public IngredientService() {
        igredientDao = new IngredientDAO();
        
    }
    
    public List<IngredientModel> getIngredient() {
       return igredientDao.getIngredient();
    }  
    public void DeleteIngredient(String Ingredient_ID) {
        igredientDao.DeleteIngredient(Ingredient_ID);
    }
    public void AddIngredient(IngredientModel ingredient) {
        igredientDao.AddIngredient(ingredient);
    }
    public void UpdateIngredient(String Ingredient_ID, String Ingredient_NAME) {
        igredientDao.UpdateIngredient(Ingredient_ID,Ingredient_NAME);
    }
//    public void UpdateIngredient(IngredientModel ingredient) {
//        igredientDao.UpdateIngredient(ingredient);
//    }
    
    
    public IngredientModel getIngredientById(String Ingredient_ID)
    {
        return igredientDao.getIngredientById(Ingredient_ID);
    }
    public boolean isIngredientDuplicated( String ingredientName)
    {
        return igredientDao.isIngredientDuplicated(ingredientName);
    }
//    public List<IngredientModel> searchIngredientByName(String ingredientName){
//        return igredientDao.searchIngredientByName(ingredientName);
//    }


}
