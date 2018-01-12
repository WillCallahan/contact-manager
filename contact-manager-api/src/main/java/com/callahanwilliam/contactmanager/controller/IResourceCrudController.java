package com.callahanwilliam.contactmanager.controller;

import org.springframework.hateoas.Resource;

/**
 * Defines standard methods for models of the application that follow HATEOAS resource standards
 *
 * @param <T>  Type being accessed by the API
 * @param <ID> Type of the primary key of the object being accessed by the API
 */
public interface IResourceCrudController<T, ID> {
	
	/**
	 * Finds all available objects
	 *
	 * @return All objects
	 */
	Iterable findAll();
	
	/**
	 * Finds the object with a matching {@link ID}
	 *
	 * @param id Id to search by
	 * @return Matching object
	 */
	Resource<T> findOne(ID id);
	
	/**
	 * Gets the total count of the object
	 *
	 * @return Total number of objects
	 */
	Resource<Number> count();
	
	/**
	 * Creates a new instance of an object
	 *
	 * @param type Object to create
	 * @return Created object
	 */
	Resource<T> create(T type);
	
	/**
	 * Updates an existing object
	 *
	 * @param id   Id of the object to update
	 * @param type Object to update
	 * @return Updated object
	 */
	Resource<T> update(ID id, T type);
	
	/**
	 * Deletes an object
	 *
	 * @param id Id of the object to delete
	 */
	void delete(ID id);
	
}
