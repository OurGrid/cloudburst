package org.ourgrid.cloud.actions;

import java.util.LinkedList;
import java.util.List;

import org.ourgrid.cloud.InstanceContext;

import com.amazonaws.services.ec2.model.StartInstancesRequest;

public class StartInstanceAction extends AbstractAction<Void> {

	@Override
	protected Void execute(InstanceContext context) {
		StartInstancesRequest sir = new StartInstancesRequest();
		List<String> instancesIds = new LinkedList<String>();
		instancesIds.add(context.getInstanceId());
		getEc2().startInstances(sir);
		return null;
	}
}
