package model;


public class MenuModel {
    private String Menu_ID;
    private String Name_ID;
    private String Menu_Name;
    private String Recipe_ID;
    private String Recipe_TITLE;
    private String Time_Menu;
      private int Total_Recipe_Title;


    public MenuModel() {
    }

    public MenuModel(String Menu_ID,String Name_ID, String Menu_Name, String Recipe_ID, String Recipe_TITLE, String Time_Menu) {
        this.Menu_ID = Menu_ID;
        this.Name_ID = Name_ID;
        this.Menu_Name = Menu_Name;
        this.Recipe_ID = Recipe_ID;
        this.Recipe_TITLE = Recipe_TITLE;
        this.Time_Menu = Time_Menu;
        
    }

public int getTotal_Recipe_Title() {
        return Total_Recipe_Title;
    }

    public void setTotal_Recipe_Title(int Total_Recipe_Title) {
        this.Total_Recipe_Title = Total_Recipe_Title;
    }
    public String getName_ID() {
        return Name_ID;
    }

    public void setName_ID(String Name_ID) {
        this.Name_ID = Name_ID;
    }

    public String getMenu_ID() {
        return Menu_ID;
    }

    public void setMenu_ID(String Menu_ID) {
        this.Menu_ID = Menu_ID;
    }

    public String getMenu_Name() {
        return Menu_Name;
    }

    public void setMenu_Name(String Menu_Name) {
        this.Menu_Name = Menu_Name;
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

    public String getTime_Menu() {
        return Time_Menu;
    }

    public void setTime_Menu(String Time_Menu) {
        this.Time_Menu = Time_Menu;
    }
    
}
