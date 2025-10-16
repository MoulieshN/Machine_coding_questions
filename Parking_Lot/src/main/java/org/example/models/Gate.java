package org.example.models;

import org.example.enums.GateStatus;
import org.example.enums.GateType;

public class Gate extends BaseModel{
    private Long gateNumber;
    private GateType gateType; // Entry or Exit
    private Operator operator;
    private GateStatus gateStatus; // Open or Closed

    public Long getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(Long gateNumber) {
        this.gateNumber = gateNumber;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }
}
