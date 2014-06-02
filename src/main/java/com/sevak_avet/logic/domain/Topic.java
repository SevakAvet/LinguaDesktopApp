package com.sevak_avet.logic.domain;

import javax.persistence.*;

@Entity
@Table(name = "TOPICS")
public class Topic {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "lang_id")
    private int langId;

    @Column(name = "topic", nullable = false, length = 3000)
    private String topic;

    public Topic(int userId, int langId, String topic) {
        this.userId = userId;
        this.langId = langId;
        this.topic = topic;
    }

    public Topic() {
    }

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

    public int getLangId() {
        return langId;
    }

    public void setLangId(int langId) {
        this.langId = langId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
