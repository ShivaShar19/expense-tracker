package Expense_Tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Expense_Tracker.model.Expense;
import Expense_Tracker.model.User;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>{

    List<Expense> findByUser(User user);
    List<Expense> findByUserAndCategory(User user, String category);

	
}
 