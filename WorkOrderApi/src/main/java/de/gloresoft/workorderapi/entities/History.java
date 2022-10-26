package de.gloresoft.workorderapi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String projectNumber;
    private String emailId;
    private LocalDateTime timestamp;
    private String action;

    public History() {
    }

    public History(Long id, String username, String projectNumber, String emailId, LocalDateTime timestamp, String action) {
        this.id = id;
        this.username = username;
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

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        History history = (History) o;
        return Objects.equals(username, history.username) && Objects.equals(projectNumber, history.projectNumber) && Objects.equals(emailId, history.emailId) && Objects.equals(timestamp, history.timestamp) && Objects.equals(action, history.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, projectNumber, emailId, timestamp, action);
    }
}
