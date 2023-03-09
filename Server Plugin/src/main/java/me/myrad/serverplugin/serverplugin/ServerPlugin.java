package me.myrad.serverplugin.serverplugin;

import me.myrad.serverplugin.serverplugin.listeners.FallDamageListener;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

public final class ServerPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Server Plugin has been enabled!");
        getServer().getPluginManager().registerEvents(new FallDamageListener(), this);
    }

}
