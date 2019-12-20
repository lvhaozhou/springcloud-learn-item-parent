package com.lhz.leanitem.api.service;

import com.lhz.base.ResponseBase;
import com.lhz.leanitem.api.entity.UserEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: lhz
 * @Date: 2019/12/18 0018 16:11
 * @Description: 会员服务接口
 * @Version: 1.0
 */
public interface IMemberService {

    //实体类是存放在接口还是实现项目 正常应该单独建，也可以实体类存放在接口项目
    //代码实现放在实现类
    @RequestMapping("/getMember")
    public UserEntity getMember(@RequestParam("name") String name);

    @RequestMapping("/getUserInfo")
    public ResponseBase getUserInfo();

}
