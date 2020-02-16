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
@Table(name = "WORKFLOW_STEP")

public class Step implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "STEP_ID")
    private Integer stepId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SEQUENCE")
    private Integer sequence;    
    @JoinColumn(name = "WORKFLOW_ID", referencedColumnName = "WORKFLOW_ID")
    @ManyToOne(optional = false)
    private Workflow workflowId;
	
    
    public Step() {
    }

    public Step(Integer stepId) {
        this.stepId = stepId;
    }

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
    
    public Workflow getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(Workflow workflowId) {
        this.workflowId = workflowId;
    }


	@Override
    public int hashCode() {
        int hash = 0;
        hash += (stepId != null ? stepId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object other) {
           
        return (
        		(other instanceof Step) && (this.stepId != null && ((Step)other).stepId != null) 
        		&& (this.stepId == ((Step)other).stepId)
        		);

    }

	@Override
	public String toString() {
		return "Step [stepId=" + stepId + ", name=" + name + ", sequence=" + sequence + ", workflowId=" + workflowId
				+ "]";
	}  
}