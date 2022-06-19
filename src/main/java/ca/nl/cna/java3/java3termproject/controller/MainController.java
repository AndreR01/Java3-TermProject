package ca.nl.cna.java3.java3termproject.controller;

import ca.nl.cna.java3.java3termproject.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

/**
 * THe main controller for the course project
 *
 * This will handle request for Education now.
 *
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
     * @param id
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
    String addNewEducation(@RequestParam Integer id, @RequestParam String title,
                           @RequestParam String institutionName, @RequestParam Integer gradYear,
                           @RequestParam LocalDate startDate, @RequestParam LocalDate endDate,
                           @RequestParam String abbreviation) {


        Education education = new Education();
        //education.setId(id);
        education.setTitle(title);
        education.setInstitutionName(institutionName);
        education.setGradYear(gradYear);
        education.setStartDate(startDate);
        education.setEndDate(endDate);
        education.setAbbreviation(abbreviation);
        educationRepository.save(education);
        return "Education saved";
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
     * @param id
     * @param startDate
     * @param endDate
     * @param jobTitle
     * @param company
     * @param description
     * @return Skill saved
     */
    @PostMapping(path = VERSION_1 + EXPERIENCE)
    public @ResponseBody
    String addNewExperience(@RequestParam Integer id, @RequestParam LocalDate startDate,
                            @RequestParam LocalDate endDate, @RequestParam String jobTitle,
                            @RequestParam String company, @RequestParam String description) {


        Experience experience = new Experience();
        //experience.setId(id);
        experience.setStartDate(startDate);
        experience.setEndDate(endDate);
        experience.setJobTitle(jobTitle);
        experience.setCompany(company   );
        experience.setDescription(description);
        experienceRepository.save(experience);
        return "Experience saved";
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
     * S
     * @param id
     * @param name
     * @param type
     * @return
     */
    @PostMapping(path = VERSION_1 + SKILLS)
    public @ResponseBody
    String addNewSkill(@RequestParam Integer id, @RequestParam String name,
                           @RequestParam String type) {


        Skills skill = new Skills();
        skill.setId(id);
        skill.setName(name);
        skill.setType(type);
        skillsRepository.save(skill);
        return "Skill saved";
    }

    @DeleteMapping(path = VERSION_1 + SKILLS)
    public @ResponseBody
    String deleteSkill(@RequestParam Integer id) {
        skillsRepository.deleteById(id);
        return "Skill deleted";
    }




}


