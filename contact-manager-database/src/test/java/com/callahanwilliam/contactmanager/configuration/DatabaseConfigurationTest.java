package com.callahanwilliam.contactmanager.configuration;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.DeleteTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.util.TableUtils;
import com.callahanwilliam.contactmanager.model.dynamodb.Person;
import com.callahanwilliam.contactmanager.repository.dynamodb.IPersonRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DynamoDbConfiguration.class)
@WebAppConfiguration
@ActiveProfiles("test")
@TestPropertySource(properties = {"amazon.dynamodb.endpoint=http://localhost:8000/", "amazon.aws.accesskey=test1", "amazon.aws.secretkey=test231"})
public class DatabaseConfigurationTest {
	
	private final Log log = LogFactory.getLog(this.getClass());
	
	private DynamoDBMapper dynamoDBMapper;
	
	@Autowired
	private AmazonDynamoDB amazonDynamoDB;
	
	@Autowired
	private IPersonRepository iPersonRepository;
	
	@Before
	public void setup() throws Exception {
		log.info("Setting up tests...");
		dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
		CreateTableRequest createTableRequest = dynamoDBMapper.generateCreateTableRequest(Person.class);
		createTableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
		TableUtils.createTableIfNotExists(amazonDynamoDB, createTableRequest);
		log.info("Setup for testing complete!");
	}
	
	@Test
	public void test() {
		log.info("Modifying database");
	}
	
	@After
	public void destroy() throws Exception {
		log.info("Destroying tests...");
		dynamoDBMapper.batchDelete(iPersonRepository.findAll());
//		DeleteTableRequest deleteTableRequest = dynamoDBMapper.generateDeleteTableRequest(Person.class);
//		TableUtils.deleteTableIfExists(amazonDynamoDB, deleteTableRequest);
		log.info("Destroyed all tests!");
	}
	
}
