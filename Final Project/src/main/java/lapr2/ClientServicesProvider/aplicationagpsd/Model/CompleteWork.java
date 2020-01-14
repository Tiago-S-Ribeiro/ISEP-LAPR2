package lapr2.ClientServicesProvider.aplicationagpsd.Model;

import java.io.Serializable;

/**
 * @author Tiago
 */
public class CompleteWork implements Serializable{

    private String description;
    private String extraTime;
    private ExecutionOrder executionOrder;
    private Invoice invoice;

    private static final String EXTRA_TIME_BY_OMISSION = "0";

    private static final String DESCRIPTION_BY_OMISSION = "without description";

    private static final ExecutionOrder EXECUTION_ORDER_BY_OMISSION = new ExecutionOrder();

    private static final Invoice INVOICE_ORDER_BY_OMISSION = new Invoice();

    public CompleteWork(String description, ExecutionOrder executionOrder) {
        this.description = description;
        this.executionOrder = executionOrder;
        this.extraTime = EXTRA_TIME_BY_OMISSION;
        this.invoice = INVOICE_ORDER_BY_OMISSION;
    }

    public CompleteWork() {
        this.description = DESCRIPTION_BY_OMISSION;
        this.executionOrder = EXECUTION_ORDER_BY_OMISSION;
        this.extraTime = EXTRA_TIME_BY_OMISSION;
        this.invoice = INVOICE_ORDER_BY_OMISSION;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.description = description;
    }

    public String getExtraTime() {
        return extraTime;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setExtraTime(String extraTime) {
        if (extraTime == null || extraTime.isEmpty()) {
            throw new IllegalArgumentException("Invalid Time");
        }
        this.extraTime = extraTime;
    }

    public ExecutionOrder getExecutionOrder() {
        return executionOrder;
    }

    public void setExecutionOrder(ExecutionOrder executionOrder) {
        if (executionOrder == null) {
            throw new IllegalArgumentException("Invalid Execution order.");
        }
        this.executionOrder = executionOrder;
    }

    public void setInvoice(Invoice invoice) {
        if (invoice == null) {
            throw new IllegalArgumentException("Invalid Invoice");
        }
        this.invoice = invoice;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CompleteWork e = (CompleteWork) obj;

        return e.description.equalsIgnoreCase(description) && e.extraTime == extraTime && this.invoice.equals(e.invoice);
    }

    @Override
    public String toString() {
        return "*Completed Service* ("+this.getExecutionOrder().getSchedule().getDay().toYearMonthDayString() +")"+" Description: " + description + ", extra time consumed: " + extraTime + ".";
    }
}
