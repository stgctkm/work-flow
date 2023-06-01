package workflow.domain.model.user;

import java.io.Serializable;

public class User implements Serializable {
    String name;
    String password;

    public User() {
        this("", "");
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String name() {
        return name;
    }

    public String password() {
        return password;
    }
}
