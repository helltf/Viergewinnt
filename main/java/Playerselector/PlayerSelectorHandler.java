package Playerselector;

import Viergewinnt.Viergewinnt;
import de.plugin.extra.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerSelectorHandler implements Listener {


    @EventHandler
    public void handleViergewinntSelectorClick(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;
        if (event.getView().getTitle().equals("Select your Opponent!")) {
            Viergewinnt vg = new Viergewinnt(54,"Viergewinnt",createContent(),null,null,null);
            event.setCancelled(true);
            if (!event.getCurrentItem().getType().equals(Material.PLAYER_HEAD)||event.getCurrentItem().getItemMeta().getDisplayName().equals(event.getWhoClicked().getName())) {
                event.getWhoClicked().sendMessage("Can't challenge yourself!");
                return;
            }
        else{
                vg.setPlayer2(Bukkit.getPlayerExact(event.getCurrentItem().getItemMeta().getDisplayName()));
                vg.setPlayer1(((Player) event.getWhoClicked()).getPlayer());
                vg.editContent(0, vg.createPlayerHead(vg.getPlayer1()),vg.getContent());
                vg.editContent(8, vg.createPlayerHead(vg.getPlayer2()),vg.getContent());
                vg.openGUI(vg.getPlayer1(), vg.getPlayer2(), vg.createInventory(vg.getInventorySize(), vg.getContent(), vg.gui_name));
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
