package org.analytik.workflow.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * 
 * @author Harshita Tiwari
 * Copyright 2020 by Harshita Tiwari. All rights reserved.
 *
 */
@Entity
@Table(name = "ACTIVITY_DETAILS")
public class ActivityDetails implements Serializable {
 
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "ACTIVITY_DETAILS_ID")
    private Integer activityDetailsId;
    @Column(name = "START_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @Column(name = "END_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    @Column(name = "STATUS")
    private String status;
    @JoinColumn(name = "ACTIVITY_ID", referencedColumnName = "ACTIVITY_ID")
    @ManyToOne(optional = false)
    private Activity activity;
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @ManyToOne(optional = false)
    private User user;

    public ActivityDetails() {
    }

    public ActivityDetails(Integer activityDetailsId) {
        this.activityDetailsId = activityDetailsId;
    }

    public Integer getActivityDetailsId() {
        return activityDetailsId;
    }

    public void setActivityDetailsId(Integer activityDetailsId) {
        this.activityDetailsId = activityDetailsId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
    	return user;
    }
    
    public void setUser(User user) {
    	this.user = user;
    }
    
    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (activityDetailsId != null ? activityDetailsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object other) {
        
    	return (
        		(other instanceof ActivityDetails) && (this.activityDetailsId != null && ((ActivityDetails)other).activityDetailsId != null) 
        		&& (this.activityDetailsId == ((ActivityDetails)other).activityDetailsId)
        		);
    }

	@Override
	public String toString() {
		return "ActivityDetails [activityDetailsId=" + activityDetailsId + ", startTime=" + startTime + ", endTime="
				+ endTime + ", status=" + status + ", activity=" + activity + ", user=" + user + "]";
	}
	
}
