/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Bao Ngoc
 */
public class RecipeModel {
    private String Recipe_ID;
    private String Recipe_TITLE;
    private String Recipe_Steps;
    private String Descriptions_Nutrient;
    private String Descriptions_Time;
    private String Descriptions_Difficult;
    private String Descriptions_Rate;
    private String Descriptions_Note;
    private byte[] Recipe_Image;

    public RecipeModel() {
    }

    public RecipeModel(String recipe_ID, String recipe_TITLE, String recipe_Steps, String descriptions_Nutrient,
            String descriptions_Time, String descriptions_Difficult,  String descriptions_Rate,
            String descriptions_Note, byte[] recipe_Image) {
        Recipe_ID = recipe_ID;
        Recipe_TITLE = recipe_TITLE;
        Recipe_Steps = recipe_Steps;
        Descriptions_Nutrient = descriptions_Nutrient;
        Descriptions_Time = descriptions_Time;
        Descriptions_Difficult = descriptions_Difficult;
       
        Descriptions_Rate = descriptions_Rate;
        Descriptions_Note = descriptions_Note;
        Recipe_Image = recipe_Image;
    }
    public RecipeModel(String trim, String trim0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public String getRecipe_ID() {
        return Recipe_ID;
    }

    public void setRecipe_ID(String Recipe_ID) {
        this.Recipe_ID = Recipe_ID;
    }

    public String getRecipe_TITLE() {
        return Recipe_TITLE;
    }

    public void setRecipe_TITLE(String Recipe_TITLE) {
        this.Recipe_TITLE = Recipe_TITLE;
    }

    public String getRecipe_Steps() {
        return Recipe_Steps;
    }

    public void setRecipe_Steps(String Recipe_Steps) {
        this.Recipe_Steps = Recipe_Steps;
    }

    public String getDescriptions_Nutrient() {
        return Descriptions_Nutrient;
    }

    public void setDescriptions_Nutrient(String Descriptions_Nutrient) {
        this.Descriptions_Nutrient = Descriptions_Nutrient;
    }

    public String getDescriptions_Time() {
        return Descriptions_Time;
    }

    public void setDescriptions_Time(String Descriptions_Time) {
        this.Descriptions_Time = Descriptions_Time;
    }

    public String getDescriptions_Difficult() {
        return Descriptions_Difficult;
    }

    public void setDescriptions_Difficult(String Descriptions_Difficult) {
        this.Descriptions_Difficult = Descriptions_Difficult;
    }

    public String getDescriptions_Rate() {
        return Descriptions_Rate;
    }

    public void setDescriptions_Rate(String Descriptions_Rate) {
        this.Descriptions_Rate = Descriptions_Rate;
    }

    public String getDescriptions_Note() {
        return Descriptions_Note;
    }

    public void setDescriptions_Note(String Descriptions_Note) {
        this.Descriptions_Note = Descriptions_Note;
    }

    public byte[] getRecipe_Image() {
        return Recipe_Image;
    }

    public void setRecipe_Image(byte[] Recipe_Image) {
        this.Recipe_Image = Recipe_Image;
    }

}
