package fi.codecrystal.riseofpvp;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.*;

import java.util.logging.Level;

public class ScoreBoard extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        getLogger().log(Level.INFO,"Plugin Enabled");

        if (!Bukkit.getOnlinePlayers().isEmpty())
            for (Player onlineplayer : Bukkit.getOnlinePlayers())
                createBoard(onlineplayer);
    }

    @Override
    public void onDisable() {
        getLogger().log(Level.INFO,"Plugin Disabled");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        createBoard(event.getPlayer());
    }

    public void createBoard(Player player) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective obj = board.registerNewObjective("HubScoreboard-1", "dummy", ChatColor.AQUA+"-- scores --");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        setScoreboardRow(board,"Hubscoreboard-1", 3, ChatColor.BLUE + "=-=-=-=-=");
        setScoreboardRow(board,"Hubscoreboard-1", 2, ChatColor.BLUE + "Kills: "+ChatColor.DARK_BLUE+player.getStatistic(Statistic.MOB_KILLS));
        setScoreboardRow(board,"Hubscoreboard-1", 1, ChatColor.BLUE + "Something");
        player.setScoreboard(board);
    }

    private void setScoreboardRow(Scoreboard board, String objective, int row, String rowmessage) {
        Score score = board.getObjective(objective).getScore(rowmessage);
        score.setScore(row);
    }



}
