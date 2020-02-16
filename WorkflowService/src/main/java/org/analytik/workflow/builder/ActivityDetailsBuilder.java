package org.analytik.workflow.builder;

import java.util.Date;

import org.analytik.workflow.model.Activity;
import org.analytik.workflow.model.ActivityDetails;
import org.analytik.workflow.model.User;

/**
 * 
 * @author Harshita Tiwari
 * Copyright 2020 by Harshita Tiwari. All rights reserved.
 *
 */

public class ActivityDetailsBuilder {
	
	private Integer activityDetailsId	= null;
	private Activity activity			= null;
    private Date startTime				= null;
    private Date endTime				= null;
    private String status				= null;
    private User user					= null;

    public ActivityDetailsBuilder withActivityDetailsId(Integer activityDetailsId) {
    	
    	this.activityDetailsId = activityDetailsId;
    	return this;
    }
    
    public ActivityDetailsBuilder withActivity(Activity activity) {
    	
    	this.activity = activity;
    	return this;
    }

	public ActivityDetailsBuilder withStartTime(Date startTime) {
		
		this.startTime = startTime;
		return this;
	}
	
	public ActivityDetailsBuilder withEndTime(Date endTime) {
		
		this.endTime = endTime;
		return this;
	}
	
	public ActivityDetailsBuilder withStatus(String status) {
		
		this.status = status;
		return this;
	}
	
	public ActivityDetailsBuilder withUser(User user) {
		
		this.user = user;
		return this;
	}
	
	public ActivityDetails build() {
		
		ActivityDetails activityDetails= new ActivityDetails();
		
		activityDetails.setActivityDetailsId(activityDetailsId);
		activityDetails.setActivity(activity);
		activityDetails.setStartTime(startTime);
		activityDetails.setEndTime(endTime);
		activityDetails.setStatus(status);
		activityDetails.setUser(user);
			
		return activityDetails;
	}
}