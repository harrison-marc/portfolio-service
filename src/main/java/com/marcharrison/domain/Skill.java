package com.marcharrison.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by marc on 9/22/17.
 */

@Entity
@IdClass(SkillId.class)
@EntityListeners(AuditingEntityListener.class)
public class Skill {

    @Id
    private String name;
    private String level;
    @Id
    private String category;

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @LastModifiedDate
    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModified;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }
}
