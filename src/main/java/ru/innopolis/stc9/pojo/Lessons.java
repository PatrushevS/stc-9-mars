package ru.innopolis.stc9.pojo;

import java.sql.Date;

public class Lessons {
    private int id;
    private int subject_id;
    private Date date;
    private String name;

    public Lessons(int id, int subject_id, Date date, String name) {
        this.id = id;
        this.subject_id = subject_id;
        this.date = date;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}