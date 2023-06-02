package workflow.infrastructure.datasource.user;

import org.apache.ibatis.annotations.Mapper;
import workflow.domain.model.user.User;

import java.util.List;

@Mapper
interface UserMapper {

    List<User> authorizers();
}
