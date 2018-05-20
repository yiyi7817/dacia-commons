package org.gensis0.lib.dacia.commons.core;

import java.util.Date;
import java.util.concurrent.Executor;

import org.apache.commons.lang.ArrayUtils;
import org.gensis0.lib.dacia.commons.StatusInfo;
import org.gensis0.lib.dacia.commons.exception.ContainerExecutionException;
import org.gensis0.lib.dacia.commons.utils.RandomUtils;

public class ThreadContainer implements Container {

	public final static int THREAD_CONTAINER = 41;
	public static String containerName = "default_thread_container";
	private long containerId = -1L;
	private int delayTime = 10;
	private int coreSize = 10;
	private int initSize = 10;
	private int maxSize = 30;
	private Executor pool;
	private Thread[] thread_pool;
	private Long[] time_count;

	public ThreadContainer() {
		this.thread_pool = new Thread[this.initSize];
	}

	public ThreadContainer(int initSize) {
		this.initSize = initSize;
		this.thread_pool = new Thread[initSize];
	}

	@Override
	public String getContainerName() {
		return ThreadContainer.containerName;
	}

	@Override
	public long genContainerId() {
		if (this.containerId == -1L) {
			this.containerId = RandomUtils.genRandomNum(Integer.MAX_VALUE) + new Date().getTime();
		}
		return this.containerId;
	}

	@Override
	public int size() {
		return this.initSize;
	}

	@Override
	public int maxSize() {
		return this.maxSize;
	}

	@Override
	public boolean autoIncre() {
		return false;
	}

	@Override
	public boolean delay() {
		if (this.delayTime == 10) {
			return false;
		}
		return false;
	}

	@Override
	public boolean healthCheck() {
		return false;
	}

	@Override
	public StatusInfo status() {
		return StatusInfo.INITIAL;
	}

	public Container addHandler(Thread thread) {
		return this;
	}

	public Container setDelay(int delay) {
		this.delayTime = delay;
		return this;
	}

	public Container setInitSize(int size) {
		this.initSize = size;
		return this;
	}

	public Container setCoreSize(int size) {
		this.coreSize = size;
		return this;
	}

	public Container setMaxSize(int size) {
		this.maxSize = size;
		return this;
	}

	@Override
	public <T> T get() throws ContainerExecutionException {
		if (this.coreSize < this.maxSize) {

		}
		return null;
	}

	private Thread[] increThreadPool(Thread thread) {
		return (Thread[]) ArrayUtils.add(this.thread_pool, thread);
	}

	private Thread[] decreThreadPool(int pos) {
		return (Thread[]) ArrayUtils.remove(this.thread_pool, pos);
	}
}
