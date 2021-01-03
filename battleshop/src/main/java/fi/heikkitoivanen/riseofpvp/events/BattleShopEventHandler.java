package fi.heikkitoivanen.riseofpvp.events;

import fi.heikkitoivanen.riseofpvp.entities.NpcManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class BattleShopEventHandler implements Listener {

    private NpcManager npcManager;

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (npcManager.getNpcs() != null && !npcManager.getNpcs().isEmpty()) {
            npcManager.addJoinPacket(event.getPlayer());
        }
        System.out.println("was empty?");
    }


    public NpcManager getNpcManager() {
        return npcManager;
    }

    public void setNpcManager(NpcManager npcManager) {
        this.npcManager = npcManager;
    }

}
