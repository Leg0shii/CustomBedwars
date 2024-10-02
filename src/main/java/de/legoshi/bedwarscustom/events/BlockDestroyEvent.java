package de.legoshi.bedwarscustom.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockDestroyEvent implements Listener {

    @EventHandler
    public void onDestroy(BlockBreakEvent event) {

        if(event.getBlock().getType().equals(Material.RED_BED)) {
            for(Player all : Bukkit.getOnlinePlayers()) {
                all.playSound(all.getLocation(), Sound.ENTITY_ENDER_DRAGON_DEATH, 1, 1);
            }
            Bukkit.broadcastMessage("§6§l[§7LE§6§l]§r§7 §c§lDas rote Bett wurde zerstört!");
        }

        if(event.getBlock().getType().equals(Material.BLUE_BED)) {
            for(Player all : Bukkit.getOnlinePlayers()) {
                all.playSound(all.getLocation(), Sound.ENTITY_ENDER_DRAGON_DEATH, 1, 1);
            }
            Bukkit.broadcastMessage("§6§l[§7LE§6§l]§r§7 §c§lDas blaue Bett wurde zerstört!");
        }

    }

}
