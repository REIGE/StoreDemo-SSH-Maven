package com.reige.store.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by REIGE on 2017/7/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class ProductDaoTest {

    @Autowired
    ProductDao productDao;
    @Test
    public void findCountByCid() throws Exception {
        Integer count = productDao.findCountByCid(1);
        System.out.println(count);
    }

    @Test
    public void findByPage() throws Exception {
        List<Product> productList = productDao.findByPage(1, 0, 10);
        for (Product p :productList){
            System.out.println(p.getPname());
        }
    }

    @Test
    public void finByPid() throws Exception {
        Product product = productDao.finByPid(1);
        System.out.println(product.getPname());
    }

}