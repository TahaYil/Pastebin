package com.taa.okullab.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;


public class PastebinDto {
    private String destcription;
    private String name;
    private String content;
    private Timestamp expireDate;

    public PastebinDto() {
    }

    public PastebinDto(String destcription, String name, String content, Timestamp expireDate) {
        this.destcription = destcription;
        this.name = name;
        this.content = content;
        this.expireDate = expireDate;
    }

    public String getDestcription() {
        return destcription;
    }

    public void setDestcription(String destcription) {
        this.destcription = destcription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Timestamp expireDate) {
        this.expireDate = expireDate;
    }
}
