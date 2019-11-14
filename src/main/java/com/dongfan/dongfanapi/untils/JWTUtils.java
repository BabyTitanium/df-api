package com.dongfan.dongfanapi.untils;


import com.alibaba.fastjson.JSON;
import com.sun.corba.se.impl.oa.toa.TOA;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @Author: lll
 * @Date: 2019/7/28 12:29
 * @Version 1.0
 */

public class JWTUtils {

    private static String secret="r398!jd26%h$jfeio";

   // private static long expireTime=2592000;//一个月

    //解析jwt
    /**
     * 创建jwt
     * @return
     * @throws Exception
     */
    public static String createJWT(UserTokenInfo userTokenInfo,long expireTime) throws Exception {
        String subject=JSON.toJSONString(userTokenInfo);
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256; //指定签名的时候使用的签名算法，也就是header那部分，jjwt已经将这部分内容封装好了。
        long nowMillis = System.currentTimeMillis();//生成JWT的时间
        //下面就是在为payload添加各种标准声明和私有声明了
        JwtBuilder builder = Jwts.builder() //这里其实就是new一个JwtBuilder，设置jwt的body
                .setSubject(subject)        //sub(Subject)：代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串，可以存放什么userid，roldid之类的，作为什么用户的唯一标志。
                .signWith(signatureAlgorithm, secret);//设置签名使用的签名算法和签名使用的秘钥
        if (expireTime >= 0) {
            long expMillis = nowMillis + expireTime;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);     //设置过期时间
        }
        return builder.compact();
       }

//上面代码中两次用到的generalKey()方法
    /**
     * 解密jwt
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) {
        try {
            Claims claims = Jwts.parser()  //得到DefaultJwtParser
                    .setSigningKey(secret)         //设置签名的秘钥
                    .parseClaimsJws(jwt).getBody();//设置需要解析的jwt
            return claims;
        }catch (ExpiredJwtException e){
            return null;
        }

    }
    public static   UserTokenInfo getUserInfo(String jwt) {
        Claims claims=parseJWT(jwt);
        if(claims!=null){
            String str=claims.getSubject();
            UserTokenInfo userTokenInfo=JSON.parseObject(str,UserTokenInfo.class);
            return  userTokenInfo;
        }else{
            return null;
        }

    }


    public static void main(String[] args) {
        UserTokenInfo userTokenInfo=new UserTokenInfo();
        userTokenInfo.setUserId(20);
        userTokenInfo.setNickName("刘蹦哒\uD83D\uDC8B");
        try {
            String str=createJWT(userTokenInfo,2592000000L);
            System.out.println(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        String token="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ7XCJuaWNrTmFtZVwiOlwi5YiY6Lmm5ZOSXHVEODNEXHVEQzhCXCIsXCJ1c2VySWRcIjoyMH0iLCJleHAiOjE1NjQ4NDM4Njl9.f-4HI5Z2mAxpjw-QYX-G7y3_kSkQfpmLjevYk7zbPl8";
//        UserTokenInfo userTokenInfo=getUserInfo(token);
//        System.out.println(userTokenInfo.getUserId());
    }
    }
