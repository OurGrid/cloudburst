package org.ourgrid.cloud;

import org.ourgrid.cloud.actions.CreateInstanceAction;
import org.ourgrid.cloud.actions.GetInstanceStatusAction;


public class Main {

	public static void main(String[] args) {
		InstanceContext context = new InstanceContext();
		context.setAccessKey("AccessKey");
		context.setSecretKey("SecretKey");
		context.setImageId("ami-1fed5976");
		context.setSecurityGroup("quick-start-1");
		context.setKeyName("KeyName");
		
		String instanceId = new CreateInstanceAction().run(context);
		context.setInstanceId(instanceId);
		String status = new GetInstanceStatusAction().run(context);
		System.out.println(status);
	}
	
}
