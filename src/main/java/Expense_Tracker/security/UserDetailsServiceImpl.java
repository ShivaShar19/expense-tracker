package Expense_Tracker.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import Expense_Tracker.ExpenseTrackerApplication;
import Expense_Tracker.model.User;
import Expense_Tracker.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    private final ExpenseTrackerApplication expenseTrackerApplication;
	
    @Autowired
    private UserRepository userRepository;

    UserDetailsServiceImpl(ExpenseTrackerApplication expenseTrackerApplication) {
        this.expenseTrackerApplication = expenseTrackerApplication;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with email: " + email));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                new ArrayList<>()
        );
    }

}
