package com.prutzkow.resourcer;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Providing access to text resources.
 * 
 * Using initialization-on-demand, thread-safety, and dependency injection.
 * 
 * History:
 * 
 * 1.0 - The first version.
 * 
 * 2.0 - Added initialization-on-demand and thread-safety.
 * 
 * 2.1 - Added the getInstance method for dependency injection.
 * 
 * @version 2.1
 */
public class ProjectResourcer implements Resourcer {
	public static final String MISSING_PARAMETER_VALUE_MESSAGE_FORMAT = "Value for parameter \"%s\" is missing";

	private static final String DEFAULT_PROPERTY_NAME = "resources.text";
	private static String basename = DEFAULT_PROPERTY_NAME;
	
	private ProjectResourcer() {
	}

	public void setBasename(String basename) {
		ProjectResourcer.basename = basename;
	}

	public static Resourcer getInstance() {
		return ResourcerHolder.resourcer;
	}

	private static void reinitialize() {
		synchronized (ProjectResourcer.class) {
			if ((ProjectResourcer.isBasenameChanged())
					|| (ProjectResourcer.isLocaleChanged())) {
				ResourcerHolder.basename = ProjectResourcer.basename;
				ResourcerHolder.resources = ResourceBundle.getBundle(
						ResourcerHolder.basename, Locale.getDefault());
			}
		}
	}

	private static boolean isLocaleChanged() {
		Locale systemLocale = Locale.getDefault();
		Locale resourcerLocale = ResourcerHolder.resources.getLocale();

		return (!systemLocale.equals(resourcerLocale));
	}

	private static boolean isBasenameChanged() {
		return (!ProjectResourcer.basename.equals(ResourcerHolder.basename));
	}

	@Override
	public String getString(String resourceKey) {
		ProjectResourcer.reinitialize();
		ResourceBundle resources = ResourcerHolder.resources;
		String resourceValue;

		try {
			resourceValue = resources.getString(resourceKey);
		} catch (MissingResourceException e) {
			resourceValue = String.format(
					ProjectResourcer.MISSING_PARAMETER_VALUE_MESSAGE_FORMAT,
					resourceKey);
		}

		return resourceValue;
	}

	private static class ResourcerHolder {
		private static String basename = ProjectResourcer.basename;
		private static ResourceBundle resources = ResourceBundle.getBundle(
				ProjectResourcer.basename, Locale.getDefault());
		private static Resourcer resourcer = new ProjectResourcer();
	}
}
