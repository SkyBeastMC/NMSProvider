/**
 *
 */
package fr.skybeastmc.nmsprovider;

/**
 * @author Charles
 */
public enum ServerVersion {
    v1_10_R1("1.10");

    private final String vanillaName;

    ServerVersion(String vanillaName) {
        this.vanillaName = vanillaName;
    }

    public String getVanillaName() {
        return vanillaName;
    }
}
