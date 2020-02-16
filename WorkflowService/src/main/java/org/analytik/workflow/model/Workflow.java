package org.analytik.workflow.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Harshita Tiwari
 * Copyright 2020 by Harshita Tiwari. All rights reserved.
 *
 */
@Entity
@Table(name = "WORKFLOW")

public class Workflow implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "WORKFLOW_ID")
    private Integer workflowId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "TYPE")
    private String type;    
	
    public Workflow() {
    }

    public Workflow(Integer workflowId) {
        this.workflowId = workflowId;
    }

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
    public int hashCode() {
        int hash = 0;
        hash += (workflowId != null ? workflowId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object other) {
        
    	return (
        		(other instanceof Workflow) && (this.workflowId != null && ((Workflow)other).workflowId != null) 
        		&& (this.workflowId == ((Workflow)other).workflowId)
        		);
    }

	@Override
	public String toString() {
		return "Workflow [workflowId=" + workflowId + ", name=" + name + ", type=" + type + ", workflowDetails="
				 + "]";
	}

}