package workflow.infrastructure.datasource.account;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.GrantedAuthority;
import workflow.domain.model.user.User;

import java.util.List;

@Mapper
interface UserAccountMapper {
    User findByUsername(@Param("username") String username);

    List<GrantedAuthority> rolesOf(@Param("username") String username);
}
