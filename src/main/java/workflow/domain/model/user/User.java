package workflow.domain.model.user;

import java.io.Serializable;

public class User implements Serializable {
    String name;
    String password;

    public String name() {
        return name;
    }

    public String password() {
        return password;
    }
}
