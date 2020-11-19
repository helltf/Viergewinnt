package Playerselector;

import Viergewinnt.Viergewinnt;
import de.plugin.extra.Inventories;
import de.plugin.extra.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PlayerSelectorHandler implements Listener {

    @EventHandler
    public void handleViergewinntSelectorClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;
        if (event.getView().getTitle().equals("Select your Opponent!")) {

            event.setCancelled(true);
            if (!event.getCurrentItem().getType().equals(Material.PLAYER_HEAD)||event.getCurrentItem().getItemMeta().getDisplayName().equals(event.getWhoClicked().getName())) {
                event.getWhoClicked().sendMessage("Can't challenge yourself!");
                return;
            }
        else{   Inventories.Viergewinnt.setContent(Inventories.Viergewinnt.resetInventory());
                Inventories.Viergewinnt.setPlayer2(Bukkit.getPlayerExact(event.getCurrentItem().getItemMeta().getDisplayName()));
                Inventories.Viergewinnt.setPlayer1(((Player) event.getWhoClicked()).getPlayer());
                Inventories.Viergewinnt.editContent(0, Inventories.Viergewinnt.createPlayerHead(Inventories.Viergewinnt.getPlayer1()),Inventories.Viergewinnt.getContent());
                Inventories.Viergewinnt.editContent(8, Inventories.Viergewinnt.createPlayerHead(Inventories.Viergewinnt.getPlayer2()),Inventories.Viergewinnt.getContent());
                Inventories.Viergewinnt.setHasMove(Inventories.Viergewinnt.initializeHasMove(Inventories.Viergewinnt.getHasMove(),Inventories.Viergewinnt.getPlayer1()));
                Inventories.Viergewinnt.openGUI(Inventories.Viergewinnt.getPlayer1(), Inventories.Viergewinnt.getPlayer2(),Inventories.Viergewinnt.createInventory(Inventories.Viergewinnt.getInventorySize(), Inventories.Viergewinnt.getContent(), Inventories.Viergewinnt.gui_name));

            }
        }
    }
    public static ItemStack[] createContent(){
        ItemStack[] content = new ItemStack[54];
        for(int i=0;i<54;i++){
            content[i]=new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
            if(i%9==0||i%9==8){
                content[i]=new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
            }

        }
        return content;
    }

}
