package workflow.infrastructure.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import workflow.application.service.workflow.workflow.WorkFlowService;
import workflow.domain.model.workflow.WorkFlows;

import java.time.LocalDateTime;

@Component
public class WarnOverdueWorkFlowsTask {

    Logger logger = LoggerFactory.getLogger(WarnOverdueWorkFlowsTask.class);

    WorkFlowService workFlowService;

    WarnOverdueWorkFlowsTask(WorkFlowService workFlowService) {
        this.workFlowService = workFlowService;
    }

    @Scheduled(fixedRate = 10000)
    @Scheduled(cron = "0 15 * * * *")
    public void warnLeft() {
        logger.info("The time is now {}", LocalDateTime.now());
        WorkFlows workFlows = workFlowService.list().overdueWorkFlows();
        workFlows.list().forEach(workFlow -> {
            logger.info("ユーザー {} (ユーザーID = {}) にアサインされたワークフロー（申請ID = {}）が期限を過ぎています.アサイン日時 = {}",
                    workFlow.assignedUser().name(),
                    workFlow.assignedUser().userId(),
                    workFlow.applicationForm().id(),
                    workFlow.assignedDateTime());
        });
    }
}
