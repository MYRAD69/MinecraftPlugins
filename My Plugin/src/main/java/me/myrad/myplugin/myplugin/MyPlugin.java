package me.myrad.myplugin.myplugin;

import me.myrad.myplugin.myplugin.commands.DieCommand;
import me.myrad.myplugin.myplugin.listeners.FireMan;
import me.myrad.myplugin.myplugin.listeners.PlayerJoin;
import me.myrad.myplugin.myplugin.listeners.RedWoolBreak;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class MyPlugin extends JavaPlugin {
    RedWoolBreak r = new RedWoolBreak();
    FireMan f = new FireMan();
    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("My Plugin has started!");
        getCommand("die").setExecutor(new DieCommand());
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("checkf")) {
            sender.sendMessage(ChatColor.GREEN + "it works!");
            getServer().getPluginManager().registerEvents(r, this);
            sender.getServer().broadcastMessage(ChatColor.DARK_RED + "NO RED WOOL ANYMORE!");
        }
        if (command.getName().equalsIgnoreCase("checks")) {
            sender.sendMessage(ChatColor.GREEN + "it works!");
            HandlerList.unregisterAll(r);
            sender.getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + "YES RED WOOL!");
        }
        if (command.getName().equalsIgnoreCase("fireon")) {
            sender.sendMessage("You are now da fireman");
            getServer().getPluginManager().registerEvents(f, this);
        }
        if (command.getName().equalsIgnoreCase("fireoff")) {
            sender.sendMessage("No longer da fireman");
            HandlerList.unregisterAll(f);
        }
        return true;
    }
}
