package Playerselector;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Collection;

public class PlayerSelector {

    public int inventorySize;
    public String gui_name;
    
    public PlayerSelector(int inventorySize, String gui_name){
        this.inventorySize=inventorySize;
        this.gui_name=gui_name;
    }
    public void openPlayerSelector(Player player, int inventorySize, String gui_name){
        Inventory inv = Bukkit.createInventory(null,inventorySize,gui_name);
        int x=0;
        Collection<Player> oplayer= (Collection<Player>) Bukkit.getOnlinePlayers();
        for (Player availableplayers :oplayer) {
            ItemStack itemstack = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta meta = (SkullMeta) itemstack.getItemMeta();
            meta.setDisplayName(availableplayers.getName());
            meta.setOwningPlayer(availableplayers);
            itemstack.setItemMeta(meta);
            inv.setItem(x, itemstack);
            x++;
        }

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
