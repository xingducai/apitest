package com.yuancda.apitest.demo;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class GoodExample {



    /**
     * 积分兑换
     */
    @Test
   void pointExchangeRmb() {
/**
 *   public String goodsName;  //微信id
 *     public String imgUrl;  //微信id
 *     //    public Long merchantId;
 *     public Double price;
 *     public Double sourPrice;
 *     public Integer weight;
 *     public Integer valuatType; //类型
 *     public Integer categoryId; //商品类别id
 *     public Integer discount;
 */
        Map<String, Object> content = new HashMap<>();
        content.put("goodsName", "name"); //平台积分
        content.put("imgUrl", "http"); //平台积分
        content.put("price", "3.0"); //平台积分
        content.put("sourPrice", "3.0"); //平台积分
        content.put("weight", "100"); //平台积分
        content.put("valuatType", "1"); //平台积分
        content.put("categoryId", "1"); //平台积分
        content.put("discount", "1"); //平台积分


        var sign = ParmsUtil.HMACSHA256(content, Conf.private_key);

        JSONObject params = new JSONObject();
        params.put("appId", Conf.appId);
        params.put("timestamp", DateFormatUtil.format("yyyy-MM-dd HH:mm"));
        params.put("sign", sign);
        params.put("bizContent", JSONObject.toJSONString(content));
        log.info(sign);
        String res =  UrlUtil.openContentType(Conf.host + "addGoods", "application/json", params.toJSONString());
        log.info(res);

    }
    @Test
   void byId() {

        Map<String, Object> content = new HashMap<>();
        content.put("deviceId", Conf.deviceId); //平台积分

        var sign = ParmsUtil.HMACSHA256(content, Conf.private_key);

        JSONObject params = new JSONObject();
        params.put("appId", Conf.appId);
        params.put("timestamp", DateFormatUtil.format("yyyy-MM-dd HH:mm"));
        params.put("sign", sign);
        params.put("bizContent", JSONObject.toJSONString(content));
        log.info(sign);
        String res = UrlUtil. openContentType(Conf.host + "getDeviceById", "application/json", params.toJSONString());
        log.info(res);
    }
    @Test
  void goodsList() {

        Map<String, Object> content = new HashMap<>();
        content.put("deviceId", Conf.deviceId); //平台积分

        var sign = ParmsUtil.HMACSHA256(content, Conf.private_key);

        JSONObject params = new JSONObject();
        params.put("appId", Conf.appId);
        params.put("timestamp", DateFormatUtil.format("yyyy-MM-dd HH:mm"));
        params.put("sign", sign);
        params.put("bizContent", JSONObject.toJSONString(content));
        log.info(sign);
        String res = UrlUtil. openContentType(Conf.host + "goodsList", "application/json", params.toJSONString());
        log.info(res);
    }



}
