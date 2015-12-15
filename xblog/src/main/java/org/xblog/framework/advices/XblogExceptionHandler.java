package org.xblog.framework.advices;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.xblog.framework.advices.filters.ResponseFilter;

@ControllerAdvice
public class XblogExceptionHandler extends ResponseEntityExceptionHandler implements ResponseBodyAdvice<Object> {
	
	private List<ResponseFilter> filters;

	@ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> defaultErrorHandler(HttpServletRequest req, Exception e, WebRequest webReq) throws Exception {
		
		XblogResponseEnvelop envelop = new XblogResponseEnvelop(1, null);
		envelop.addError(e.getMessage());
		envelop.addAdditionInfo("url", req.getRequestURL());
		envelop.addAdditionInfo("errorClassName", e.getClass().getName());
		envelop.addAdditionInfo("stackTrace", e.getStackTrace());
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
		
		return handleExceptionInternal(e, envelop, headers, HttpStatus.OK, webReq);
    }

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		if (body instanceof XblogResponseEnvelop) {
			return body;
		}
		response.getHeaders().add("Access-Control-Allow-Origin", "*");
		if (filters != null) {
			for(ResponseFilter filter : filters) {
				body = filter.filter(body, returnType, selectedContentType, selectedConverterType, request, response);
			}
		}
		return new XblogResponseEnvelop(0, body);
	}

	public List<ResponseFilter> getFilters() {
		return filters;
	}

	public void setFilters(List<ResponseFilter> filters) {
		this.filters = filters;
	}
}
