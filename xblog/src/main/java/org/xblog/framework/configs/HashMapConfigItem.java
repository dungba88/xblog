package org.xblog.framework.configs;

import java.util.HashMap;

public class HashMapConfigItem implements XblogConfigItem {
	
	private HashMap<String, Object> map;

	@Override
	public Object get(String key) {
		if (map != null)
			return map.get(key);
		return null;
	}

	public HashMap<String, Object> getMap() {
		return map;
	}

	public void setMap(HashMap<String, Object> map) {
		this.map = map;
	}

}
