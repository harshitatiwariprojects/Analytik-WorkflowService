package org.analytik.workflow.model;

//3 USERS:
//admin - workflow
//executive	- step
//operator	-activity

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author HARSHITA TIWARI
 */
@Entity
@Table(name = "USER")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "USER_ID")
	private Integer userId;
    @Column(name = "USER_TYPE")
    private String userType;
	
    
    public User() {
    }

    public User(Integer userId) {
        this.userId = userId;
    }
    public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	@Override
	public int hashCode() {
		int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
	}
	
	@Override
	public boolean equals(Object other) {
		return (
        		(other instanceof User) && (this.userId != null && ((User)other).userId != null) 
        		&& (this.userId == ((User)other).userId)
        		);
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", user_type=" + userType + "]";
	}
    
}
