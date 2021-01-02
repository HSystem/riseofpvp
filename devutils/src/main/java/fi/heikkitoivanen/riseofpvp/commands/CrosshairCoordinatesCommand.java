package fi.heikkitoivanen.riseofpvp.commands;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Set;

public class CrosshairCoordinatesCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            Block block = player.getTargetBlock((Set<Material>) null, 3);
            player.sendMessage(block.getLocation().toString());
        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }
}
