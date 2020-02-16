package org.analytik.workflow.dto;

/**
 * 
 * @author Harshita Tiwari
 * Copyright 2020 by Harshita Tiwari. All rights reserved.
 *
 */

public class WorkflowDTO {

	private Integer workflowId;
    private String name;
    private String type;

	public Integer getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(Integer workflowId) {
		this.workflowId = workflowId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

	@Override
	public String toString() {
		return "WorkflowDTO [workflowId=" + workflowId + ", name=" + name + ", type=" + type + ", workflowDetailsDTO="
				 + "]";
	}
        
}