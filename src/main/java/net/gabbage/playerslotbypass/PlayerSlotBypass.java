package net.gabbage.playerslotbypass;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class PlayerSlotBypass extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);

    }

    @EventHandler
    public void onPlayerLoginEvent(PlayerLoginEvent event) {
        // Checking if the reason we are being kicked is a full server
        if (event.getResult() == PlayerLoginEvent.Result.KICK_FULL) {
            // Checking if the player has the specified permission node
            if (event.getPlayer().hasPermission("playerslot.bypass")) {
                // If the condition above is true, we execute the following code, that allows the player on the server
                event.allow();
                getLogger().info(event.getPlayer().getDisplayName() + " bypassed player slot limit");
            }
        }

    }
}
