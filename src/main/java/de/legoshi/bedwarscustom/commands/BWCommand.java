package de.legoshi.bedwarscustom.commands;

import de.legoshi.bedwarscustom.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class BWCommand implements CommandExecutor {

    // /bw add <num> <name>
    // /bw remove <num> <name>

    // /bw setSpawner
    // /bw removeSpawner

    // /bw setSpawn <num>
    // /bw setBed <num>

    // /bw start
    // /bw stop
    // /bw speed <num>

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        if(args.length > 0) {
            switch (args[0]) {
                case "add":
                    addMember(args, player);
                    return true;
                case "remove":
                    removeMember(args, player);
                    return true;
                case "setSpawner":
                    setSpawner(player);
                    return true;
                case "removeSpawner":
                    removeSpawner(player);
                    return true;
                case "setSpawn":
                    setSpawn(args, player);
                    return true;
                case "setBed":
                    setBed(args, player);
                    return true;
                case "start":
                    if(Main.getInstance().team1.size() >= 1 && Main.getInstance().team2.size() >= 1) {
                        Main.getInstance().stopped = false;
                        Bukkit.broadcastMessage("§6§l[§7LE§6§l]§r§7 §aDas Spiel wurde gestartet!");
                        return true;
                    }
                    if(Main.getInstance().team1.size() == 0) {
                        Bukkit.broadcastMessage("§6§l[§7LE§6§l]§r§7 §cTeam 1 hat noch keine Spieler!");
                        return true;
                    }
                    Bukkit.broadcastMessage("§6§l[§7LE§6§l]§r§7 §cTeam 2 hat noch keine Spieler!");
                    return true;
                case "stop":
                    Main.getInstance().stopped = true;
                    Bukkit.broadcastMessage("§6§l[§7LE§6§l]§r§7 §cDas Spiel wurde unterbrochen!");
                    return true;
                case "speed":
                    int speed;
                    try {
                        speed = Integer.parseInt(args[1]);
                    } catch (NumberFormatException e) {
                        sender.sendMessage("§6§l[§7LE§6§l]§r§7 §cBitte gib eine Zahl ein. (/bw speed <Zahl>)!");
                        return true;
                    }
                    Bukkit.broadcastMessage("§6§l[§7LE§6§l]§r§7 §aItems spawnen nun alle " + speed + "s.");
                    return true;
                case "info":
                    sender.sendMessage("§6§l[§7LE§6§l]§r§7 §b /bw <add/remove> <num> <name>");
                    sender.sendMessage("§6§l[§7LE§6§l]§r§7 §b /bw <set/remove>Spawner");
                    sender.sendMessage("§6§l[§7LE§6§l]§r§7 §b /bw setSpawn <num>");
                    sender.sendMessage("§6§l[§7LE§6§l]§r§7 §b /bw setBed <num>");
                    sender.sendMessage("§6§l[§7LE§6§l]§r§7 §b /bw start/stop <num>");
                    sender.sendMessage("§6§l[§7LE§6§l]§r§7 §b /bw speed");
                    return true;
                default:
            }
        }

        sender.sendMessage("§6§l[§7LE§6§l]§r§7 Wrong command syntax.");
        return false;
    }

    private void setBed(String[] args, Player sender) {

        if(args[1].equals("1")) {
            Main.getInstance().bed1 = sender.getLocation();
            sender.sendMessage("§6§l[§7LE§6§l]§r§7 Successfully set bed of team 1 [red].");
            return;
        }

        if(args[1].equals("2")) {
            Main.getInstance().bed2 = sender.getLocation();
            sender.sendMessage("§6§l[§7LE§6§l]§r§7 Successfully set bed of team 2 [blue].");
        }

    }

    private void setSpawn(String[] args, Player sender) {

        if(args[1].equals("1")) {
            Main.getInstance().spawnPoint1 = sender.getLocation();
            sender.sendMessage("§6§l[§7LE§6§l]§r§7 Successfully set spawn of team 1.");
            return;
        }

        if(args[1].equals("2")) {
            Main.getInstance().spawnPoint2 = sender.getLocation();
            sender.sendMessage("§6§l[§7LE§6§l]§r§7 Successfully set spawn of team 2.");
            return;
        }

    }

    private void removeSpawner(CommandSender sender) {

        Main.getInstance().locations.clear();
        sender.sendMessage("§6§l[§7LE§6§l]§r§7 Successfully removed all spawners.");
    }

    private void setSpawner(CommandSender sender) {

        Main.getInstance().locations.add(((Player) sender).getLocation());
        sender.sendMessage("§6§l[§7LE§6§l]§r§7 Successfully added spawner.");
    }

    private void removeMember(String[] args, CommandSender sender) {

        Player player = Bukkit.getPlayer(args[2]);
        if(player == null) {
            sender.sendMessage("§6§l[§7LE§6§l]§r§7 Not online.");
            return;
        }
        if(args[1].equals("1")) {

            ArrayList<Player> team1 = Main.getInstance().team1;
            if(team1.contains(player)) {
                sender.sendMessage("§6§l[§7LE§6§l]§r§7 Successfully removed player from team 1.");
                team1.remove(player);
                return;
            }
            team1.add(player);
            sender.sendMessage("§6§l[§7LE§6§l]§r§7 Player not in team 1.");
            return;
        }

        if(args[1].equals("2")) {

            ArrayList<Player> team2 = Main.getInstance().team2;
            if(team2.contains(player)) {
                sender.sendMessage("§6§l[§7LE§6§l]§r§7 Successfully removed player from team 2.");
                team2.remove(player);
                return;
            }
            team2.add(player);
            sender.sendMessage("§6§l[§7LE§6§l]§r§7 Player not in team 2.");
        }

    }

    private void addMember(String[] args, CommandSender sender) {

        Player player = Bukkit.getPlayer(args[2]);
        if(player == null) {
            sender.sendMessage("§6§l[§7LE§6§l]§r§7 not online.");
            return;
        }
        if(args[1].equals("1")) {

            ArrayList<Player> team1 = Main.getInstance().team1;
            if(team1.contains(player)) {
                sender.sendMessage("§6§l[§7LE§6§l]§r§7 already in team 1.");
                return;
            }
            team1.add(player);
            sender.sendMessage("§6§l[§7LE§6§l]§r§7 Successfully added player to team 1.");
            return;
        }

        if(args[1].equals("2")) {

            ArrayList<Player> team2 = Main.getInstance().team2;
            if(team2.contains(player)) {
                sender.sendMessage("§6§l[§7LE§6§l]§r§7 already in team 2.");
                return;
            }
            team2.add(player);
            sender.sendMessage("§6§l[§7LE§6§l]§r§7 Successfully added player to team 2.");
        }

    }
}
