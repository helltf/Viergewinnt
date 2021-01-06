package Viergewinnt;

import de.plugin.extra.Inventories;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Arrays;

public class ViergewinntHandler implements Listener {

    @EventHandler
    public void handlePlayerSlotClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;
        if (event.getView().getTitle().equals("Viergewinnt")) {
            Player clickedPlayer = (Player) event.getWhoClicked();
            event.setCancelled(true);
            Player otherplayer;
            if(Inventories.Viergewinnt.getHasMove().contains(clickedPlayer)){
                if(clickedPlayer.equals(Inventories.Viergewinnt.getPlayer1())) {
                   otherplayer= Inventories.Viergewinnt.getPlayer2();
                }
                else{
                    otherplayer=Inventories.Viergewinnt.getPlayer1();
                }
                Inventories.Viergewinnt.setContent(Inventories.Viergewinnt.setPlayersPoint(Inventories.Viergewinnt.content, clickedPlayer,event.getSlot()));
                Inventories.Viergewinnt.setHasMove(Inventories.Viergewinnt.switchPlayerWhoHasMove(Inventories.Viergewinnt.getHasMove(),clickedPlayer,otherplayer));
                Inventories.Viergewinnt.setBorderforPlayerWithMove(Inventories.Viergewinnt.getContent(),otherplayer);
                Inventories.Viergewinnt.renewInventory(Inventories.Viergewinnt.getPlayer1(),Inventories.Viergewinnt.getPlayer2(),Inventories.Viergewinnt.getContent(),Inventories.Viergewinnt.getInventorySize(),Inventories.Viergewinnt.getGui_name());
                Inventories.Viergewinnt.checkForWin(Inventories.Viergewinnt.getContent());
            }
            else{
                return;
            }
        }
    }
}
