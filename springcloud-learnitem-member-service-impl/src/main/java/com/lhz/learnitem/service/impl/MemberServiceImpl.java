package com.lhz.learnitem.service.impl;

import com.lhz.base.BaseApiService;
import com.lhz.base.ResponseBase;
import com.lhz.leanitem.api.entity.UserEntity;
import com.lhz.leanitem.api.service.IMemberService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: lhz
 * @Date: 2019/12/18 0018 16:50
 * @Description: member实现类
 * @Version: 1.0
 */
@RestController
public class MemberServiceImpl extends BaseApiService implements IMemberService {

    @RequestMapping("/getMember")
    @Override
    public UserEntity getMember(@RequestParam(value = "name") String name) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(name);
        userEntity.setAge(10);
        return userEntity;
    }

    @RequestMapping("/getUserInfo")
    @Override
    public ResponseBase getUserInfo() {
        try {
            Thread.sleep(1500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return setResultSuccess("订单服务调用会员服务接口成功。。。");
    }
}
