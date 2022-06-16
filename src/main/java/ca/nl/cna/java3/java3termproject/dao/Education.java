package ca.nl.cna.java3.java3termproject.dao;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Simple class to represent a student's education. This clas
 * represents a single diploma, certificat or degree. Students
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
@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;
    private String institutionName;
    private Integer gradYear;

    @JsonFormat(pattern="yyyy-MM-dd") //yyyy-MM_dd
    private LocalDate startDate;

    @JsonFormat(pattern="yyyy-MM-dd") //yyyy-MM_dd
    private LocalDate endDate;

    private String abbreviation;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public Integer getGradYear() {
        return gradYear;
    }

    public void setGradYear(Integer gradYear) {
        this.gradYear = gradYear;
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

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
