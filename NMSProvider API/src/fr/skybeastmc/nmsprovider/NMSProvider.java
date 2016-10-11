/**
 * 
 */
package fr.skybeastmc.nmsprovider;

/**
 * @author SkyBeast
 *
 */
public final class NMSProvider {
    private static Provider provider;

    private NMSProvider() {
    }

    public static void register(Provider provider) {
	if (provider == null)
	    NMSProvider.provider = provider;
	else
	    throw new IllegalArgumentException("Cannot cheat NMSProvider");
    }

    public static Provider getProvider() {
	return provider;
    }
}
