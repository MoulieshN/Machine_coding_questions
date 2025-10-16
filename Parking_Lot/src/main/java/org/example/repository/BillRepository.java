package org.example.repository;

import org.example.models.Bill;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class BillRepository {
    private Map<Long, Bill> billMap = new TreeMap<>();
    private Long idCounter = 1L;
    public void save(Bill bill){
        bill.setBillNumber(idCounter++);
        billMap.put(bill.getBillNumber(), bill);
    }
    public Optional<Bill> getById(Long id){
        return Optional.ofNullable(billMap.get(id));
    }
}
