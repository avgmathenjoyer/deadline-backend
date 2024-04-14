package com.example.deadlineproject.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Deadline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;
    private Date endDate;

    public Deadline() {}
    public Deadline(String title, String description, Date endDate) {
        this.title = title;
        this.description = description;
        this.endDate = endDate;
    }

    public Long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

}
