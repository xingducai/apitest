package com.yuancda.apitest.demo;

import lombok.extern.slf4j.Slf4j;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Map;

@Slf4j
public class ParmsUtil {


    /**
     * 参数生成拼接请求参数URL
     */
    public static String mapToString(Map<String, Object> doc) {
        String str = doc.keySet().stream().sorted((a, b) -> a.compareTo(b)).map(s -> "&" + s + "=" + doc.get(s)).reduce((a, b) -> a + b).get();
        return str.substring(1, str.length());
    }


    public static String HMACSHA256(Map<String, Object> doc, String key) {
        try {
//            String sign = mapToString(doc) + "&key=" + pay_key;
//            return Sign.sign(sign, algo).toUpperCase();

            String data = mapToString(doc) + "&key=" + key;
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");

            SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");

            sha256_HMAC.init(secret_key);

            byte[] array = sha256_HMAC.doFinal(data.getBytes("UTF-8"));

            StringBuilder sb = new StringBuilder();

            for (byte item : array) {

                sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));

            }

            return sb.toString().toUpperCase();
        } catch (Exception e) {
            log.error(e + "");
        }
        return "";


    }
}
