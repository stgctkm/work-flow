package workflow.domain.model.workflow;

import workflow.domain.primitive.amount.Amount;

/**
 * 申請書
 */
public class ApplicationForm {
    ApplicationFormId id;

    Amount amount;

    String usage;

    public ApplicationForm() {
        this(new ApplicationFormId(), new Amount(), "");
    }

    public ApplicationForm(ApplicationFormId id, Amount amount, String usage) {
        this.id = id;
        this.amount = amount;
        this.usage = usage;
    }

    public ApplicationForm(ApplicationFormId id) {
        this.id = id;
    }

    public ApplicationFormId id() {
        return id;
    }

    public Amount amount() {
        return amount;
    }

    public String usage() {
        return usage;
    }
}
