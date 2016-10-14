/**
 *
 */
package fr.skybeastmc.nmsprovider.core;

import fr.skybeastmc.nmsprovider.ServerType;
import fr.skybeastmc.nmsprovider.ServerVersion;

/**
 * @author Charles
 */
public interface ServerVersionFinder {

    void find();

    ServerType getType();

    ServerVersion getVersion();

    String getNMSPackage();
}
