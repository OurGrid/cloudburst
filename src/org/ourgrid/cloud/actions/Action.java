package org.ourgrid.cloud.actions;

import org.ourgrid.cloud.InstanceContext;

public interface Action<T> {

	T run(InstanceContext context);
	
}
