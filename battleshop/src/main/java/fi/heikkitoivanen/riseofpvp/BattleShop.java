package fi.heikkitoivanen.riseofpvp;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class BattleShop extends JavaPlugin {

    // battleshop npc 1, x=265,y=94,z=-46
    // battleshop npc 2, x=267,y=94,z=-46
    @Override
    public void onEnable() {
        getLogger().log(Level.INFO,"Plugin Enabled");
    }

    @Override
    public void onDisable() {
        getLogger().log(Level.INFO,"Plugin Disabled");
    }

}
