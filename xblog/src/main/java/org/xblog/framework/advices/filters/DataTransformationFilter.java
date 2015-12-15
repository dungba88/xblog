package org.xblog.framework.advices.filters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;

public class DataTransformationFilter implements ResponseFilter {

	@Override
	public Object filter(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		return doFilter(body, returnType);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private <T> Object doFilter(T body, MethodParameter returnType) {
		DataTransformer annotation = returnType.getMethodAnnotation(DataTransformer.class);
		if (annotation == null)
			return body;
		Class<? extends IDataTransformer<?>> filteringClass = annotation.value();
		try {
			IDataTransformer<T> filterer = (IDataTransformer<T>) filteringClass.newInstance();
			if (body instanceof List)
				return filter((List) body, filterer);
			return filterer.assemble(body);
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
	
	private <T> List<Object> filter(List<T> objects, IDataTransformer<T> filterer) {
		List<Object> list = new ArrayList<>();
		if (objects == null)
			return list;
		for (T object : objects) {
			Object item = filterer.assemble(object);
			list.add(item);
		}
		return list;
	}
}
