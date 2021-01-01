package fi.heikkitoivanen.riseofpvp;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class Welcome extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        getLogger().log(Level.INFO,"Plugin Enabled");
    }

    @Override
    public void onDisable() {
        getLogger().log(Level.INFO,"Plugin Disabled");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage(ChatColor.LIGHT_PURPLE+"Welcome to the Rise of PVP!!");
        event.getPlayer().sendMessage(ChatColor.LIGHT_PURPLE+"CAN YOU LEARN PVP AND BECOME ONE OF THE BEST PLAYERS IN THIS SERVER");
    }



}
