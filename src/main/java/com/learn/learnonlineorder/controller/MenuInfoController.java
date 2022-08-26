package com.learn.learnonlineorder.controller;


import com.learn.learnonlineorder.entity.MenuItem;
import com.learn.learnonlineorder.entity.Restaurant;
import com.learn.learnonlineorder.service.MenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MenuInfoController {
    @RequestMapping(value = "/restaurant/{restaurantId}/menu", method = RequestMethod.GET)
//  requesting the menu list for a restaurant
    @ResponseBody
    public List<MenuItem> getMenus(@PathVariable("restaurantId") int restaurantId) {
        return menuInfoService.getAllMenuItem(restaurantId);
    }

    @Autowired
    private MenuInfoService menuInfoService;

    @RequestMapping(value = "/restaurants", method = RequestMethod.GET)
// only request the restaurants list
    @ResponseBody
//    the response will be a json
    public List<Restaurant> getRestaurants() {
        return menuInfoService.getRestaurants();
    }
}

