package de.plugin.extra;

import Playerselector.PlayerSelector;
import Viergewinnt.Viergewinnt;
import challCompass.challComp;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class Inventories {
    public static ArrayList<Player> hasMove= new ArrayList<Player>();
    public static Viergewinnt Viergewinnt = new Viergewinnt(54,"Viergewinnt",createContent(),null,null,hasMove);
    public static PlayerSelector ps = new PlayerSelector(54,"Select your Opponent!");
    public static challComp compass = new challComp(54, "Select your Mode");

    public static ItemStack[] createContent(){
        ItemStack[] content = new ItemStack[54];
        for(int i=0;i<54;i++){
            content[i]=new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
            if(i%9==8){
                content[i]=new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
            }
            if(i%9==0){
                content[i] = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
            }

        }
        return content;
    }
}
