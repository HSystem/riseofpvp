package fi.heikkitoivanen.riseofpvp.events;

import fi.heikkitoivanen.riseofpvp.entities.NpcManager;
import fi.heikkitoivanen.riseofpvp.packets.PacketReader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class BattleShopEventHandler implements Listener {

    private NpcManager npcManager;

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (npcManager.getNpcs() != null && !npcManager.getNpcs().isEmpty()) {
            npcManager.addJoinPacket(event.getPlayer());
            PacketReader packetReader = new PacketReader();
            packetReader.inject(event.getPlayer());
        }
        System.out.println("was empty?");
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        PacketReader packetReader = new PacketReader();
        packetReader.uninject(event.getPlayer());
    }


    public NpcManager getNpcManager() {
        return npcManager;
    }

    public void setNpcManager(NpcManager npcManager) {
        this.npcManager = npcManager;
    }

}
