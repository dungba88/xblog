package org.xblog.app.plugins;

import org.xblog.framework.plugins.RenderableXblogPlugin;
import org.xblog.framework.plugins.messages.HandlerInterceptorPayload;

public class GoogleAnalyticsPlugin extends RenderableXblogPlugin {

	@Override
	public void onPostHandle(HandlerInterceptorPayload payload) {
		try {
			String content = render(payload.getRequest());
			appendContent(payload, "beforeFooter", content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
