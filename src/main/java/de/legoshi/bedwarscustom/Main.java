package de.legoshi.bedwarscustom;

import de.legoshi.bedwarscustom.commands.BWCommand;
import de.legoshi.bedwarscustom.events.*;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Main extends JavaPlugin {

    public static Main instance;

    public ArrayList<Player> team1;
    public ArrayList<Player> team2;

    public Location spawnPoint1;
    public Location spawnPoint2;

    public Location bed1;
    public Location bed2;

    public boolean stopped;
    public int speed;

    public ArrayList<Location> locations;

    @Override
    public void onEnable() {

        instance = this;

        Bukkit.broadcastMessage("Started!");
        Bukkit.getWorld("world").setGameRule(GameRule.KEEP_INVENTORY, true);

        this.team1 = new ArrayList<>();
        this.team2 = new ArrayList<>();

        this.spawnPoint1 = new Location(null, 0,0,0);
        this.spawnPoint2 = new Location(null, 0,0,0);

        this.bed1 = new Location(null, 0,0,0);
        this.bed2 = new Location(null, 0,0,0);

        this.locations = new ArrayList<>();
        this.speed = 5;

        this.stopped = true;

        Bukkit.getScheduler().runTaskTimer(this, () -> {
            if(!stopped) {
                for (Location loc : locations) {

                    ItemStack itemStack;
                    int randItem;
                    boolean dropped = true;

                    while(dropped) {
                        dropped = false;
                        try {
                            randItem = (int) Math.floor(Math.random() * Material.values().length);
                            itemStack = new ItemStack(Material.values()[randItem]);
                            loc.getWorld().dropItemNaturally(loc, itemStack);
                        } catch (Exception e) {
                            dropped = true;
                        }
                    }

                }
            }
        },0, 20L * 10);

        commandRegistration();
        listenerRegistration();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void commandRegistration() {

        getCommand("bw").setExecutor(new BWCommand());
    }

    private void listenerRegistration() {

        PluginManager pm = Bukkit.getPluginManager();
       pm.registerEvents(new PlayerKillEvent(), this);
       pm.registerEvents(new BlockDestroyEvent(), this);
       pm.registerEvents(new PlayerJoinEvent(), this);
       pm.registerEvents(new PlayerLeaveEvent(), this);
       pm.registerEvents(new PlayerRespawnEvent(), this);
    }

    public static Main getInstance() {
        return instance;
    }

}
