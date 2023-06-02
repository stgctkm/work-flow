package workflow.presentaion.controller.workflow;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import workflow.application.service.user.UserService;
import workflow.application.service.workflow.history.WorkFlowHistoryService;
import workflow.application.service.workflow.workflow.WorkFlowService;
import workflow.domain.model.account.UserAccount;
import workflow.domain.model.form.ApplicationFormId;
import workflow.domain.model.user.Users;
import workflow.domain.model.workflow.WorkFlow;
import workflow.domain.model.workflow.history.WorkFlowHistories;

@Controller
@RequestMapping("work-flows/{applicationFormId}")
class WorkFlowController {

    UserService userService;
    WorkFlowService workFlowService;
    WorkFlowHistoryService workFlowHistoryService;

    WorkFlowController(
            UserService userService,
            WorkFlowService workFlowService,
            WorkFlowHistoryService workFlowHistoryService) {
        this.userService = userService;
        this.workFlowService = workFlowService;
        this.workFlowHistoryService = workFlowHistoryService;
    }

    @ModelAttribute("workFlow")
    WorkFlow workFlow(@PathVariable ApplicationFormId applicationFormId) {
        return workFlowService.workFlowOf(applicationFormId);
    }

    @ModelAttribute("isAssigned")
    boolean isAssigned(
            @ModelAttribute("workFlow") WorkFlow workFlow,
            @AuthenticationPrincipal UserAccount userAccount) {
        return workFlow.isAssignedUser(userAccount.getUsername());
    }

    @GetMapping()
    String form(@PathVariable("applicationFormId") ApplicationFormId applicationFormId,
                Model model) {

        Users authorizers = userService.authorizers();
        model.addAttribute("authorizers", authorizers);

        WorkFlowHistories histories = workFlowHistoryService.histories(applicationFormId);
        model.addAttribute("histories", histories);

        return "work-flow/work-flow";
    }

    @PostMapping("apply")
    String apply(@PathVariable ApplicationFormId applicationFormId,
                 @ModelAttribute("assignedUser") String assignedUser) {
        workFlowService.apply(applicationFormId, assignedUser);
        return "redirect:/application-forms";
    }

    @PostMapping("approve")
    String approve(@PathVariable ApplicationFormId applicationFormId) {
        workFlowService.approve(applicationFormId);
        return "redirect:/application-forms";
    }

    @PostMapping("reject")
    String reject(@PathVariable ApplicationFormId applicationFormId) {
        workFlowService.reject(applicationFormId);
        return "redirect:/application-forms";
    }

    @PostMapping("cancel")
    String cancel(@PathVariable ApplicationFormId applicationFormId) {
        workFlowService.cancel(applicationFormId);
        return "redirect:/application-forms";
    }
}
