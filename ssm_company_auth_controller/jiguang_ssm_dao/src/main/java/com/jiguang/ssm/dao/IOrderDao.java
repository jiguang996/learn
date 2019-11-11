package com.jiguang.ssm.dao;

import com.jiguang.ssm.domain.Member;
import com.jiguang.ssm.domain.Orders;
import com.jiguang.ssm.domain.Product;
import com.jiguang.ssm.domain.Traveller;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IOrderDao {

    @Select("select *  from orders")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product" ,column = "productID" ,javaType = Product.class,one = @One(select = "com.jiguang.ssm.dao.IProductDao.findById"))
    })
    List<Orders> findAll();


    @Select("select * from orders where id=#{orderId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "orderNum"),
            @Result(property = "orderTime", column = "orderTime"),
            @Result(property = "orderStatus", column = "orderStatus"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "peopleCount", column = "peopleCount"),
            @Result(property = "payType", column = "payType"),
            @Result(property = "orderDesc", column = "orderDesc"),
            @Result(property = "product" ,column = "productID" ,javaType = Product.class,one = @One(select = "com.jiguang.ssm.dao.IProductDao.findById")),
            @Result(property = "traveller" ,column = "travellerId",javaType = java.util.List.class,many=@Many(select = "com.jiguang.ssm.dao.ITravellerDao.finByOrdersId")),
            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "com.jiguang.ssm.dao.IMemberDao.findByOrdersId"))
    })
    Orders findById(String orderId);
}
