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
@Table(name = "WORKFLOW_DETAILS")

public class WorkflowDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "WORKFLOW_DETAILS_ID")
    private Integer workflowDetailsId;
    @Column(name = "START_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Column(name = "END_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @Column(name = "STATUS")
    private String status;
    @JoinColumn(name = "WORKFLOW_ID", referencedColumnName = "WORKFLOW_ID")
    @ManyToOne(optional = false)
    private Workflow workflow;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private User user;

    public WorkflowDetails() {
    }

    public WorkflowDetails(Integer workflowDetailsId) {
        this.workflowDetailsId = workflowDetailsId;
    }

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
    
    public User getUser() {
    	return user;
    }
    
    public void setUser(User user) {
    	this.user = user;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Workflow getWorkflow() {
        return workflow;
    }

    public void setWorkflow(Workflow workflow) {
        this.workflow = workflow;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (workflowDetailsId != null ? workflowDetailsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object other) {
        
    	return (
        		(other instanceof WorkflowDetails) && (this.workflowDetailsId != null && ((WorkflowDetails)other).workflowDetailsId != null) 
        		&& (this.workflowDetailsId == ((WorkflowDetails)other).workflowDetailsId)
        		);
    }

	@Override
	public String toString() {
		return "WorkflowDetails [workflowDetailsId=" + workflowDetailsId + ", startTime=" + startTime + ", endTime="
				+ endTime + ", status=" + status + ", workflow=" + workflow + ", user=" + user + "]";
	}

     
}