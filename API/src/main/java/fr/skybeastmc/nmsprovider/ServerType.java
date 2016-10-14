/**
 *
 */
package fr.skybeastmc.nmsprovider;

/**
 * @author Charles
 */
public enum ServerType {
    SPIGOT("Spigot"),
    CRAFTBUKKIT("CraftBukkit");

    private final String name;

    ServerType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
