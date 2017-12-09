package ru.astolbov.start.menu;

/**
 * Created by alex on 1/28/17.
 */
public abstract class BaseItem implements MenuItem {
    /**
     * Name of item.
     */
    private String menuName;

    /**
     * Item for exit.
     */
    private boolean exitMenu;

    /**
     * Set name and exit flag of item.
     * @param setMenuName - menu name
     * @param setExitMenu - exit flag
     */
    public BaseItem(String setMenuName, boolean setExitMenu) {
        this.menuName =  setMenuName;
        this.exitMenu = setExitMenu;
    }

    /**
     * Define name of menu.
     * @return - name of menu
     */
    public String getMenuName() {
        return this.menuName;
    }

    /**
     * Actions that are performed when you select this menu.
     * @return strings - array to show
     */
    //public abstract ArrayList<String> doCommandMenu();

    /**
     * Return the flag of the output from the menu.
     * @return -  flag "Exit"
     */
    public boolean goExit() {
        return this.exitMenu;
    }
}
