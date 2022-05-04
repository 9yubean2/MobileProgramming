package com.example.listview;

public class singerItem {
    String name;
    String mobile;
    public singerItem(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;

    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "singerItem{" +
                "name=" + name + "\n" +
                ",mobile=" + mobile + "\n" +
                "}";
    }
}
