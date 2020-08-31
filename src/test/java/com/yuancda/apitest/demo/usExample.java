package com.yuancda.apitest.demo;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class usExample {


    /**
     *同步用户信息
     */
    @Test
    void addUser() {

        Map<String, Object> content = new HashMap<>();
        content.put("phone", "13538178747");
        content.put("nickName", "测试账号");
        content.put("unionid", "test1");
        content.put("gender", "1");
        content.put("avatar", "http://images.voidiot.com/default_avatar.png");
//        content.put("deviceId", 10000);

        var sign = ParmsUtil.HMACSHA256(content, Conf.private_key);

        JSONObject params = new JSONObject();
        params.put("appId", Conf.appId);
        params.put("timestamp", DateFormatUtil.format("yyyy-MM-dd HH:mm"));
        params.put("sign", sign);
        params.put("bizContent", JSONObject.toJSONString(content));
        log.info(sign);
        String res = UrlUtil.openContentType("https://api.voidiot.com/open-api/syncUserInfo", "application/json", params.toJSONString());
        log.info(res);
    }


}
