package org.analytik.workflow.dto;

/**
 * 
 * @author Harshita Tiwari
 * Copyright 2020 by Harshita Tiwari. All rights reserved.
 *
 */

public class ActivityDTO {

    private Integer activityId;
    
    private String name;
    private Integer sequence;
    private Character remarks;
    private String actions;
    private Integer stepId;
    private ActivityDetailsDTO activityDetailsDTO;
    
    
	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
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

	public Character getRemarks() {
		return remarks;
	}

	public void setRemarks(Character remarks) {
		this.remarks = remarks;
	}

	public String getActions() {
		return actions;
	}

	public void setActions(String actions) {
		this.actions = actions;
	}

	public Integer getStepId() {
		return stepId;
	}

	public void setStepId(Integer stepId) {
		this.stepId = stepId;
	}	
	
	public ActivityDetailsDTO getActivityDetailsDTO() {
		return activityDetailsDTO;
	}

	public void setActivityDetailsDTO(ActivityDetailsDTO activityDetailsDTO) {
		this.activityDetailsDTO = activityDetailsDTO;
	}

	@Override
	public String toString() {
		return "ActivityDTO [activityId=" + activityId + ", name=" + name + ", sequence=" + sequence + ", remarks="
				+ remarks + ", actions=" + actions + ", stepId=" + stepId + ", activityDetailsDTO=" + activityDetailsDTO
				+ "]";
	}
}