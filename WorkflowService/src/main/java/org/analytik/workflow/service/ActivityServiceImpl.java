package org.analytik.workflow.service;

import java.util.List;
import java.util.Optional;

import org.analytik.workflow.builder.ActivityBuilder;
import org.analytik.workflow.builder.ActivityDetailsBuilder;
import org.analytik.workflow.dto.ActivityDTO;
import org.analytik.workflow.dto.ActivityDetailsDTO;
import org.analytik.workflow.model.Activity;
import org.analytik.workflow.model.ActivityDetails;
import org.analytik.workflow.model.Step;
import org.analytik.workflow.model.User;
import org.analytik.workflow.repository.ActivityDetailsRepository;
import org.analytik.workflow.repository.ActivityRepository;
import org.analytik.workflow.repository.StepRepository;
import org.analytik.workflow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 
 * @author Harshita Tiwari
 * Copyright 2020 by Harshita Tiwari. All rights reserved.
 *
 */

@Service
public class ActivityServiceImpl implements ActivityService{

	@Autowired
	private StepRepository stepRepository;
	
	@Autowired
	private ActivityRepository activityRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ActivityDetailsRepository activityDetailsRepository;
	
	@Override
	public List<Activity> getAllActivity(){
		
		return this.activityRepository.findAll();
	}

	@Override
	public Optional<Activity> getActivityById(int activity_id) {

		return this.activityRepository.findById(activity_id);
	}
	
	@Override
	public List<ActivityDetails> getAllActivityDetails(){
		
		return this.activityDetailsRepository.findAll();
	}

	@Override
	public Optional<ActivityDetails> getActivityDetailsById(int activityDetailsId) {

		return this.activityDetailsRepository.findById(activityDetailsId);
	}

	
	@Override
	public ActivityDetails createActivityDetails(ActivityDetailsDTO activityDetailsDTO) {
		
		ActivityDetails createActivityDetails= new ActivityDetails();
		
		ActivityDetailsBuilder activityDetailsBuilder = new ActivityDetailsBuilder();
		
		Optional<Step> stepOption = this.stepRepository.findById(activityDetailsDTO.getStepId());
		
		Optional<User> userOption= this.userRepository.findById(activityDetailsDTO.getUserId());	
		
		if(stepOption.isPresent() && userOption.isPresent()) {
			
			
			Optional<Activity> activityOption= this.activityRepository.findById(activityDetailsDTO.getActivityId());
			

			if(activityOption.isPresent()) {
				
				activityDetailsBuilder.withActivity(activityOption.get());
				activityDetailsBuilder.withActivityDetailsId(activityDetailsDTO.getActivityDetailsId());
				activityDetailsBuilder.withStartTime(activityDetailsDTO.getStartTime());
				activityDetailsBuilder.withEndTime(activityDetailsDTO.getEndTime());
				activityDetailsBuilder.withStatus(activityDetailsDTO.getStatus());
				activityDetailsBuilder.withUser(userOption.get());
				
				createActivityDetails = activityDetailsBuilder.build();
				createActivityDetails = this.activityDetailsRepository.save(createActivityDetails);
				
				this.activityDetailsRepository.flush();
			}
			
		}
		return createActivityDetails;
	}
	
	@Override
	public Activity createActivity(ActivityDTO activityDTO) {
		
		Activity createActivity= new Activity();
		
		ActivityBuilder activityBuilder= new ActivityBuilder();
		
		Optional<Step> stepOption = this.stepRepository.findById(activityDTO.getStepId());
		
		if(stepOption.isPresent()) {
		
			activityBuilder.withSequenceAs(activityDTO.getSequence());
			activityBuilder.withActivityIdAs(activityDTO.getActivityId());
			activityBuilder.withActivityNameAs(activityDTO.getName());
			activityBuilder.withStepIdAs(stepOption.get());
			activityBuilder.withActionAs(activityDTO.getActions());
			activityBuilder.withRemarksAs(activityDTO.getRemarks());
			
			
			createActivity = activityBuilder.build();
			
			createActivity = this.activityRepository.save(createActivity);
			
			this.activityRepository.flush();	
			
			ActivityDetails activityDetails = new ActivityDetails();
			activityDetails.setActivity(createActivity);
			activityDetails.setActivityDetailsId(activityDTO.getActivityId());			
			
			this.activityDetailsRepository.save(activityDetails);
		
		}		
		return createActivity;
		
	}
	
	@Override
	public Activity updateActivity(ActivityDTO activityDTO) {
		
		Activity updateActivity= new Activity();
		
		ActivityBuilder activityBuilder= new ActivityBuilder();
			
		Optional<Step> stepOption = this.stepRepository.findById(activityDTO.getStepId());
		
		if(stepOption.isPresent()) {
		
			activityBuilder.withSequenceAs(activityDTO.getSequence());
			activityBuilder.withActivityIdAs(activityDTO.getActivityId());
			activityBuilder.withActivityNameAs(activityDTO.getName());
			activityBuilder.withStepIdAs(stepOption.get());
			activityBuilder.withActionAs(activityDTO.getActions());
			activityBuilder.withRemarksAs(activityDTO.getRemarks());
			
			
			updateActivity = activityBuilder.build();
			
			updateActivity = this.activityRepository.save(updateActivity);
			
			this.activityRepository.flush();	
			
			ActivityDetails activityDetails = new ActivityDetails();
			activityDetails.setActivity(updateActivity);
			activityDetails.setActivityDetailsId(activityDTO.getActivityId());			
			
			this.activityDetailsRepository.save(activityDetails);		
					
		
		}		
		return updateActivity;		
	}
	
	@Override
	public void deleteActivity(ActivityDTO activityDTO) {
		
		Activity deleteActivity= new Activity();
				
		Optional<Step> stepOption = this.stepRepository.findById(activityDTO.getStepId());
		
		if(stepOption.isPresent()) {
		
			deleteActivity.setActivityId(activityDTO.getActivityId());
			
			this.activityRepository.delete(deleteActivity);
			
			this.activityRepository.flush();	
			
			ActivityDetails activityDetails = new ActivityDetails();
			activityDetails.setActivity(deleteActivity);
			activityDetails.setActivityDetailsId(activityDTO.getActivityId());			
			
			this.activityDetailsRepository.delete(activityDetails);						
		
		}		
	}
}