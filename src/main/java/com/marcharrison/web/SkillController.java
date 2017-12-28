package com.marcharrison.web;

import com.marcharrison.domain.SkillRepository;
import com.marcharrison.domain.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by marc on 9/22/17.
 */

@RestController
@RequestMapping(path="/api")
@CrossOrigin
public class SkillController {

    @Autowired
    SkillRepository skillRepository;

    @CrossOrigin(origins = {"http://localhost:3000", "https://marc-harrison-portfolio.herokuapp.com/"})
    @PostMapping(path="/skill/add") // Map ONLY GET Requests
    public @ResponseBody String addNewSkill (@Valid @RequestBody Skill skill) {
        skillRepository.save(skill);
        return "Added skill " + skill.toString();
    }

    @CrossOrigin(origins = {"http://localhost:3000", "https://marc-harrison-portfolio.herokuapp.com/"})
    @DeleteMapping(path="/skill/all") // Map ONLY GET Requests
    public @ResponseBody String deleteAllSkills () {
        skillRepository.deleteAll();
        return "Deleted all skills";
    }

    @CrossOrigin
    @GetMapping(path="/skill/all")
    public @ResponseBody Iterable<Skill> getAllSkills() {
        // This returns a JSON or XML with the skills
        return skillRepository.findAll();
    }

}
