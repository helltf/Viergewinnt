package challCompass;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.Collection;

public class challComp {
    public int inventorySize;
    public String gui_name;

    public challComp(int inventorySize,String gui_name){
        this.inventorySize=inventorySize;
        this.gui_name=gui_name;
    }

    public void openSelectorGUI(Player player,int inventorySize,String gui_name){
        Inventory inv = Bukkit.createInventory(null,inventorySize,gui_name);
        inv.setItem(10,new ItemStack(Material.BLUE_STAINED_GLASS_PANE));
        player.openInventory(inv);
    }
    public int getInventorySize() {
        return inventorySize;
    }
    public void setInventorySize(int inventorySize) {
        this.inventorySize = inventorySize;
    }
    public String getGui_name() {
        return gui_name;
    }
    public void setGui_name(String gui_name) {
        this.gui_name = gui_name;
    }
}
