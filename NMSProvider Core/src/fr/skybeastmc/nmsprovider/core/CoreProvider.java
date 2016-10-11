/**
 * 
 */
package fr.skybeastmc.nmsprovider.core;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.configuration.file.YamlConfiguration;

import fr.skybeastmc.nmsprovider.NMSProvider;
import fr.skybeastmc.nmsprovider.Provider;
import fr.skybeastmc.nmsprovider.ServerType;
import fr.skybeastmc.nmsprovider.ServerVersion;

public final class CoreProvider implements Provider {
    public static final CoreProvider INSTANCE = new CoreProvider();
    private static ServerType serverType;
    private static ServerVersion serverVersion;
    public static final File MODULE_FOLDER = new File("plugins/NMSProvider/module");
    private static Logger log;
    private static String fullServerVersion;

    private CoreProvider() {
    }

    public static void load(Logger log, ServerVersionFinder serverVersionFinder) throws ModuleLoadException {
	CoreProvider.log = log;

	serverVersionFinder.find();
	serverType = serverVersionFinder.getType();
	serverVersion = serverVersionFinder.getVersion();

	findModule();
    }

    public static void enable() {

	NMSProvider.register(INSTANCE);

    }

    private static ModuleDescription findModule() throws ModuleLoadException {
	if (!MODULE_FOLDER.exists() || !MODULE_FOLDER.isDirectory()) {
	    MODULE_FOLDER.mkdirs();
	    throw new ModuleLoadException(
		    "No module found. Go to " + MODULE_FOLDER.getAbsolutePath() + " and add a module.");
	}

	for (File file : MODULE_FOLDER.listFiles()) {
	    if (file.getName().endsWith(".jar")) {
		try {
		    ModuleDescription module = getModuleDescription(file);
		    if (module != null)
			return module;
		    log.severe("Found an non-module in module folder. Please go to " + MODULE_FOLDER.getAbsolutePath()
			    + " and delete \"" + file.getName() + "\". The plugin is still working.");
		} catch (ModuleLoadException ex) {
		    log.log(Level.SEVERE,
			    "Found an non-module or incompatible module in module folder. Please go to "
				    + MODULE_FOLDER.getAbsolutePath() + " and delete \"" + file.getName()
				    + "\". The plugin is still working.",
			    ex);
		}
	    }
	}
	throw new ModuleLoadException(
		"No VALID module found. Go to " + MODULE_FOLDER.getAbsolutePath() + " and add a VALID module.");
    }

    private static ModuleDescription getModuleDescription(File file) throws ModuleLoadException {
	try (JarFile jar = new JarFile(file)) {
	    JarEntry entry = jar.getJarEntry("module.yml");

	    if (entry == null)
		throw new InvalidModuleException("Jar does not contain module.yml file");

	    YamlConfiguration config = YamlConfiguration
		    .loadConfiguration(new InputStreamReader(jar.getInputStream(entry)));

	    String author = config.getString("author");
	    String version = config.getString("version");
	    String moduleClass = config.getString("class");
	    List<String> serverVersions = config.getStringList("server_versions");
	    List<String> serverTypes = config.getStringList("server_types");

	    if (serverVersions != null && !serverVersions.isEmpty() && serverTypes != null && !serverTypes.isEmpty()
		    && moduleClass != null) {
		return new ModuleDescription(author, version, moduleClass, serverVersions, serverTypes, jar);
	    } else {
		throw new InvalidModuleException("Error while loading module.yml");
	    }

	} catch (IOException e) {
	    throw new ModuleLoadException("Error while loading the module description", e);
	}
    }

    @Override
    public String fullServerVersion() {
	if (fullServerVersion == null)
	    fullServerVersion = getServerType() + "_" + getServerVersion();
	return fullServerVersion;
    }

    @Override
    public ServerType getServerType() {
	return serverType;
    }

    @Override
    public ServerVersion getServerVersion() {
	return serverVersion;
    }
}
