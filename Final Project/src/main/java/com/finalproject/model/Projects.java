package com.finalproject.model;

import javax.persistence.*;

@Entity
@Table(name = "projects")

public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "budget")
    private int budget;

    @Column(name = "time")
    private int time;

    @Column(name = "importance")
    @Enumerated(EnumType.STRING)
    private String importance;

    public Projects(int id, String title, int budget, int time, String importance) {

    }

    public Projects(String title, int budget, int time, String importance) {
        super();
        this.id = id;
        this.title = title;
        this.budget = budget;
        this.time = time;
        this.importance = importance;
    }

    public Projects() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getImportance() {
        return importance;
    }

    public void setImportance(String importance) {
        this.importance = importance;
    }

    public String toString() {
        return Integer.toString(id) + " " + title + " " + budget + " " + time + " " + importance;
    }
}
