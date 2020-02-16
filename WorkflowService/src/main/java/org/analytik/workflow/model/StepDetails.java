package org.analytik.workflow.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Harshita Tiwari
 * Copyright 2020 by Harshita Tiwari. All rights reserved.
 *
 */
@Entity
@Table(name = "STEP_DETAILS")
public class StepDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "STEP_DETAILS_ID")
    private Integer stepDetailsId;
    @Column(name = "START_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Column(name = "END_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @Column(name = "STATUS")
    private String status;
    @JoinColumn(name = "STEP_ID", referencedColumnName = "STEP_ID")
    @ManyToOne(optional = false)
    private Step step;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private User user;
    

    public StepDetails() {
    }

    public StepDetails(Integer stepDetailsId) {
        this.stepDetailsId = stepDetailsId;
    }

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
    
    public User getUser() {
    	return user;
    }
    
    public void setUser(User user) {
    	this.user = user;
    }

    public Step getStep() {
        return step;
    }

    public void setStep(Step step) {
        this.step = step;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stepDetailsId != null ? stepDetailsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object other) {
        
    	return (
        		(other instanceof StepDetails) && (this.stepDetailsId != null && ((StepDetails)other).stepDetailsId != null) 
        		&& (this.stepDetailsId == ((StepDetails)other).stepDetailsId)
        		);
    }

	@Override
	public String toString() {
		return "StepDetails [stepDetailsId=" + stepDetailsId + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", status=" + status + ", step=" + step + ", user=" + user + "]";
	}

    
    
}
