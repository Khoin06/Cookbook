package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.MenuModel;
import utils.JdbcSingleton;

public class MenuDAO {

    public void addMenu(MenuModel menu) {
        Connection connection = JdbcSingleton.getInstance().getConnection();

        String query = "INSERT INTO Menu (Menu_ID,Name_ID, Menu_Name, Recipe_ID, Recipe_TITLE, Time_Menu) VALUES (?,?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, menu.getMenu_ID());
            stmt.setString(2, menu.getName_ID());
            stmt.setString(3, menu.getMenu_Name());
            stmt.setString(4, menu.getRecipe_ID());
            stmt.setString(5, menu.getRecipe_TITLE());
            stmt.setString(6, menu.getTime_Menu());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
   
        }
    }

    public void updateMenu(MenuModel menu) {
        Connection connection = JdbcSingleton.getInstance().getConnection();

        String query = "UPDATE Menu SET Menu_Name = ?,Name_ID = ? , Recipe_ID = ?, Recipe_TITLE = ?, Time_Menu = ? WHERE Menu_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, menu.getMenu_Name());
            stmt.setString(2, menu.getName_ID());
            stmt.setString(3, menu.getRecipe_ID());
            stmt.setString(4, menu.getRecipe_TITLE());
            stmt.setString(5, menu.getTime_Menu());
            stmt.setString(6, menu.getMenu_ID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void deleteMenu(String Menu_ID) {
        Connection connection = JdbcSingleton.getInstance().getConnection();

        String query = "DELETE FROM Menu WHERE Recipe_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, Menu_ID);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
          
        }
    }

    public MenuModel getMenuById(String Menu_ID) {
        Connection connection = JdbcSingleton.getInstance().getConnection();

        String query = "SELECT * FROM Menu WHERE Menu_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, Menu_ID);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new MenuModel(
                        rs.getString("Menu_ID"),
                        rs.getString("Name_ID"),
                        rs.getString("Menu_Name"),
                        rs.getString("Recipe_ID"),
                        rs.getString("Recipe_TITLE"),
                        rs.getString("Time_Menu")
                     
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<MenuModel> getAllMenus() {
        Connection connection = JdbcSingleton.getInstance().getConnection();

        List<MenuModel> menus = new ArrayList<>();
        String query = "SELECT Menu_ID, Name_ID, Menu_Name, Recipe_ID, Recipe_TITLE, Time_Menu FROM Menu";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                menus.add(new MenuModel(
                    rs.getString("Menu_ID"),
                    rs.getString("Name_ID"),
                    rs.getString("Menu_Name"),
                    rs.getString("Recipe_ID"),
                    rs.getString("Recipe_TITLE"),
                    rs.getString("Time_Menu")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return menus;
    }

public List<MenuModel> getTotalRecipeTitlesByNameID() {
    List<MenuModel> menus = new ArrayList<>();
    String sql = "SELECT Name_ID, COUNT(Recipe_TITLE) AS Total_Recipe_Title FROM Menu GROUP BY Name_ID;";

    try (Connection conn = JdbcSingleton.getInstance().getConnection(); 
         PreparedStatement pstmt = conn.prepareStatement(sql); 
         ResultSet rs = pstmt.executeQuery()) {

        while (rs.next()) {
            String nameID = rs.getString("Name_ID");
            int totalRecipeTitle = rs.getInt("Total_Recipe_Title");
            MenuModel menu = new MenuModel();
            menu.setName_ID(nameID);
            menu.setTotal_Recipe_Title(totalRecipeTitle);
            menus.add(menu);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return menus;
}





}
