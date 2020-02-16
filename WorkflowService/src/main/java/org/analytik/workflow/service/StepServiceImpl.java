package org.analytik.workflow.service;

import java.util.List;
import java.util.Optional;

import org.analytik.workflow.builder.StepBuilder;
import org.analytik.workflow.dto.StepDTO;
import org.analytik.workflow.dto.StepDetailsDTO;
import org.analytik.workflow.model.Step;
import org.analytik.workflow.model.StepDetails;
import org.analytik.workflow.model.User;
import org.analytik.workflow.model.Workflow;
import org.analytik.workflow.repository.StepDetailsRepository;
import org.analytik.workflow.repository.StepRepository;
import org.analytik.workflow.repository.UserRepository;
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
public class StepServiceImpl implements StepService{

	@Autowired
	private WorkflowRepository workflowRepository;
	
	@Autowired
	private StepRepository stepRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StepDetailsRepository stepDetailsRepository;
	
	@Override
	public Optional<Step> getStepById(int stepId) {

		return this.stepRepository.findById(stepId);
	}

	@Override
	public List<Step> getAllStep() {

		return this.stepRepository.findAll();
	}
	
	
	@Override
	public Optional<StepDetails> getStepDetailsById(int stepDetailsId) {

		return this.stepDetailsRepository.findById(stepDetailsId);
	}

	@Override
	public List<StepDetails> getAllStepDetails() {

		return this.stepDetailsRepository.findAll();
	}
	
	
	@Override
	public Step createStep(StepDTO stepDTO) {
		
		Step step = new Step();
		
		StepBuilder stepBuilder = new StepBuilder();
				
		Optional<Workflow> workflowOption = this.workflowRepository.findById(stepDTO.getWorkflowId());
		
		if(workflowOption.isPresent()) {
			
			stepBuilder.withStepIdAs(stepDTO.getStepId());
			stepBuilder.withNameAs(stepDTO.getName());
			stepBuilder.withSequenceAs(stepDTO.getSequence());
			stepBuilder.withWorkflowIdAs(workflowOption.get());
			
			step= stepBuilder.build();
			
			step= this.stepRepository.save(step);
			this.stepRepository.flush();
			
			StepDetails stepDetails = new StepDetails();
			stepDetails.setStepDetailsId(stepDTO.getStepId());
			stepDetails.setStep(step);
			
			this.stepDetailsRepository.save(stepDetails);
					
		}		
		return step;
	}
	

	@Override
	public StepDetails createStepDetails(StepDetailsDTO stepDetailsDTO) {
		
		StepDetails stepDetails = new StepDetails();
		
		Optional<Step> stepOption= this.stepRepository.findById(stepDetailsDTO.getStepId());
		Optional<User> userOption= this.userRepository.findById(stepDetailsDTO.getUserId());

		if(stepOption.isPresent() && userOption.isPresent()) {
			
			stepDetails.setStepDetailsId(stepDetailsDTO.getStepDetailsId());
			stepDetails.setStatus(stepDetailsDTO.getStatus());
			stepDetails.setStartTime(stepDetailsDTO.getStartTime());
			stepDetails.setEndTime(stepDetailsDTO.getEndTime());
			stepDetails.setStep(stepOption.get());
			stepDetails.setUser(userOption.get());
			
			stepDetails = this.stepDetailsRepository.save(stepDetails); 
			this.stepDetailsRepository.flush();
		
		}		
		return stepDetails;
	}		
		
}