package challCompass;

import Playerselector.PlayerSelector;
import Viergewinnt.Viergewinnt;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;


public class challCompHandler implements Listener {

    @EventHandler
    public void handleNavigatorClick(InventoryClickEvent event) {
        PlayerSelector ps = new PlayerSelector(54,"Select your Opponent!");
        challComp compass = new challComp(54, "Select your Mode");
        Player player = (Player) event.getWhoClicked();
        if (!(event.getWhoClicked() instanceof Player)) return;
        if (event.getView().getTitle().equals(compass.getGui_name())) {
            event.setCancelled(true);
            switch (event.getCurrentItem().getType()) {
                case BLUE_STAINED_GLASS_PANE:
                    ps.openPlayerSelector(player, ps.getInventorySize(), ps.getGui_name());

            }
        }

    }

    @EventHandler
    public void handleNavigatorOpener(PlayerInteractEvent event) {
        challComp compass = new challComp(54, "Select your Mode");
        if (event.getItem().getType() != Material.COMPASS) {
            return;
        }

        if (event.getAction() == Action.RIGHT_CLICK_AIR
                || event.getAction() == Action.RIGHT_CLICK_BLOCK
                || event.getAction() == Action.LEFT_CLICK_BLOCK
                || event.getAction() == Action.LEFT_CLICK_AIR) {
            compass.openSelectorGUI(event.getPlayer(), compass.getInventorySize(), compass.getGui_name());
        }
    }

}
