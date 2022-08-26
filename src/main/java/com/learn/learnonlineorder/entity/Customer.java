package com.learn.learnonlineorder.entity;

import javax.persistence.*;
import java.io.Serializable;

// This is an entity of customers
@Entity
@Table(name = "customers")
public class Customer implements Serializable {
    @Id
//    entity item
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private boolean enabled;

    //    foreign key
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(unique = true)
    private Cart cart;

    //    remaining helper function
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
