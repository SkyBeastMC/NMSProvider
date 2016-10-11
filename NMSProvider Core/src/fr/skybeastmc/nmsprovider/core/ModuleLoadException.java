/**
 * 
 */
package fr.skybeastmc.nmsprovider.core;

/**
 * @author Charles
 *
 */
public class ModuleLoadException extends Exception {

    public ModuleLoadException() {
        super();
    }

    public ModuleLoadException(String message) {
        super(message);
    }

    public ModuleLoadException(String message, Throwable cause) {
        super(message, cause);
    }

    public ModuleLoadException(Throwable cause) {
        super(cause);
    }
}
