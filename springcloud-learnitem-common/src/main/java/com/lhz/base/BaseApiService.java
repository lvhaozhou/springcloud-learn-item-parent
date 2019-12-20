package com.lhz.base;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: lhz
 * @Date: 2019/12/19 0019 10:59
 * @Description:
 * @Version: 1.0
 */
@Component
public class BaseApiService {
    public ResponseBase setResultErorr(Integer code, String msg){
        return setResult(code, msg, null);
    }

    //返回错误可以修改msg
    public ResponseBase setResultErorr(String msg){
        return setResult(500, msg, null);
    }

    //返回成功可以传data
    public ResponseBase setResultSuccess(Object data){
        return setResult(200, "处理成功", data);
    }

    //返回成功无data
    public ResponseBase setResultSuccess(){
        return setResult(200, "处理成功", null);
    }

    //返回成功无data
    public ResponseBase setResultSuccess(String msg){
        return setResult(200, msg, null);
    }

    //通用部分
    public ResponseBase setResult(Integer code, String msg, Object data) {
        return new ResponseBase(code, msg, data);
    }
}
