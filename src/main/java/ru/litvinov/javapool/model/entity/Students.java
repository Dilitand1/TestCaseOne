package ru.litvinov.javapool.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Students implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "name")
    String name;
    @Column(name = "course")
    String course;

    @OneToMany(mappedBy = "students", fetch = FetchType.EAGER)
    List<Emails> emails = new ArrayList<>();

    public Students(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public List<Emails> getList() {
        return emails;
    }

    public void setList(List<Emails> list) {
        this.emails = list;
    }

    @Override
    public String toString() {
        return "Students {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accountList=" + emails +
                '}';
    }
}
