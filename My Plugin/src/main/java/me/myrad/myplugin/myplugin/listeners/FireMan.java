package me.myrad.myplugin.myplugin.listeners;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class FireMan implements Listener {
    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.LEFT_CLICK_AIR)) {
            Player p = e.getPlayer();
            Location loc = p.getEyeLocation();
            Vector direction = loc.getDirection().normalize();
            double x, y, z;
            x = loc.getX() + direction.getX();
            y = loc.getY() + direction.getY();
            z = loc.getZ() + direction.getZ();
            World w = e.getPlayer().getWorld();
            Location locnew = new Location(w, x, y, z);
            Entity entity = w.spawnEntity(locnew, EntityType.FIREBALL);
            direction.multiply(2);
            entity.setVelocity(direction);
        }
    }
}
