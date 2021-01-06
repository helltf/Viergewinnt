package challCompass;

import de.plugin.extra.Inventories;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;


public class challCompHandler implements Listener {

    @EventHandler
    public void handleNavigatorClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (!(event.getWhoClicked() instanceof Player)) return;
        if (event.getView().getTitle().equals(Inventories.compass.getGui_name())) {
            event.setCancelled(true);

            if (event.getCurrentItem() != null) {
                switch (event.getCurrentItem().getType()) {
                    case BLUE_STAINED_GLASS_PANE:
                        Inventories.ps.openPlayerSelector(player, Inventories.ps.getInventorySize(), Inventories.ps.getGui_name());
                        break;

                }
            }

        }
    }

    @EventHandler
    public void handleNavigatorOpener(PlayerInteractEvent event) {
        if (!event.getMaterial().equals(Material.COMPASS)){}
         else {
            if (event.getAction() == Action.RIGHT_CLICK_AIR
                    || event.getAction() == Action.RIGHT_CLICK_BLOCK
                    || event.getAction() == Action.LEFT_CLICK_BLOCK
                    || event.getAction() == Action.LEFT_CLICK_AIR) {
                Inventories.compass.openSelectorGUI(event.getPlayer(), Inventories.compass.getInventorySize(), Inventories.compass.getGui_name());
            }
        }
    }
}
