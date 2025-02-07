package services;

import dao.MenuDAO;
import model.MenuModel;


import java.util.List;

public class MenuService {
    private MenuDAO menuDAO;

 

    public MenuService() {
        menuDAO = new MenuDAO();
    }
//    public void addMenu(MenuModel menu){
//        menuDAO.addMenu(menu);
//    }
    public void addMenu(MenuModel menu) {
        String maxID = getMaxMenuID();
        String prefix = maxID.substring(0, 1); 
        String numericPart = maxID.substring(1); 
        int numericValue = Integer.parseInt(numericPart);
        numericValue++;
        String newNumericPart = String.format("%04d", numericValue);
        menu.setMenu_ID(prefix + newNumericPart);
        menuDAO.addMenu(menu);
    }

    public String getMaxMenuID() {
        List<MenuModel> menus = getAllMenus();
        String maxID = "M000";

        for (MenuModel menu : menus) {
            if (menu.getMenu_ID().compareTo(maxID) > 0) {
                maxID = menu.getMenu_ID();
            }
        }
        return maxID;
    }

    public void updateMenu(MenuModel menu) {
         menuDAO.updateMenu(menu);
    }

    public void deleteMenu(String Menu_ID) {
         menuDAO.deleteMenu(Menu_ID);
    }

    public MenuModel getMenuById(String Menu_ID) {
        return menuDAO.getMenuById(Menu_ID);
    }

    public List<MenuModel> getAllMenus() {
        return menuDAO.getAllMenus();
    }
    public List<MenuModel> getTotalRecipeTitlesByNameID(){
        return menuDAO.getTotalRecipeTitlesByNameID();
    }

    
}
