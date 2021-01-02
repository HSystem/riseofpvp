package fi.heikkitoivanen.riseofpvp;

import fi.heikkitoivanen.riseofpvp.commands.CrosshairCoordinatesCommand;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class DevUtils extends JavaPlugin {

    @Override
    public void onEnable() {
        //this.getServer().getPluginManager().registerEvents(this, this);
        getLogger().log(Level.INFO,"Plugin Enabled");

        this.getCommand("crossc").setExecutor(new CrosshairCoordinatesCommand());
    }

    @Override
    public void onDisable() {
        getLogger().log(Level.INFO,"Plugin Disabled");
    }

}
