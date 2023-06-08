package workflow.domain.model.account;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import workflow.domain.model.user.User;
import workflow.domain.model.user.UserId;

import java.util.Collection;

/**
 * ユーザーアカウント
 */
public class UserAccount implements UserDetails  {

    User user;
    Authorities authorities;

    public UserAccount(User user, Authorities authorities) {
        this.user = user;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities.asList();
    }

    @Override
    public String getPassword() {
        return user.password();
    }

    public UserId userId() {
        return user.userId();
    }

    @Override
    public String getUsername() {
        return user.name();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}