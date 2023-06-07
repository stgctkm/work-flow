package workflow.infrastructure.datasource.account;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import workflow.application.service.account.UserAccountRepository;
import workflow.domain.model.account.Authorities;
import workflow.domain.model.account.UserAccount;
import workflow.domain.model.user.User;

import java.util.List;

@Repository
public class UserAccountDataSource implements UserAccountRepository {

    UserAccountMapper userAccountMapper;

    UserAccountDataSource(UserAccountMapper userAccountMapper) {
        this.userAccountMapper = userAccountMapper;
    }

    @Override
    public UserAccount userOf(String username) {
        User user = userAccountMapper.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("User not found for name: %s".formatted(username));
        List<GrantedAuthority> roles = userAccountMapper.rolesOf(username);
        return new UserAccount(user, new Authorities(roles));
    }
}
