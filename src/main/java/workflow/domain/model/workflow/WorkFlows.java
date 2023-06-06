package workflow.domain.model.workflow;

import workflow.domain.primitive.date.DateTime;

import java.util.List;

public record WorkFlows(List<WorkFlow> list) {

    public WorkFlows overdueWorkFlows() {
        return new WorkFlows(
                list.stream()
                        .filter(workFlow -> workFlow.assignedDateTime().warningDateTime().isBefore(DateTime.now()))
                        .toList());
    }
}
