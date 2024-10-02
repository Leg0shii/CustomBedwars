package de.legoshi.bedwarscustom.events;

import de.legoshi.bedwarscustom.Main;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerRespawnEvent implements Listener {

    @EventHandler
    public void onRespawn(org.bukkit.event.player.PlayerRespawnEvent respawnEvent) {

        Player player = respawnEvent.getPlayer();

        if(Main.getInstance().team1.contains(player)) {
            Location loc = Main.getInstance().spawnPoint1.clone();
            while (!isSpawnable(loc.clone())) {
                loc.add(0, 1, 0);
            }
            respawnEvent.setRespawnLocation(loc);
        }

        if(Main.getInstance().team2.contains(player)) {
            Location loc = Main.getInstance().spawnPoint2.clone();
            while (!isSpawnable(loc.clone())) {
                loc.add(0, 1, 0);
            }
            respawnEvent.setRespawnLocation(loc);
        }

    }

    private boolean isSpawnable(Location loc) {
        return (loc.getBlock().getType().isAir() && loc.add(0, 1, 0).getBlock().getType().isAir());
    }
}
