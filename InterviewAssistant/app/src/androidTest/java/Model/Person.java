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

    public int getId() {
        return id;
    }
}
