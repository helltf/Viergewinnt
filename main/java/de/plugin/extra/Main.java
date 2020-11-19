package de.plugin.extra;
import Playerselector.PlayerSelectorHandler;
import Viergewinnt.ViergewinntHandler;
import challCompass.challCompHandler;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private static Main plugin;


    @Override
    public void onEnable(){
        getLogger().info("enabled");
        plugin = this;
        PluginManager pluginmanager = Bukkit.getPluginManager();
        pluginmanager.registerEvents(new ViergewinntHandler(),this);
        pluginmanager.registerEvents(new challCompHandler(),this);
        pluginmanager.registerEvents(new PlayerSelectorHandler(),this);
    }
    @Override
    public void onDisable(){
        getLogger().info("disabled");
    }

}
