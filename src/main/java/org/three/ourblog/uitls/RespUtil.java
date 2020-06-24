package org.three.ourblog.uitls;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
public class RespUtil {
    private int code;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    private RespUtil(){}

    public RespUtil code(int code) {
        this.code = code;
        return this;
    }

    public RespUtil message(String message) {
        this.message = message;
        return this;
    }

    public RespUtil data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    @Override
    public String toString() {
        return "RespUtil{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public RespUtil data(Map<String, Object> data) {
        for (String key: data.keySet()){
            this.data.put(key, data.get(key));
        }
        return this;
    }

    public static RespUtil ok(){
        RespUtil respUtil = new RespUtil();
        respUtil.code(200);
        respUtil.message("成功");
        return respUtil;
    }

    public static RespUtil error(){
        RespUtil respUtil = new RespUtil();
        respUtil.code(500);
        respUtil.message("失败");
        return respUtil;
    }

}
