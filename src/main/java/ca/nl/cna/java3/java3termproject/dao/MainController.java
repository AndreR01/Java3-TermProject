package ca.nl.cna.java3.java3termproject.dao;


import ca.nl.cna.java3.java3termproject.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

/**
 * Java 3 CP3566 Spring 2022
 *
 * The main controller for the course project
 *
 * This will handle GET, POST, PUT & DELETE requests for Education, Experience and Skills.
 *
 * @author Andre
 */
//TODO Consider using 3 different controllers
@RestController
@RequestMapping(path = "/api")
public class MainController {

    //Constants used in REST API definition
    public static final String API_ROOT_PATH = "/api";
    public static final String VERSION_1 = "/v1";
    public static final String EDUCATION = "/educations";
    public static final String EXPERIENCE = "/experience";
    public static final String SKILLS = "/skills";

    //Education
    /**
     * Enables automatic dependency injection for Education.
     */
    @Autowired // This links this to the database
    private EducationRepository educationRepository;

    /**
     * HTTP GET request for all Education.
     *
     * @return educationRepository.findAll()
     */
    @GetMapping(path = VERSION_1 + EDUCATION)
    public @ResponseBody
    Iterable<Education> getAllEducation() {
        String name = "Test";
        return educationRepository.findAll();
    }

    /**
     * HTTP GET request for Education by entered id.
     *
     * @param id
     * @return educationRepository.findById(id)
     */
    @GetMapping(path = VERSION_1 + EDUCATION + "/{id}")
    public @ResponseBody
    Optional<Education> getEductionWithID(@PathVariable Integer id) {
        String name = "Test";
        return educationRepository.findById(id);
    }

    /**
     * HTTP POST request for a new Education entry.
     *
     * @param title
     * @param institutionName
     * @param gradYear
     * @param startDate
     * @param endDate
     * @param abbreviation
     * @return Education saved
     */
    @PostMapping(path = VERSION_1 + EDUCATION)
    public @ResponseBody
    String addNewEducation(@RequestParam String title,
                           @RequestParam String institutionName, @RequestParam Integer gradYear,
                           @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                           @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
                           @RequestParam String abbreviation) {


        Education education = new Education();
        education.setTitle(title);
        education.setInstitutionName(institutionName);
        education.setGradYear(gradYear);
        education.setStartDate(startDate);
        education.setEndDate(endDate);
        education.setAbbreviation(abbreviation);
        educationRepository.save(education);
        return "Education saved";
    }

    /**
     * HTTP PUT request for an updated Education entry.
     *
     * @param title
     * @param institutionName
     * @param gradYear
     * @param startDate
     * @param endDate
     * @param abbreviation
     * @return Education updated OR Fail - no experience to update
     */
    @PutMapping(path = VERSION_1 + EDUCATION)
    public @ResponseBody
    String updateEducation(@RequestParam Integer id, @RequestParam String title,
                           @RequestParam String institutionName, @RequestParam Integer gradYear,
                           @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                           @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
                           @RequestParam String abbreviation) {

        Optional<Education> optionalEducation = educationRepository.findById(id);

        if (optionalEducation.isPresent()) {
            Education education = optionalEducation.get();
            education.setTitle(title);
            education.setInstitutionName(institutionName);
            education.setGradYear(gradYear);
            education.setStartDate(startDate);
            education.setEndDate(endDate);
            education.setAbbreviation(abbreviation);
            educationRepository.save(education);
            return "Education updated";
        } else {
            addNewEducation(title, institutionName, gradYear, startDate, endDate, abbreviation);
            //TODO if we add a new row. The return fail is redundant?
            return "Education did not exist. Added as a new Education";
        }
    }

    /**
     * HTTP DELETE request to delete an Education entry by id.
     *
     * @param id
     * @return Education deleted
     */
    @DeleteMapping(path = VERSION_1 + EDUCATION)
    public @ResponseBody
    String deleteEducation(@RequestParam Integer id) {
        educationRepository.deleteById(id);
        return "Education deleted";
    }



    //Experience
    /**
     * Enables automatic dependency injection for Experience.
     */
    @Autowired // This links this to the database
    private ExperienceRepository experienceRepository;

    /**
     * HTTP GET request for all Experience.
     *
     * @return experienceRepository.finaAll()
     */
    @GetMapping(path = VERSION_1 + EXPERIENCE)
    public @ResponseBody
    Iterable<Experience> getAllExperience() {
        String name = "Test";
        return experienceRepository.findAll();
    }

    /**
     * HTTP GET request for Experience entered by id.
     *
     * @param id
     * @return experienceRepository.findById(id)
     */
    @GetMapping(path = VERSION_1 + EXPERIENCE + "/{id}")
    public @ResponseBody
    Optional<Experience> getExperienceWithID(@PathVariable Integer id) {
        String name = "Test";
        return experienceRepository.findById(id);
    }

    /**
     * HTTP POST request for a new Experience entry.
     *
     * @param startDate
     * @param endDate
     * @param jobTitle
     * @param company
     * @param description
     * @return Experience saved
     */
    @PostMapping(path = VERSION_1 + EXPERIENCE)
    public @ResponseBody
    String addNewExperience(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate, @RequestParam String jobTitle,
                            @RequestParam String company, @RequestParam String description) {


        Experience experience = new Experience();
        experience.setStartDate(startDate);
        experience.setEndDate(endDate);
        experience.setJobTitle(jobTitle);
        experience.setCompany(company);
        experience.setDescription(description);
        experienceRepository.save(experience);
        return "Experience saved";
    }

    /**
     * HTTP PUT request for an updated Education entry.
     *
     * @param startDate
     * @param endDate
     * @param jobTitle
     * @param company
     * @param description
     * @return Experience updated OR Fail - no experience to update
     */
    @PutMapping(path = VERSION_1 + EXPERIENCE)
    public @ResponseBody
    String updateExperience(@RequestParam Integer id,
                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
                            @RequestParam String jobTitle,
                            @RequestParam String company, @RequestParam String description) {

        Optional<Experience> optionalExperience = experienceRepository.findById(id);

        if (optionalExperience.isPresent()) {
            Experience experience = optionalExperience.get();
            experience.setStartDate(startDate);
            experience.setEndDate(endDate);
            experience.setJobTitle(jobTitle);
            experience.setCompany(company);
            experience.setDescription(description);
            experienceRepository.save(experience);
            return "Experience updated";
        } else {
            addNewExperience(startDate, endDate, jobTitle, company, description);
            //TODO if we add a new row. The return fail is redundant?
            return "Experience did not exist. Added as a new Experience";
        }
    }

    /**
     * HTTP DELETE request to delete an Experience entry by id.
     *
     * @param id
     * @return Experience deleted
     */
    @DeleteMapping(path = VERSION_1 + EXPERIENCE)
    public @ResponseBody
    String deleteExperience(@RequestParam Integer id) {
        experienceRepository.deleteById(id);
        return "Experience deleted";
    }



    //Skills
    /**
     * Enables automatic dependency injection for Skills.
     */
    @Autowired // This links this to the database
    private SkillsRepository skillsRepository;

    /**
     * HTTP GET request for all Skills.
     *
     * @return skillsRepository.findAll()
     */
    @GetMapping(path = VERSION_1 + SKILLS)
    public @ResponseBody
    Iterable<Skills> getAllSkills() {
        String name = "Test";
        return skillsRepository.findAll();
    }

    /**
     * HTTP GET request for Skills entered by id.
     *
     * @param id
     * @return skillRepository.findById(id)
     */
    @GetMapping(path = VERSION_1 + SKILLS + "/{id}")
    public @ResponseBody
    Optional<Skills> getSkillsWithID(@PathVariable Integer id) {
        String name = "Test";
        return skillsRepository.findById(id);
    }

    /**
     * HTTP POST request for a new Skill entry.
     *
     * @param name
     * @param type
     * @return Skill saved
     */
    @PostMapping(path = VERSION_1 + SKILLS)
    public @ResponseBody
    String addNewSkill(@RequestParam String name,
                       @RequestParam String type) {


        Skills skill = new Skills();
        skill.setName(name);
        skill.setType(type);
        skillsRepository.save(skill);
        return "Skill saved";
    }

    /**
     * HTTP PUT request for an updated Skills entry.
     *
     * @param name
     * @param type
     * @return Skills updated
     */
    @PutMapping(path = VERSION_1 + SKILLS)
    public @ResponseBody
    String updateSkill(@RequestParam Integer id, @RequestParam String name,
                       @RequestParam String type) {

        Optional<Skills> optionalSkills = skillsRepository.findById(id);

        if (optionalSkills.isPresent()) {
            Skills skill = optionalSkills.get();
            skill.setName(name);
            skill.setType(type);
            skillsRepository.save(skill);
            return "Skill updated";
        } else {
            addNewSkill(name, type);
            //TODO if we add a new row. The return fail is redundant?
            return "Skill did not exist. Added as a new skill";
        }
    }

    /**
     * HTTP DELETE request to delete a Skills entry by id.
     *
     * @param id
     * @return Skill deleted
     */
    @DeleteMapping(path = VERSION_1 + SKILLS)
    public @ResponseBody
    String deleteSkill(@RequestParam Integer id) {
        skillsRepository.deleteById(id);
        return "Skill deleted";
    }
}


