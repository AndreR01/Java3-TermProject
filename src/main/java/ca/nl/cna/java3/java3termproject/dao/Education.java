package ca.nl.cna.java3.java3termproject.dao;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Optional;

/**
 * Java 3 CP3566 Spring 2022
 *
 * Simple class to represent a student's education. This class
 * represents a single diploma, certificate or degree. Students
 * may have many of these
 *
 * Education has the following attributes:
 *  - ID - for DB purposes, primary key
 *  - Title -  program title ie "Accelerated Software Development"
 *  - School - name of institution, university, college or school
 *  - Grad year - year of the class ie "Class of 2022"
 *  - Start Date - when the program started
 *  - End Date -  when the program ended
 *  - Abbreviation - how the degree is denoted ie "ASD"
 *
 *  Future considerations - degree type
 *
 * @author Andre
 */
@Entity(name = "education")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;

    private String title;
    private String institutionName;
    private Integer gradYear;

    @JsonFormat(pattern="yyyy-MM-dd") //yyyy-MM-dd
    private LocalDate startDate;

    @JsonFormat(pattern="yyyy-MM-dd") //yyyy-MM-dd
    private LocalDate endDate;

    private String abbreviation;


    /**
     * Get id for Education object.
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }


    /**
     * Set id for Education object.
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get title for  Education object.
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set title for Education object.
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get institution name for Education object.
     *
     * @return institutionName
     */
    public String getInstitutionName() {
        return institutionName;
    }

    /**
     * Set institution name for Education object.
     *
     * @param institutionName
     */
    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    /**
     * Get graduation year for Education object.
     *
     * @return gradYear
     */
    public Integer getGradYear() {
        return gradYear;
    }

    /**
     * Set gradution year for Education object.
     *
     * @param gradYear
     */
    public void setGradYear(Integer gradYear) {
        this.gradYear = gradYear;
    }

    /**
     * Get start date for Education object.
     *
     * @return startDate
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Set start date for Education object.
     *
     * @param startDate
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * Get end date for Education object.
     *
     * @return endDate
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Set end date for Education object.
     *
     * @param endDate
     */
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    /**
     * Get abbreviation for Education object.
     *
     * @return abbreviation
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * Set abbreviation for Education object.
     *
     * @param abbreviation
     */
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
