package edu.unca.twreese.SpoutItemTutorial;

import java.text.MessageFormat;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;

/*
 * This is a sample event listener
 */
public class SpoutItemTutorialListener implements Listener {
    private final SpoutItemTutorial plugin;

    /*
     * This listener needs to know about the plugin which it came from
     */
    public SpoutItemTutorialListener(SpoutItemTutorial plugin) {
        // Register the listener
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        
        this.plugin = plugin;
    }

    /*
     * Send the sample message to all players that join
     */
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage(this.plugin.getConfig().getString("sample.message"));
        SpoutPlayer player = SpoutManager.getPlayer(event.getPlayer());
        player.setSkin("http://www.minecraftskins.com/newuploaded_skins/skin_20121115095227188033.png");
        
    }
    
    /*
     * Another example of a event handler. This one will give you the name of
     * the entity you interact with, if it is a Creature it will give you the
     * creature Id.
     */
    @EventHandler
    public void onPlayerInteract(PlayerInteractEntityEvent event) {
        final EntityType entityType = event.getRightClicked().getType();

        event.getPlayer().sendMessage(MessageFormat.format(
                "You interacted with a {0} it has an id of {1}",
                entityType.getName(),
                entityType.getTypeId()));
    }
}
