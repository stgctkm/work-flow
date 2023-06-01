package workflow.domain.model.workflow;

public enum WorkFlowEvent {
    作成(WorkFlowStatus.作成中),
    申請(WorkFlowStatus.申請中),
    承認(WorkFlowStatus.承認済),
    差戻し(WorkFlowStatus.作成中),
    却下(WorkFlowStatus.却下),
    ;

    final WorkFlowStatus nextStatus;

    WorkFlowEvent(WorkFlowStatus nextStatus) {
        this.nextStatus = nextStatus;
    }

    public WorkFlowStatus nextStatus() {
        return nextStatus;
    }
}
