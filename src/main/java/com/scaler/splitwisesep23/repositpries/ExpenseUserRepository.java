package com.scaler.splitwisesep23.repositpries;

import com.scaler.splitwisesep23.models.Expense;
import com.scaler.splitwisesep23.models.ExpenseUser;
import com.scaler.splitwisesep23.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseUserRepository extends JpaRepository<ExpenseUser, Long> {
    List<ExpenseUser> findAllByUser(User user);
}
