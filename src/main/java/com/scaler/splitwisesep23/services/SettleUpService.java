package com.scaler.splitwisesep23.services;

import com.scaler.splitwisesep23.strategy.SettleUpStrategy;
import com.scaler.splitwisesep23.dto.Transaction;
import com.scaler.splitwisesep23.models.*;
import com.scaler.splitwisesep23.repositpries.ExpenseUserRepository;
import com.scaler.splitwisesep23.repositpries.GroupRepository;
import com.scaler.splitwisesep23.repositpries.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SettleUpService {

    private final UserRepository userRepository;
    private final ExpenseUserRepository expenseUserRepository;
    private final SettleUpStrategy settleUpStrategy;
    private final GroupRepository groupRepository;

    @Autowired
    public SettleUpService(UserRepository userRepository,
                           ExpenseUserRepository expenseUserRepository,
                           SettleUpStrategy settleUpStrategy,
                           GroupRepository groupRepository) {
        this.userRepository = userRepository;
        this.expenseUserRepository = expenseUserRepository;
        this.settleUpStrategy = settleUpStrategy;
        this.groupRepository = groupRepository;
    }

    public List<Transaction> settleUpUser(Long userId) {
    /*
        1. Get all the expenses in which user is part of
        2. Iterate through all the expenses and find out of all people
            involved in those expenses who owes how much extra / less.
        3. Use Min and Max heap approach to find all the transactions
            that we have to make to get settle up.
        4. Return the transactions of the user.
     */

        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new RuntimeException("Invalid user!");
        }

        User user = userOptional.get();

        List<ExpenseUser> expenseUsers = expenseUserRepository.findAllByUser(user);

        List<Expense> expensesToSettleUp = new ArrayList<>();
        for (ExpenseUser expenseUser : expenseUsers) {
            expensesToSettleUp.add(expenseUser.getExpense());
        }

        return settleUpStrategy.settleUp(expensesToSettleUp);
    }

    public List<Transaction> settleUpGroup(Long groupId) {
         /*
        1. Get all the expenses that were made in the group.
        2. Iterate through all the expenses and find out of all people
            involved in those expenses who owes how much extra / less.
        3. Use Min and Max heap approach to find all the transactions
            that we have to make to get settle up.
        4. Return all the transactions.
     */

        Optional<Group> groupOptional = groupRepository.findById(groupId);
        if (groupOptional.isEmpty()) {
            throw new RuntimeException("Invalid Group!");
        }

        Group group = groupOptional.get();

        return settleUpStrategy.settleUp(group.getExpenses());
    }
}
