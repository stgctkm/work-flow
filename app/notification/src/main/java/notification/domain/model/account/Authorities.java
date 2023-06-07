package notification.domain.model.account;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class Authorities implements Serializable {
    List<GrantedAuthority> authorities;

    public Authorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public List<GrantedAuthority> asList() {
        return Collections.unmodifiableList(authorities);
    }
}
