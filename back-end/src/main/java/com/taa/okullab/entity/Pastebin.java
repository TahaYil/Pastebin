package com.taa.okullab.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "pastebin")
public class Pastebin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name="content")
    private String content;

    @Column(name="hash")
    private String hash;

    @Column(name="expireDate")
    private Timestamp expireDate;

    public Pastebin() {
    }
    public Pastebin(String name, String description, String content, String hash, Timestamp expireDate) {
        this.name = name;
        this.description = description;
        this.content = content;
        this.hash = hash;
        this.expireDate = expireDate;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Timestamp getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Timestamp expireDate) {
        this.expireDate = expireDate;
    }
}
