package org.xblog.framework.advices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class XblogResponseEnvelop {

	private int errorCode;
	
	@JsonInclude(Include.NON_NULL)
	private Object result;
	
	@JsonInclude(Include.NON_NULL)
	private List<Object> errors;
	
	@JsonInclude(Include.NON_NULL)
	private Map<String, Object> additionalInfos;
	
	public XblogResponseEnvelop(int errorCode, Object result) {
		this.errorCode = errorCode;
		this.result = result;
	}
	
	public void addAdditionInfo(String key, Object value) {
		if (additionalInfos == null)
			additionalInfos = new HashMap<>();
		additionalInfos.put(key, value);
	}
	
	public void addError(Object error) {
		if (errors == null)
			errors = new ArrayList<>();
		errors.add(error);
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public List<Object> getErrors() {
		return errors;
	}

	public void setErrors(List<Object> errors) {
		this.errors = errors;
	}

	public Map<String, Object> getAdditionalInfos() {
		return additionalInfos;
	}

	public void setAdditionalInfos(Map<String, Object> additionalInfos) {
		this.additionalInfos = additionalInfos;
	}
}
