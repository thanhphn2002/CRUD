package com.CRUD;

import javax.persistence.*;

@Entity
@Table (name = "data")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private long id;

    @Column (nullable = false, length = 50)
    private String name;

    @Column (nullable = false)
    private int age;

    @Column (nullable = false, length = 10)
    private String gender;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
