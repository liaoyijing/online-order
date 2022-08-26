package com.learn.learnonlineorder.service;


import com.learn.learnonlineorder.dao.MenuInfoDao;
import com.learn.learnonlineorder.entity.MenuItem;
import com.learn.learnonlineorder.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuInfoService {
    //Docking to the request's supporting service inside the dao to call the specific method
    @Autowired
    private MenuInfoDao menuInfoDao;


    public List<Restaurant> getRestaurants() {
        return menuInfoDao.getRestaurants();
    }

    public List<MenuItem> getAllMenuItem(int restaurantId) {
        return menuInfoDao.getAllMenuItem(restaurantId);
    }

    public MenuItem getMenuItem(int id) {
        return menuInfoDao.getMenuItem(id);
    }
}

