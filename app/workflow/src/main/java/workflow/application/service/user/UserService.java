package workflow.application.service.user;

import org.springframework.stereotype.Service;
import workflow.domain.model.user.Users;

@Service
public class UserService {

    UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users authorizers() {
        return userRepository.authorizers();
    }

}
