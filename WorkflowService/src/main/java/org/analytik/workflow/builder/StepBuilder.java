package org.analytik.workflow.builder;

import java.util.ArrayList;
import java.util.List;

import org.analytik.workflow.model.Activity;
import org.analytik.workflow.model.Step;
import org.analytik.workflow.model.Workflow;

/**
 * 
 * @author Harshita Tiwari
 * Copyright 2020 by Harshita Tiwari. All rights reserved.
 *
 */

public class StepBuilder {

	private Integer stepId           		= null;
	private Workflow workflow       		= null;
	private String name                  	= null;
	private int sequence                 	= 0;
	private List<Activity> activityList  	= new ArrayList<>();
    

    public StepBuilder withActivityAs(Activity activity){
        this.activityList.add(activity);
        return this;
    }

    public StepBuilder withStepIdAs(Integer stepId){

        this.stepId = stepId;
        return this;
    }

    public StepBuilder withWorkflowIdAs(Workflow workflow){

        this.workflow = workflow;
        return this;
    }
 
    public StepBuilder withNameAs(String name){

        this.name = name;
        return this;
    }

    public StepBuilder withSequenceAs(int sequence){

        this.sequence = sequence;
        return this;
    }

    public Step build(){

        Step step = new Step();

        step.setWorkflowId(this.workflow);
        step.setStepId(this.stepId);
        step.setName(this.name);
        step.setSequence(this.sequence);
               
        return step;
    }
}