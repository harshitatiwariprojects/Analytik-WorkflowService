package org.analytik.workflow.dto;

import java.util.Date;

/**
 * 
 * @author Harshita Tiwari
 * Copyright 2020 by Harshita Tiwari. All rights reserved.
 *
 */

public class WorkflowDetailsDTO {

	private Integer workflowDetailsId;
    private Date startTime;
    private Date endTime;
    private String status;
    private Integer workflowId;
    private Integer userId;
	
    public Integer getWorkflowDetailsId() {
		return workflowDetailsId;
	}
	
    public void setWorkflowDetailsId(Integer workflowDetailsId) {
		this.workflowDetailsId = workflowDetailsId;
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
	
	public Integer getWorkflowId() {
		return workflowId;
	}
	
	public void setWorkflowId(Integer workflowId) {
		this.workflowId = workflowId;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
	@Override
	public String toString() {
		return "WorkflowDetailsDTO [workflowDetailsId=" + workflowDetailsId + ", startTime=" + startTime + ", endTime="
				+ endTime + ", status=" + status + ", workflowId=" + workflowId + ", user=" + userId + "]";
	}
         
}