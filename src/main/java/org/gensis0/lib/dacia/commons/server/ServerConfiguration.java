package org.gensis0.lib.dacia.commons.server;

import java.util.ArrayList;
import java.util.List;

import org.gensis0.lib.dacia.commons.core.Tuple;
import org.gensis0.lib.dacia.commons.core.lower.DACIAClassLoader;

/**
 * 服务器的基本抽象。
 * 
 * @author yihan
 *
 */
public class ServerConfiguration {
	public static long SERVER_CONF_IP=1000000001L;
	/**
	 * 服务器实例ID。
	 */
	private long serverId;
	/**
	 * 服务器类型名称，此名称是ServerManagement中的服务器名称。{@link <strong>org.gensis0.lib.dacia.commons.server.ServerManagement</strong>}
	 */
	private String serverTypeName;
	/**
	 * 服务器实例名称，可用于用户或者默认生成的名称，相当于一个标签，建议不同服务器实例，其名称不同。
	 */
	private String serverName;
	/**
	 * 服务器的配置项目。
	 */
	private List<Tuple> serverOptions;

	public ServerConfiguration(long serverId, String serverTypeName, String serverName, List<Tuple> serverOptions) {
		this.serverId = serverId;
		this.serverTypeName = serverTypeName;
		this.serverName = serverName;
		this.serverOptions = serverOptions;
	}

	public ServerConfiguration() {
		this.serverOptions = new ArrayList<Tuple>();
	}

	public ServerConfiguration(long serverId, String serverTypeName, String serverName) {
		this.serverId = serverId;
		this.serverTypeName = serverTypeName;
		this.serverName = serverName;
		this.serverOptions = new ArrayList<Tuple>();
	}

	public long getServerId() {
		return serverId;
	}

	public void setServerId(long serverId) {
		this.serverId = serverId;
	}

	public String getServerTypeName() {
		return serverTypeName;
	}

	public void setServerTypeName(String serverTypeName) {
		this.serverTypeName = serverTypeName;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public List<Tuple> getServerOptions() {
		return serverOptions;
	}

	public void setServerOptions(List<Tuple> serverOptions) {
		this.serverOptions = serverOptions;
	}

	public void addServerOption(Tuple serverOption) {
		this.serverOptions.add(serverOption);
	}

	public void addServerOption(List<Tuple> serverOptions) {
		this.serverOptions.addAll(serverOptions);
	}

}
