package org.gensis0.lib.dacia.commons.core;

import org.gensis0.lib.dacia.commons.exception.ContainerConfigException;

public interface ContainerManagementOperation {

	public int size();

	public Container initContainer(ContainerConfig config) throws ContainerConfigException;
}
