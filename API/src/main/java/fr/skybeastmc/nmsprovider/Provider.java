/**
 *
 */
package fr.skybeastmc.nmsprovider;

/**
 * @author Charles
 */
public interface Provider {

    ServerType getServerType();

    ServerVersion getServerVersion();

    String fullServerVersion();
}
