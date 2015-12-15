package org.xblog.deprecated.framework.conversion;

import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Deprecated
public class TimestampEditor extends PropertyEditorSupport {

	private String dateFormat;

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		try {
			setValue(new Timestamp(sdf.parse(text).getTime()));
		} catch (ParseException ex) {
			throw new IllegalArgumentException("Could not parse date: " + ex.getMessage(), ex);
		}
	}

	@Override
	public String getAsText() {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Timestamp value = (Timestamp) getValue();
		return (value != null ? sdf.format(value) : "");
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}
}
