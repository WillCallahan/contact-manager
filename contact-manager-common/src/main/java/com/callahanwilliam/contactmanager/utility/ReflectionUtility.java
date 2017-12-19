package com.callahanwilliam.contactmanager.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Constructor;
import java.util.Arrays;

/**
 * Contains utility methods for reflection
 */
public class ReflectionUtility {
	
	private static final Log log = LogFactory.getLog(ListUtility.class);
	
	/**
	 * Gets a matching {@link Constructor}, accepting variable argument constructors if one exists
	 *
	 * @param clazz Class to get constructors from
	 * @param parameters Parameters to be sent to the constructor
	 * @param <T> Type of the class to get constructors from
	 * @throws NoSuchMethodException if no constructor if found with the provided parameters
	 * @return Matching constructor
	 */
	@SuppressWarnings("unchecked")
	public static <T> Constructor<T> getConstructor(Class<T> clazz, Class<?>... parameters) throws NoSuchMethodException {
		try {
			clazz.getConstructor(parameters);
		} catch (NoSuchMethodException e) {
			log.warn("Unable to get constructor with parameters " + Arrays.toString(parameters));
		}
		for (Constructor constructor : clazz.getConstructors()) {
			if (parameters.length == constructor.getParameterCount() - 1 && constructorHasVariableArgs(constructor))
				return constructor;
		}
		throw new NoSuchMethodException("Constructor not found with parameters " + Arrays.toString(parameters));
	}
	
	/**
	 * Checks if a constructor has a variable number of arguments
	 *
	 * @param constructor Constructor to check
	 * @return Whether or not a constructor has variable arguments
	 */
	public static boolean constructorHasVariableArgs(Constructor<?> constructor) {
		return constructor.getParameterCount() > 0 && constructor.getParameterTypes()[constructor.getParameterCount() - 1].equals(Iterable.class);
	}
	
}
