package org.analytik.workflow.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.analytik.workflow.dto.StepDTO;
import org.analytik.workflow.dto.StepDetailsDTO;
import org.analytik.workflow.model.Step;
import org.analytik.workflow.model.StepDetails;
import org.analytik.workflow.service.StepService;
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
public class StepController {
	
	@Autowired
    private final StepService stepService;

    public StepController(StepService stepService) {

        this.stepService = stepService;
    }
    
    @GetMapping(value = "/createStep.htm")
    public String createStep(HttpServletRequest request, HttpServletResponse response, Model model) {
              
        StepDTO stepDTO = new StepDTO();
        
        if(request.getParameter("sequence")!= null) {
        	stepDTO.setStepId(Integer.parseInt(request.getParameter("step_id")));
        	stepDTO.setSequence(Integer.parseInt(request.getParameter("sequence")));
        	stepDTO.setName(request.getParameter("name"));
        	stepDTO.setWorkflowId(Integer.parseInt(request.getParameter("workflow_id")));
        
        }
        
        Step step = this.stepService.createStep(stepDTO);
        String stepData = null;
      
	        if(step != null) {
	        	
	        	stepData = step.toString();
	        	response.setStatus(200);
	        	
	        } else{
	            
	        	  response.setStatus(500);
	        }

        return new Gson().toJson(stepData);
    }

    @GetMapping(value = "/createStepDetails.htm")
    public String createStepDetails(HttpServletRequest request, HttpServletResponse response, Model model) {
    	        
        String stepDetailsData = null;
        StepDetailsDTO stepDetailsDTO = new StepDetailsDTO();
        SimpleDateFormat format = new SimpleDateFormat();
        
        if(request.getParameter("sequence") != null) {
        	
        	stepDetailsDTO.setStepDetailsId(Integer.parseInt(request.getParameter("stepDetailsId")));
        	stepDetailsDTO.setStepId(Integer.parseInt(request.getParameter("step_id")));
        	stepDetailsDTO.setStatus(request.getParameter("status"));
        	stepDetailsDTO.setUserId(Integer.parseInt(request.getParameter("user_id")));
        	
        	if(request.getParameter("startTime") != null) {
        		
        		format.applyPattern("dd-MM-yyyy HH:mm:ss");
        		Date startTime;
        		
        		try {
					
        			startTime = format.parse(request.getParameter("startTime"));
					
        			stepDetailsDTO.setStartTime(startTime);
		    		
				} catch (ParseException e) {
					
					e.printStackTrace();
				}  		
        	}
        	
        	if(request.getParameter("endTime") != null) {
        		
        		format.applyPattern("dd-MM-yyyy HH:mm:ss");
        		Date endTime;
        		
        		try {
        			endTime = format.parse(request.getParameter("endTime"));
        			
        			stepDetailsDTO.setEndTime(endTime);
        			
        		} catch(ParseException e) {
        			e.printStackTrace();
        		}
        	}
        }
        
        StepDetails stepDetails = this.stepService.createStepDetails(stepDetailsDTO);
               
        if(stepDetails != null) {
        	stepDetailsData = stepDetails.toString();
        	response.setStatus(200);
        } else {
        	response.setStatus(500);
        }
        
        return new Gson().toJson(stepDetailsData);
        
    }
    
    
    @GetMapping(value = "/step.htm")
    public String getstep(HttpServletRequest request, HttpServletResponse response, Model model) {

        String stepKey = request.getParameter("step_id");        
        
        Optional<Step> stepOption = this.stepService.getStepById(Integer.parseInt(stepKey));
        
        String stepData = null;
	
        if(stepOption.isPresent()){
            stepData = stepOption.get().toString();
            response.setStatus(200);
        }else{
            response.setStatus(500);
        }

        return new Gson().toJson(stepData);
    }   
    
    @GetMapping(value = "/allStep.htm")
    public String getAllStep(HttpServletRequest request, HttpServletResponse response, Model model) {

        String stepData = null;

        List<Step> stepList = this.stepService.getAllStep();

        if(!stepList.isEmpty()){
        	stepData = new Gson().toJson(stepList);
            response.setStatus(200);
        }else{
        	stepData = new Gson().toJson(new ArrayList<Step>());
            response.setStatus(500);
        }

        return stepData;
    }
    
    @GetMapping(value = "/stepDetails.htm")
    public String getstepDetails(HttpServletRequest request, HttpServletResponse response, Model model) {

        String detailsKey = request.getParameter("stepDetailsId");
        
        String detailsData = null;

        Optional<StepDetails> detailsOption = this.stepService.getStepDetailsById(Integer.parseInt(detailsKey));

        if(detailsOption.isPresent()){
            detailsData = detailsOption.get().toString();
            response.setStatus(200);
        }else{
            response.setStatus(500);
        }

        return new Gson().toJson(detailsData);
    }  
    
    @GetMapping(value = "/allStepDetails.htm")
    public String getAllStepDetails(HttpServletRequest request, HttpServletResponse response, Model model) {

        String detailsData = null;

        List<StepDetails> detailsList = this.stepService.getAllStepDetails();

        if(!detailsList.isEmpty()){
        	detailsData = new Gson().toJson(detailsList);
            response.setStatus(200);
        }else{
        	detailsData = new Gson().toJson(new ArrayList<Step>());
            response.setStatus(500);
        }

        return detailsData;
    }
}