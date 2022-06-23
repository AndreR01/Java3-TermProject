package ca.nl.cna.java3.java3termproject.dao;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
@Entity(name = "skill")
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String type;

    /**
     * Get an id for a Skills object.
     *
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set an id for a Skills object.
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get a name for a Skills object.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set a name for a Skills object.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get a type for a Skills object.
     *
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Set a type for a Skills object.
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }
}
