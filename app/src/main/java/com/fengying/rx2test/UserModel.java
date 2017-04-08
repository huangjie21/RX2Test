package com.fengying.rx2test;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by huangjie on 2017/4/7.
 */

@Entity(nameInDb = "User")
public class UserModel {

    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb = "UserName")
    private String userName;
    @Property(nameInDb = "Age")
    private int age;
    @Property(nameInDb = "Mobile")
    private String mobile;
    @Property(nameInDb = "Address")
    private String address;
    
    @Generated(hash = 1682241753)
    public UserModel(Long id, String userName, int age, String mobile,
            String address) {
        this.id = id;
        this.userName = userName;
        this.age = age;
        this.mobile = mobile;
        this.address = address;
    }
    @Generated(hash = 782181818)
    public UserModel() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getMobile() {
        return this.mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

}
