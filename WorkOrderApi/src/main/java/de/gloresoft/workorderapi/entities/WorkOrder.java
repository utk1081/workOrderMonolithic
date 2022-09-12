package de.gloresoft.workorderapi.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class WorkOrder {

    @Id
    private Long id;
    private String employeeName;
    private String projectNumber;
    private String emailId;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private Integer workingDays;

    public WorkOrder() {
    }
    public WorkOrder(Long id, String employeeName, String projectNumber, String emailId, LocalDate dateFrom, LocalDate dateTo, Integer workingDays) {
        this.id = id;
        this.employeeName = employeeName;
        this.projectNumber = projectNumber;
        this.emailId = emailId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.workingDays = workingDays;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
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

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public Integer getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(Integer workingDays) {
        this.workingDays = workingDays;
    }

}
