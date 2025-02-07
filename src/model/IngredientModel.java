package model;


public class IngredientModel {
    private String Ingredient_ID;
    private String Ingredient_NAME;

    public IngredientModel() {
    }

    public IngredientModel(String Ingredient_ID, String Ingredient_NAME) {
        this.Ingredient_ID = Ingredient_ID;
        this.Ingredient_NAME = Ingredient_NAME;
    }

    public String getIngredient_ID() {
        return Ingredient_ID;
    }

    public void setIngredient_ID(String Ingredient_ID) {
        this.Ingredient_ID = Ingredient_ID;
    }

    public String getIngredient_NAME() {
        return Ingredient_NAME;
    }

    public void setIngredient_NAME(String Ingredient_NAME) {
        this.Ingredient_NAME = Ingredient_NAME;
    }


    
    
}
