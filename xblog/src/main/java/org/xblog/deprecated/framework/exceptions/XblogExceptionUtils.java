package org.xblog.deprecated.framework.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;

@Deprecated
public class XblogExceptionUtils {

	public static String getStackTraceAsString(Exception ex) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		ex.printStackTrace(pw);
		return "<div>"+sw.toString().replace("\n", "<br />")+"</div>";
	}
}
