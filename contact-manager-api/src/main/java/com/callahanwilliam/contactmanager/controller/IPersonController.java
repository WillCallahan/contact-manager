package com.callahanwilliam.contactmanager.controller;

import com.callahanwilliam.contactmanager.model.dynamodb.Person;

/**
 * Controller for the {@link Person} DMO
 */
public interface IPersonController extends IResourceCrudController<Person, String> {
}
