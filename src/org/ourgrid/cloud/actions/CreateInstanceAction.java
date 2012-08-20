package org.ourgrid.cloud.actions;

import org.ourgrid.cloud.InstanceContext;

import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.Reservation;
import com.amazonaws.services.ec2.model.RunInstancesRequest;
import com.amazonaws.services.ec2.model.RunInstancesResult;

public class CreateInstanceAction extends AbstractAction<String> {

	@Override
	protected String execute(InstanceContext context) {
		RunInstancesRequest runInstancesRequest = new RunInstancesRequest()
				.withInstanceType("t1.small")
				.withImageId(context.getImageId())
				.withMinCount(1).withMaxCount(1)
				.withSecurityGroupIds(context.getSecurityGroup())
				.withKeyName(context.getKeyName());

		RunInstancesResult result = getEc2().runInstances(runInstancesRequest);
		Reservation reservation = result.getReservation();
		Instance instance = reservation.getInstances().iterator().next();
		return instance.getInstanceId();
	}
}
