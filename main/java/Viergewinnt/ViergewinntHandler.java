package Viergewinnt;

import de.plugin.extra.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class ViergewinntHandler implements Listener {

    @EventHandler
    public void handlePlayerSlotClick(InventoryClickEvent event) {

        if (!(event.getWhoClicked() instanceof Player)) return;
        if (event.getView().getTitle().equals("Viergewinnt")) {
            Player clickedPlayer = (Player) event.getWhoClicked();
        }
    }
    public static ItemStack[] createContent(){
        ItemStack[] content = new ItemStack[54];
        for(int i=0;i<54;i++){
            content[i]=new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
            if(i%9==0||i%9==8){
                content[i]=new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
            }
        }
        return content;
    }
}
