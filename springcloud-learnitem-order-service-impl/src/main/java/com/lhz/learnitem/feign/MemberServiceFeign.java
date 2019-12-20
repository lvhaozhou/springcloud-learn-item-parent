package com.lhz.learnitem.feign;

import com.lhz.leanitem.api.service.IMemberService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Auther: lhz
 * @Date: 2019/12/18 0018 18:01
 * @Description: 会员项目feign 接口
 * @Version: 1.0
 */
@FeignClient(name = "app-lhz-member")
public interface MemberServiceFeign extends IMemberService {

}
