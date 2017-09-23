package com.marcharrison.domain;

import javax.persistence.*;

/**
 * Created by marc on 9/22/17.
 */

@Entity @IdClass(SkillId.class)
public class Skill {

    @Id
    private String name;
    @Id
    private String level;
    @Id
    private String category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
