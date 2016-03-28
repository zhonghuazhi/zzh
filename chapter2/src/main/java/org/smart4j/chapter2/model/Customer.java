package org.smart4j.chapter2.model;

/**
 * Created by zhonghua on 15/10/26.
 */
public class Customer {

    /**
     * 属性列表
     */
    private long id;

    private String name;

    private String contact;

    private String telephone;

    private String email;

    private String remark;

    public Customer() {
    }

    public Customer(long id, String name, String contact, String telephone,
                    String email, String remark) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.telephone = telephone;
        this.email = email;
        this.remark = remark;
    }

    /**
     * 属性 get/set
     *
     * @return
     */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return this.getId() + " " + this.getName() +
                " " + this.getContact() + " " + this.getTelephone();
    }
}