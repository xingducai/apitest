package com.yuancda.apitest.demo;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class OrderExample {



    @Test
    void pointExchangeRmb() {

        Map<String, Object> content = new HashMap<>();
        content.put("unionid", Conf.unionid); //平台用户手机号
        content.put("opendoorRecordId", 1815); //平台积分

        var sign = ParmsUtil.HMACSHA256(content, Conf.private_key);

        JSONObject params = new JSONObject();
        params.put("appId", Conf.appId);
        params.put("timestamp", DateFormatUtil.format("yyyy-MM-dd HH:mm"));
        params.put("sign", sign);
        params.put("bizContent", JSONObject.toJSONString(content));
        log.info(sign);
        String res = UrlUtil.openContentType(Conf.host + "getOrdersByOpenDoorId", "application/json", params.toJSONString());
        log.info(res);
    }

    /**
     * 订单列表
     */
    @Test
    void orders() {

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
        String res = UrlUtil.openContentType(Conf.host + "orders/search", "application/json", params.toJSONString());
        log.info(res);
    }

}
