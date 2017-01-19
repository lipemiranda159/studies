package Model;

import java.io.Serializable;

/**
 * Created by Rafael on 19/01/2017.
 */

public class Person implements Serializable {
    private static final long serialVersionUID = 1633833011084400384L;
    int id;
    String postCode;
    short number;
    String Name;
    String cellphone;

    public Person(int id, String postCode, String number, String name, String cellphone) {

        this.id = id;
        this.postCode = postCode;
        this.number = Short.valueOf(number);
        this.Name = name;
        this.cellphone = cellphone;

    }

    public int getId() {
        return id;
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
}
