package com.reige.store.order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by REIGE on 2017/7/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class OrderDaoTest {

    @Autowired
    OrderDao orderDao;

    @Test
    public void save() throws Exception {
        Order order = new Order();

        orderDao.save(order);
    }

}