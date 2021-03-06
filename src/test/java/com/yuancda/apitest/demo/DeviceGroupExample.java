package com.yuancda.apitest.demo;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class DeviceGroupExample {



    /**
     * 点位列表
     */

    @Test
   void deviceGroup() {

        var page = new JSONObject();
        page.put("nowPage" ,1);
        page.put("limit" ,1);
        var content = new JSONObject();
        content.put("page", page);

        var sign = ParmsUtil.HMACSHA256(content, Conf.private_key);

        JSONObject params = new JSONObject();
        params.put("appId", Conf.appId);
        params.put("timestamp", DateFormatUtil.format("yyyy-MM-dd HH:mm"));
        params.put("sign", sign);
        params.put("bizContent", JSONObject.toJSONString(content));
        log.info(sign);
        String res = UrlUtil.openContentType(Conf.host + "deviceGroup/search", "application/json", params.toJSONString());
        log.info(res);
    }



}
