package de.plugin.extra;

import Playerselector.PlayerSelector;
import Viergewinnt.Viergewinnt;
import challCompass.challComp;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Inventories {
    public static ArrayList<Player> hasMovenew= new ArrayList<Player>();
    public static Viergewinnt Viergewinnt = new Viergewinnt(54,"Viergewinnt",createContent(),null,null,hasMovenew);
    public static Viergewinnt Viergewinntdefault = new Viergewinnt(54,"Viergewinnt",createContent(),null,null,hasMovenew);
    public static PlayerSelector ps = new PlayerSelector(54,"Select your Opponent!");
    public static challComp compass = new challComp(54, "Select your Mode");

    public static Material[] createContent(){
        Material[] content = new Material[54];
        for(int i=0;i<54;i++){

            content[i]=Material.WHITE_STAINED_GLASS_PANE;
            if(i%9==8){
                content[i]=Material.BLACK_STAINED_GLASS_PANE;
            }
            if(i%9==0){
                content[i] = Material.GREEN_STAINED_GLASS_PANE;
            }
            if(i==0||i==8)content[i]= Material.PLAYER_HEAD;
        }
        return content;
    }
}
