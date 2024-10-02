package de.legoshi.bedwarscustom.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerJoinEvent implements Listener {

    @EventHandler
    public void onLeave(org.bukkit.event.player.PlayerJoinEvent event) {

        event.setJoinMessage("§6§l[§7LE§6§l]§r§7 §a" + event.getPlayer().getDisplayName() + " hat den Server betreten!");

    }

}
