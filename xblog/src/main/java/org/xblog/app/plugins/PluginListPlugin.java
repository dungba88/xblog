package org.xblog.app.plugins;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.xblog.framework.exceptions.XblogExceptionUtils;
import org.xblog.framework.plugins.PluginManager;
import org.xblog.framework.plugins.RenderableXblogPlugin;
import org.xblog.framework.plugins.messages.HandlerInterceptorPayload;

public class PluginListPlugin extends RenderableXblogPlugin {
	
	@Autowired
	private PluginManager pluginManager;

	@Override
	public void onPostHandle(HandlerInterceptorPayload payload) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("plugins", pluginManager.getPlugins());

		String content = null;
		try {
			content = render(map, payload.getRequest());
		} catch (Exception ex) {
			content = XblogExceptionUtils.getStackTraceAsString(ex);
		}
		appendContent(payload, "afterContent", content);
	}

}
