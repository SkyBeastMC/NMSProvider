/**
 * 
 */
package fr.skybeastmc.nmsprovider.core;

import java.util.List;
import java.util.jar.JarFile;

/**
 * @author Charles
 *
 */
public class ModuleDescription {
    private final String author;
    private final String version;
    private final String moduleClass;
    private final List<String> serverVersions;
    private final List<String> serverTypes;
    private final JarFile file;

    public ModuleDescription(String author, String version, String moduleClass, List<String> serverVersions,
	    List<String> serverTypes, JarFile file) {
	this.author = author;
	this.version = version;
	this.moduleClass = moduleClass;
	this.serverVersions = serverVersions;
	this.serverTypes = serverTypes;
	this.file = file;
    }

    public boolean isCompatible() {
	return serverTypes.contains(CoreProvider.INSTANCE.getServerType().toString())
		&& serverVersions.contains(CoreProvider.INSTANCE.getServerVersion().toString());
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((author == null) ? 0 : author.hashCode());
	result = prime * result + ((file == null) ? 0 : file.hashCode());
	result = prime * result + ((moduleClass == null) ? 0 : moduleClass.hashCode());
	result = prime * result + ((serverTypes == null) ? 0 : serverTypes.hashCode());
	result = prime * result + ((serverVersions == null) ? 0 : serverVersions.hashCode());
	result = prime * result + ((version == null) ? 0 : version.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	ModuleDescription other = (ModuleDescription) obj;
	if (author == null) {
	    if (other.author != null)
		return false;
	} else if (!author.equals(other.author))
	    return false;
	if (file == null) {
	    if (other.file != null)
		return false;
	} else if (!file.equals(other.file))
	    return false;
	if (moduleClass == null) {
	    if (other.moduleClass != null)
		return false;
	} else if (!moduleClass.equals(other.moduleClass))
	    return false;
	if (serverTypes == null) {
	    if (other.serverTypes != null)
		return false;
	} else if (!serverTypes.equals(other.serverTypes))
	    return false;
	if (serverVersions == null) {
	    if (other.serverVersions != null)
		return false;
	} else if (!serverVersions.equals(other.serverVersions))
	    return false;
	if (version == null) {
	    if (other.version != null)
		return false;
	} else if (!version.equals(other.version))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "ModuleDescription [author=" + author + ", version=" + version + ", moduleClass=" + moduleClass
		+ ", serverVersions=" + serverVersions + ", serverTypes=" + serverTypes + ", file=" + file + "]";
    }

    public String getAuthor() {
	return author;
    }

    public String getVersion() {
	return version;
    }

    public String getModuleClass() {
	return moduleClass;
    }

    public List<String> getServerVersions() {
	return serverVersions;
    }

    public List<String> getServerTypes() {
	return serverTypes;
    }

    public JarFile getFile() {
	return file;
    }
}
