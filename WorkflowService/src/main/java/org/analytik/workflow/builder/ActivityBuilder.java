package org.analytik.workflow.builder;

import org.analytik.workflow.model.Activity;
import org.analytik.workflow.model.Step;

/**
 * 
 * @author Harshita Tiwari
 * Copyright 2020 by Harshita Tiwari. All rights reserved.
 *
 */

public class ActivityBuilder {

    private Step step           		 = null;
    private Integer activityId       	 = null;
    private String name                  = null;
    private int sequence                 = 0;
    private Character remarks            = null;
    private String actions               = null;
    
    public ActivityBuilder withStepIdAs(Step step){

        this.step = step;
        return this;
    }

    public ActivityBuilder withActivityIdAs(Integer activityId){

        this.activityId = activityId;
        return this;
    }

    public ActivityBuilder withActivityNameAs(String name){

        this.name = name;
        return this;
    }

    public ActivityBuilder withSequenceAs(int sequence){

        this.sequence = sequence;
        return this;
    }

    public ActivityBuilder withRemarksAs(Character remarks){

        this.remarks = remarks;
        return this;
    }

    public ActivityBuilder withActionAs(String actions){

        this.actions = actions;
        return this;
    }

    public Activity build(){

    	Activity activity = new Activity();
    	activity.setActions(actions);
    	activity.setSequence(this.sequence);
    	activity.setName(this.name);
    	activity.setActivityId(this.activityId);
    	activity.setStepId(this.step);
    	activity.setRemarks(this.remarks);
    

        return activity;
    }
}