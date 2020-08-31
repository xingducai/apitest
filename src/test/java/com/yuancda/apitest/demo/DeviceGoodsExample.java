package com.yuancda.apitest.demo;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class DeviceGoodsExample {

    /**
     * 积分兑换
     */

    @Test
   void getDeviceGoods() {

        Map<String, Object> content = new HashMap<>();
        content.put("deviceId", Conf.deviceId); //平台积分

        var sign = ParmsUtil.HMACSHA256(content, Conf.private_key);

        JSONObject params = new JSONObject();
        params.put("appId", Conf.appId);
        params.put("timestamp", DateFormatUtil.format("yyyy-MM-dd HH:mm"));
        params.put("sign", sign);
        params.put("bizContent", JSONObject.toJSONString(content));
        log.info(sign);
        String res = UrlUtil.openContentType(Conf.host + "getDeviceGoods", "application/json", params.toJSONString());
        log.info(res);
    }

    @Test
     void updateDeviceInfo() {

        Map<String, Object> content = new HashMap<>();
        content.put("deviceId", 100570); //平台积分
        content.put("name", "广东1"); //平台积分
        content.put("imgUrl", "广东"); //平台积分
        content.put("address", "广东"); //平台积分
        content.put("qrCode", "广东"); //平台积分

        var sign = ParmsUtil.HMACSHA256(content, Conf.private_key);

        JSONObject params = new JSONObject();
        params.put("appId", Conf.appId);
        params.put("timestamp", DateFormatUtil.format("yyyy-MM-dd HH:mm"));
        params.put("sign", sign);
        params.put("bizContent", JSONObject.toJSONString(content));
        log.info(sign);
        String res = UrlUtil.openContentType(Conf.host + "updateDeviceInfo", "application/json", params.toJSONString());
        log.info(res);
    }


}
