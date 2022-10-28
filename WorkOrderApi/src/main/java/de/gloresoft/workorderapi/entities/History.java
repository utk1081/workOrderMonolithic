package de.gloresoft.workorderapi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
public class History {

    
    //@GeneratedValue
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
    private Long id;
    private String user;
    private String projectNumber;
    private String email_Id;
    private Timestamp timestamp;
    private String action;

    public History() {
    }

    public History(Long id, String user, String projectNumber, String emailId, Timestamp timestamp, String action) {
        this.id = id;
        this.user = user;
        this.projectNumber = projectNumber;
        this.email_Id = emailId;
        this.timestamp = timestamp;
        this.action = action;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp2) {
        this.timestamp = timestamp2;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber;
    }

    public String getEmailId() {
        return email_Id;
    }

    public void setEmailId(String emailId) {
        this.email_Id = emailId;
    }
}
