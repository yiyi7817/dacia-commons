package org.gensis0.lib.dacia.commons.core;

import org.gensis0.lib.dacia.commons.exception.ContainerExecutionException;

public interface ContainerOperation {

	public String start(boolean daemon) throws ContainerExecutionException;

	public void stop(String containerId) throws ContainerExecutionException;

	public String getId();

	public String getName();
}
