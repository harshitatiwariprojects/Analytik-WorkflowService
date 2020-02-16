 package org.analytik.workflow.service;

import java.util.List;
import java.util.Optional;

import org.analytik.workflow.dto.ActivityDTO;
import org.analytik.workflow.dto.ActivityDetailsDTO;
import org.analytik.workflow.model.Activity;
import org.analytik.workflow.model.ActivityDetails;
/**
 * 
 * @author Harshita Tiwari
 * Copyright 2020 by Harshita Tiwari. All rights reserved.
 *
 */

public interface ActivityService {

	public List<Activity> getAllActivity();
	
	public Optional<Activity> getActivityById(int activity_id);

	public Optional<ActivityDetails> getActivityDetailsById(int activityDetailsId);

	public List<ActivityDetails> getAllActivityDetails();
	
	public ActivityDetails createActivityDetails(ActivityDetailsDTO activityDetailsDTO);
	
	public Activity createActivity(ActivityDTO activityDTO);

	public Activity updateActivity(ActivityDTO activityDTO);
	
	public void deleteActivity(ActivityDTO activityDTO);
	
}
