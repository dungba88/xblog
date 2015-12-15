package org.xblog.impl.plugins;

import java.util.ArrayList;
import java.util.List;

import org.xblog.framework.interceptors.Observer;
import org.xblog.framework.plugins.Plugin;
import org.xblog.framework.plugins.PluginManager;
import org.xblog.framework.plugins.messages.XblogMessage;

public class XblogPluginManager implements PluginManager, Observer {

	private List<Plugin> plugins;

	@Override
	public void onMessage(XblogMessage message) {
		if (plugins == null)
			return;
		for (Plugin plugin : plugins) {
			if (plugin.isActive())
				plugin.onMessage(message);
		}
	}

	@Override
	public void activatePlugin(Plugin plugin) {
		plugin.setActive(true);
	}

	@Override
	public void deactivatePlugin(Plugin plugin) {
		plugin.setActive(false);
	}

	@Override
	public void registerPlugin(Plugin plugin) {
		if (plugins == null)
			plugins = new ArrayList<Plugin>();
		Plugin existPlugin = findPluginById(plugin.getId());
		if (existPlugin == null) {
			plugins.add(plugin);
			plugin.setActive(true);
		}
	}

	@Override
	public void degisterPlugin(Plugin plugin) {
		if (plugins == null)
			return;
		Plugin existPlugin = findPluginById(plugin.getId());
		if (existPlugin != null)
			plugins.remove(existPlugin);
	}

	@Override
	public List<Plugin> getPlugins() {
		return plugins;
	}

	@Override
	public void setPlugins(List<Plugin> plugins) {
		this.plugins = new ArrayList<Plugin>();
		if (plugins != null) {
			for (Plugin plugin : plugins) {
				this.plugins.add(plugin);
				plugin.setActive(true);
			}
		}
	}
	
	private Plugin findPluginById(String id) {
		if (plugins == null)
			return null;
		for (Plugin plugin : plugins) {
			if (plugin.getId().equals(id)) {
				return plugin;
			}
		}
		return null;
	}
}
