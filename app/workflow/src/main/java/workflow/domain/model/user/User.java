package workflow.domain.model.user;

import java.io.Serializable;

/**
 * ユーザー
 */
public class User implements Serializable {
    UserId userId;
    String name;
    String password;

    public User() {
        this(new UserId(), "", "");
    }

    public User(UserId userId, String name, String password) {
        this.userId = userId;
        this.name = name;
        this.password = password;
    }

    public UserId userId() {
        return userId;
    }

    public String name() {
        return name;
    }

    public String password() {
        return password;
    }
}
