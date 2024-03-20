package resource;

import com.prutzkow.resourcer.ProjectResourcer;
import com.prutzkow.resourcer.Resourcer;

public class MessageManager {
	private final static Resourcer resource = ProjectResourcer.getInstance();

	// класс извлекает информацию из файла messages.properties
	private MessageManager() {
	}

	public static String getProperty(String key) {
		return resource.getString(key);
	}

}