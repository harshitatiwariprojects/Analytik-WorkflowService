package org.analytik.workflow.dto;

import java.util.Date;

/**
 * 
 * @author Harshita Tiwari
 * Copyright 2020 by Harshita Tiwari. All rights reserved.
 *
 */

public class ActivityDetailsDTO {
	
	private Integer activityDetailsId;
	private Integer activityId;
    private Date startTime;
    private Date endTime;
    private String status;
    private Integer userId;
    private Integer stepId;
    
	public Integer getActivityDetailsId() {
		return activityDetailsId;
	}
	
	public void setActivityDetailsId(Integer activityDetailsId) {
		this.activityDetailsId = activityDetailsId;
	}
	
	public Date getStartTime() {
		return startTime;
	}
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	public Date getEndTime() {
		return endTime;
	}
	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
		
	public Integer getActivityId() {
		return activityId;
	}
	
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public Integer getStepId() {
		return stepId;
	}

	public void setStepId(Integer stepId) {
		this.stepId = stepId;
	}
	
	@Override
	public String toString() {
		return "ActivityDetailsDTO [activityDetailsId=" + activityDetailsId + ", activityId=" + activityId
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", status=" + status + ", userId=" + userId
				+ ", stepId=" + stepId + "]";
	}  

}