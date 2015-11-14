package org.xblog.impl.views;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.xblog.framework.views.Renderer;

@Component
public class XblogRenderer implements Renderer {

	@Override
	public String render(ViewResolver viewResolver, String path, Map<String, Object> model, HttpServletRequest request) throws Exception {
		if (viewResolver == null)
			return "";
		View view = viewResolver.resolveViewName(path, Locale.US);
		MockHttpServletResponse response = new MockHttpServletResponse();
		if (view == null)
			throw new IllegalArgumentException("No view can be resolved for "+path);
		view.render(model, request, response);
		return response.getContentAsString();
	}
}
