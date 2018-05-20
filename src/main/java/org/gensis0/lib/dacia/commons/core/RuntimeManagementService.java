package org.gensis0.lib.dacia.commons.core;
//package org.gensis0.dacia.commons.core;
//
//import java.util.List;
//
//import org.gensis0.dacia.commons.api.container.Container;
//import org.gensis0.dacia.commons.api.container.RuntimeManagement;
//import org.gensis0.dacia.commons.exception.CommonException;
//
///**
// * 默认运行时容器管理服务实现。
// * 
// * @author Jerry Han
// *
// */
//public class RuntimeManagementService implements RuntimeManagement {
//
//	private RuntimeContainer container;
//
//	public RuntimeManagementService() {
//		this.container = (RuntimeContainer) RuntimeContainer.getContainer();
//	}
//
//	@Override
//	public List<RuntimeElement> queryLayeredElements(String layerName) {
//		return this.container.getLayeredElements(layerName);
//	}
//
//	@Override
//	public RuntimeElement queryElement(String elementName) {
//		return this.container.get(elementName);
//	}
//
//	@Override
//	public RuntimeLayer queryLayer(String layerName) {
//		return this.container.getLayer(layerName);
//	}
//
//	@Override
//	public boolean registerElement(RuntimeElement element) {
//		this.container.update(element);
//		return true;
//	}
//
//	@Override
//	public boolean registerLayer(RuntimeLayer layer) {
//		this.container.update(layer);
//		return true;
//	}
//
//	@Override
//	public Container getContainer() {
//		return this.container;
//	}
//
//	@Override
//	public RuntimeManagement getInstance(String containerName) throws CommonException {
//		if (this.container.getContainerName().equals(containerName)) {
//			return this;
//		}
//		return null;
//	}
//
//}
