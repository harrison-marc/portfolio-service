package com.marcharrison.web;

import com.marcharrison.domain.SkillRepository;
import com.marcharrison.domain.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by marc on 9/22/17.
 */

@Controller
@RequestMapping(path="/api")
@CrossOrigin
public class SkillController {

    @Autowired
    SkillRepository skillRepository;

    @CrossOrigin(origins = {"http://localhost:3000", "https://marc-harrison-portfolio.herokuapp.com/"})
    @GetMapping(path="/skill/add") // Map ONLY GET Requests
    public @ResponseBody String addNewSkill (@RequestParam String category, @RequestParam String level, @RequestParam String name) {
        Skill skill = new Skill();
        skill.setCategory(category);
        skill.setLevel(level);
        skill.setName(name);
        skillRepository.save(skill);
        return "Saved";
    }

    @CrossOrigin(origins = {"http://localhost:3000", "https://marc-harrison-portfolio.herokuapp.com/"})
    @GetMapping(path="/skill/delete/all") // Map ONLY GET Requests
    public @ResponseBody String deleteAllSkills () {
        Iterable<Skill> skills = getAllSkills();
        skills.forEach(skill -> skillRepository.delete(skill));
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
