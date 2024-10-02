package de.legoshi.bedwarscustom.events;

import de.legoshi.bedwarscustom.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeaveEvent implements Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {

        Main.getInstance().team1.remove(event.getPlayer());
        Main.getInstance().team2.remove(event.getPlayer());
        event.setQuitMessage("§6§l[§7LE§6§l]§r§7 §a" + event.getPlayer().getDisplayName() + " hat den Server verlassen!");

        if(Main.getInstance().team1.isEmpty() && !Main.getInstance().stopped) Bukkit.broadcastMessage("§6§l[§7LE§6§l]§r§7 §a§lTeam BLAU hat gewonnen!");
        if(Main.getInstance().team2.isEmpty() && !Main.getInstance().stopped) Bukkit.broadcastMessage("§6§l[§7LE§6§l]§r§7 §a§lTeam BLAU hat gewonnen!");

    }

}
