package com.callahanwilliam.contactmanager.configuration;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.util.StringUtils;

@Configuration
@ComponentScan("com.callahanwilliam")
@EnableDynamoDBRepositories(basePackages = "com.callahanwilliam.contactmanager.repository.dynamodb")
public class DynamoDbConfiguration {
	
	//@Value("${amazon.dynamodb.endpoint}")
	private String dbEndpoint = "http://localhost:8000/";
	
	//@Value("${amazon.aws.accesskey}")
	private String awsAccessKey = "key";
	
	//@Value("${amazon.aws.secretkey}")
	private String awsSecretKey = "key2";
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean
	public AmazonDynamoDB amazonDynamoDB() {
		AmazonDynamoDB amazonDynamoDB = new AmazonDynamoDBClient(new BasicAWSCredentials(awsAccessKey, awsSecretKey));
		if (!StringUtils.isEmpty(dbEndpoint))
			amazonDynamoDB.setEndpoint(dbEndpoint);
		return amazonDynamoDB;
	}
	
}
