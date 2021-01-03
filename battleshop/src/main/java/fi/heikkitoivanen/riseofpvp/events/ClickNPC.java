package fi.heikkitoivanen.riseofpvp.events;

import fi.heikkitoivanen.riseofpvp.entities.NpcManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ClickNPC implements Listener {

    @EventHandler
    public void onClick(RightClickNPC event) {
        Player player = event.getPlayer();
        //player.sendMessage("you clicked "+event.getNPC().displayName);
        player.sendMessage(NpcManager.getGreetingDialogByNPCName(event.getNPC().displayName));
    }

}
