package com.edm.model;

public class ApplicationBean {
	private int id;
	private String name;
	private String deploymentLocation;
	private String logType;
	private int applicationTypeId;

	public int getApplicationTypeId() {
		return applicationTypeId;
	}

	public void setApplicationTypeId(int applicationTypeId) {
		this.applicationTypeId = applicationTypeId;
	}

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

	public String getDeploymentLocation() {
		return deploymentLocation;
	}

	public void setDeploymentLocation(String deploymentLocation) {
		this.deploymentLocation = deploymentLocation;
	}

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

}
