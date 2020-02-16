package org.analytik.workflow.service;

import java.util.List;
import java.util.Optional;

import org.analytik.workflow.dto.WorkflowDTO;
import org.analytik.workflow.dto.WorkflowDetailsDTO;
import org.analytik.workflow.model.Workflow;
import org.analytik.workflow.model.WorkflowDetails;
/**
 * 
 * @author Harshita Tiwari
 * Copyright 2020 by Harshita Tiwari. All rights reserved.
 *
 */

public interface WorkflowService {

    public Optional<Workflow> getWorkflowById(int workflow_id) ;

    public List<Workflow> getAllWorkflow();

    public Optional<WorkflowDetails> getWorkflowDetailsById(int workflowDetailsId);

    public List<WorkflowDetails> getAllWorkflowDetails();

    public Workflow createWorkflow(WorkflowDTO workflowDTO);
    
    public WorkflowDetails createWorkflowDetails(WorkflowDetailsDTO workflowDetailsDTO);

}