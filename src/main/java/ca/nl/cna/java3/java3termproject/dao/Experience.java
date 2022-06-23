package ca.nl.cna.java3.java3termproject.dao;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Java 3 CP3566 Spring 2022
 *
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

    /**
     * Get id for an Experience object.
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set id for an Experience object.
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get a start date for an Experience object.
     *
     * @return startDate
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Set a start date for an Experience object.
     *
     * @param startDate
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * Get an end date for an Experience object.
     *
     * @return endDate
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Set an end date for an Experience object.
     *
     * @param endDate
     */
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    /**
     * Get a job title for an Experience object.
     *
     * @return jobTitle
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * Set a job title for an Experience object.
     *
     * @param jobTitle
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /**
     * Get a company for an Experience object.
     *
     * @return company
     */
    public String getCompany() {
        return company;
    }

    /**
     * Set a company for an Experience object.
     *
     * @param company
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * Get a description for an Experience object.
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set a description for an Experience object.
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}



