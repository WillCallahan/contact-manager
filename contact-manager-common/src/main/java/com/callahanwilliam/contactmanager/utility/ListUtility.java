package com.callahanwilliam.contactmanager.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains utility methods for working with {@link java.util.List}
 */
public class ListUtility {
	
	private static final Log log = LogFactory.getLog(ListUtility.class);
	
	/**
	 * Encapsulates {@link Iterable<E>} into a {@link List<T>}
	 *
	 * @param iterableToEncapsulate Objects to encapsulate
	 * @param encapsulationObject Object to encapsulate existing objects in
	 * @param <T> Type of the object to encapsulate existing objects
	 * @param <E> Type of the object being encapsulated
	 * @return Encapsulated objects
	 */
	public static <T, E> Iterable<T> encapsulateObjects(Iterable<E> iterableToEncapsulate, Class<T> encapsulationObject) {
		try {
			List<T> encapsulationList = new ArrayList<>();
			for (E obj : iterableToEncapsulate) {
				Constructor<T> constructor = ReflectionUtility.getConstructor(encapsulationObject, obj.getClass());
				if (ReflectionUtility.constructorHasVariableArgs(constructor))
					encapsulationList.add(constructor.newInstance(obj, new ArrayList<>()));
				else
					encapsulationList.add(constructor.newInstance(obj));
			}
			return encapsulationList;
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			log.error("Unable to encapsulate objects!");
			return null;
		}
	}
	
}
