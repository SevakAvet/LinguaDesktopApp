package com.sevak_avet.logic.domain;

import javax.persistence.*;

@Entity
@Table(name = "ANSWERS")
public class Answer {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "name")
    private String name;

    @Column(name = "birthday")
    private String birthday;

    @Column(name = "gender")
    private String gender;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "rus_level")
    private int rusLevel;

    @Column(name = "eng_level")
    private int engLevel;

    public Answer(int userId, String name, String birthday, String gender, String occupation, int rusLevel, int engLevel) {
        this.userId = userId;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.occupation = occupation;
        this.rusLevel = rusLevel;
        this.engLevel = engLevel;
    }

    public Answer(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getRusLevel() {
        return rusLevel;
    }

    public void setRusLevel(int rusLevel) {
        this.rusLevel = rusLevel;
    }

    public int getEngLevel() {
        return engLevel;
    }

    public void setEngLevel(int engLevel) {
        this.engLevel = engLevel;
    }
}
