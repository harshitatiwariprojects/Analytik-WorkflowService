package org.analytik.workflow.repository;

import org.analytik.workflow.model.ActivityDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * 
 * @author Harshita Tiwari
 * Copyright 2020 by Harshita Tiwari. All rights reserved.
 *
 */

@Repository
public interface ActivityDetailsRepository extends JpaRepository<ActivityDetails,Integer>{

}
