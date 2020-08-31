package com.yuancda.apitest.demo;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class PointExample {


    /**
     * 积分兑换
     */
    @Test
    void pointExchangeRmb() {

        Map<String, Object> content = new HashMap<>();
        content.put("phone", "13538178747"); //平台用户手机号
        content.put("points", "100"); //平台积分
        content.put("money", "1"); //小蓝智能货柜平台的金额
        content.put("outBizNo", System.currentTimeMillis());//平台订单号
        content.put("remark", "积分兑换");

        var sign = ParmsUtil.HMACSHA256(content, Conf.private_key);

        JSONObject params = new JSONObject();
        params.put("appId", Conf.appId);
        params.put("timestamp", DateFormatUtil.format("yyyy-MM-dd HH:mm"));
        params.put("sign", sign);
        params.put("bizContent", JSONObject.toJSONString(content));
        log.info(sign);
        String res = UrlUtil.openContentType("http://localhost:10101/points/exchange/rmb", "application/json", params.toJSONString());
        log.info(res);
    }


    /**
     * 通过流水获取兑换记录
     *
     * @param serialNum
     */
    @Test
    void pointExchangeRecordRmb(String serialNum) {

        Map<String, Object> content = new HashMap<>();
        content.put("serialNum", serialNum); //平台用户手机号
        var sign = ParmsUtil.HMACSHA256(content, Conf.private_key);
        JSONObject params = new JSONObject();
        params.put("appId", Conf.appId);
        params.put("timestamp", DateFormatUtil.format("yyyy-MM-dd HH:mm"));
        params.put("sign", sign);
        params.put("bizContent", JSONObject.toJSONString(content));
        log.info(sign);
        String res = UrlUtil.openContentType("http://localhost:10101/points/exchange/record", "application/json", params.toJSONString());
        log.info(res);
    }


}
