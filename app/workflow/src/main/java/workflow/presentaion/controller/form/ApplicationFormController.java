package workflow.presentaion.controller.form;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import workflow.application.service.workflow.workflow.WorkFlowService;
import workflow.domain.model.account.UserAccount;
import workflow.domain.model.form.ApplicationForm;
import workflow.domain.model.form.ApplicationFormId;
import workflow.domain.model.workflow.WorkFlowSearchCriteria;
import workflow.domain.model.workflow.WorkFlows;

@Controller
@RequestMapping("application-forms")
class ApplicationFormController {

    WorkFlowService workFlowService;

    ApplicationFormController(WorkFlowService workFlowService) {
        this.workFlowService = workFlowService;
    }

    @GetMapping("new")
    String start(@ModelAttribute("applicationForm") ApplicationForm applicationForm) {
        return "application-form/new-application-form";
    }



    @PostMapping
    String register(@ModelAttribute("applicationForm") ApplicationForm applicationForm,
                    @AuthenticationPrincipal UserAccount userAccount) {
        ApplicationFormId applicationFormId = workFlowService.create(applicationForm, userAccount.userId());
        return "redirect:/work-flows/" + applicationFormId;
    }

    @GetMapping
    String list(
            @ModelAttribute("workFlowSearchCriteria") WorkFlowSearchCriteria workFlowSearchCriteria,
            Authentication authentication,
            Model model) {
        UserAccount userAccount = (UserAccount) authentication.getPrincipal();
        WorkFlows workFlows = workFlowService.listOf(userAccount.userId(), workFlowSearchCriteria);
        model.addAttribute("workFlows", workFlows);
        return "application-form/list";
    }

    @InitBinder("applicationForm")
    void bindApplicationForm(WebDataBinder binder) {
        binder.setAllowedFields(
                "amount",
                "usage"
        );
    }
    @InitBinder("workFlowSearchCriteria")
    void bindWorkFlowSearchCriteria(WebDataBinder binder) {
        binder.setAllowedFields(
                "from",
                "to",
                "assignedOnly"
        );
    }
}
