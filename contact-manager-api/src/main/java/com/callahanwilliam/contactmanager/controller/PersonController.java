package com.callahanwilliam.contactmanager.controller;

import com.callahanwilliam.contactmanager.model.dynamodb.Person;
import com.callahanwilliam.contactmanager.repository.dynamodb.IPersonRepository;
import com.callahanwilliam.contactmanager.utility.ListUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for the {@link Person} DMO
 */
@RestController
@RequestMapping("/persons")
public class PersonController implements IPersonController {
	
	private final IPersonRepository iPersonRepository;
	
	@Autowired
	public PersonController(IPersonRepository iPersonRepository) {
		this.iPersonRepository = iPersonRepository;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Resource<Person> findOne(@PathVariable("id") String id) {
		return new Resource<>(iPersonRepository.findOne(id));
	}
	
	/**
	 * {@inheritDoc}
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Iterable findAll() {
		return ListUtility.encapsulateObjects(iPersonRepository.findAll(), Resource.class);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Resource<Person> create(@RequestBody Person person) {
		return new Resource<>(iPersonRepository.save(person));
	}
	
	/**
	 * {@inheritDoc}
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public Resource<Person> update(@PathVariable("id") String id, @RequestBody Person person) {
		person.setId(id);
		return new Resource<>(iPersonRepository.save(person));
	}
	
	/**
	 * {@inheritDoc}
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		iPersonRepository.delete(id);
	}
	
}
