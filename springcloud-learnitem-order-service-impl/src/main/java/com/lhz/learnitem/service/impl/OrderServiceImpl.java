package com.lhz.learnitem.service.impl;

import com.lhz.base.BaseApiService;
import com.lhz.base.ResponseBase;
import com.lhz.leanitem.api.entity.UserEntity;
import com.lhz.learnitem.api.service.IOrderService;
import com.lhz.learnitem.feign.MemberServiceFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: lhz
 * @Date: 2019/12/18 0018 17:57
 * @Description: 订单服务调用会员服务
 * @Version: 1.0
 */
@RestController
public class OrderServiceImpl extends BaseApiService implements IOrderService {
    //订单服务继承会员服务接口实现调用，减少重复代码
    @Autowired
    private MemberServiceFeign memberServiceFeign;

    @RequestMapping("/orderToMember")
    @Override
    public String orderToMember(String name) {
        UserEntity member = memberServiceFeign.getMember(name);
        return member == null ? "没有找到用户信息" : member.toString();
    }

    //没有解决服务的雪崩效应
    @RequestMapping("/orderToMemberInfo")
    @Override
    public ResponseBase orderToMemberInfo() {
        System.out.println("orderToMemberInfo: 线程池名称 = " + Thread.currentThread().getName());
        return memberServiceFeign.getUserInfo();
    }

    //解决服务的雪崩效应
    /**
     * 功能描述: 默认开启服务的隔离方式是以线程池方式
     * 默认开启服务降级方法 orderToMemberInfoHystrixFallback
     * 默认开启服务的熔断机制
     * 启动时要加注解@ElnabeHystrix
     * 设置超时时间 默认时间是1秒 超时的化方法还是会执行 但是返回的是降级方法 ，要禁止
     * @param: []
     * @return: com.lhz.base.ResponseBase
     * @auther: lhz
     * @date: 2019/12/19 0019 下午 3:57
     */
    @HystrixCommand(fallbackMethod = "orderToMemberInfoHystrixFallback")
    @RequestMapping("/orderToMemberInfoHystrix")
    public ResponseBase orderToMemberInfoHystrix() {
        System.out.println("orderToMemberInfoHystrix: 线程池名称 = " + Thread.currentThread().getName());
        return memberServiceFeign.getUserInfo();
    }

    //fallbackMethod 服务降级时使用此方法
    //默认开启了线程池隔离方式
    public ResponseBase orderToMemberInfoHystrixFallback() {
        return setResultSuccess("返回友好的提示， 服务器正忙， 请稍后再试！");
    }


    //订单服务接口
    @RequestMapping("/orderInfo")
    @Override
    public ResponseBase orderInfo() {
        System.out.println("orderInfo: 线程池名称 = " + Thread.currentThread().getName());
        return setResultSuccess();
    }

    //hystrix 有2种方式配置服务保护 通过注解和接口形式
}
