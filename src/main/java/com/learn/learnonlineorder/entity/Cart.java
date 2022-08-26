package com.learn.learnonlineorder.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

//by calling it an entity, the framework will see it as an object
@Entity
@Table(name = "cart")
public class Cart implements Serializable {
    //This serialization is what makes this data automatically serialized into a specialized format before it can be saved to disk.
    private static final long serialVersionUID = 1L;
//    这个可以用随机数或者自己定一个初始值

    @Id
//    priory key
    @GeneratedValue(strategy = GenerationType.AUTO)
//    The database will self-increment the index of this form, the first, the second and the third. Automatically set a pk to him. It is the specific value.
    private int id;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderItem> orderItemList;

    private double totalPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

}

