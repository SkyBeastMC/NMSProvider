/**
 *
 */
package fr.skybeastmc.nmsprovider.core.bukkit;

import fr.skybeastmc.nmsprovider.core.CoreProvider;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class Main extends JavaPlugin {

    public void onLoad() {
        try {
            CoreProvider.load(getLogger(), new BukkitServerVersionFinder());
        } catch (Exception e) {
            getLogger().log(Level.SEVERE, "Error while loading plugin", e);
            getLogger().log(Level.SEVERE, "Disabling plugin NOW");
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }

    public void onEnable() {
        try {
            CoreProvider.enable();
        } catch (Exception e) {
            getLogger().log(Level.SEVERE, "Error while enabling plugin", e);
            getLogger().log(Level.SEVERE, "Disabling plugin NOW");
            Bukkit.getPluginManager().disablePlugin(this);
        }
    }
}
