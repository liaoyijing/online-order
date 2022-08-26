package com.learn.learnonlineorder.dao;

import com.learn.learnonlineorder.entity.Cart;
import com.learn.learnonlineorder.entity.OrderItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// dao mean the session to the database using hibernate
@Repository
public class CartDao {
    //check out clean the cart
    @Autowired
    private SessionFactory sessionFactory;

    public void removeCartItem(int orderItemId) {
//        hibernate session created and communicating with the MySql
        Session session = null;
        try {
            session = sessionFactory.openSession();
            OrderItem cartItem = session.get(OrderItem.class, orderItemId);
            Cart cart = cartItem.getCart();
            cart.getOrderItemList().remove(cartItem);
// remove cartItem in the list
            session.beginTransaction();
            session.delete(cartItem);
            session.getTransaction().commit();

        } catch (Exception ex) {
            ex.printStackTrace();
            if (session != null) {
                session.getTransaction().rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }

    public void removeAllCartItems(Cart cart) {
        for (OrderItem item : cart.getOrderItemList()) {
            removeCartItem(item.getId());
        }
    }
}

