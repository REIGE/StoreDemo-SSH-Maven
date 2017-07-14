package com.reige.store.cart;

import com.reige.store.product.Product;

/**
 * Created by REIGE on 2017/7/14.
 */
public class CartItem {
    private Product product;//商品对象
    private Integer count;//数量


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getSubtotal() {
        return count * product.getShop_price();
    }

}
