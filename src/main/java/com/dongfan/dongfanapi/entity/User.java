package com.dongfan.dongfanapi.entity;

public class User {
    private Integer id;

    private String openid;

    private String nickName;

    private Integer sex;

    private String headimgurl;

    private String privilege;

    private String unionid;

    private String phone;

    private String province;

    private String city;

    private String country;

    private String language;

    private String invateCode;

    private String realName;

    private String type;

    public User(Integer id, String openid, String nickName, Integer sex, String headimgurl, String privilege, String unionid, String phone, String province, String city, String country, String language, String invateCode, String realName, String type) {
        this.id = id;
        this.openid = openid;
        this.nickName = nickName;
        this.sex = sex;
        this.headimgurl = headimgurl;
        this.privilege = privilege;
        this.unionid = unionid;
        this.phone = phone;
        this.province = province;
        this.city = city;
        this.country = country;
        this.language = language;
        this.invateCode = invateCode;
        this.realName = realName;
        this.type = type;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl == null ? null : headimgurl.trim();
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege == null ? null : privilege.trim();
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getInvateCode() {
        return invateCode;
    }

    public void setInvateCode(String invateCode) {
        this.invateCode = invateCode == null ? null : invateCode.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }
}