package com.learn.learnonlineorder.dao;


import com.learn.learnonlineorder.entity.Authorities;
import com.learn.learnonlineorder.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {
    // user hibernate MySql communication
    @Autowired
    private SessionFactory sessionFactory;

    public void signUp(Customer customer) {
//        give all the entity needed for creating a customer
        Authorities authorities = new Authorities();
        authorities.setAuthorities("ROLE_USER");
        authorities.setEmail(customer.getEmail());

        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(authorities);
            session.save(customer);
            session.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    //    look up the customer in the database
    public Customer getCustomer(String email) {
        Customer customer = null;
        try (Session session = sessionFactory.openSession()) {
            customer = session.get(Customer.class, email);
// use the email to look up customer class and return the customer object
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return customer;
    }
}

