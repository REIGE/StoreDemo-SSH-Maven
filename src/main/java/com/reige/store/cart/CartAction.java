package com.reige.store.cart;

import com.opensymphony.xwork2.ActionSupport;
import com.reige.store.product.Product;
import com.reige.store.product.ProductService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by REIGE on 2017/7/14.
 */
public class CartAction extends ActionSupport{
    private Integer pid;//接收 pid
    private Integer count;//接收 count

    private ProductService productService;

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    /**
     * 从session范围获得购物车的带码
     * @param request
     * @return
     */
    public Cart getCart(HttpServletRequest request){
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart ==null){
            cart = new Cart();
            request.getSession().setAttribute("cart",cart);
        }
        return cart;
    }

    /**
     * 添加到购物车的方法
     * @return
     */
    public String addCart(){
        Product product = productService.findByPid(pid);
        CartItem cartItem = new CartItem();
        cartItem.setCount(count);
        cartItem.setProduct(product);
        //获取购物车 需要依赖request对象
        HttpServletRequest request = ServletActionContext.getRequest();
        Cart cart = getCart(request);
        cart.addCart(cartItem);
        return "addCartSuccess";
    }

    /**
     * 清空购物车
     * @return
     */
    public String clearCart(){
        HttpServletRequest request = ServletActionContext.getRequest();
        Cart cart = getCart(request);
        cart.clearCart();
        return "clearCartSuccess";
    }

    /**
     * 移除一条购物项
     * @return
     */
    public String removeCart(){
        HttpServletRequest request = ServletActionContext.getRequest();
        Cart cart = getCart(request);
        cart.removeCart(pid);

        return "removeCartSuccess";
    }

    /**
     * 我的购物车
     * @return
     */
    public String myCart(){
        return "myCartSuccess";
    }

}
