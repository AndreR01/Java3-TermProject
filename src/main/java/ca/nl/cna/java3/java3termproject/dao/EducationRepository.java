package ca.nl.cna.java3.java3termproject.dao;

import org.hibernate.integrator.spi.Integrator;
import org.springframework.data.repository.CrudRepository;

public interface EducationRepository extends CrudRepository<Education, Integer> {

    /* If we need specialized queries beyond those inclued in the CrudRepository we can
     engage her or in the repository interfaces.
     But we only need CRUD so don't populate this interface
    */
}
