package ca.nl.cna.java3.java3termproject.dao;

import org.springframework.data.repository.CrudRepository;

public interface ExperienceRepository extends CrudRepository<Experience, Integer> {

    /* If we need specialized queries beyond those included in the CrudRepository we can
     engage here or in the repository interfaces.
     But we only need CRUD so don't populate this interface
    */

}
