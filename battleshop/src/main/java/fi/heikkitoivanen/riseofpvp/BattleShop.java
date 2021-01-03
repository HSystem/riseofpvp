package fi.heikkitoivanen.riseofpvp;

import fi.heikkitoivanen.riseofpvp.entities.NpcManager;
import fi.heikkitoivanen.riseofpvp.events.BattleShopEventHandler;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class BattleShop extends JavaPlugin implements Listener {

    public NpcManager npcManager;

    @Override
    public void onEnable() {
        this.npcManager = new NpcManager();
        BattleShopEventHandler battleShopEventHandler = new BattleShopEventHandler();
        battleShopEventHandler.setNpcManager(this.npcManager);
        this.getServer().getPluginManager().registerEvents(battleShopEventHandler,this);
        getLogger().log(Level.INFO,"Plugin Enabled");
    }



    @Override
    public void onDisable() {
        getLogger().log(Level.INFO,"Plugin Disabled");
    }

}
