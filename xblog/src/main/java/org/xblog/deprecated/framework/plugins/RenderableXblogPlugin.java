package org.xblog.deprecated.framework.plugins;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ViewResolver;
import org.xblog.deprecated.framework.views.Renderer;
import org.xblog.framework.constants.MessageConstants;
import org.xblog.framework.plugins.AbstractXblogPlugin;
import org.xblog.framework.plugins.messages.HandlerInterceptorPayload;
import org.xblog.framework.plugins.messages.XblogMessage;

@Deprecated
public abstract class RenderableXblogPlugin extends AbstractXblogPlugin {
	
	private ViewResolver viewResolver;
	
	@Autowired
	private Renderer renderer;

	@Override
	public void onMessage(XblogMessage message) {
		if (message.getEvent().equals(MessageConstants.PRE_HANDLE)) {
			onPreHandle((HandlerInterceptorPayload) message.getPayload());
		} else if (message.getEvent().equals(MessageConstants.POST_HANDLE)) {
			onPostHandle((HandlerInterceptorPayload) message.getPayload());
		}
	}
	
	protected String render(HttpServletRequest request) throws Exception {
		Map<String, Object> model = getModel();
		return render(model, request);
	}
	
	protected String render(Map<String, Object> model, HttpServletRequest request) throws Exception {
		String prefix = getConfigAsString("view.prefix", "");
		String suffix = getConfigAsString("view.suffix", "");
		String path = prefix + getId() + suffix;
		return render(path, model, request);
	}
	
	protected String render(String path, Map<String, Object> model, HttpServletRequest request) throws Exception {
		if (renderer == null)
			return null;
		return renderer.render(getViewResolver(), path, model, request);
	}
	
	@SuppressWarnings("unchecked")
	protected void appendContent(HandlerInterceptorPayload payload, String hook, String content) {
		Map<String, Object> model = payload.getModelAndView().getModel();
		if (!model.containsKey("hooks")) {
			model.put("hooks", new HashMap<String, String>());
		}
		HashMap<String, String> map = (HashMap<String, String>) model.get("hooks");
		if (map != null) {
			String existingContent = "";
			if (map.containsKey(hook)) {
				existingContent = map.get(hook);
			}
			map.put(hook, existingContent + content);
		}
	}

	public void onPreHandle(HandlerInterceptorPayload payload) {
		
	}
	
	public void onPostHandle(HandlerInterceptorPayload payload) {
		
	}

	public ViewResolver getViewResolver() {
		if (viewResolver == null)
			viewResolver = (ViewResolver) getConfig("view.defaultResolver");
		return viewResolver;
	}

	public void setViewResolver(ViewResolver viewResolver) {
		this.viewResolver = viewResolver;
	}
}
