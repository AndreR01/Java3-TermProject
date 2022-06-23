package ca.nl.cna.java3.java3termproject.dao;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
@Entity(name = "skill")
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
