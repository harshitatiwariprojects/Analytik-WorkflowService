package org.analytik.workflow.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.analytik.workflow.dto.WorkflowDTO;
import org.analytik.workflow.dto.WorkflowDetailsDTO;
import org.analytik.workflow.model.Workflow;
import org.analytik.workflow.model.WorkflowDetails;
import org.analytik.workflow.service.WorkflowService;
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
public class WorkflowController {
	
	@Autowired
    private final WorkflowService workflowService;

    public WorkflowController(WorkflowService workflowService) {

        this.workflowService = workflowService;
    }

    
    @GetMapping(value = "/createWorkflow.htm")
    public String createWorkflow(HttpServletRequest request, HttpServletResponse response, Model model) {

        String workflowData = null;
        
        WorkflowDTO workflowDTO = new WorkflowDTO();
        
        if(request.getParameter("workflow_id")!= null) {
        	
        	workflowDTO.setWorkflowId(Integer.parseInt(request.getParameter("workflow_id")));
        	workflowDTO.setName(request.getParameter("name"));
        	workflowDTO.setType(request.getParameter("type"));
        
        }
        
        Workflow workflow = this.workflowService.createWorkflow(workflowDTO);
               
	        if(workflow != null) {
	        	
	        	workflowData = workflow.toString();
	        	response.setStatus(200);
	        } else{	            
	        	  response.setStatus(500);
	        }

        return new Gson().toJson(workflowData);
    }
    
    @GetMapping(value = "/createWorkflowDetails.htm")
    public String createWorkflowDetails(HttpServletRequest request, HttpServletResponse response, Model model) {
    	
        String workflowDetailsData = null;
        WorkflowDetailsDTO workflowDetailsDTO = new WorkflowDetailsDTO();
        SimpleDateFormat format = new SimpleDateFormat();
        
        if(request.getParameter("workflow_id") != null) {
        	
        	workflowDetailsDTO.setWorkflowDetailsId(Integer.parseInt(request.getParameter("workflowDetailsId")));
        	workflowDetailsDTO.setWorkflowId(Integer.parseInt(request.getParameter("workflow_id")));
        	workflowDetailsDTO.setStatus(request.getParameter("status"));
        	workflowDetailsDTO.setUserId(Integer.parseInt(request.getParameter("user_id")));
        	
        	if(request.getParameter("startTime") != null) {
        		
        		format.applyPattern("dd-MM-yyyy HH:mm:ss");
        		Date startTime;
        		
        		try {
					
        			startTime = format.parse(request.getParameter("startTime"));
					
					workflowDetailsDTO.setStartTime(startTime);
		    		
				} catch (ParseException e) {
					
					e.printStackTrace();
				}  		
        	}
        	
        	if(request.getParameter("endTime") != null) {
        		
        		format.applyPattern("dd-MM-yyyy HH:mm:ss");
        		Date endTime;
        		
        		try {
        			endTime = format.parse(request.getParameter("endTime"));
        			
        			workflowDetailsDTO.setEndTime(endTime);
        			
        		} catch(ParseException e) {
        			e.printStackTrace();
        		}
        	}
        }
        	WorkflowDetails workflowDetails = this.workflowService.createWorkflowDetails(workflowDetailsDTO);
        	      	
        	if(workflowDetails != null) {
        		
        		workflowDetailsData = workflowDetails.toString();
        		response.setStatus(200);
        		
        	} else {
        		response.setStatus(500);
        	}
        	
        return new Gson().toJson(workflowDetailsData);
    }
    
    
    @GetMapping(value = "/workflow.htm")
    public String getWorkflow(HttpServletRequest request, HttpServletResponse response, Model model) {

        String workflowKey = request.getParameter("workflowDetailsId");
        
        String workflowData = null;

        Optional<Workflow> workflowOption = this.workflowService.getWorkflowById(Integer.parseInt(workflowKey));

        if(workflowOption.isPresent()){
        	workflowData = workflowOption.get().toString();
            response.setStatus(200);
        }else{
            response.setStatus(500);
        }
        
        return new Gson().toJson(workflowData);
    }   
    
    @GetMapping(value = "/allWorkflow.htm")
    public String getAllWorkflow(HttpServletRequest request, HttpServletResponse response, Model model) {

        String workflowData = null;

        List<Workflow> workflowList = this.workflowService.getAllWorkflow();

        if(!workflowList.isEmpty()){
        	workflowData = new Gson().toJson(workflowList);
            response.setStatus(200);
        }else{
        	workflowData = new Gson().toJson(new ArrayList<Workflow>());
            response.setStatus(500);
        }


        return workflowData;
    }
    
    @GetMapping(value = "/workflowDetails.htm")
    public String getWorkflowDetails(HttpServletRequest request, HttpServletResponse response, Model model) {

        String detailsKey = request.getParameter("workflowDetailsId");
        
        String detailsData = null;

        Optional<WorkflowDetails> detailsOption = this.workflowService.getWorkflowDetailsById(Integer.parseInt(detailsKey));

        if(detailsOption.isPresent()){
        	detailsData = detailsOption.get().toString();
            response.setStatus(200);
        }else{
            response.setStatus(500);
        }
        
        return new Gson().toJson(detailsData);
    }   
    
    @GetMapping(value = "/allWorkflowDetails.htm")
    public String getAllWorkflowDetails(HttpServletRequest request, HttpServletResponse response, Model model) {

        String detailsData = null;

        List<WorkflowDetails> detailsList = this.workflowService.getAllWorkflowDetails();

        if(!detailsList.isEmpty()){
        	detailsData = new Gson().toJson(detailsList);
            response.setStatus(200);
        }else{
        	detailsData = new Gson().toJson(new ArrayList<WorkflowDetails>());
            response.setStatus(500);
        }

        return detailsData;
    }

}