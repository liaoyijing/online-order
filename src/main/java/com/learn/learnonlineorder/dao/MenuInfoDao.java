package com.learn.learnonlineorder.dao;


import com.learn.learnonlineorder.entity.MenuItem;
import com.learn.learnonlineorder.entity.Restaurant;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

@Repository

public class MenuInfoDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Restaurant> getRestaurants() {
        // this is the dao to look up the restaurant
        try (Session session = sessionFactory.openSession()) {
//           build criteria
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Restaurant> criteria = builder.createQuery(Restaurant.class);
            criteria.from(Restaurant.class);//从rest class里面拿
            return session.createQuery(criteria).getResultList();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new ArrayList<>();
    }


    public List<MenuItem> getAllMenuItem(int restaurantId) {
//        get Menu item
        try (Session session = sessionFactory.openSession()) {
            Restaurant restaurant = session.get(Restaurant.class, restaurantId);
            if (restaurant != null) {
                return restaurant.getMenuItemList();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    public MenuItem getMenuItem(int menuItemId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(MenuItem.class, menuItemId);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
