package org.analytik.workflow.service;

import java.util.List;
import java.util.Optional;

import org.analytik.workflow.dto.StepDTO;
import org.analytik.workflow.dto.StepDetailsDTO;
import org.analytik.workflow.model.Step;
import org.analytik.workflow.model.StepDetails;
/**
 * 
 * @author Harshita Tiwari
 * Copyright 2020 by Harshita Tiwari. All rights reserved.
 *
 */

public interface StepService {

    public Optional<Step> getStepById(int step_id) ;

    public List<Step> getAllStep();

    public Optional<StepDetails> getStepDetailsById(int stepDetailsId);

    public List<StepDetails> getAllStepDetails();

    public Step createStep(StepDTO stepDTO);
    
    public StepDetails createStepDetails(StepDetailsDTO stepDetailsDTO);

}
