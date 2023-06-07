package notification.application.service.account;


import workflow.domain.model.account.UserAccount;

public interface UserAccountRepository {
    UserAccount userOf(String username);
}
