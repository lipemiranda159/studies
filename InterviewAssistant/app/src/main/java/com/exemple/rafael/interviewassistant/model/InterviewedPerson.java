package com.exemple.rafael.interviewassistant.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Rafael on 19/01/2017.
 */

@Entity(indexes = {
        @Index(value = "id, postCode", unique = true)
})
public class InterviewedPerson {
    @Id
    private Long id;
    @NotNull
    private String postCode;
    private short number;
    private String Name;
    private String cellphone;


    public InterviewedPerson() {

    }

    public InterviewedPerson(Long id) {
        this.id = id;
    }

    @Generated(hash = 1601718371)
    public InterviewedPerson(Long id, @NotNull String postCode, short number, String Name,
            String cellphone) {
        this.id = id;
        this.postCode = postCode;
        this.number = number;
        this.Name = Name;
        this.cellphone = cellphone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPostCode() {
        return postCode;
    }

    public short getNumber() {
        return number;
    }

    public String getName() {
        return Name;
    }

    public String getCellPhone() {
        return cellphone;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public void setNumber(short number) {
        this.number = number;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setCellPhone(String cellPhone) {
        this.cellphone = cellPhone;
    }

    public String getCellphone() {
        return this.cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }
}
