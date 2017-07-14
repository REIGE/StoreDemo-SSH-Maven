package com.reige.store.cart;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by REIGE on 2017/7/14.
 */
public class Cart {

    private Map<Integer,CartItem> map = new HashMap<Integer, CartItem>();

    // 获得一个map的value的集合
    //相当于有一个属性:cartItems
    public Collection<CartItem> getCartItems(){
        return map.values();
    }

    private Double total = 0d;

    public Double getTotal() {
        return total;
    }

    //将购物项添加到购物车
    public void addCart(CartItem cartItem){
        //获得购物项标识id
        Integer pid = cartItem.getProduct().getPid();
        if (map.containsKey(pid)){
            CartItem cartItem_temp = map.get(pid);
            //直接修改了地址 不用再set
            cartItem_temp.setCount(cartItem_temp.getCount()+cartItem.getCount());
        }else {
            map.put(pid,cartItem);
        }
        total += cartItem.getSubtotal();
    }

    //将 购物项从购物车中移除
    public void removeCart(Integer pid){
        // 将购物项从map集合中移除
        CartItem cartItem = map.remove(pid);
        //设置总计钱数
        total -= cartItem.getSubtotal();
    }

    public void clearCart(){
        //清空map
        map.clear();
        //总计设置为0
        total = 0d;
    }
}
