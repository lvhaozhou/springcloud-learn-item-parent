package com.lhz.base;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @Auther: lhz
 * @Date: 2019/12/19 0019 11:09
 * @Description:
 * @Version: 1.0
 */
//统一规范相应
@Data
@Slf4j
public class ResponseBase {
    private Integer rtnCode;
    private String msg;
    private Object data;

    public ResponseBase() {

    }

    public ResponseBase(Integer rtnCode, String msg, Object data) {
        super();
        this.rtnCode = rtnCode;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseBase[" +
                "rtnCode=" + rtnCode +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ']';
    }
}
