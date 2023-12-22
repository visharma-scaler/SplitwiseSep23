package com.scaler.splitwisesep23.strategy;

import com.scaler.splitwisesep23.dto.Transaction;
import com.scaler.splitwisesep23.models.Expense;
import org.springframework.stereotype.Component;

import java.util.List;

public interface SettleUpStrategy {
    List<Transaction> settleUp(List<Expense> expensesToSettleUp);
}
