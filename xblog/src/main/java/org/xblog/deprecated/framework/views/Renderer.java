package org.xblog.deprecated.framework.views;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ViewResolver;

@Deprecated
public interface Renderer {

	public String render(ViewResolver viewResolver, String path, Map<String, Object> model, HttpServletRequest request) throws Exception;
}
