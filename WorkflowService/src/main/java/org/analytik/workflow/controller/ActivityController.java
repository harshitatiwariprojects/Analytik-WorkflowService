package org.analytik.workflow.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.analytik.workflow.dto.ActivityDTO;
import org.analytik.workflow.dto.ActivityDetailsDTO;
import org.analytik.workflow.model.Activity;
import org.analytik.workflow.model.ActivityDetails;
import org.analytik.workflow.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

/**
 * 
 * @author Harshita Tiwari
 * Copyright 2020 by Harshita Tiwari. All rights reserved.
 *
 */

@RequestMapping("analytik")
@RestController
public class ActivityController {

	@Autowired
    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {

        this.activityService = activityService;
    }
    
    @GetMapping(value = "/createActivityDetails.htm")
    public String createActivityDetails(HttpServletRequest request, HttpServletResponse response, Model model) {   
              
        String activityData = null;
        
        ActivityDetailsDTO activityDetailsDTO = new ActivityDetailsDTO();
        
        SimpleDateFormat format = new SimpleDateFormat();
        
        if(request.getParameter("sequence") != null) {
        	
        	activityDetailsDTO.setActivityDetailsId(Integer.parseInt(request.getParameter("activityDetailsId")));
	        activityDetailsDTO.setStatus(request.getParameter("status"));
	        activityDetailsDTO.setActivityId(Integer.parseInt(request.getParameter("activityId")));
	        activityDetailsDTO.setUserId(Integer.parseInt(request.getParameter("user_id")));
	        activityDetailsDTO.setStepId(Integer.parseInt(request.getParameter("step_id")));
	        if(request.getParameter("startTime") != null) {
	        	
	        	format.applyPattern("dd-MM-yyyy HH:mm:ss");
	    		
	    		Date startTime;
				try {					
					startTime = format.parse(request.getParameter("startTime"));
					
		    		activityDetailsDTO.setStartTime(startTime);
		    		
				} catch (ParseException e) {
					
					e.printStackTrace();
				}  		
	    	}
	        
	        if(request.getParameter("endTime") != null) {
	        	
	        	format.applyPattern("dd-MM-yyyy HH:mm:ss");
	    		
	    		Date endTime;
				
	    		try {					
					endTime = format.parse(request.getParameter("endTime"));
					
		    		activityDetailsDTO.setEndTime(endTime);
		    		
				} catch (ParseException e) {
					
					e.printStackTrace();
				}	
	        }	        
        }
        
        ActivityDetails activityDetails = this.activityService.createActivityDetails(activityDetailsDTO);	
        
        if(activityDetails != null){
            activityData = activityDetails.toString();
            response.setStatus(200);
        } else{
            response.setStatus(500);
        }
        
        return new Gson().toJson(activityData);
        
    }
    
    @GetMapping(value = "/createActivity.htm")
    public String createActivity(HttpServletRequest request, HttpServletResponse response, Model model) {

        String activityData = null;
        
        ActivityDTO activityDTO = new ActivityDTO();
        
        if(request.getParameter("sequence") != null) {
        	
	        activityDTO.setSequence(Integer.parseInt(request.getParameter("sequence")));
	        activityDTO.setName(request.getParameter("activityName"));
	        activityDTO.setActivityId(Integer.parseInt(request.getParameter("activity_id")));
	        activityDTO.setActions(request.getParameter("actions"));
	        activityDTO.setRemarks(request.getParameter("remarks").charAt(0));
	        activityDTO.setStepId(Integer.parseInt(request.getParameter("step_id")));
	      	
		} 
        
        Activity activity = this.activityService.createActivity(activityDTO);

        if(activity != null){
            activityData = activity.toString();
            response.setStatus(200);
        } else{
            response.setStatus(500);
        }

        return new Gson().toJson(activityData);
    }

   
    @GetMapping(value = "/updateActivity.htm")
    public String updateActivity(HttpServletRequest request, HttpServletResponse response, Model model) {

        ActivityDTO activityDTO = new ActivityDTO();
             
        if(request.getParameter("sequence") != null) {
        	
	        activityDTO.setSequence(Integer.parseInt(request.getParameter("sequence")));
	        activityDTO.setName(request.getParameter("activityName"));
	        activityDTO.setActivityId(Integer.parseInt(request.getParameter("activity_id")));
	        activityDTO.setActions(request.getParameter("actions"));
	        activityDTO.setRemarks(request.getParameter("remarks").charAt(0));
	        activityDTO.setStepId(Integer.parseInt(request.getParameter("step_id")));
	      	
		} 
        
        Activity activity = this.activityService.createActivity(activityDTO);
        String activityData = null;

        if(activity != null){
            activityData = activity.toString();
            response.setStatus(200);
        } else{
            response.setStatus(500);
        }
        
        return new Gson().toJson(activityData);
    	
    }
    
    
    @GetMapping(value = "/activity.htm")
    public String getActivity(HttpServletRequest request, HttpServletResponse response, Model model) {

        String activityKey = request.getParameter("activity_id");
        
        String activityData = null;

        Optional<Activity> activityOption = this.activityService.getActivityById(Integer.parseInt(activityKey));

        if(activityOption.isPresent()){
            activityData = activityOption.get().toString();
            response.setStatus(200);
        }else{
            response.setStatus(500);
        }

        return new Gson().toJson(activityData);
    }

    @GetMapping(value = "/allActivity.htm")
    public String getAllActivity(HttpServletRequest request, HttpServletResponse response, Model model) {

        String activityData = null;

        List<Activity> activityList = this.activityService.getAllActivity();

        if(!activityList.isEmpty()){
            activityData = new Gson().toJson(activityList);
            response.setStatus(200);
        }else{
            activityData = new Gson().toJson(new ArrayList<Activity>());
            response.setStatus(500);
        }

        return activityData;
    }

    @GetMapping(value = "/activityDetails.htm")
    public String getActivityDetails(HttpServletRequest request, HttpServletResponse response, Model model) {

        String detailsKey = request.getParameter("activityDetailsId");
        
        String detailsData = null;

        Optional<ActivityDetails> detailsOption = this.activityService.getActivityDetailsById(Integer.parseInt(detailsKey));

        if(detailsOption.isPresent()){
        	detailsData = detailsOption.get().toString();
            response.setStatus(200);
        }else{
            response.setStatus(500);
        }

        return new Gson().toJson(detailsData);
    }


    @GetMapping(value = "/allActivityDetails.htm")
    public String getAllActivityDetails(HttpServletRequest request, HttpServletResponse response, Model model) {

        String detailsData = null;

        List<ActivityDetails> detailsList = this.activityService.getAllActivityDetails();

        if(!detailsList.isEmpty()){
            detailsData = new Gson().toJson(detailsList);
            response.setStatus(200);
        }else{
            detailsData = new Gson().toJson(new ArrayList<ActivityDetails>());
            response.setStatus(500);
        }

        return detailsData;
      }
}