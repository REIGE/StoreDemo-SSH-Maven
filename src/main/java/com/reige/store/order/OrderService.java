package com.reige.store.order;

/**
 * Created by REIGE on 2017/7/14.
 */
public class OrderService {
    private OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public Integer save(Order order) {
        return  orderDao.save(order);
    }


}
