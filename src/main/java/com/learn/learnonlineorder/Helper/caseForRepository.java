package com.learn.learnonlineorder.Helper;


import com.learn.learnonlineorder.entity.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class caseForRepository {

    public void signUp(Customer customer) {
    }

    public Customer getCustomer(String email) {
        return new Customer();
    }
}
