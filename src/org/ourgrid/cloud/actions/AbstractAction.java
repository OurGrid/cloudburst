package org.ourgrid.cloud.actions;

import org.ourgrid.cloud.InstanceContext;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.ec2.AmazonEC2Client;

public abstract class AbstractAction<T> implements Action<T> {

	private AmazonEC2Client ec2;

	@Override
	public T run(InstanceContext context) {
		AWSCredentials credentials = new BasicAWSCredentials(
				context.getAccessKey(), 
				context.getSecretKey());
		
		this.ec2 = new AmazonEC2Client(credentials);
		return execute(context);
	}
	
	protected abstract T execute(InstanceContext context);

	protected AmazonEC2Client getEc2() {
		return ec2;
	}
}
