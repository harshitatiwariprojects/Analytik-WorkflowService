package org.analytik.workflow.dto;

import java.util.Date;

/**
 * 
 * @author Harshita Tiwari
 * Copyright 2020 by Harshita Tiwari. All rights reserved.
 *
 */

public class StepDetailsDTO {
	
	private Integer stepDetailsId;
    private Date startTime;
    private Date endTime;
    private String status;
    private Integer stepId;
    private Integer userId;
    
    public Integer getStepDetailsId() {
        return stepDetailsId;
    }

    public void setStepDetailsId(Integer stepDetailsId) {
        this.stepDetailsId = stepDetailsId;
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

    public Integer getStepId() {
        return stepId;
    }

    public void setStepId(Integer stepId) {
        this.stepId = stepId;
    }
    
    public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "StepDetailsDTO [stepDetailsId=" + stepDetailsId + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", status=" + status + ", stepId =" + stepId + ", user=" + userId + "]";
	}   

}