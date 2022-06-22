package ca.nl.cna.java3.java3termproject.dao;

import ca.nl.cna.java3.java3termproject.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.rmi.registry.LocateRegistry;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * THe main controller for the course project
 * <p>
 * This will handle request for Education, Experience and Skills.
 */
//TODO Consider using 3 different controllers
@RestController
@RequestMapping(path = "/api")
public class MainController {

    //Constant used in REST API definition
    public static final String VERSION_1 = "/v1";
    public static final String EDUCATION = "/educations";
    public static final String EXPERIENCE = "/experience";
    public static final String SKILLS = "/skills";

    //Education
    @Autowired // This links this to the database
    private EducationRepository educationRepository;

    @GetMapping(path = VERSION_1 + EDUCATION)
    public @ResponseBody
    Iterable<Education> getAllEducation() {
        return educationRepository.findAll();
    }

    @GetMapping(path = VERSION_1 + EDUCATION + "/{id}")
    public @ResponseBody
    Optional<Education> getEductionWithID(@PathVariable Integer id) {
        return educationRepository.findById(id);
    }

    /**
     * Add a new education to the resume
     *
     * @param title
     * @param institutionName
     * @param gradYear yyyy-MM_dd
     * @param startDate yyyy-MM_dd
     * @param endDate yyyy-MM_dd
     * @param abbreviation
     * @return Education saved
     */
    @PostMapping(path = VERSION_1 + EDUCATION)
    public @ResponseBody
    //TODO remove id as it auto generates
    String addNewEducation(@RequestParam String title,
                           @RequestParam String institutionName, @RequestParam Integer gradYear,
                           @RequestParam LocalDate startDate, @RequestParam LocalDate endDate,
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

    //TODO Correct code for PUTMapping
    // Pass in the id

    /**
     * Update education to the resume
     *
     * @param title
     * @param institutionName
     * @param gradYear yyyy-MM_dd
     * @param startDate yyyy-MM_dd
     * @param endDate yyyy-MM_dd
     * @param abbreviation
     * @return Education saved
     */
    @PutMapping(path = VERSION_1 + EDUCATION)
    public @ResponseBody
    //TODO remove id as it auto generates
    String updateEducation(@RequestParam Integer id, @RequestParam String title,
                           @RequestParam String institutionName, @RequestParam Integer gradYear,
                           @RequestParam LocalDate startDate, @RequestParam LocalDate endDate,
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
            //TODO Create a new eduction
            return "Fail - no education to update";
        }
    }

    @DeleteMapping(path = VERSION_1 + EDUCATION)
    public @ResponseBody
    String deleteEducation(@RequestParam Integer id) {
        educationRepository.deleteById(id);
        return "Education deleted";
    }

    //Experience
    @Autowired // This links this to the database
    private ExperienceRepository experienceRepository;

    @GetMapping(path = VERSION_1 + EXPERIENCE)
    public @ResponseBody
    Iterable<Experience> getAllExperience() {
        return experienceRepository.findAll();
    }

    @GetMapping(path = VERSION_1 + EXPERIENCE + "/{id}")
    public @ResponseBody
    Optional<Experience> getExperienceWithID(@PathVariable Integer id) {
        return experienceRepository.findById(id);
    }

    /**
     * Add a new experience to the resume
     *
     * @param startDate yyyy-MM_dd
     * @param endDate yyyy-MM_dd
     * @param jobTitle
     * @param company
     * @param description
     * @return Skill saved
     */
    @PostMapping(path = VERSION_1 + EXPERIENCE)
    public @ResponseBody
    //TODO remove id as it auto generates
    String addNewExperience(@RequestParam LocalDate startDate,
                            @RequestParam LocalDate endDate, @RequestParam String jobTitle,
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


    //TODO Correct code for PUTMapping
    // Pass in the id

    /**
     * Update experience in the resume
     *
     * @param startDate yyyy-MM_dd
     * @param endDate yyyy-MM_dd
     * @param jobTitle
     * @param company
     * @param description
     * @return Skill saved
     */
    @PutMapping(path = VERSION_1 + EXPERIENCE)
    public @ResponseBody
    //TODO remove id as it auto generates
    String updateExperience(@RequestParam Integer id, @RequestParam LocalDate startDate,
                            @RequestParam LocalDate endDate, @RequestParam String jobTitle,
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
            //TODO Create a new experience?
            return "Fail - no experience to update";
        }
    }


    @DeleteMapping(path = VERSION_1 + EXPERIENCE)
    public @ResponseBody
    String deleteExperience(@RequestParam Integer id) {
        experienceRepository.deleteById(id);
        return "Experience deleted";
    }

    //Skills
    @Autowired // This links this to the database
    private SkillsRepository skillsRepository;

    @GetMapping(path = VERSION_1 + SKILLS)
    public @ResponseBody
    Iterable<Skills> getAllSkills() {
        return skillsRepository.findAll();
    }

    @GetMapping(path = VERSION_1 + SKILLS + "/{id}")
    public @ResponseBody
    Optional<Skills> getSkillsWithID(@PathVariable Integer id) {
        return skillsRepository.findById(id);
    }

    /**
     * Add a new skill to the resume
     *
     * @param name
     * @param type
     * @return
     */
    @PostMapping(path = VERSION_1 + SKILLS)
    public @ResponseBody
    //TODO remove id as it auto generates
    String addNewSkill(@RequestParam String name,
                       @RequestParam String type) {


        Skills skill = new Skills();
        skill.setName(name);
        skill.setType(type);
        skillsRepository.save(skill);
        return "Skill saved";
    }

    //TODO Correct code for PUTMapping
    // Pass in the id

    /**
     * Upaate a skill in the resume
     *
     * @param name
     * @param type
     * @return
     */
    @PutMapping(path = VERSION_1 + SKILLS)
    public @ResponseBody
    //TODO remove id as it auto generates
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
            //TODO Create a new skill?
            return "Fail - no education to update";
        }
    }

    @DeleteMapping(path = VERSION_1 + SKILLS)
    public @ResponseBody
    String deleteSkill(@RequestParam Integer id) {
        skillsRepository.deleteById(id);
        return "Skill deleted";
    }
}


