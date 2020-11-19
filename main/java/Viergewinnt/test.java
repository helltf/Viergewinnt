package Viergewinnt;

import challCompass.challComp;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


import java.util.ArrayList;
import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        ItemStack[] content = createContent();

        for (int x = 0;x<54;x++)
        if (content[x].equals(content[x + 1])&&content[x].equals(content[x + 2])&&content[x].equals(content[x + 3])&&!content[x].equals(new ItemStack(Material.WHITE_STAINED_GLASS_PANE))) {
        }
    }
    public static ItemStack[] createContent(){
        ItemStack[] content = new ItemStack[54];
        for(int i=0;i<54;i++){
            content[i]=new ItemStack(Material.WHITE_STAINED_GLASS_PANE);

        }
        return content;
    }
}
