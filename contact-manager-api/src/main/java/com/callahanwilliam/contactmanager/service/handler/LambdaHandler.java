package com.callahanwilliam.contactmanager.service.handler;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.internal.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.internal.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringLambdaContainerHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.callahanwilliam.contactmanager.configuration.SpringConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class LambdaHandler implements RequestHandler<AwsProxyRequest, AwsProxyResponse> {
	
	private final Log log = LogFactory.getLog(this.getClass());
	
	private SpringLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;
	
	@Override
	public AwsProxyResponse handleRequest(AwsProxyRequest awsProxyRequest, Context context) {
		log.info("Handling Request " + awsProxyRequest.getPath());
		configureHandler();
		return handler.proxy(awsProxyRequest, context);
	}
	
	private void configureHandler() {
		try {
			log.debug("Configuring the Spring Request handler");
			handler = SpringLambdaContainerHandler.getAwsProxyHandler(SpringConfiguration.class);
		} catch (ContainerInitializationException e) {
			log.fatal("Unable to configure Request Handler", e);
		}
	}
	
}