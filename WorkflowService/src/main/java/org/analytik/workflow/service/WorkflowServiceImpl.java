package org.analytik.workflow.service;

import java.util.List;
import java.util.Optional;

import org.analytik.workflow.builder.WorkflowBuilder;
import org.analytik.workflow.dto.WorkflowDTO;
import org.analytik.workflow.dto.WorkflowDetailsDTO;
import org.analytik.workflow.model.User;
import org.analytik.workflow.model.Workflow;
import org.analytik.workflow.model.WorkflowDetails;
import org.analytik.workflow.repository.UserRepository;
import org.analytik.workflow.repository.WorkflowDetailsRepository;
import org.analytik.workflow.repository.WorkflowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 
 * @author Harshita Tiwari
 * Copyright 2020 by Harshita Tiwari. All rights reserved.
 *
 */

@Service
public class WorkflowServiceImpl implements WorkflowService{
	
	@Autowired
	private WorkflowRepository workflowRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Optional<Workflow> getWorkflowById(int workflowId) {

		return this.workflowRepository.findById(workflowId);
	}

	@Autowired
	private WorkflowDetailsRepository workflowDetailsRepository;
	
	@Override
	public List<Workflow> getAllWorkflow() {

		return this.workflowRepository.findAll();
	}	
	
	@Override
	public Optional<WorkflowDetails> getWorkflowDetailsById(int workflowDetailsId) {

		return this.workflowDetailsRepository.findById(workflowDetailsId);
	}

	@Override
	public List<WorkflowDetails> getAllWorkflowDetails() {

		return this.workflowDetailsRepository.findAll();
	}
	
	@Override
	public Workflow createWorkflow(WorkflowDTO workflowDTO) {
		
		WorkflowBuilder workflowBuilder = new WorkflowBuilder();
		
		workflowBuilder.withWorkflowIdAs(workflowDTO.getWorkflowId());
		workflowBuilder.withWorkflowTypeAs(workflowDTO.getType());
		workflowBuilder.withNameAs(workflowDTO.getName());
		
		Workflow workflow = workflowBuilder.build();
		
		workflow = this.workflowRepository.save(workflow);
		this.workflowRepository.flush();
		
		WorkflowDetails workflowDetails = new WorkflowDetails();
		workflowDetails.setWorkflowDetailsId(workflowDTO.getWorkflowId());
		workflowDetails.setWorkflow(workflow);
		
		this.workflowDetailsRepository.save(workflowDetails);
		
		return workflow;
	}	
	
	@Override
	public WorkflowDetails createWorkflowDetails(WorkflowDetailsDTO workflowDetailsDTO) {
		
		WorkflowDetails workflowDetails = new WorkflowDetails(); 
		
		Optional<Workflow> workflowOption = this.workflowRepository.findById(workflowDetailsDTO.getWorkflowId());
		Optional<User> userOption= this.userRepository.findById(workflowDetailsDTO.getUserId());

		if(workflowOption.isPresent() && userOption.isPresent()) {
						
			workflowDetails.setWorkflowDetailsId(workflowDetailsDTO.getWorkflowDetailsId());
			workflowDetails.setStatus(workflowDetailsDTO.getStatus());
			workflowDetails.setStartTime(workflowDetailsDTO.getStartTime());
			workflowDetails.setEndTime(workflowDetailsDTO.getEndTime());
			workflowDetails.setWorkflow(workflowOption.get());
			workflowDetails.setUser(userOption.get());
			
			workflowDetails = this.workflowDetailsRepository.save(workflowDetails);
			this.workflowDetailsRepository.flush();
		}
		
		return workflowDetails;
	}
	
}
