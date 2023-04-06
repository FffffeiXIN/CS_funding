package com.sustech.cs_funding.common;
import lombok.Data;
import java.util.HashMap;
import java.util.Map;


/**
 * TODO: None
 *
 * @Description 要求所有返回的数据格式都应该为Result对象，建议使用链式编程进行赋值,第一项必须生命ok/error
 */
@Data
public class Result {
    private Integer code;

    private boolean state;

    private String message;

    private Map<String, Object> data = new HashMap<>();


    public static Result ok() {
        Result result = new Result();
        result.state = true;
        return result;
    }

    public static Result error() {
        Result result = new Result();
        result.state = false;
        return result;
    }


    public Result code(int code) {
        this.code = code;
        return this;
    }

    public Result message(String message) {
        this.message = message;
        return this;
    }

    public Result addData(String key, Object value) {
        data.put(key, value);
        return this;
    }

    public Result data(Map<String, Object> data) {
        this.data = data;
        return this;
    }

}

