package org.gensis0.lib.dacia.commons.cache;

import org.gensis0.lib.dacia.commons.server.Server;

public interface DACIACacheProviderManagement {

	public String cacheProviderName();

	public <P> DACIACacheManager<P> initialCacheManager(Server server);
}
