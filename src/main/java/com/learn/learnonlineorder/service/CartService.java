package com.learn.learnonlineorder.service;


import com.learn.learnonlineorder.dao.CartDao;
import com.learn.learnonlineorder.entity.Cart;
import com.learn.learnonlineorder.entity.Customer;
import com.learn.learnonlineorder.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private CartDao cartDao;

    public Cart getCart() {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        Customer customer = customerService.getCustomer(username);

        if (customer != null) {
            Cart cart = customer.getCart();
            double totalPrice = 0;
            for (OrderItem item : cart.getOrderItemList()) {
                totalPrice += item.getPrice() * item.getQuantity();
            }
//            This is to calculate the total price, used to update this cart on the line.
            cart.setTotalPrice(totalPrice);
            return cart;
        }
        return new Cart();
    }

    public void cleanCart() {
//        Get user, user name, user object, call dao
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        Customer customer = customerService.getCustomer(username);
        if (customer != null) {
            cartDao.removeAllCartItems(customer.getCart());
        }
    }

}

