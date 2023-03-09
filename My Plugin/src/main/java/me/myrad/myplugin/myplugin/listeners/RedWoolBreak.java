package me.myrad.myplugin.myplugin.listeners;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class RedWoolBreak implements Listener {
    @EventHandler
    public void onRedWoolBreak(BlockBreakEvent e) {
        Block b = e.getBlock();
        if (b.getBlockData().getMaterial().equals(Material.RED_WOOL)) {
            e.setCancelled(true);
        }
    }
}
