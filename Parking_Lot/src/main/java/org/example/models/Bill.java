package org.example.models;

import org.example.enums.BillStatus;

import java.util.Date;
import java.util.List;

public class Bill extends  BaseModel{

    private Long billNumber;
    // round it of to two decimal places and multiply by 100 to avoid floating point issues
    private Long amount;
    private Ticket ticket;
    private Date exitTime;
    private Gate generatedAtGate;
    private Operator generatedByOperator;
    private List<Payment> payments;
    private BillStatus billStatus;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Long getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(Long billNumber) {
        this.billNumber = billNumber;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public Gate getGeneratedAtGate() {
        return generatedAtGate;
    }

    public void setGeneratedAtGate(Gate generatedAtGate) {
        this.generatedAtGate = generatedAtGate;
    }

    public Operator getGeneratedByOperator() {
        return generatedByOperator;
    }

    public void setGeneratedByOperator(Operator generatedByOperator) {
        this.generatedByOperator = generatedByOperator;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }
}
