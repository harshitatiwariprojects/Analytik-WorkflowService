package org.analytik.workflow.dto;

/**
 * 
 * @author Harshita Tiwari
 * Copyright 2020 by Harshita Tiwari. All rights reserved.
 *
 */

public class StepDTO {
	
	private Integer stepId;
    private String name;
    private Integer sequence;
    private Integer workflowId;

    public Integer getStepId() {
        return stepId;
    }

    public void setStepId(Integer stepId) {
        this.stepId = stepId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(Integer workflowId) {
        this.workflowId = workflowId;
    }

	@Override
	public String toString() {
		return "StepDTO [stepId=" + stepId + ", name=" + name + ", sequence=" + sequence + ", workflowId="
				+ workflowId + "]";
	}
    
}
