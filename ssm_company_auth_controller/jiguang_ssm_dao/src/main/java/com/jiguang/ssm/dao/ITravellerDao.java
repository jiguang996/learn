package com.jiguang.ssm.dao;

import com.jiguang.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITravellerDao {

    @Select("select * from  traveller  where id  in (select  travellerID   from order_traveller  where orderID=#{orderId})")
    List<Traveller> findByOrdersId( String orderId);

}
