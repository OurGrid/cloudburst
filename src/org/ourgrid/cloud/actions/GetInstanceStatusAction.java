package org.ourgrid.cloud.actions;

import java.util.List;

import org.ourgrid.cloud.InstanceContext;

import com.amazonaws.services.ec2.model.DescribeInstanceStatusRequest;
import com.amazonaws.services.ec2.model.DescribeInstanceStatusResult;
import com.amazonaws.services.ec2.model.InstanceStatus;

public class GetInstanceStatusAction extends AbstractAction<String> {

	@Override
	public String execute(InstanceContext context) {
		DescribeInstanceStatusRequest describeInstanceRequest = new DescribeInstanceStatusRequest()
				.withInstanceIds(context.getInstanceId());
		DescribeInstanceStatusResult describeInstanceResult = getEc2()
				.describeInstanceStatus(describeInstanceRequest);
		List<InstanceStatus> state = describeInstanceResult
				.getInstanceStatuses();
		String status = state.get(0).getInstanceState().getName();
		return status;
	}

}
