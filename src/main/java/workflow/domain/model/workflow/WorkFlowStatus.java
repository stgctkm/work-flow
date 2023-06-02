package workflow.domain.model.workflow;

public enum WorkFlowStatus {
    作成中,
    申請中,
    承認済,
    却下

    ;

    public boolean isOnCreating() {
        return this == 作成中;
    }

    public boolean isOnApplied() {
        return this == 申請中;
    }

    public boolean isApproved() {
        return this == 承認済;
    }

    public boolean isCanceled() {
        return this == 却下;
    }
}
