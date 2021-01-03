package fi.heikkitoivanen.riseofpvp.events;

import fi.heikkitoivanen.riseofpvp.entities.NpcManager;
import net.minecraft.server.v1_16_R3.EntityPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class RightClickNPC extends Event implements Cancellable {

    private final Player player;
    private final EntityPlayer npc;
    //private final NpcManager npcManager;
    private boolean isCancelled;
    private static final HandlerList handlerList = new HandlerList();

    public RightClickNPC(Player player, EntityPlayer npc) {
        this.player = player;
        this.npc = npc;
    }

    public Player getPlayer() {
        return player ;
    }

    public EntityPlayer getNPC() {
        return npc;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.isCancelled = b; 
    }
}
