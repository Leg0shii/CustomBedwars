package de.legoshi.bedwarscustom.events;

import de.legoshi.bedwarscustom.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerKillEvent implements Listener {

    @EventHandler
    public void onKill(PlayerDeathEvent playerDeathEvent) {

        playerDeathEvent.setDeathMessage("§6§l[§7LE§6§l]§r§7 " + playerDeathEvent.getDeathMessage());
        Player death = playerDeathEvent.getEntity();

        if(Main.getInstance().team1.contains(death)) {

            if(!Main.getInstance().bed1.getBlock().getType().equals(Material.RED_BED)) {
                death.sendMessage("§6§l[§7LE§6§l]§r§7 §4Du bist leider Raus!");
                Bukkit.broadcastMessage("§6§l[§7LE§6§l]§r§7 §c" + death.getDisplayName() + " ist ausgeschieden!");
                Main.getInstance().team1.remove(death);
                if(Main.getInstance().team1.size() == 0) {
                    Bukkit.broadcastMessage("§6§l[§7LE§6§l]§r§7 §a§lTeam BLAU hat gewonnen!");
                    Main.getInstance().team1.clear();
                    Main.getInstance().stopped = true;
                }
                death.setGameMode(GameMode.SPECTATOR);
            }
        }

        if(Main.getInstance().team2.contains(death)) {

            if(!Main.getInstance().bed2.getBlock().getType().equals(Material.BLUE_BED)) {
                death.sendMessage("§6§l[§7LE§6§l]§r§7 §4Du bist leider Raus!");
                Bukkit.broadcastMessage("§6§l[§7LE§6§l]§r§7 §c" + death.getDisplayName() + " ist ausgeschieden!");
                Main.getInstance().team2.remove(death);
                if(Main.getInstance().team2.size() == 0) {
                    Bukkit.broadcastMessage("§6§l[§7LE§6§l]§r§7 §a§lTeam ROT hat gewonnen!");
                    Main.getInstance().team2.clear();
                    Main.getInstance().stopped = true;
                }
                death.setGameMode(GameMode.SPECTATOR);
            }
        }

    }

}
