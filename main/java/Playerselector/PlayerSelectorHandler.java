package Playerselector;

import de.plugin.extra.Inventories;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class PlayerSelectorHandler implements Listener {

    @EventHandler
    public void handleViergewinntSelectorClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;
        if (event.getView().getTitle().equals("Select your Opponent!")) {

            event.setCancelled(true);
            if(event.getCurrentItem() != null){
                if (event.getCurrentItem().getType().equals(Material.PLAYER_HEAD) && !event.getCurrentItem().getItemMeta().getDisplayName().equals(event.getWhoClicked().getName())) {
                    Inventories.Viergewinnt=Inventories.Viergewinntdefault;
                    Inventories.Viergewinnt.setContent(Inventories.Viergewinnt.resetInventory());
                    Inventories.Viergewinnt.setPlayer2(Bukkit.getPlayerExact(event.getCurrentItem().getItemMeta().getDisplayName()));
                    Inventories.Viergewinnt.setPlayer1(((Player) event.getWhoClicked()).getPlayer());
                    //Inventories.Viergewinnt.editContent(0, Inventories.Viergewinnt.createPlayerHead(Inventories.Viergewinnt.getPlayer1()),Inventories.Viergewinnt.getContent());
                    //Inventories.Viergewinnt.editContent(8, Inventories.Viergewinnt.createPlayerHead(Inventories.Viergewinnt.getPlayer2()),Inventories.Viergewinnt.getContent());
                    Inventories.Viergewinnt.setHasMove(Inventories.Viergewinnt.initializeHasMove(Inventories.Viergewinnt.getHasMove(),Inventories.Viergewinnt.getPlayer1()));
                    Inventories.Viergewinnt.openGUI(Inventories.Viergewinnt.getPlayer1(), Inventories.Viergewinnt.getPlayer2(),Inventories.Viergewinnt.createInventory(Inventories.Viergewinnt.getInventorySize(), Inventories.Viergewinnt.getContent(), Inventories.Viergewinnt.gui_name));
                } else {
                    event.getWhoClicked().sendMessage("Can't challenge yourself!");
                }
            }
        }
    }

}
