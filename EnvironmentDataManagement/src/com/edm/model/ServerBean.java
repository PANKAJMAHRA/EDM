package com.edm.model;

public class ServerBean {

	private int id;
	private String name;
	private int environmentId;
	private int networkDomainId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEnvironmentId() {
		return environmentId;
	}
	public void setEnvironmentId(int environmentId) {
		this.environmentId = environmentId;
	}
	public int getNetworkDomainId() {
		return networkDomainId;
	}
	public void setNetworkDomainId(int networkDomainId) {
		this.networkDomainId = networkDomainId;
	}
	
	
}
