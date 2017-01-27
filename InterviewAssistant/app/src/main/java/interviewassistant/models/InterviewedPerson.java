package interviewassistant.models;

import java.io.Serializable;

/**
 * Created by Rafael on 19/01/2017.
 */

public class InterviewedPerson implements Serializable, IPersistentEntity {
    private static final long serialVersionUID = 1633833011084400384L;
    int id;
    String postCode;
    short number;
    String Name;
    String cellphone;

    public InterviewedPerson(int id, String postCode, String number, String name, String cellphone) {

        this.id = id;
        this.postCode = postCode;
        this.number = Short.valueOf(number);
        this.Name = name;
        this.cellphone = cellphone;

    }

    public InterviewedPerson() {

    }

    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
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
}
