package org.analytik.workflow.builder;

import org.analytik.workflow.model.Workflow;

/**
 * 
 * @author Harshita Tiwari
 * Copyright 2020 by Harshita Tiwari. All rights reserved.
 *
 */

public class WorkflowBuilder {

	private Integer workflowId               	= null;
	private String name                       	= null;
	private String type           			 	= null;
    

    public WorkflowBuilder withWorkflowIdAs(Integer workflowId){

        this.workflowId = workflowId;
        return this;
    }

    public WorkflowBuilder withNameAs(String name){

        this.name = name;
        return this;
    }

    public WorkflowBuilder withWorkflowTypeAs(String type){

        this.type = type;
        return this;
    }

    public Workflow build(){

        Workflow workflow = new Workflow();

        workflow.setWorkflowId(this.workflowId);
        workflow.setName(this.name);
        workflow.setType(this.type);
        
        return workflow;
    }
}