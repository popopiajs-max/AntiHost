import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.server.ServerCommandEvent;

public class AntiHost extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("AntiHost AdBlocker loaded!");
    }

    @EventHandler
    public void onCommand(ServerCommandEvent event) {
        String cmd = event.getCommand();
        // Блокируем команду, если в ней есть ссылка хостинга
        if (cmd.contains("MCServerHost.com") || cmd.contains("tellraw")) {
            if (cmd.contains("Hosted by") || cmd.contains("Free Minecraft")) {
                event.setCancelled(true);
            }
        }
    }
}
