package workflow.infrastructure.datasource.user;

import org.springframework.stereotype.Repository;
import workflow.application.service.user.UserRepository;
import workflow.domain.model.user.Users;

@Repository
public class UserDataSource implements UserRepository {

    UserMapper userMapper;

    UserDataSource(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Users authorizers() {
        return new Users(userMapper.authorizers());
    }
}
