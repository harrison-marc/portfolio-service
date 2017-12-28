package com.marcharrison.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * Created by marc on 9/22/17.
 */

@Entity @IdClass(SkillId.class)
@EntityListeners(AuditingEntityListener.class)
public class Skill {

    @Id
    @NotNull(message = "Name cannot be null")
    private String name;
    @Id
    @NotNull(message = "Category cannot be null")
    @Pattern(regexp = "framework|language|tool",  message = "Invalid category")
    private String category;
    @NotNull(message = "Level cannot be null")
    @Pattern(regexp = "beginner|novice|intermediate|expert|sme", message = "Invalid level")
    private String level;

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

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name);
        stringBuilder.append(" to the ");
        stringBuilder.append(category);
        stringBuilder.append(" category at the ");
        stringBuilder.append(level);
        stringBuilder.append(" level.");
        return stringBuilder.toString();
    }
}
