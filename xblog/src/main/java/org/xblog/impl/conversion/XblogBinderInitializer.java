package org.xblog.impl.conversion;

import java.beans.PropertyEditor;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.xblog.framework.controllers.BinderInitializer;

public class XblogBinderInitializer implements BinderInitializer {

	private Map<Class<?>, ? extends PropertyEditor> customEditors;
	
	private Validator[] validators;

	@Override
	public void initDataBinder(HttpServletRequest request,
			WebDataBinder binder) throws Exception {
		if (customEditors != null) {
			for (Class<?> clazz : customEditors.keySet()) {
				binder.registerCustomEditor(clazz, customEditors.get(clazz));
			}
		}
		if (getValidators() != null)
			binder.addValidators(getValidators());
	}

	public Map<Class<?>, ? extends PropertyEditor> getCustomEditors() {
		return customEditors;
	}

	public void setCustomEditors(
			Map<Class<?>, ? extends PropertyEditor> customEditors) {
		this.customEditors = customEditors;
	}

	public Validator[] getValidators() {
		return validators;
	}

	public void setValidators(Validator[] validators) {
		this.validators = validators;
	}
}
