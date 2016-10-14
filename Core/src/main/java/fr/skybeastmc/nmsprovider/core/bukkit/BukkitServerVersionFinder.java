/**
 *
 */
package fr.skybeastmc.nmsprovider.core.bukkit;

import fr.skybeastmc.nmsprovider.ServerType;
import fr.skybeastmc.nmsprovider.ServerVersion;
import fr.skybeastmc.nmsprovider.core.ServerVersionFinder;
import org.bukkit.Bukkit;

/**
 * @author Charles
 */
public class BukkitServerVersionFinder implements ServerVersionFinder {
    private ServerType type;
    private ServerVersion version;
    private String nmsPackage;

    @Override
    public void find() {
        String v = Bukkit.getVersion();

        type = ServerType.CRAFTBUKKIT; //Defaults to CRAFTBUKKIT

        if (v.contains("Spigot")) {
            type = ServerType.SPIGOT;
        }


    }

    @Override
    public ServerType getType() {
        return type;
    }

    @Override
    public ServerVersion getVersion() {
        return version;
    }

    @Override
    public String getNMSPackage() {
        return nmsPackage;
    }

}
