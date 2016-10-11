/**
 * 
 */
package fr.skybeastmc.nmsprovider.core;

/**
 * @author Charles
 *
 */
public class InvalidModuleException extends ModuleLoadException {

    public InvalidModuleException() {
        super();
    }

    public InvalidModuleException(String message) {
        super(message);
    }

    public InvalidModuleException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidModuleException(Throwable cause) {
        super(cause);
    }
}
