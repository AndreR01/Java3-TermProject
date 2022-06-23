package ca.nl.cna.java3.java3termproject.dao;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Simple class to represent a student's experience. This class
 * represents a single instance. Students may have many of these
 *
 * Experience has the following attributes:
 *  - ID - for DB purposes, primary key
 *  - Start Date - when the program started
 *  - End Date -  when the program ended
 *  - Job Title -  the job title ie "Work Term Student"
 *  - Company - name of company/employer/organisation
 *  - Description - description of role and responsibilities
 *
 *  Future considerations - degree type
 *
 * @author Andre
 */
@Entity(name = "experience")
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd") //yyyy-MM-dd
    private LocalDate startDate;

    @JsonFormat (pattern = "yyyy-MM-dd") //yyyy-MM-dd
    private LocalDate endDate;

    private String jobTitle;
    private String company;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}



