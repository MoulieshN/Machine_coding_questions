package org.example.dtos;

import org.example.dtos.enums.ResponseStatus;
import org.example.models.Bill;

public class BillResponseDto {
    private Bill bill;
    private String message;
    private ResponseStatus status;

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }
}
