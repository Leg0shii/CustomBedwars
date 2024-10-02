# BedWarsCustom

**BedWarsCustom** is a Bukkit/Spigot Minecraft plugin that allows server administrators to create and manage custom BedWars game modes with configurable teams, spawn points, beds, spawners, and gameplay settings.

## Features

- **Team Management:** Add and remove players from Team 1 or Team 2.
- **Custom Spawn Points & Beds:** Set unique spawn locations and bed positions for each team.
- **Spawner Configuration:** Add or remove item spawners to control item drops.
- **Game Control:** Start and stop games, and adjust item drop speed dynamically.
- **Automated Item Drops:** Randomly drops items at configured spawner locations during the game.
- **Event Handling:** Manages player kills, block destruction, joins, leaves, and respawns.

## Installation

1. **Prerequisites:**
   - A Bukkit/Spigot compatible Minecraft server.
   - Java 8 or higher.

2. **Download:**
   - Obtain the latest `BedWarsCustom.jar` from the repo.

3. **Setup:**
   - Place the `BedWarsCustom.jar` file into your server's `plugins` directory.
   - Start the server to generate necessary configuration files and folders.

## Configuration

Customize the plugin by editing configuration files generated in the `plugins/BedWarsCustom/` directory. Adjust team settings, spawn points, bed locations, spawner positions, and game settings as needed.

## Commands

- **Team Management:**
  ```
  /bw add <team_number> <player_name>
  /bw remove <team_number> <player_name>
  ```
- **Spawner Management:**
  ```
  /bw setSpawner
  /bw removeSpawner
  ```
- **Setting Spawn Points & Beds:**
  ```
  /bw setSpawn <team_number>
  /bw setBed <team_number>
  ```
- **Game Control:**
  ```
  /bw start
  /bw stop
  /bw speed <seconds>
  /bw info
  ```

## Usage

Once installed and configured, use the `/bw` command to manage teams, spawners, spawn points, beds, and control the game flow. Ensure both teams have at least one player before starting the game.

## Permissions

Integrate with your server’s permission system to manage access to commands and administrative controls as needed. Permissions can be extended to control team assignments and game management features.
