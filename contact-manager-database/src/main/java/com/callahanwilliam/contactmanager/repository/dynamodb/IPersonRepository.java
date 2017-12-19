package com.callahanwilliam.contactmanager.repository.dynamodb;

import com.callahanwilliam.contactmanager.model.dynamodb.Person;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for the {@link Person} DMO
 */
@EnableScan
public interface IPersonRepository extends CrudRepository<Person, String> {
}
