package fi.heikkitoivanen.riseofpvp;

import net.minecraft.server.v1_16_R3.*;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
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

        // ******************
        // play sound on spawn
        // ******************
        /*
        Location l = event.getPlayer().getLocation(); // spawned player location
        String string = "entity.player.levelup";
        MinecraftKey key = new MinecraftKey(string);
        SoundEffect effect = new SoundEffect(key);
        float volume = 1f; //1 = 100%
        float pitch = 0.5f; //Float between 0.5 and 2.0
        Packet packet  = new PacketPlayOutNamedSoundEffect(effect, SoundCategory.PLAYERS, l.getX(), l.getY(), l.getZ(),  volume, pitch);

        for (Player player : getServer().getOnlinePlayers()) {
            ((CraftPlayer)player).getHandle().playerConnection.sendPacket(packet);
        }
        */

        // ******************
        // TODO: Nice particle effects!
        // ******************
        /*
        Implement the nice particles here
         */



        // ******************
        // Broadcast message telling of new player
        // ******************
        for (Player player : this.getServer().getOnlinePlayers()) {
            player.sendMessage(ChatColor.YELLOW+" "+player.getDisplayName()+" is a new rival in Rise of PVP!");
        }

    }



}
