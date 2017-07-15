package com.reige.store.order;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.reige.store.cart.Cart;
import com.reige.store.cart.CartItem;
import com.reige.store.user.User;
import com.reige.store.utils.PageBean;
import org.apache.struts2.ServletActionContext;
import org.aspectj.weaver.ast.Or;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;


/**
 * Created by REIGE on 2017/7/14.
 */
public class OrderAction extends ActionSupport {

    private OrderService orderService;
    private Order order;
    private Integer state;
    private Integer page;


    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String saveOrder() {
        order = new Order();
        order.setOrdertime(new Date());
        order.setState(1);//1 未付款 2已付款 3已经发货 4已经收货
        HttpServletRequest request = ServletActionContext.getRequest();
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart==null){
            this.addActionMessage("请先去购物");
            return "msg";
        }
        order.setTotal(cart.getTotal());
        User existUser = (User) request.getSession().getAttribute("existUser");
        if (existUser==null){
            addActionMessage("请先登陆");
            return "msg";
        }
        order.setUser(existUser);
        for (CartItem item:cart.getCartItems()){
            OrderItem orderItem = new OrderItem();
            orderItem.setCount(item.getCount());
            orderItem.setSubtotal(item.getSubtotal());
            orderItem.setProduct(item.getProduct());
            orderItem.setOrder(order);

            order.getOrderItems().add(orderItem);
        }
        //清空购物车
        cart.clearCart();

        //保存订单
        Integer oid = orderService.save(order);
        order.setOid(oid);

        return "saveOrderSuccess";
    }

    public String payOrder(){
        Order currOrder = orderService.findByOid(order.getOid());
        currOrder.setAddr(order.getAddr());
        currOrder.setName(order.getName());
        currOrder.setPhone(order.getPhone());

        orderService.update(currOrder);
        return NONE;
    }

    /**
     * 后台按状态查询查询订单
     */
    public String adminFindByState() {
        PageBean<Order> pageBean = orderService.findByPage(state, page);
        // 将PageBean的数据保存到页面:
        ActionContext.getContext().getValueStack().set("pageBean", pageBean);
        return "adminFindByStateSuccess";
    }

    /**
     * 后台查询所有订单
     */
    public String adminFindAll() {
        PageBean<Order> pageBean = orderService.findByPage(page);
        // 将PageBean的数据保存到页面:
        ActionContext.getContext().getValueStack().set("pageBean", pageBean);
        return "adminFindAllSuccess";
    }
}
