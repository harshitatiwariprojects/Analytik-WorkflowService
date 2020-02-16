package org.analytik.workflow.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Harshita Tiwari
 * Copyright 2020 by Harshita Tiwari. All rights reserved.
 *
 */
@Entity
@Table(name = "STEP_ACTIVITY")
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "ACTIVITY_ID")
    private Integer activityId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SEQUENCE")
    private Integer sequence;
    @Column(name = "REMARKS")
    private Character remarks;
    @Column(name = "ACTIONS")
    private String actions;
    @JoinColumn(name = "STEP_ID", referencedColumnName = "STEP_ID")
    @ManyToOne(optional = false)
    private Step stepId;

    
    public Activity() {
    }

    public Activity(Integer activityId) {
        this.activityId = activityId;
    }

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
        
    public Step getStepId() {
        return stepId;
    }

    public void setStepId(Step stepId) {
        this.stepId = stepId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (activityId != null ? activityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object other) {
        
    	return (
        		(other instanceof Activity) && (this.activityId != null && ((Activity)other).activityId != null) 
        		&& (this.activityId == ((Activity)other).activityId)
        		);
    }

	@Override
	public String toString() {
		return "Activity [activityId=" + activityId + ", name=" + name + ", sequence=" + sequence + ", remarks="
				+ remarks + ", actions=" + actions + ", stepId=" + stepId + "]";
	}
    
}