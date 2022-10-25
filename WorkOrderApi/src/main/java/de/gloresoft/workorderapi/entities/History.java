package de.gloresoft.workorderapi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class History {

    @Id
    @GeneratedValue
    private Long id;
    private String user;
    private String projectNumber;
    private String emailId;
    private LocalDateTime timestamp;
    private String action;

    public History() {
    }

    public History(Long id, String user, String projectNumber, String emailId, LocalDateTime timestamp, String action) {
        this.id = id;
        this.user = user;
        this.projectNumber = projectNumber;
        this.emailId = emailId;
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
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
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
