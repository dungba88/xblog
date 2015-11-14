package org.xblog.app.plugins;

import java.util.Date;

import org.xblog.app.models.user.User;
import org.xblog.framework.plugins.RenderableXblogPlugin;
import org.xblog.framework.plugins.messages.HandlerInterceptorPayload;

public class ExamplePlugin extends RenderableXblogPlugin {
	
	private long startTime;
	
	@Override
	public void onPreHandle(HandlerInterceptorPayload payload) {
		startTime = new Date().getTime();
	}

	@Override
	public void onPostHandle(HandlerInterceptorPayload payload) {
		if (payload.getModelAndView() == null
				|| payload.getModelAndView().getModel() == null)
			return;
		User user = (User) payload.getModelAndView().getModel().get("user");
		if (user != null)
			user.setDisplayName(user.getDisplayName() + " Modified");
		
		long now = new Date().getTime();
		appendContent(payload, "afterContent", "Executed time: " + (now - startTime) + "milliseconds");
	}
}
