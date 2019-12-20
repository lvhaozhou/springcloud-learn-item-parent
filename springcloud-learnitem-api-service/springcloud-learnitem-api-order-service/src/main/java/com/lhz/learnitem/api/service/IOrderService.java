package com.lhz.learnitem.api.service;

import com.lhz.base.ResponseBase;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: lhz
 * @Date: 2019/12/18 0018 17:53
 * @Description: 订单service
 * @Version: 1.0
 */
public interface IOrderService {

    //订单调用会员服务
    @RequestMapping("/orderToMember")
    public String orderToMember(String name);

    //订单调用会员服务用户信息
    @RequestMapping("/orderToMemberInfo")
    public ResponseBase orderToMemberInfo();

    //订单服务接口
    @RequestMapping("/orderInfo")
    public ResponseBase orderInfo();
}
