package workflow.domain.model.workflow;

/**
 * ワークフローステータス
 */
public enum WorkFlowStatus {
    作成中,
    申請中,
    承認済,
    却下

    ;

    /**
     * 作成中かどうか
     */
    public boolean isOnCreating() {
        return this == 作成中;
    }

    /**
     * 申請中かどうか
     */
    public boolean isOnApplied() {
        return this == 申請中;
    }

    /**
     * 承認済かどうか
     */
    public boolean isApproved() {
        return this == 承認済;
    }

    /**
     * 却下されたかどうか
     */
    public boolean isCanceled() {
        return this == 却下;
    }
}
