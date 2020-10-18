package ru.litvinov.javapool.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "emails")
public class Emails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "email")
    String email;

    @ManyToOne
    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID")
    Students students;

    public Emails() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }
}
