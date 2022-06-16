package ca.nl.cna.java3.java3termproject.controller;

import ca.nl.cna.java3.java3termproject.dao.Education;
import ca.nl.cna.java3.java3termproject.dao.EducationRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Optional;

/**
 * THe main controller for the course project
 *
 * This will handel request for Education now.
 *
 * TO// Consider using 3 different controllers
 */
@RestController
@RequestMapping(path = "/api")
public class MainController {

    //Constanst used in REST API definition
    public static final String VERSION_1 = "/v1";
    public static final String EDUCATION = "/educations";


    @Autowired // This links this to the database
    private EducationRepository educationRepository;

    @GetMapping(path = VERSION_1 + EDUCATION)
    public @ResponseBody
    Iterable<Education> getAllEducation() { return educationRepository.findAll(); }

    @GetMapping(path = VERSION_1 + EDUCATION + "/{id}")
    public  @ResponseBody
    Optional<Education> getEductionWithID(@PathVariable Integer id) { return educationRepository.findById(id); }


    /**
     * Add a new education to the resume
     * @param id
     * @param title
     * @param institutionName
     * @param gradYear
     * @param startDate
     * @param endDate
     * @param abbreviation
     * @return
     */
    @PostMapping(path = VERSION_1 + EDUCATION)
    public @ResponseBody
    String addNewEducation(@RequestParam Integer id, @RequestParam String title,
                           @RequestParam String institutionName, @RequestParam Integer gradYear,
                           @RequestParam LocalDate startDate, @RequestParam LocalDate endDate,
                           @RequestParam String abbreviation){




        Education education = new Education();
        //education.setId(id);
        education.setTitle(title);
        education.setInstitutionName(institutionName);
        education.setGradYear(gradYear);
        education.setStartDate(startDate);
        education.setEndDate(endDate);
        education.setAbbreviation(abbreviation);

        //Education
        educationRepository.save(education);
        return "Saved";
    }
}
