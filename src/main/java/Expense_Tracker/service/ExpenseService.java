package Expense_Tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Expense_Tracker.dto.ExpenseRequest;
import Expense_Tracker.model.Expense;
import Expense_Tracker.model.User;
import Expense_Tracker.repository.ExpenseRepository;
import Expense_Tracker.repository.UserRepository;

@Service
public class ExpenseService {
	
    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserRepository userRepository;

    public Expense addExpense(ExpenseRequest request, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found!"));

        Expense expense = new Expense();
        expense.setTitle(request.getTitle());
        expense.setAmount(request.getAmount());
        expense.setCategory(request.getCategory());
        expense.setDate(request.getDate());
        expense.setDescription(request.getDescription());
        expense.setUser(user);

        return expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found!"));
        return expenseRepository.findByUser(user);
    }

    public void deleteExpense(Long id, String email) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found!"));

        if (!expense.getUser().getEmail().equals(email)) {
            throw new RuntimeException("Unauthorized!");
        }
        expenseRepository.deleteById(id);
    }

    public List<Expense> getExpensesByCategory(String category, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found!"));
        return expenseRepository.findByUserAndCategory(user, category);
    }

}
