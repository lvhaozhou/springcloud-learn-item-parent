package com.lhz.learnitem.fallback;

import com.lhz.base.BaseApiService;
import com.lhz.base.ResponseBase;
import com.lhz.leanitem.api.entity.UserEntity;
import com.lhz.learnitem.feign.MemberServiceFeign;
import org.springframework.stereotype.Component;

/**
 * @Auther: lhz
 * @Date: 2019/12/20 0020 14:55
 * @Description: 服务降级实现类
 * @Version: 1.0
 */
@Component
public class MemberFallback extends BaseApiService implements MemberServiceFeign {

    @Override
    public UserEntity getMember(String name) {
        return null;
    }

    //写服务降级友好的提示
    @Override
    public ResponseBase getUserInfo() {
        return setResultSuccess("返回友好的提示， 服务器正忙， 请稍后再试, 以类的形式！");
    }
}
