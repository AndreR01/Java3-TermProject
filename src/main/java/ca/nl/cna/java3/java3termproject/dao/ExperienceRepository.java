package ca.nl.cna.java3.java3termproject.dao;

import org.springframework.data.repository.CrudRepository;

/**
 * Java 3 CP3566 Spring 2022
 *
 * Experience repository that extends CrudRepository.
 *
 * @author Andre
 */
public interface ExperienceRepository extends CrudRepository<Experience, Integer> {

    /* If we need specialized queries beyond those included in the CrudRepository we can
     engage here or in the repository interfaces.
     But we only need CRUD so don't populate this interface
    */

}
