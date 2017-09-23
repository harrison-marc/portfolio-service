package com.marcharrison.web;

import com.marcharrison.domain.SkillRepository;
import com.marcharrison.domain.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by marc on 9/22/17.
 */

@Controller
@RequestMapping(path="/api/skill")
public class SkillController {

    @Autowired
    SkillRepository skillRepository;

    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody String addNewSkill (@RequestParam String category, @RequestParam String level, @RequestParam String name) {
        Skill skill = new Skill();
        skill.setCategory(category);
        skill.setLevel(level);
        skill.setName(name);
        skillRepository.save(skill);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Skill> getAllSkills() {
        // This returns a JSON or XML with the skills
        return skillRepository.findAll();
    }

}
