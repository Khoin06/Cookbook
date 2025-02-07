package model;

public class ingre_recipeModel {
    private String Recipe_ID;
    private String Ingredient_NAME;
    private int Ingredient_QUANTITY;
    private String Ingredient_ID;
    private String unit;
    private String Recipe_TITLE;

    // Constructor
    public ingre_recipeModel(String Recipe_ID, String Ingredient_NAME, String Ingredient_ID, int Ingredient_QUANTITY, String unit, String Recipe_TITLE) {
        this.Recipe_ID = Recipe_ID;
        this.Ingredient_NAME=Ingredient_NAME;
        this.Ingredient_ID=Ingredient_ID;
        this.Ingredient_QUANTITY=Ingredient_QUANTITY;
        this.unit = unit;
        this.Recipe_TITLE=Recipe_TITLE;
    }

    public ingre_recipeModel() {
    }
    
    // Getters and setters

    public String getRecipe_ID() {
        return Recipe_ID;
    }

    public void setRecipe_ID(String Recipe_ID) {
        this.Recipe_ID = Recipe_ID;
    }

    public String getIngredient_NAME() {
        return Ingredient_NAME;
    }

    public void setIngredient_NAME(String Ingredient_NAME) {
        this.Ingredient_NAME = Ingredient_NAME;
    }

    public int getIngredient_QUANTITY() {
        return Ingredient_QUANTITY;
    }

    public void setIngredient_QUANTITY(int Ingredient_QUANTITY) {
        this.Ingredient_QUANTITY = Ingredient_QUANTITY;
    }

    public String getIngredient_ID() {
        return Ingredient_ID;
    }

    public void setIngredient_ID(String Ingredient_ID) {
        this.Ingredient_ID = Ingredient_ID;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getRecipe_TITLE() {
        return Recipe_TITLE;
    }

    public void setRecipe_TITLE(String Recipe_TITLE) {
        this.Recipe_TITLE = Recipe_TITLE;
    }
    
}
