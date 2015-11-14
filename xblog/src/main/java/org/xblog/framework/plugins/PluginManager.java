package org.xblog.framework.plugins;

import java.util.List;

public interface PluginManager {
	
	public void setPlugins(List<Plugin> plugins);
	
	public List<Plugin> getPlugins();
	
	public void registerPlugin(Plugin plugin);
	
	public void degisterPlugin(Plugin plugin);
	
	public void activatePlugin(Plugin plugin);
	
	public void deactivatePlugin(Plugin plugin);
}
