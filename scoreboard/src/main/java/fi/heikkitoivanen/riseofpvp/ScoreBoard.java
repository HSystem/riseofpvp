package fi.heikkitoivanen.riseofpvp;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.*;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;

public class ScoreBoard extends JavaPlugin implements Listener {

    private static String scoreboardId = "HubScoreboard-1";

    List<String> scoreboardEntries = new LinkedList<String>();

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

    @EventHandler
    public void onKill(EntityDeathEvent e) {
        Player player = e.getEntity().getKiller();
        player.sendMessage(ChatColor.RED+" You killed "+e.getEntity().getType());
        refreshScoreboardEntries(player, player.getScoreboard());
    }

    public void createBoard(Player player) {
        String scoreboardType = "dummy"; // do not need any templated behaviour
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective obj = board.registerNewObjective(scoreboardId, scoreboardType, ChatColor.AQUA+"-- Rise of PVP --");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        player.setScoreboard(board);
        refreshScoreboardEntries(player,board);
    }

    private void refreshScoreboardEntries(Player player, Scoreboard board) {
        //board.getEntries().clear();

        DecimalFormat df = new DecimalFormat("#.#");

        for (String entry : board.getEntries()) {
            board.resetScores(entry);
        }
        //board.resetScores(scoreboardId);
        Location loc = player.getLocation();
        int totalKills = player.getStatistic(Statistic.MOB_KILLS)+player.getStatistic(Statistic.PLAYER_KILLS);
        setScoreboardRow(board,scoreboardId, 6, ChatColor.BLUE + "=-=- scores =-=-=");
        setScoreboardRow(board,scoreboardId, 5, ChatColor.BLUE + "Mob Kills: "+ChatColor.RED+player.getStatistic(Statistic.MOB_KILLS));
        setScoreboardRow(board,scoreboardId, 4, ChatColor.BLUE + "Player Kills: "+ChatColor.RED+player.getStatistic(Statistic.PLAYER_KILLS));
        setScoreboardRow(board,scoreboardId, 3, ChatColor.BLUE + "Total Kills: "+ChatColor.RED+totalKills);
        setScoreboardRow(board,scoreboardId, 2, ChatColor.BLUE + "---");

    }

    private void setScoreboardRow(Scoreboard board, String objective, int row, String rowmessage) {
        Score score = board.getObjective(scoreboardId).getScore(rowmessage);
        score.setScore(row);
    }



}
