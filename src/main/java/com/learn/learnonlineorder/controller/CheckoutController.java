package com.learn.learnonlineorder.controller;


import com.learn.learnonlineorder.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class CheckoutController {
    //    checkout servlet
    @Autowired
    private CartService cartService;

    // mapping url for checkout, what to do is just clean the cart, nothing more
    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void checkout() {
        cartService.cleanCart();
    }
}

