package com.learn.learnonlineorder.service;


import com.learn.learnonlineorder.dao.OrderItemDao;
import com.learn.learnonlineorder.entity.Customer;
import com.learn.learnonlineorder.entity.MenuItem;
import com.learn.learnonlineorder.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {
    //对接orderdao的具体服务调用接口
    @Autowired
    private MenuInfoService menuInfoService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderItemDao orderItemDao;

    public void saveOrderItem(int menuId) {
//        Take the menu id, what you want is the corresponding order list
        final OrderItem orderItem = new OrderItem();

        // get an item'
        final MenuItem menuItem = menuInfoService.getMenuItem(menuId);

        // get the user
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();

        String username = loggedInUser.getName();
        Customer customer = customerService.getCustomer(username);
        orderItem.setMenuItem(menuItem);
        orderItem.setCart(customer.getCart());
        orderItem.setQuantity(1);
        orderItem.setPrice(menuItem.getPrice());
        orderItemDao.save(orderItem);
    }
}

